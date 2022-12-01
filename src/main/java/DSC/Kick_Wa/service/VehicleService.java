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

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final PlaceRepository placeRepository;

    //킥보드 생성
    @Transactional
    public Long create(Long placeId){
        Place place = placeRepository.findById(placeId).get();

        Long vehicleId = vehicleRepository.save(
                Vehicle.builder()
                        .place(place)
                        .baseRate(100)
                        .perMinuteRate(500)
                        .vehicleStatus(VehicleStatus.POSSIBLE)
                        .build()
        ).getId();
        return vehicleId;
    }

    //킥보드 삭제
    @Transactional
    public Long deleteVehicle(Long vehicleId){
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        vehicleRepository.delete(vehicle);
        return vehicleId;
    }

    //킥보드 정보 보여주기
    public VehicleShowInfoDto vehicleShowInfo(Long vehicleId){
        Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
        VehicleShowInfoDto vehicleShowInfoDto = new VehicleShowInfoDto(vehicle.getEndT(), vehicle.getBaseRate(),
                vehicle.getPerMinuteRate(),vehicle.getVehicleStatus());
        return vehicleShowInfoDto;
    }


}
