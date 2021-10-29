package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.Browser;
import static constants.Constant.TimeoutVariables.Wait;

public class CommonActions {
    public static WebDriver createDriver (){
        WebDriver driver = null;
        switch (Browser){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Opera":
                System.setProperty("webdriver.opers.driver","src/main/resources/operadriver.exe");
                driver = new OperaDriver();
                break;
            default:
                Assertions.fail("Incorrect driver");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Wait, TimeUnit.SECONDS);
        return driver;
    }
}
