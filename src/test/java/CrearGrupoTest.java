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

public class CrearGrupoTest {

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

        // BOTON GROUPS
        WebElement groups = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Groups\nTab 2 of 5")
                )
        );

        groups.click();

        Thread.sleep(2000);

        // BOTON CREATE GROUP
        WebElement createGroup = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Create Group")
                )
        );

        createGroup.click();

        Thread.sleep(2000);

        // INPUT NOMBRE DEL GRUPO
        WebElement groupName = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").index(1)"
                        )
                )
        );

        groupName.click();
        groupName.sendKeys("Grupo de Literatura");


        Thread.sleep(2000);


        // INPUT DESCRIPCION
        WebElement description = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").index(5)"
                        )
                )
        );

        description.click();
        description.sendKeys("grupo para estudiar literatura");

        Thread.sleep(2000);

        // CLICK EN SELECT A SUBJECT
        WebElement selectSubject = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.Button\").index(3)"
                        )
                )
        );

        selectSubject.click();

        Thread.sleep(2000);

        // CLICK EN MATEMATICAS
        WebElement matematicas = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Lengua y Literatura")
                )
        );

        matematicas.click();

        Thread.sleep(2000);

        // CLICK FINAL CREATE GROUP
        WebElement finalCreateGroup = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Create Group")
                )
        );

        finalCreateGroup.click();

        Thread.sleep(3000);
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}