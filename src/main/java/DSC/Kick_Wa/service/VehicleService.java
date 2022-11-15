package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.domain.VehicleStatus;
import DSC.Kick_Wa.dto.response.VehicleShowInfoDto;
import DSC.Kick_Wa.repository.PlaceRepository;
import DSC.Kick_Wa.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final PlaceRepository placeRepository;

    //킥보드 생성
    @Transactional
    public Long create(Long placeId,Integer baseRate, Integer perMinuteRate){
        Place place = placeRepository.findOne(placeId);

        Long vehicleId = vehicleRepository.save(
                Vehicle.builder()
                        .place(place)
                        .baseRate(100)
                        .perMinuteRate(500)
                        .vehicleStatus(VehicleStatus.POSSIBLE)
                        .build()
        );
        return vehicleId;
    }

    //킥보드 삭제
    @Transactional
    public Long deleteVehicle(Long vehicleId){
        Vehicle vehicle = vehicleRepository.findOne(vehicleId);
        vehicleRepository.delete(vehicle);
        return vehicleId;
    }

    //킥보드 정보 보여주기
    public VehicleShowInfoDto vehicleShowInfo(Long vehicleId){
        Vehicle vehicle = vehicleRepository.findOne(vehicleId);
        VehicleShowInfoDto vehicleShowInfoDto = new VehicleShowInfoDto();
        vehicleShowInfoDto.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleShowInfoDto.setBaseRate(vehicle.getBaseRate());
        vehicleShowInfoDto.setEndT(vehicle.getEndT());
        vehicleShowInfoDto.setPerMinuteRate(vehicle.getPerMinuteRate());
        return vehicleShowInfoDto;
    }


}
