import api.LoginPojo;
import api.RegisterPojo;
import api.UserHandles;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {
    LoginPojo loginPojo;
    String login;
    String password;
    UserHandles userHandles;
    RegisterPojo registerPojo;
    @Before
    public void setUp(){
        //регаемся
        RestAssured.baseURI = TestData.BASE_URL;
        registerPojo = new RegisterPojo(TestData.registerEmail, TestData.registerPassword, TestData.registerName);
        userHandles = new UserHandles();
        userHandles.apiRegisterUser(registerPojo);
        login = registerPojo.getEmail();
        password = registerPojo.getPassword();
    }
    @After
    public void deleteRegisterUser(){
        //удаляемся
        loginPojo = new LoginPojo(login, password);
        userHandles = new UserHandles();
        ValidatableResponse response = userHandles.apiLoginUser(loginPojo);
        String token = response.extract().path("accessToken");
        if (token != null) {userHandles.apiDeleteUser(token);}
    }

    @Test
    public void successLoginFromMainPageTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputCorrectEmail(login);
        loginPage.inputCorrectPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(true, loginPage.itShouldBeCreateOrderButton());
    }
    @Test
    public void successLoginFromPersonalCabinet(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(true, loginPage.isThisLoginPage());
        loginPage.inputCorrectEmail(login);
        loginPage.inputCorrectPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(true, loginPage.itShouldBeCreateOrderButton());
    }
    @Test
    public void successLoginFromRegisterPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertEquals(true, registerPage.isThisRegisterPage());
        registerPage.clickLoginLink();
        LoginPage loginPageAgain = new LoginPage(driver);
        Assert.assertEquals(true, loginPageAgain.isThisLoginPage());
        loginPageAgain.inputCorrectEmail(login);
        loginPageAgain.inputCorrectPassword(password);
        loginPageAgain.clickLoginButton();
        Assert.assertEquals(true, loginPageAgain.itShouldBeCreateOrderButton());
    }
    @Test
    public void successLoginFromRestorePasswordPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRestorePasswordLink();
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.clickLoginButton();
        LoginPage loginPageAgain = new LoginPage(driver);
        Assert.assertEquals(true, loginPageAgain.isThisLoginPage());
        loginPageAgain.inputCorrectEmail(login);
        loginPageAgain.inputCorrectPassword(password);
        loginPageAgain.clickLoginButton();
        Assert.assertEquals(true, loginPageAgain.itShouldBeCreateOrderButton());
    }
}
