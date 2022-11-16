package DSC.Kick_Wa.dto;

import lombok.Getter;

@Getter
public class SavePlaceRequestDto {

    private String name;

    private String longitude;

    private String latitude;

    public SavePlaceRequestDto( String name, String longitude, String latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
