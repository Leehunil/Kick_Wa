package DSC.Kick_Wa.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Place {

    @Id
    @GeneratedValue
    @Column(name = "place_id")
    private Long id;

    private String name;
    private Long pLocationL;
    private Long pLocationH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id")
    private Map map;

    @Builder
    public Place(String name, Long pLocationL, Long pLocationH,Map map){
        this.name = name;
        this.pLocationL = pLocationL;
        this.pLocationH = pLocationH;
        this.map = map;
    }
}
