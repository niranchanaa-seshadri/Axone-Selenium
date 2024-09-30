import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestFullPageScreenshot {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void testFullPageScreenshot() throws IOException {

        Object devicePixelRatio = ((JavascriptExecutor)driver).executeScript("return window.devicePixelRatio");
        String dprValue = String.valueOf(devicePixelRatio);
        float windowDPR = Float.parseFloat(dprValue);

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(windowDPR),1000))
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "png", new File("target/AshotFullPageScreen.png"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
