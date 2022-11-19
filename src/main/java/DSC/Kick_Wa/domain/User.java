package DSC.Kick_Wa.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String address;
    private String phoneNum;
    private String loginId;
    private String password;
    private String email;

    @CreatedDate  //생성된 시간 정보
    @Column(updatable = false) //컬럼을 수정한 이후 들어오는 데이터를 막는 것이다.
    private LocalDateTime createdAt;

    @Builder
    public User(String name, String address, String phoneNum, String loginId, String password, String email){
        this.name = name;
        this.address = address;
        this.phoneNum =phoneNum;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }

    public User(){}
}
