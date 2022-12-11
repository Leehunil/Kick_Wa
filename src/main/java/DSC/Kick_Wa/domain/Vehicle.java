package DSC.Kick_Wa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    private LocalDateTime endT;
    private Integer baseRate;
    private Integer perMinuteRate;

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    private String helmetPicture;

    @Builder
    public Vehicle(Place place, Integer baseRate, Integer perMinuteRate, VehicleStatus vehicleStatus,String helmetPicture){
        this.place = place;
        this.baseRate = baseRate;
        this.perMinuteRate = perMinuteRate;
        this.vehicleStatus = vehicleStatus;
        this.helmetPicture = helmetPicture;
    }



    public void rentalStatus(){
        this.vehicleStatus = VehicleStatus.DRIVING;
    }

    public void returnVehicle(LocalDateTime endT, Place place){
        this.vehicleStatus = VehicleStatus.POSSIBLE;
        this.endT = endT;
        this.place = place;
    }

    public void setEndT(LocalDateTime endT) {
        this.endT = endT;
    }
}
