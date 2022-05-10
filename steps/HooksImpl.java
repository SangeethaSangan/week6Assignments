package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImpl extends BaseClass {
	@Before
	public void preConditions() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");// load url
		driver.manage().window().maximize();/// maximize browser
		driver.findElement(By.id("username")).sendKeys("DemosalesManager");// enter username
		driver.findElement(By.id("password")).sendKeys("crmsfa");// enter password
		driver.findElement(By.className("decorativeSubmit")).click();// click submit button
		driver.findElement(By.linkText("CRM/SFA")).click();// click crm sfa link
		System.out.println("MyHome page is displayed");
		driver.findElement(By.linkText("Leads")).click();// click leads
		System.out.println("MyLead page is displayed");
	}

	@After
	public void postConditions() {
		driver.close();
	}
}
