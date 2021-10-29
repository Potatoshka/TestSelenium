package tests.base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {
    public static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test -{} -- Failed",context.getTestMethod().get().getName());
        String scfreenshotName = context.getTestMethod().get().getName() + Math.random();
        LOGGER.info("Trying to get Screenshot");
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(source,new File("build/reports/tests/"+scfreenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("Exception on saving screenshot");
        }

    }
}
