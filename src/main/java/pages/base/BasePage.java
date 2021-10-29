package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariables.explicityWait;

public class BasePage {
    public static WebDriver driver;
    public final By authWidget = By.xpath("//iframe[@src='https://login-widget.privat24.ua/']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToURL(String URL){
        driver.navigate().to(URL);

    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,explicityWait).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void isAuthWidgetPresented(){
    WebElement authFrame = driver.findElement(authWidget);
        waitElementIsVisible(authFrame);


    }
}
