package dtaDrvn;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Jxl {


	@DataProvider(name="logindata")
	public String[][] dataProvider() throws BiffException, IOException {
		String[][] data=null;
         data=jxl();
         return data;

	}


	public String[][] jxl() throws BiffException, IOException {

		///home/mac/Downloads/jxl.xls
		FileInputStream excell=new FileInputStream("/home/mac/Downloads/jxl.xls");
		
		Workbook workbook=Workbook.getWorkbook(excell);
		Sheet sheet=workbook.getSheet(1);
		int getrows=sheet.getRows();
		int getcolumn=sheet.getColumns();
		
		
		String testdata[][]=new String[getrows-1][getcolumn];
		
		for(int i=1;i<getrows;i++) {
			for(int j=0;j<getcolumn;j++) {
				testdata[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}
		return testdata;
		
		
	}
	@Test(dataProvider = "logindata")
	public void jxl(String uname1,String pname1) {

		System.setProperty("webdriver.chrome.driver", 
				"/home/mac/ADS/Chromedriver/112/chromedriver_linux64 (1)/chromedriver");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.browserstack.com/users/sign_in?utm_source=Email&utm_medium=Email&utm_campaign=FreeTrial_Verification");

		WebElement uname = driver.findElement(By.id("user_email_login"));
		uname.sendKeys(uname1);
		WebElement pname=driver.findElement(By.id("user_password"));
		pname.sendKeys(pname1);

		driver.findElement(By.id("user_submit")).click();

	}

}
