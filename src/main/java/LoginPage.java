import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By emailField = By.xpath("//label[text()='Email']");
    private By passwordField = By.xpath("//label[text()='Пароль']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By loginTitle = By.xpath("//h2[text()='Вход']");
    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By restorePasswordLink = By.xpath("//a[text()='Восстановить пароль']");


    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isThisLoginPage(){
        return driver.findElement(loginTitle).isDisplayed();
    }
    public void inputCorrectEmail(){}
    public void inputCorrectPassword(){}
    public void clickLoginButton(){}
    public void clickRegisterLink(){}
    public void clickRestorePasswordLink(){}


}
