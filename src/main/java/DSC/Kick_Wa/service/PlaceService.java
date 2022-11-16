package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.dto.SavePlaceRequestDto;
import DSC.Kick_Wa.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Transactional
    public void savePlace(SavePlaceRequestDto savePlaceRequestDto){
        Long placeId = placeRepository.save(
                Place.builder()
                        .name(savePlaceRequestDto.getName())
                        .pLocationL(savePlaceRequestDto.getLatitude())
                        .pLocationH(savePlaceRequestDto.getLongitude())
                        .build()
        );
    }
}
