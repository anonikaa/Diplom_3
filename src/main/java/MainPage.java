import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private By goToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By goToPersonalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");
    private By createOrder = By.xpath("//button[text()='Оформить заказ']");
    public String tabsConstructor = "//section[contains(@class, 'BurgerIngredients')]//span[text()='%s']";
    public String ingredientsTitleInListConstructor = "//h2[contains(text(), '%s')]";
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
    public boolean isThisMainPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrder));
        return driver.findElement(createOrder).isDisplayed();
    }
    public void clickTabConstructor(String ingredient){
        driver.findElement(By.xpath(String.format(tabsConstructor, ingredient))).click();
    }
}
