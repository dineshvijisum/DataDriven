package dtaDrvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DataProvider {

	

	@org.testng.annotations.DataProvider(name="loginDatas")
	public String[][] loginDataProvider() {
		
		String [][] data= {{"pofopo4020@iucake.com","12345678","dinesh"}
				//{"pofopo40gg20@iufcake.com","123df45678"},
				//{"pofopo40gg20@iucafke.com","12345ff678"},
				//{"pofopo40gg20@iucakdfe.com","12345678"}
				};

		return data;
	}


	@Test(dataProvider = "loginDatas")

	public void loginData(String uname1,String pname1, String name) throws InterruptedException {
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
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[9]/button")).click();
		
		WebElement search=driver.findElement(By.id("doc-search-box-input"));
		search.sendKeys(name);
		

		//driver.quit();

	}

}
