package digital.norse.bua;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AuthTest {

     private static WebDriver driver;


     @BeforeClass
         public static void setup() {
         System.setProperty("webdriver.chrome.driver", "/home/ik/projects/bua/chromedriver/chromedriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://admin.bua.dev.norse.digital/");
     }

     @Test
    public void userLogin() {
          WebElement loginField = driver.findElement(new By.ByXPath("//*[@id=\"app\"]/div/main/div/div/form/div[1]/div/input"));
         loginField.sendKeys("admin");
         WebElement passwordField = driver.findElement(new By.ByXPath("//*[@id=\"app\"]/div/main/div/div/form/div[2]/div/input"));
         passwordField.sendKeys("publish");
         WebElement loginButton = driver.findElement(By.tagName("button"));
         loginButton.click();
         WebElement adminDashboard = driver.findElement(By.name("Oversikt"));
         String adminMenu = adminDashboard.getText();
         Assert.assertEquals("Oversikt", adminMenu);
    }
    @Test
    // Navigate to locations and create new location
    public void locations() {
         WebElement locMenuItem = driver.findElement(new By.ByXPath("//*[@id=\"app\"]/div/header/nav/div[1]/ul/li[2]/a"));
         locMenuItem.click();
         WebDriverWait wait = (new WebDriverWait(driver, 5));
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/main/table/thead/tr/td[1]/a/span")));
         WebElement CreateLocationButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/main/h1/button"));
         CreateLocationButton.click();
         WebDriverWait wait1 = (new WebDriverWait(driver, 5));
         wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[1]/label/span")));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         WebElement VelgType = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[1]/div[1]/label"));
         VelgType.click();
        WebDriverWait wait2 = (new WebDriverWait(driver, 5));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[4]/div/input")));
         WebElement LocationName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[4]/div/input"));
         LocationName.sendKeys("ik test location");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement NesteButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/div[3]/button/span"));
        NesteButton.click();
        WebElement CrossButton = driver.findElement(By.xpath("/html/body/div[2]/a"));
        CrossButton.click();

    }

      @AfterClass
      public static void tearDown() {
          WebElement adminUser = driver.findElement(By.className("Select-multi-value-wrapper"));
          adminUser.click();
          WebElement logoutButton = driver.findElement(By.className("Select-control"));
          logoutButton.click();
          driver.quit();
 }

 private void selectElementInFiler(String text ){
         driver.findElement(By.className(".sc-bwzfXH.iRbVbm [name]")).getAttribute(text);


 }
}