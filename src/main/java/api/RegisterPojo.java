package api;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RegisterPojo {
    private String email;
    private String password;
    private String name;
    public RegisterPojo(){}
    public RegisterPojo (String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
        }
}
