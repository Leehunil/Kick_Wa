package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.domain.VehicleStatus;
import DSC.Kick_Wa.repository.Vehicle.VehicleRepository;
import DSC.Kick_Wa.repository.place.PlaceRepository;
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
    public Long create(Long placeId,Integer baseRate, Integer perMinuteRate){
        Place place = placeRepository.findById(placeId).get();

        Long vehicleId = vehicleRepository.save(
                Vehicle.builder()
                        .place(place)
                        .baseRate(baseRate)
                        .perMinuteRate(perMinuteRate)
                        .vehicleStatus(VehicleStatus.POSSIBLE)
                        .build()
        ).getId();
        return vehicleId;
    }


}
