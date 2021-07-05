import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
/*
    protected static WebDriver driver = null;

    String device="web"; // Mobile çalıştırılması için web yerine mobile yazılmalıdır.

@AfterScenario
    public void setup() {
        if (device.equals("web")){
            System.out.println("web geldi");

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver = new ChromeDriver(options);

        }
        else if (device.equals("mobile")) {
            Map<String, Object> deviceMetrics = new HashMap<>();

            deviceMetrics.put("width", 700);

            deviceMetrics.put("height", 478);

            deviceMetrics.put("pixelRatio", 3.0);


            Map<String, Object> mobileEmulation = new HashMap<>();

            mobileEmulation.put("deviceMetrics", deviceMetrics);

            mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
        }

    }

    @AfterScenario
    public void tearDown() {
        //  driver.close();
        //   driver.quit();
    }
*/
}
