package DSC.Kick_Wa.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
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

    @Builder
    public Vehicle(Place place, Integer baseRate, Integer perMinuteRate, VehicleStatus vehicleStatus){
        this.place = place;
        this.baseRate = baseRate;
        this.perMinuteRate = perMinuteRate;
        this.vehicleStatus = vehicleStatus;
    }



    public void rentalStatus(){
        this.vehicleStatus = VehicleStatus.DRIVING;
    }

    public void returnVehicle(LocalDateTime endT, Place place){
        this.vehicleStatus = VehicleStatus.POSSIBLE;
        this.endT = endT;
        this.place = place;
    }

    public void setEndT(LocalDateTime endT){
        this.endT = endT;
    }

}
