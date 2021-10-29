package tests.mobile_phone.positive;

import org.junit.jupiter.api.Test;
import pages.mobile_phone.TopUpPage;
import tests.base.BaseTest;

import static constants.Constant.TimeoutVariables.topUpURL;
import static constants.Constant.TopUpTestConstants.*;

public class TopUpPagePositiveTest extends BaseTest  {
    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToURL(topUpURL);
        TopUpPage.selectCardFromWallet();
        basePage.isAuthWidgetPresented();
    }

    @Test
    public void checkMinimumReplenishmentAmount(){
        basePage.goToURL("https://next.privat24.ua/mobile?lang=en");
        TopUpPage.enterPhoneNumber(phoneNumber);
        TopUpPage.enterAmount("200");
        TopUpPage.enterCardNumber(cardNumber);
        TopUpPage.enterCardDate(date);
        TopUpPage.enterCCV(ccv);
        TopUpPage.submitButton();


    }


}
