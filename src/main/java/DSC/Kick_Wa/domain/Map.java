package DSC.Kick_Wa.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Map {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
}
