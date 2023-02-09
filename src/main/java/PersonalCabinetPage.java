import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinetPage {
    private WebDriver driver;
    private By logOutButton = By.xpath("//button[text()='Выход']");
    public PersonalCabinetPage (WebDriver driver){
        this.driver = driver;
    }

    public boolean isThisPersonalCabinetPage(){
        return driver.findElement(logOutButton).isDisplayed();
    }
    public void clickLogOutButton(){
        driver.findElement(logOutButton).click();
    }
}
