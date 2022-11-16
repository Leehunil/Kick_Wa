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
    private String pLocationL;
    private String pLocationH;

    @Builder
    public Place(String name, String pLocationL, String pLocationH){
        this.name = name;
        this.pLocationL = pLocationL;
        this.pLocationH = pLocationH;
    }

    public Place() {
    }
}
