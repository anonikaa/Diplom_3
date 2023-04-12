import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private WebDriver driver;
    public RestorePasswordPage(WebDriver driver){
        this.driver = driver;
    }
    private By loginButton = By.xpath("//a[text()='Войти']");

    public void clickLoginButton(){
       driver.findElement(loginButton).click();
    }
}
