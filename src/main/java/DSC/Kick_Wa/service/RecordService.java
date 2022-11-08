package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.repository.RecordRepository;
import DSC.Kick_Wa.repository.UserRepository;
import DSC.Kick_Wa.repository.VehicleRepository;
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
        ).getId();
        return recordId;
    }


}
