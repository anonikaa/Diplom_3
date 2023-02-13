import api.LoginPojo;
import api.UserHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    LoginPojo loginPojo;
    UserHandles userHandles;

    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input[@name='name']");
    private By passwordField = By.xpath("//input[@name='Пароль']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By loginTitle = By.xpath("//h2[text()='Вход']");
    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By restorePasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    private By createOrder = By.xpath("//button[text()='Оформить заказ']");

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isThisLoginPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(loginTitle));
        return driver.findElement(loginTitle).isDisplayed();
    }
    public void inputEmail(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
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

    public boolean itShouldBeCreateOrderButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrder));
        return driver.findElement(createOrder).isDisplayed();
    }

    public void login(String login, String password){
        loginPojo = new LoginPojo (login,  password);
        userHandles = new UserHandles();
        userHandles.apiLoginUser(loginPojo);
        inputEmail(loginPojo.getEmail());
        inputPassword(loginPojo.getPassword());
        clickLoginButton();
        itShouldBeCreateOrderButton();
    }
}
