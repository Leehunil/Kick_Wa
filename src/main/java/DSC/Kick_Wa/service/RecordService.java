package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.domain.user.UserStatus;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.dto.response.RentVehicleInfoDto;
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
                        .startT(LocalDateTime.now().withNano(0))
                        .build()
        ).getId();
        //킥보드 상태 바꾸기
        vehicle.rentalStatus();
        //사용자 상태 바꾸기
        user.userRentalVehicle();
        return recordId;
    }

    //킥보드 반납하기
    @Transactional
    public Long returnVehicle(ReturnVehicleDto returnVehicleDto){

        Record record = recordRepository.findById(returnVehicleDto.getRecordId()).get();
        Vehicle vehicle = recordRepository.findById(returnVehicleDto.getRecordId()).get().getVehicle();
        Place place = placeRepository.findById(returnVehicleDto.getPlaceId()).get();
        User user = recordRepository.findById(returnVehicleDto.getRecordId()).get().getUser();

        LocalDateTime time = LocalDateTime.now().withNano(0);
        Long useCount = record.useCal(time);
        record.edit(place,time,useCount);
        //킥보드 정보 바꾸기
        vehicle.returnVehicle(time,place);
        //사용자 상태 바꾸기
        user.userReturnVehicle();
        //반납 장소에 킥보드 넣기
        place.placeInVehicle(vehicle);
        return record.getId();
    }

    //유저의 사용 내역 보여주기
    public List<UsageRecordDto> showUsageRecord(Long userId){
        List<Record> byUsageRecord = recordRepository.findByUserId(userId);
        for(Record record : byUsageRecord){
            if(record.getEndT() == null){
                byUsageRecord.remove(record);
            }
        }
        List<UsageRecordDto> collect = byUsageRecord.stream().map(s -> new UsageRecordDto(s)).collect(Collectors.toList());
        return collect;
    }

    //사용중인 킥보드 정보 보여주기
    public RentVehicleInfoDto rentVehicleInfoDto(Long userId){
        List<Record> records = recordRepository.findByUserIdAndUserStatus(userId, UserStatus.DRIVING);
        Record record = records.get(records.size()-1);
        RentVehicleInfoDto rentVehicleInfoDto = new RentVehicleInfoDto(record);
        return rentVehicleInfoDto;
    }

}
