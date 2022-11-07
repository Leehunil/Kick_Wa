package DSC.Kick_Wa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
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
    @JoinColumn(name = "startPlace_id")
    private Place startPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endPlace_id")
    private Place endPlace;

    private Integer useCount;
    private LocalDateTime startT;
    private LocalDateTime endT;


}
