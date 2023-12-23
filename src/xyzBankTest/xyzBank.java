package xyzBankTest;

import org.testng.annotations.*;

public class xyzBank extends Parameter {
	@BeforeTest
	public void setup() {
		driver.get(URLlink);
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		randomLogin();
	}// login

	@Test(priority = 2)
	public void DepositProcess() throws InterruptedException {
		deposit_process();
	}// DepositProcess

	@Test(priority = 3)
	public void withdrawalProcess() throws InterruptedException {
		withdrawal_Process();
	}// withdrawalProcess

	@Test(priority = 4)
	public void AssertionPart() throws InterruptedException {
		balance();
	}// AssertionPart

	@AfterTest
	public void afterTest() {
	}

}
