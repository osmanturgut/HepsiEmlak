package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum define how to initialize each browser driver.
 *
 * @author ejunior
 */
public enum Browser {

    CHROMEWEB {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            return new ChromeDriver(options);
        }
    },

    CHROMEMOBILE {
        @Override
        public WebDriver initialize(DesiredCapabilities capabilities) {

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
            return new ChromeDriver(chromeOptions);


        }
    };


    /**
     * Method to be implemented by each Browser Enum.
     *
     * @param capabilities
     * @return
     */
    public abstract WebDriver initialize(DesiredCapabilities capabilities);

    @Override
    public String toString() {
        switch (this) {
            case CHROMEMOBILE:
                return "CHROMEMOBILE";
            case CHROMEWEB:
                return "CHROMEWEB";
            default:
                throw new IllegalArgumentException();
        }
    }
}
