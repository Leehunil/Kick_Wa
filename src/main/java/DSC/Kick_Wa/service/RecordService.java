package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.repository.*;
import DSC.Kick_Wa.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final PlaceRepository placeRepository;
    private final RecordRepositorySupport recordRepositorySupport;

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
        return record.getId();
    }

    //유저의 이용 횟수 보여주기
    public Integer showUsageCount(Long userId){
        List<Record> findRecords = recordRepositorySupport.findUserInfo(userId);
        return findRecords.size();
    }

    //유저의 이용 기록 보여주기
    public List<Record> showUsageRecord(Long userId){
        List<Record> byUsageRecord = recordRepositorySupport.findUserUsage(userId);
        return byUsageRecord;
    }

    //유저의 주행 정보 보여주기

}
