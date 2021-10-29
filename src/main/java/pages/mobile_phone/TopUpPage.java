package pages.mobile_phone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TopUpPage extends BasePage {

    public TopUpPage(WebDriver driver) {
        super(driver);
    }

    private static final String buttonWallet = ("//div[contains(text(),\"My wallet\")]");
    public static final String inputCardFrom = ("//input[@class='sc-bYSBpT fJGOXC']");
    public static final String inputCardExpDate = ("//*[@id=\"app\"]/div[2]/section/div/div[1]/div[2]/div[1]/div/form/div[4]/div/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/input");
    public static final String inputCardCVV = ("//*[@id=\"app\"]/div[2]/section/div/div[1]/div[2]/div[1]/div/form/div[4]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/input");
    public static final String inputPhoneNumber = ("//input[@class='sc-bYSBpT exvPPD']");
    public static final String inputAmount = ("//input[@data-qa-node='amount']");
    public static final String submitButton = ("//button[@class='sc-VigVT cQOKFU']");


    public static void selectCardFromWallet() {
        driver.findElement(By.xpath(buttonWallet)).click();
    }

    public static void enterPhoneNumber (String phoneNumber){
        driver.findElement(By.xpath(inputPhoneNumber)).sendKeys(phoneNumber);
    }
    public static void enterAmount (String amount){
        driver.findElement(By.xpath(inputAmount)).sendKeys(amount);
    }
    public static void enterCardNumber(String cardNumber){
        driver.findElement(By.xpath(inputCardFrom)).sendKeys(cardNumber);
    }
    public static void enterCardDate(String date){
        driver.findElement(By.xpath(inputCardExpDate)).sendKeys(date);
    }
    public static void enterCCV(String ccv){
        driver.findElement(By.xpath(inputCardCVV)).sendKeys(ccv);
    }
    public static void submitButton(){
        driver.findElement(By.xpath(submitButton)).submit();
    }

}
