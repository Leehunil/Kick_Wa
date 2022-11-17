package DSC.Kick_Wa.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Place {

    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private Long id;

    private String name;
    private String latitude;
    private String longitude;

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();

    @Builder
    public Place(String name, String latitude, String longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Place() {
    }
}
