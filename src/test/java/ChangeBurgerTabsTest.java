import org.junit.Assert;
import org.junit.Test;


public class ChangeBurgerTabsTest  extends BaseTest {
    @Test
    public void moveToBulkiTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickNachinkiTab();
        mainPage.clickBulkiTab();
        Assert.assertEquals(true, mainPage.isThisBulkiSection());
    }
    @Test
    public void moveToSauceTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauseTab();
        Assert.assertEquals(true, mainPage.isThisSauseSection());
    }
    @Test
    public void moveToNachinkiTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickNachinkiTab();
        Assert.assertEquals(true, mainPage.isThisNachinkiSection());
    }

}
