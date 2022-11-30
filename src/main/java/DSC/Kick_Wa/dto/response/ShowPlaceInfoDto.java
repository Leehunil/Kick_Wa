package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Place;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShowPlaceInfoDto {

    private String name;

    private List<PlaceVehicleInfoDto> vehicles;

    public ShowPlaceInfoDto(Place place){
        name = place.getName();
        vehicles = place.getVehicles().stream()
                .map(vehicle -> new PlaceVehicleInfoDto(vehicle))
                .collect(Collectors.toList());

    }
}
