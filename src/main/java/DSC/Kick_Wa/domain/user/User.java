package DSC.Kick_Wa.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SpringBootApplication
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String uid;
    private String password;

    private String name;
    private String phoneNum;
    private String email;

    private Integer useCount;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Builder
    public User(String uid,String password, String name, String phoneNum, String email){
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.useCount = 0;
        this.userStatus = UserStatus.NOT_DRIVING;
    }

    public void userRentalVehicle(){
        this.userStatus = UserStatus.DRIVING;
        this.useCount+=1;
    }

    public void userReturnVehicle(){
        this.userStatus = UserStatus.NOT_DRIVING;
    }
}
