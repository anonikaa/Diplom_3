import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeBurgerTabsTest  extends BaseTest {
    @Test
    public void moveToBulkiTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabConstructor("Начинки");
        mainPage.clickTabConstructor("Булки");
        WebElement sauceTitleInList = driver.findElement(By.xpath(String.format(mainPage.ingredientsTitleInListConstructor, "Булки")));
        boolean sauceElementIsDisplayed = sauceTitleInList.isDisplayed();
        Assert.assertEquals(true, sauceElementIsDisplayed);
    }
    @Test
    public void moveToSauceTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabConstructor("Соусы");
        WebElement titleInList = driver.findElement(By.xpath(String.format(mainPage.ingredientsTitleInListConstructor, "Соусы")));
        boolean sauceElementIsDisplayed = titleInList.isDisplayed();
        Assert.assertEquals(true, sauceElementIsDisplayed);
    }
    @Test
    public void moveToNachinkiTabTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTabConstructor("Начинки");
        WebElement titleInList = driver.findElement(By.xpath(String.format(mainPage.ingredientsTitleInListConstructor, "Начинки")));
        boolean sauceElementIsDisplayed = titleInList.isDisplayed();
        Assert.assertEquals(true, sauceElementIsDisplayed);
    }

}
