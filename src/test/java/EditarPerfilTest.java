import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class EditarPerfilTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {

        BaseOptions options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:noReset", true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void sampleTest() throws InterruptedException {

        // BOTON PROFILE
        WebElement profile = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Profile\nTab 5 of 5")
                )
        );

        profile.click();

        Thread.sleep(2000);

        // BOTON EDIT
        WebElement edit = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.Button\").index(0)"
                        )
                )
        );

        edit.click();

        Thread.sleep(2000);

        // INPUT UNIVERSIDAD
        WebElement universidad = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").index(5)"
                        )
                )
        );

        universidad.click();
        universidad.clear();
        universidad.sendKeys("PUCP");

        Thread.sleep(2000);

        // BOTON REGION
        WebElement region = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Region (Perú)")
                )
        );

        region.click();

        Thread.sleep(2000);

        // BOTON REGION SELECCIONADA

        WebElement regionSelected = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Lima")
                )
        );

        regionSelected.click();

        Thread.sleep(2000);

        // INPUT DESCRIPCION
        WebElement imgprofile = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").index(0)"
                        )
                )
        );

        imgprofile.click();
        imgprofile.sendKeys("https://i.ibb.co/3yLc8xgj/profile.jpg");

        Thread.sleep(2000);


        // CLICK FINAL CREATE GROUP
        WebElement finalUpdateProfile = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Save Changes")
                )
        );

        finalUpdateProfile.click();

        Thread.sleep(3000);
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}