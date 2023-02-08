import org.openqa.selenium.*;
public class MainPage {
    private By goToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By goToPersonalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

    private WebDriver driver;
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }
    public void clickGoToAccountButton(){
        driver.findElement(goToAccountButton).click();
    }
    public void clickGoToPersonalCabinetButton(){
        driver.findElement(goToPersonalCabinetButton).click();
    }
}
