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

    private LocalDateTime endT;
    private Integer baseRate;
    private Integer perMinuteRate;

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    @Builder
    public Vehicle(LocalDateTime endT, Integer baseRate, Integer perMinuteRate, VehicleStatus vehicleStatus){
        this.endT = endT;
        this.baseRate = baseRate;
        this.perMinuteRate = perMinuteRate;
        this.vehicleStatus = vehicleStatus;
    }
}
