package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.dto.response.UsageRecordDto;
import DSC.Kick_Wa.repository.*;
import DSC.Kick_Wa.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final PlaceRepository placeRepository;

    //킥보드 빌린 상황
    @Transactional
    public Long rental(RentalDto rentalDto){
        User user = userRepository.findById(rentalDto.getUserId()).get();
        Vehicle vehicle = vehicleRepository.findById(rentalDto.getVehicleId()).get();

        Long recordId = recordRepository.save(
                Record.builder()
                        .user(user)
                        .vehicle(vehicle)
                        .startT(LocalDateTime.now())
                        .build()
        ).getId();
        vehicle.rentalStatus();

        Record record = recordRepository.findById(recordId).get();
        record.addUseCount();
        user.userRentalVehicle();
        return recordId;
    }

    //킥보드 반납하기
    @Transactional
    public Long returnVehicle(ReturnVehicleDto returnVehicleDto){
        Record record = recordRepository.findById(returnVehicleDto.getRecordId()).get();
        Vehicle vehicle = recordRepository.findById(returnVehicleDto.getRecordId()).get().getVehicle();
        Place place = placeRepository.findById(returnVehicleDto.getPlaceId()).get();
        LocalDateTime time = LocalDateTime.now();
        Long useCount = record.useCal(time);
        record.edit(place,time,useCount);
        vehicle.returnVehicle(time,place);
        User user = recordRepository.findById(returnVehicleDto.getRecordId()).get().getUser();
        user.userReturnVehicle();
        return record.getId();
    }

    //유저의 이용 횟수 보여주기
    //public Integer showUsageCount(Long userId){
    //    List<Record> findRecords = recordRepositorySupport.findUserInfo(userId);
    //    return findRecords.size();
    //}

    //유저의 사용 내역 보여주기
    public List<UsageRecordDto> showUsageRecord(Long userId){
        List<Record> byUsageRecord = recordRepository.findByUserId(userId);
        List<UsageRecordDto> collect = byUsageRecord.stream().map(s -> new UsageRecordDto(s)).collect(Collectors.toList());
        return collect;
    }



}
