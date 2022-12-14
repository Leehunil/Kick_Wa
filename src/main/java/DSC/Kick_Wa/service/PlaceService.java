package DSC.Kick_Wa.service;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.dto.SavePlaceRequestDto;
import DSC.Kick_Wa.dto.response.ShowPlaceInfoDto;
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
                        .latitude(savePlaceRequestDto.getLatitude())
                        .longitude(savePlaceRequestDto.getLongitude())
                        .build()
        ).getId();
    }
    public ShowPlaceInfoDto showPlaceInfo(Long placeId){
        Place place = placeRepository.findByPlaceId(placeId).get();
        ShowPlaceInfoDto showPlaceInfoDto = new ShowPlaceInfoDto(place);
        return showPlaceInfoDto;
    }
}
