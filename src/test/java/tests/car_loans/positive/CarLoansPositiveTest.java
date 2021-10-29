package tests.car_loans.positive;

import org.junit.jupiter.api.Test;
import pages.car_loans.CarLoansPage;
import tests.base.BaseTest;

import static constants.Constant.TimeoutVariables.carLoansURL;

public class CarLoansPositiveTest extends BaseTest {
    @Test
    public void selectAgreements(){
        basePage.goToURL(carLoansURL);
        CarLoansPage.selectAgreementsTab();
        basePage.isAuthWidgetPresented();
    }


}
