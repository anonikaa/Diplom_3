import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private By goToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By goToPersonalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");
    private By createOrder = By.xpath("//button[text()='Оформить заказ']");
    private By bulkiTab = By.xpath("//section[contains(@class, 'BurgerIngredients')]//span[text()='Булки']");
    private By bulkiCurrentSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Булки']");
    private By sauseTab = By.xpath("//section[contains(@class, 'BurgerIngredients')]//span[text()='Соусы']");
    private By sauseCurrentSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Соусы']");
    private By nachinkiTab = By.xpath("//section[contains(@class, 'BurgerIngredients')]//span[text()='Начинки']");
    private By nachinkiCurrentSection = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Начинки']");

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
    public void clickBulkiTab(){
        driver.findElement(bulkiTab).click();
    }
    public boolean isThisBulkiSection(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(bulkiCurrentSection));
        return driver.findElement(bulkiCurrentSection).isDisplayed();
    }
    public void clickSauseTab(){
        driver.findElement(sauseTab).click();
    }
    public boolean isThisSauseSection(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(sauseCurrentSection));
        return driver.findElement(sauseCurrentSection).isDisplayed();
    }
    public void clickNachinkiTab(){
        driver.findElement(nachinkiTab).click();
    }
    public boolean isThisNachinkiSection(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(nachinkiCurrentSection));
        return driver.findElement(nachinkiCurrentSection).isDisplayed();
    }
}
