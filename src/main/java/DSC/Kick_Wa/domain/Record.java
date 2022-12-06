package DSC.Kick_Wa.domain;

import DSC.Kick_Wa.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Record {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endPlace_id")
    private Place endPlace;

    private Long useFee;
    private LocalDateTime startT;
    private LocalDateTime endT;

    @Builder
    public Record(User user, Vehicle vehicle, LocalDateTime startT){
        this.user = user;
        this.vehicle = vehicle;
        this.startT = startT;
        this.useFee = 0L;
    }

    public Long driveTime(LocalDateTime endT){
        Duration duration = Duration.between(this.startT,endT);
        Long seconds = duration.getSeconds();
        Long minute = seconds/60;
        return minute;
    }

    public void useCal(Long minute){
        this.useFee= 500+(minute * 100);
    }

    public void edit(Place endPlace,LocalDateTime endT){
        this.endPlace = endPlace;
        this.endT = endT;
    }
}
