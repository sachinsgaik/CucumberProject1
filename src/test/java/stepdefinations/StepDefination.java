package stepdefinations;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import Utilities.ReadConfigFile;
import gherkin.formatter.model.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;

public class StepDefination extends Base{
	
	@Before
	public void setup()
	{
		System.out.println("Setup method executed");
		driver=new ChromeDriver();
		
		ReadConfigFile ReadConfig = new ReadConfigFile();
		String broswer=ReadConfig.getBroswer();
		
		if(broswer.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(broswer.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(broswer.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
			
		
	}
	@Given("User Launch Chorme Broswer")
	public void user_launch_chorme_broswer() {
		System.setProperty("webdriver.chrome.driver", "H:\\softwares\\chromedriver_win32\\chromedriver.exe");
		
		//driver=new ChromeDriver();
		
		ad=new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
	    
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws InterruptedException {
	   ad.setUsername(email);
	   Thread.sleep(2000);
	   ad.setPassword(password);
	   Thread.sleep(2000);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
		ad.clickOnLogin();
		Thread.sleep(2000);
	}
	
	@Then("User verify the page title should be {string}")
	public void user_verify_the_page_title_should_be(String title) {
	    Assert.assertEquals(title, driver.getTitle());
	}

	@Then("Close broswer")
	public void close_broswer() {
		
		
		 driver.close();
	   
	}
	@After
	public void tearDown(Scenario sc)
	{
		System.out.println("Tear Down method execuetd");
		
		/*if(sc.isFailed()==true)
		{
			String filewithPath="C:\\Users\\DELL\\eclipse-workspace\\Maven1\\ScreenShots\\isFailed.png";
			TakeScreenshot scrshot=((TakeScreenshot)driver);
			
			File scrfile=scrshot
		}*/
		
		driver.quit();
	}

}
