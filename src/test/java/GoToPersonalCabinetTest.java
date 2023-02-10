import api.LoginPojo;
import api.RegisterPojo;
import api.UserHandles;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoToPersonalCabinetTest extends BaseTest{
    RegisterPojo registerPojo;
    UserHandles userHandles;
    LoginPojo loginPojo;
    String login;
    String password;
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        registerPojo = new RegisterPojo(TestData.registerEmail, TestData.registerPassword, TestData.registerName);
        userHandles = new UserHandles();
        userHandles.apiRegisterUser(registerPojo);}
    @After
    public void cleanUp(){
        loginPojo = new LoginPojo(login, password);
        userHandles = new UserHandles();
        ValidatableResponse response = userHandles.apiLoginUser(loginPojo);
        String token = response.extract().path("accessToken");
        if (token != null) {userHandles.apiDeleteUser(token);}
    }
    @Test
    public void goToPersonalCabinetTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(registerPojo.getEmail(), registerPojo.getPassword());
        MainPage mainPageAgain = new MainPage(driver);
        mainPageAgain.clickGoToPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        Assert.assertEquals(true, personalCabinetPage.isThisPersonalCabinetPage());
    }
}
