package api;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class UserHandles {
    public ValidatableResponse apiLoginUser (LoginPojo login){
        return given()
                .header("Content-type", "application/json")
                .body(login)
                .when()
                .post("api/auth/login").then();
    }
    public ValidatableResponse apiDeleteUser (String token){
        return given()
                .header("Content-type", "application/json")
                .header("authorization", token)
                .when()
                .delete("api/auth/user").then();
    }
    public ValidatableResponse apiRegisterUser(RegisterPojo registerPojo){
        return given()
                .header("Content-type", "application/json")
                .body(registerPojo)
                .when()
                .post("/api/auth/register").then();
    }
}
