import org.junit.Assert;
import org.junit.Test;

public class GoToConstructorFromLK extends BaseTest{
    @Test
    public void goToConstructorPageFromPersonalCabinetTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToPersonalCabinetButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        mainPage.clickGoToPersonalCabinetButton();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);
        personalCabinetPage.goToConstructorPage();
        Assert.assertEquals(true, mainPage.isThisMainPage());
    }
}
