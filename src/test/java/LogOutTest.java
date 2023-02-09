import org.junit.Assert;
import org.junit.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void logOutTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        mainPage.clickGoToPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.clickLogOutButton();
        Assert.assertEquals(true, loginPage.isThisLoginPage());
    }
}
