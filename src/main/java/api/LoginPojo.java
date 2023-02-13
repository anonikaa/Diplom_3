package api;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginPojo {
    private String email;
    private String password;
    public LoginPojo(){}
    public LoginPojo(String email, String password){
        this.email = email;
        this.password = password;
    }

}
