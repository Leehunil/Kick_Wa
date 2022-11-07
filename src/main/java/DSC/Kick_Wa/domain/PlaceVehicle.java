package DSC.Kick_Wa.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PlaceVehicle {

    @Id
    @GeneratedValue
    @Column(name = "placeVehicle_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
