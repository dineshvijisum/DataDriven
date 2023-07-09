package dtaDrvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothIncorrect {

	
	 @Test
	   @Parameters({"userName","password"})
	public static void main(String uname1,String pname1) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/mac/ADS/Chromedriver/107/chromedriver_linux64/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.browserstack.com/users/sign_in?utm_source=Email&utm_medium=Email&utm_campaign=FreeTrial_Verification");
	
		WebElement uname = driver.findElement(By.id("user_email_login"));
		uname.sendKeys(uname1);
		WebElement pname=driver.findElement(By.id("user_password"));
		pname.sendKeys(pname1);
		
		driver.findElement(By.id("user_submit")).click();
		//driver.quit();

	}

}
