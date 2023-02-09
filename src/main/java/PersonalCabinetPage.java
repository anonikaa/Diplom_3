import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalCabinetPage {
    private WebDriver driver;
    private By logOutButton = By.xpath("//button[text()='Выход']");
    public PersonalCabinetPage (WebDriver driver){
        this.driver = driver;
    }

    public boolean isThisPersonalCabinetPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        return driver.findElement(logOutButton).isDisplayed();
    }
    public void clickLogOutButton(){
        driver.findElement(logOutButton).click();
    }

}
