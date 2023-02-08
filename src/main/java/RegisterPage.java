import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }
    private By registerTitle = By.xpath("");
    private By nameField = By.xpath("");
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By registerButton = By.xpath("");
    private By loginLink = By.xpath("");

    public boolean isThisRegisterPage(){return}
    public void inputCorrectName(){}
    public void inputCorrectEmail(){}
    public void inputCorrectPassword(){}
    public void inputIncorrectPassword(){}
    public void clickRegisterButton(){}
    public void clickLoginLink(){}
}

