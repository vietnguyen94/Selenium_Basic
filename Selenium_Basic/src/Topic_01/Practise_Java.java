package Topic_01;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise_Java {
	WebDriver driver;
  @Test
  public void TC_01_LoginEmpty() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://live.guru99.com");
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//button[@title='Login']")).click();
	  String actualEmail= driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  String expectedEmailFaild = "This is a required field.";  
	  Assert.assertEquals(actualEmail, expectedEmailFaild);
	  String actualPassword = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  String expectedPasswordFail = "This is a required field.";
	  Assert.assertEquals(actualPassword, expectedPasswordFail);
  }
	  @Test
  public void TC_02_LoginWithEmailInvalid() {
	  driver = new FirefoxDriver(); 
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://live.guru99.com");
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
	  driver.findElement(By.xpath("//button[@title='Login']")).click();
	  String actualEmailFaild = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	  String expectedOutPut = "Please enter a valid email address. For example johndoe@domain.com.";
	  Assert.assertEquals(actualEmailFaild, expectedOutPut);
	  
  }
	  @Test
	  public void TC_05_CreateAnAccount() {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("http://live.guru99.com");
		  driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		  driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Vu");
		  driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Bao");
		  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Vy");
		  String emailRandom = UUID.randomUUID().toString().replace("-", "");
		  emailRandom += "@gmail.com";
		  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailRandom);
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123123123");
		  driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123123123");
		  driver.findElement(By.xpath("//button[@title='Register']")).click();
		  String expectedRegisterSuccess = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
		  String actualRegisterSuccess = "Thank you for registering with Main Website Store.";
		  Assert.assertEquals(actualRegisterSuccess, expectedRegisterSuccess);
		  String expectedURL = "http://live.guru99.com/index.php/customer/account/logoutSuccess/";
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
		  driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
		  String actualUrl = driver.getCurrentUrl();
		  Assert.assertEquals(expectedURL, actualUrl);
	  }
	  @Test
	  public void TC_03_LoginWithPasswordlessthan6characters() {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("http://live.guru99.com");
		  driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		  driver.findElement(By.xpath("//button[@title='Login']")).click();
		  String actualPasswordFaild = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
		  String expectedPasswordFail = "Please enter 6 or more characters without leading or trailing spaces.";
		  Assert.assertEquals(actualPasswordFaild, expectedPasswordFail);
	  }
  
	  @Test
	  public void TC_04_LoginWithPasswordInvalid() {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("http://live.guru99.com");
		  driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
		  driver.findElement(By.xpath("//button[@title='Login']")).click();
		  String actualPasswordFaild = driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
		  String expectedPasswordFail = "Invalid login or password.";
		  Assert.assertEquals(actualPasswordFaild, expectedPasswordFail);
	  }
}
