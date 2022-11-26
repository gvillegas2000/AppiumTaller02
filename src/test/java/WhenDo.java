import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WhenDo {

    AppiumDriver driver;

    @BeforeEach
    public void configure() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Geovany");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", "com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // implicit waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void verifyCalculator() throws InterruptedException {

        String nombre = "Test";
        String nota = "Test Appium";
        boolean eliminar = true;
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(nombre);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(nota);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Guardar']")).click();

        if(eliminar == true){
            //android.widget.ImageView[@content-desc="Más opciones"]
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Más opciones']")).click();
        }

    }

}
