package xyzBankTest;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Parameter {
	// Basic Code >>>
	static WebDriver driver = new ChromeDriver();
	static SoftAssert softassert = new SoftAssert();
	static String URLlink = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";
	// function variables >>>
	static Random random = new Random();
	static int randomNumber = 100 + random.nextInt(1000);
	static String balanceBeforeDeposit="";
	static String balanceDuringProcess="";
	static String balanceAfterProcess="";
	static int BalanceAssert=0;
	

	public static void randomLogin() throws InterruptedException {
		//
		Thread.sleep(2000);
		WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg"));
		loginButton.click();
		Thread.sleep(2000);

		Select dropdown = new Select(driver.findElement(By.id("userSelect")));
//		List<WebElement> customerOptions = dropdown.getOptions();
		int randomIndex = 1 + random.nextInt(4);
		dropdown.selectByIndex(randomIndex);
		WebElement login = driver.findElement(By.cssSelector(".btn.btn-default"));
		login.click();

	}// randomLogin

	public static void deposit_process() throws InterruptedException {
		Thread.sleep(2000);
		balanceBeforeDeposit=driver.findElement(By.cssSelector("strong.ng-binding:nth-child(2)")).getText();
		System.out.println(balanceBeforeDeposit);
		
		WebElement depo = driver.findElement(By.cssSelector("button.btn-lg:nth-child(2)"));
		depo.click();
		Thread.sleep(1000);

		WebElement amount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
		amount.sendKeys(String.valueOf(randomNumber));
		Thread.sleep(500);
		WebElement depositButton = driver.findElement(By.cssSelector(".btn.btn-default"));
		depositButton.click();
		balanceDuringProcess=driver.findElement(By.cssSelector("strong.ng-binding:nth-child(2)")).getText();
		System.out.println(balanceDuringProcess);

	}// Deposit

	public static void withdrawal_Process() throws InterruptedException {
		Thread.sleep(2000);
		WebElement withdrawl = driver.findElement(By.cssSelector("button.btn-lg:nth-child(3)"));
		withdrawl.click();
		Thread.sleep(1000);
		WebElement amount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
		amount.sendKeys(String.valueOf(randomNumber));
		Thread.sleep(500);
		WebElement withdrawButton = driver.findElement(By.cssSelector(".btn.btn-default"));
		withdrawButton.click();
		balanceAfterProcess =driver.findElement(By.cssSelector("strong.ng-binding:nth-child(2)")).getText();
		System.out.println(balanceAfterProcess);

	}// Withdrawal
	
	public static void balance() throws InterruptedException {
Thread.sleep(1000);
BalanceAssert=Integer.parseInt(balanceDuringProcess);
System.out.println(BalanceAssert);
softassert.assertEquals(Integer.parseInt(balanceBeforeDeposit)+randomNumber, BalanceAssert);
softassert.assertEquals(balanceAfterProcess, balanceBeforeDeposit ,"Error");
softassert.assertAll();
	}//balance

}// Class




//1- go to this website and press on customer login
//2- select any random customer from the list
//3- add one Deposit process let the amount to be randomly entered use java concepts
//4- then withdraw the amount you add
//5- create one assertion that the balance is correct





