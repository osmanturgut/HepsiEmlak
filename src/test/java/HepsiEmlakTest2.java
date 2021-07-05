import com.thoughtworks.gauge.Step;
import enums.Browser;
import factory.BrowserProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


public class HepsiEmlakTest2 {
    protected static WebDriver driver = null;
    public JavascriptExecutor executor;
    static Long timeout = Long.parseLong("30");
    static WebDriverWait wait;

    public WebElement visibilityElement(By by) {
        return (WebElement) this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void sendKeys(By by, CharSequence text) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public void clickVisibilityElement(By by) {
        this.visibilityElement(by).click();
    }

    @Step("<url> url'ye Git")
    public void url(String url) {
        driver.get(url);
    }

    @Step("<xpath> beklemeli xpath li elemente tikla")
    public void xpathliElementeTikla(String xpath) {
        clickVisibilityElement((By.xpath(xpath)));

    }

    @Step("<selector> beklemeli css li elemente tikla")
    public void cssliElementeTikla(String selector) {
        clickVisibilityElement(By.cssSelector(selector));

    }

    @Step("<kutu> yeni ya girilen <miktar> degeri")
    public void girilenDeger(String kutu, String miktar) {
        sendKeys(By.cssSelector(kutu), miktar);
    }

    @Step("<kategori>is yeri kategori seç")
    public void kategoriSecimi(String kategori) {
        WebElement element = driver.findElement(By.cssSelector(kategori));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    @Step("<jsExecuter> executer'li elemente tiklayalim")
    public void javaScripExecuterBekleme(String jsExecuter) {
        WebElement element = driver.findElement(By.cssSelector(jsExecuter));
        wait.until(ExpectedConditions.visibilityOf(element));
        executor.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    @Step("<jsExecuter> executer'li elemente tikla ")
    public void javaScripExecuter(String jsExecuter) {
        WebElement element = driver.findElement(By.cssSelector(jsExecuter));
        executor.executeScript("arguments[0].click();", element);
    }

    @Step("scroll yap")
    public void scrollDown() throws InterruptedException {
        waitForSecond();
        executor.executeScript("window.scrollBy(0,250)");
    }

    @Step("1 saniye bekle")
    public void waitForSecond() throws InterruptedException {
        Thread.sleep(1500);
    }

    @Step("<test> clickle")
    public void clickElement(String test) {
        WebElement element = driver.findElement(By.cssSelector(test));
        ((WebElement) this.wait.until(ExpectedConditions.elementToBeClickable(element))).click();
    }

    @Step("<element> element ile <excepted> kontrol edilmesi")
    public void filtreKontrol(String element, String excepted) {
        WebElement webElement = visibilityElement(By.xpath(element));
        String actual = webElement.getText();
        System.out.println("Asertion : " + actual);
        Assert.assertEquals(actual, excepted);

    }

    public void validatePhoneNumber(String number) {
        Pattern pattern = Pattern.compile("(0)[5-9][0-9][0-9][\\s]([0-9]){3}[\\s]([0-9]){2}[\\s]([0-9]){2}");
        Matcher matcher = pattern.matcher(number);
        assertTrue(matcher.matches());
    }

    @Step("satan kisinin <iletisim> bilgilerini getir ve kontrol et")
    public void phone(String kontrol) {
        List<WebElement> liElements = driver.findElements(By
                .xpath(kontrol));

        for (int i = 1; i < liElements.size() + 1; i++) {
            WebElement linkElement = driver
                    .findElement(By
                            .xpath(kontrol + "[" + i
                                    + "]/a"));
            validatePhoneNumber(linkElement.getText());

        }
    }

    @Step("<text>verilen xpathin textini al")
    public void xpathText(String text) {

        WebElement element = driver.findElement(By.xpath(text));
        wait.until(ExpectedConditions.visibilityOf(element));
        String deger = element.getAttribute("href");
        Pattern pattern = Pattern.compile("^(0(\\d{10}))$");
        Matcher matcher = pattern.matcher(deger.substring(6));
        assertTrue(matcher.matches());
        System.out.println("geldi : " + deger.substring(6));

    }

    @Step("<filtre> filtre kontrol edilmesi")
    public void MobileFiltreKontrol(String filtre) {
        List<WebElement> liElements = driver.findElements(By
                .xpath(filtre));
        for (int i = 1; i < liElements.size(); i++) {
            WebElement linkElement = driver
                    .findElement(By
                            .xpath(filtre + "[" + i
                                    + "]/div/div/p"));

        }
    }

    @Step("<platform> test olarak çaliştirilir")
    public void platformSecimi(String platform) {
        driver = BrowserProvider.createDriver(Browser.valueOf(platform.toUpperCase()));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30L, 500L);
        executor = (JavascriptExecutor) driver;
    }


}


