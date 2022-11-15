package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.repository.PlaceRepository;
import DSC.Kick_Wa.repository.RecordRepository;
import DSC.Kick_Wa.repository.User.UserRepository;
import DSC.Kick_Wa.repository.VehicleRepository;
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

    //킥보드 빌린 상황
    @Transactional
    public Long rental(RentalDto rentalDto){
        User user = userRepository.findOne(rentalDto.getUserId());
        Vehicle vehicle = vehicleRepository.findOne(rentalDto.getVehicleId());

        Long recordId = recordRepository.save(
                Record.builder()
                        .user(user)
                        .vehicle(vehicle)
                        .startT(LocalDateTime.now())
                        .build()
        );
        vehicle.rentalStatus();
        return recordId;
    }

    //킥보드 반납하기
    @Transactional
    public Long returnVehicle(ReturnVehicleDto returnVehicleDto){
        Record record = recordRepository.findOne(returnVehicleDto.getRecordId());
        Vehicle vehicle = vehicleRepository.findOne(returnVehicleDto.getVehicleId());
        Place place = placeRepository.findOne(returnVehicleDto.getPlaceId());
        LocalDateTime time = LocalDateTime.now();
        Long useCount = record.useCal();
        record.edit(place,time,useCount);
        vehicle.returnStatus();
        return record.getId();
    }

    //유저의 이용 횟수 보여주기
    public Integer showUsageCount(Long userId){
        List<Record> findRecords = recordRepository.findUserInfo(userId);
        return findRecords.size();
    }

    //유저의 이용 기록 보여주기
    public List<Record> showUsageRecord(Long userId){
        List<Record> byUsageRecord = recordRepository.findUserUsage(userId);
        return byUsageRecord;
    }

    //유저의 주행 정보 보여주기
}
