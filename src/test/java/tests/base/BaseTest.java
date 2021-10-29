package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;
import pages.car_loans.CarLoansPage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;


@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarLoansPage carLoansPage = new CarLoansPage(driver);
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    @AfterEach
    void clearCookiesAndLocalStorage(){
if(clearCookie){
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    driver.manage().deleteAllCookies();
    javascriptExecutor.executeScript("window.sessionStorage.clear()");

}
    }

    static {
LOGGER.info("Start time: "+ LocalTime.now());
LOGGER.info("Starting clear reports directory");
        File allureResults = new File("allure-results/");
        if(allureResults.isDirectory()){
            for(File item: Objects.requireNonNull(allureResults.listFiles())){
                item.delete();
            }
        }
        if(cleanReportDirectory){
            File allureScreenshots = new File("build/reports/tests/");
            for(File item: Objects.requireNonNull(allureScreenshots.listFiles())){
                item.delete();
            }
        }
    }


    @AfterAll
    void close(){
        if(!holdBrowser){
            driver.close();
        }
    }
}
