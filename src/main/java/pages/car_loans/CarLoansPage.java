package pages.car_loans;

import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;


public class CarLoansPage extends BasePage {

    public CarLoansPage(WebDriver driver) {
        super(driver);

    }

    public static final By agreements =By.xpath("//*[@id=\"app\"]/div[2]/section/div[2]/a[2]/div");

    public static void selectAgreementsTab(){
        driver.findElement(agreements).click();
    }
}
