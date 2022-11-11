package DSC.Kick_Wa.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Long residentNum;
    private String address;
    private String phoneNum;
    private String loginId;
    private String password;

    @Builder
    public User(String name, Long residentNum, String address, String phoneNum, String loginId, String password){
        this.name = name;
        this.residentNum = residentNum;
        this.address = address;
        this.phoneNum =phoneNum;
        this.loginId = loginId;
        this.password = password;
    }

    public User(){}
}
