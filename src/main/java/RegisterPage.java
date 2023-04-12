import api.RegisterPojo;
import api.UserHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    UserHandles userHandles;
    RegisterPojo registerPojo;
    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }
    private By registerTitle = By.xpath("//h2[text()='Регистрация']");
    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input[@name='name']");
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input[@name='name']");
    private By passwordField = By.xpath("//input[@name='Пароль']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']");
    private By incorrectPasswordToast = By.xpath("//p[@class='input__error text_type_main-default']");

    public boolean isThisRegisterPage(){
        return driver.findElement(registerTitle).isDisplayed();
    }
    public void inputName(String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputEmail(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }
    public void inputPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
    public boolean incorrectPasswordToastShouldBePresented(){
        return driver.findElement(incorrectPasswordToast).isDisplayed();
    }
    public RegisterPage getTheRegisterPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();
        return this;
    }
}

