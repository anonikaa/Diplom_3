import api.LoginPojo;
import api.UserHandles;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RegisterTest extends BaseTest{
    String login;
    String password;
    private UserHandles userHandles;
    private LoginPojo loginPojo;
    @Before
    public void setUp(){
    RestAssured.baseURI = TestData.BASE_URL;}

    @After
    public void deleteRegisterUser(){
        loginPojo = new LoginPojo(login, password);
        userHandles = new UserHandles();
        ValidatableResponse response = userHandles.apiLoginUser(loginPojo);
        String token = response.extract().path("accessToken");
        if (token != null) {userHandles.apiDeleteUser(token);}
    }

    @Test
    public void registerWithIncorrectPasswordTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(true, loginPage.isThisLoginPage());
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertEquals(true, registerPage.isThisRegisterPage());
        login = TestData.registerEmail;
        password = TestData.INCORRECT_PASSWORD;

        registerPage.inputName(TestData.registerName);
        registerPage.inputEmail(login);
        registerPage.inputPassword(password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(true, registerPage.incorrectPasswordToastShouldBePresented());
    }
    @Test
    public void successRegisterTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getTheRegisterPage();
        Assert.assertEquals(true, registerPage.isThisRegisterPage());

        login = TestData.registerEmail;
        password = TestData.registerPassword;
        registerPage.inputName(TestData.registerName);
        registerPage.inputEmail(login);
        registerPage.inputPassword(password);
        registerPage.clickRegisterButton();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(true, loginPage.isThisLoginPage());
    }
}
