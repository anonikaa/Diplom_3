import org.junit.Assert;
import org.junit.Test;

public class GoToPersonalCabinetTest extends BaseTest{
    @Test
    public void goToPersonalCabinetTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        MainPage mainPageAgain = new MainPage(driver);
        mainPageAgain.clickGoToPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        Assert.assertEquals(true, personalCabinetPage.isThisPersonalCabinetPage());
    }
}
