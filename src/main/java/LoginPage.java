import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
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
        return driver.findElement(loginTitle).isDisplayed();
    }
    public void inputCorrectEmail(){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(TestData.EXIST_EMAIL);
    }
    public void inputCorrectPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(TestData.EXIST_PASSWORD);
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
    public void login(){
        inputCorrectEmail();
        inputCorrectPassword();
        clickLoginButton();
        itShouldBeCreateOrderButton();

    }
}
