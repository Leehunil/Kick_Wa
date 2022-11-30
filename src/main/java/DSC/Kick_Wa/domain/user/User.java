package DSC.Kick_Wa.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String email;
    private String picture;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer useCount;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.useCount = 0;
        this.userStatus = UserStatus.NOT_DRIVING;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    public void userRentalVehicle(){
        this.userStatus = UserStatus.DRIVING;
        this.useCount+=1;
    }

    public void userReturnVehicle(){
        this.userStatus = UserStatus.NOT_DRIVING;
    }
}
