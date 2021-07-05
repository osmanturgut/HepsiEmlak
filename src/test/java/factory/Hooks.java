package factory;

import com.thoughtworks.gauge.AfterScenario;

public class Hooks {
    @AfterScenario
    public void closeBrowsers() {
        BrowserProvider.getDriver().quit();
    }
}