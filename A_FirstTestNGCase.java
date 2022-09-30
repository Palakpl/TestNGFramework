import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class A_FirstTestNGCase {
    WebDriver driver;
    @Test(priority = 1)
    void openBrowser()
    {
        System.out.printf("Open Browser");
        System.setProperty("webdriver.chrome.driver","C:\\Software\\SoftwareDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    void registerUser()
    {
        System.out.println("User is able to register");
    }
//
    @Test(priority = 3)
    void selectItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
        //driver.findElement(By.linkText("shopping cart")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")));

        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
//        try
//        {
//        Alert alert = driver.switchTo().alert();
//        Thread.sleep(2000);
//        //System.out.println(alert.getText());
//        alert.accept();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();

        //
//        WebElement targetElement = driver.findElement(By.xpath("/html/body/div[5]/div/p/a"));
//            Actions action = new Actions(driver);
//            Thread.sleep(2000);
//            action.click(targetElement).build().perform();
//
//        }
//
//        catch (Exception e)
//        {
//
//        }


    }
    @Test(priority = 4)
    void checkout()
    {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/form/div/div/div[2]/div/div/div[1]/input")).sendKeys("Mantra");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Pancholi");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("mpancholi@yahoo.com");
        //driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Mantra");
        WebElement Country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select = new Select(Country);
        select.selectByValue("133");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Ahmedabad");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Bodakdev");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("38451");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("4578535525");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();

    }
 @Test(priority = 5)
 void shippingType()
  {
    //driver.findElement(By.id("shippingoption_1")).click();
      driver.findElement(By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]")).click();
   //driver.findElement(By.id("shippingoption_0")).click();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      WebElement radio = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[1]/div/div/ul/li[1]/div[1]/input"));
     // Select select = new Select(radio);
      radio.click();
      //select.selectByValue("Ground___Shipping.FixedByWeightByTotal");
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();

  }
  @Test(priority = 6)
    void paymentMethod()
  {
      WebElement radio = driver.findElement(By.id("paymentmethod_1"));
      radio.click();
      driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
  }
  @Test(priority = 7)
    void paymentInformation()
  {
    WebElement cardType = driver.findElement(By.className("dropdownlists"));
    Select select = new Select(cardType);
    select.selectByValue("MasterCard");
    driver.findElement(By.id("CardholderName")).sendKeys("M Pancholi");
    driver.findElement(By.id("CardNumber")).sendKeys("122456");
    WebElement month = driver.findElement(By.id("ExpireMonth"));
    Select select1 = new Select(month);
    select1.selectByValue("6");
    WebElement year = driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]"));
    Select select2 = new Select(year);
    select2.selectByValue("2026");
    driver.findElement(By.id("CardCode")).sendKeys("789");
    driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();

  }

//    @Test(priority = 4)
//    void closeBrowser() throws InterruptedException {

//        Thread.sleep(2000);
//        driver.close();
//    }
}
