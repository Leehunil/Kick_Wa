package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.repository.User.UserRepository;
import DSC.Kick_Wa.repository.Vehicle.VehicleRepository;
import DSC.Kick_Wa.repository.record.RecordRepository;
import DSC.Kick_Wa.repository.record.RecordRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
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
        return recordId;
    }

    //킥보드 반납하기
    public Long returnVehicle(Long recordeId,ReturnVehicleDto returnVehicleDto){
        Record record = recordRepository.findById(recordeId).get();
        record.useCal();
        return recordRepositorySupport.returnVehicle(returnVehicleDto);
    }

}
