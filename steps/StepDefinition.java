package steps;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

/////Create Lead	
	@When("click on CreateLead")
	public void click_on_create_lead() {
		driver.findElement(By.linkText("Create Lead")).click();// locate and click create lead
	}

	@Then("CreateLead page is displayed")
	public void create_lead_page_is_displayed() {
		System.out.println("CreateLead page is displayed");
	}

	@Given("Enter CompanyName as {string}")
	public void enter_company_name(String compName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);// locate company name and enter
																					// value
	}

	@Given("Enter FirstName as {string}")
	public void enter_first_name(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);// locate first name and enter value
	}

	@Given("Enter LastName as {string}")
	public void enter_last_name(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);// locate last name and enter value
	}

	@Given("select source from dropdown as {string}")
	public void select_source_from_dropdown(String SourceId) {
		WebElement element = driver.findElement(By.id("createLeadForm_dataSourceId"));// select 'employee' from source
		Select dd = new Select(element);
		dd.selectByVisibleText(SourceId);
	}

	@Given("Enter FirstLocalName as {string}")
	public void enter_first_local_name(String fNameLocal) {
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNameLocal);// locate first local name and
																						// enter value
	}

	@Given("Enter LastLocalName as {string}")
	public void enter_last_local_name(String LNameLocal) {
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys(LNameLocal);// locate last local name and
																						// value

	}

	@Given("Enter DepartmentName as {string}")
	public void enter_department_name(String deptName) {
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(deptName);// locate dept name and enter
																						// value
	}

	@Given("Enter Description as {string}")
	public void enter_description(String description) {
		driver.findElement(By.id("createLeadForm_description")).sendKeys(description);// locate description and enter
																						// value
	}

	@Given("Enter emailid as {string}")
	public void enter_emailid(String emailId) {
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailId);// locate email and enter
																					// value
	}

	@Given("Select country from dropdown as {string}")
	public void select_country_from_dropdown(String country) {
		WebElement ele = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));// select 'New York' from
																							// country dropdown
		Select dd1 = new Select(ele);
		dd1.selectByVisibleText(country);
	}

	@When("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.className("smallSubmit")).click();// locate and click create lead button
	}

	@Then("LeadId is Created")
	public void verifyCreatedLead() {
		String title = driver.getTitle();// get current title of the page
		System.out.println(title);
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();// get lead first name
		// System.out.println(text);
		assertEquals(firstName, "Sangeetha");
	}

	@But("Error messagge is displayed")
	public void displayErrorMessage() {
		System.out.println("Error message is displayed");
	}

	//////

	@Given("click on find leads")
	public void click_on_find_leads() {
		driver.findElement(By.xpath("//a[contains(@href,'findLeads')]")).click();
	}

	@Given("click on email")
	public void click_on_email() {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}

	@Given("Search lead with emailid as {string}")
	public void search_lead_emailid(String email) {
		driver.findElement(By.name("emailAddress")).sendKeys(email);
	}

	@Given("click on findlead button")
	public void click_on_findleads() {

		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
	}

	@Given("click on first listed leadid")
	public void click_on_first_listed_leadid() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[contains(@href,'partyId')]")).click();

	}

	@Given("click on edit")
	public void click_on_edit() {
		driver.findElement(By.xpath("//a[contains(@href,'updateLead')]")).click();
	}

	String oldDesc;

	@Given("update description as {string}")
	public void update_description(String updatedesc) {
		WebElement updateDesc = driver.findElement(By.id("updateLeadForm_description"));
		oldDesc = updateDesc.getText();
		updateDesc.clear();
		updateDesc.sendKeys(updatedesc);
	}

	@When("click on update button")
	public void click_on_update_button() {
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}

	@Then("lead should be updated and verify updated details")
	public void vetifyUpdate() {

		String newDesc = driver.findElement(By.id("viewLead_description_sp")).getText();
		Assert.assertNotEquals(newDesc, oldDesc);

	}

	@Given("clear firstname field")
	public void clearFirstName() {
		driver.findElement(By.id("updateLeadForm_firstName")).clear();
	}

	@But("Error message is displayed")
	public void verifyEditlead() {
		System.out.println("Error message should be displayed");
	}

	////// Duplicate lead
	@Given("click on duplicateLead")
	public void click_on_duplicate_lead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}

	@Given("clear lastname field")
	public void clear_lastname_field() {
		driver.findElement(By.id("createLeadForm_lastName")).clear();
	}

	@Given("Clear previous company name")
	public void clear_previous_companyName() {
		driver.findElement(By.id("createLeadForm_companyName")).clear();
	}

	@Given("update companyname field as {string}")
	public void update_companyname_field_as(String string) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("new comp");
	}

	@When("click on create")
	public void click_on_create() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Duplicated lead should not be created")
	public void duplicated_lead_should_not_be_created() {
		System.out.println("Duplicated lead should not be created");

	}

	@Then("Duplicatelead should be created")
	public void duplicatelead_should_be_created() {
		String Title1 = driver.getTitle();
		System.out.println(Title1);
	}

	@Then("Updated company name should be displayed")
	public void updated_company_name_should_be_displayed() {
		System.out.println("error message should be displayed");
	}

	/// delete lead
	@When("click on delete")
	public void click_on_delete() {
		driver.findElement(By.className("subMenuButtonDangerous")).click();
	}

	String LeadId;

	@Given("Print selected leadid")
	public void print_selected_leadid() {
		String compName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		LeadId = compName.replaceAll("\\D", "");
	}

	@Then("verify whether leadid is deleted or not")
	public void verify_whether_leadid_is_deleted_or_not() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Catalog')]/preceding::a[text()='Find Leads']")).click();
		driver.findElement(By.name("id")).sendKeys(LeadId);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("page info" + text2);

		if (text2.contains("No records")) {

			System.out.println(" Lead id is deleted sucessfully!!");
		} else {
			System.out.println(" Lead id is not deleted");
		}
	}
}
