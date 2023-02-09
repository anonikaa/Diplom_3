import api.LoginPojo;
import api.UserHandles;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class RegisterTest extends BaseTest{
    String login;
    String password;
    private UserHandles userHandles;
    private LoginPojo loginPojo;
    @After
    public void deleteRegisterUser(){
        loginPojo = new LoginPojo(login, password);
        userHandles = new UserHandles();
        ValidatableResponse response = userHandles.apiLoginUser(loginPojo);
        String token = response.extract().path("accessToken");
        System.out.println(token);
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
        registerPage.inputCorrectName(TestData.registerName);
        registerPage.inputCorrectEmail(TestData.registerEmail);
        registerPage.inputIncorrectPassword();
        registerPage.clickRegisterButton();
        Assert.assertEquals(true, registerPage.incorrectPasswordToastShouldBePresented());
    }
    @Test
    public void successRegisterTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getTheRigisterPage();
        Assert.assertEquals(true, registerPage.isThisRegisterPage());
        login = TestData.registerEmail;
        password = TestData.registerPassword;
        registerPage.inputCorrectName(TestData.registerName);
        registerPage.inputCorrectEmail(login);
        registerPage.inputCorrectPassword(password);
        registerPage.clickRegisterButton();
    }
}
