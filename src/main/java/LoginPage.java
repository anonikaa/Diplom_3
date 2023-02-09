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
    public void inputCorrectEmail(){
        driver.findElement(emailField).sendKeys(TestData.EMAIL_FOR_LOGIN);
    }
    public void inputCorrectPassword(){
        driver.findElement(passwordField).sendKeys(TestData.PASSWORD_FOR_LOGIN);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }
    public void clickRestorePasswordLink(){
        driver.findElement(restorePasswordLink).click();
    }
}
