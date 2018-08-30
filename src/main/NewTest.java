package main;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTest {
  
	String appUrl = "http://localhost/vtigercrm/";
	String pathDriver = "D://Automation//Drivers//IEDriverServer32bit.exe";
	WebDriver driver;
	WebDriverWait wait;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	
/*===================================================================================================================================================================*/	
/*------------------------------------------------------------------Before/After Test Methods------------------------------------------------------------------------*/
	@BeforeTest
  public void openSite() {
		
		System.setProperty("webdriver.ie.driver",pathDriver);
		driver = new InternetExplorerDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
		driver.get(appUrl);
		Assert.assertEquals(driver.getTitle(), "vtiger", "Login page title not vtiger");
		System.out.println("Vtigercrm site accessed.");
				
  }
		
	
	@BeforeClass
	public void signIn() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("admin");
        
        //password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("12345");	
        
        //signin
        WebElement btnSignIn = driver.findElement(By.xpath("//*[@id=\"loginFormDiv\"]/form/div[3]/button"));
        btnSignIn.click();
        
		try{
			Thread.sleep(5000);
			}
			catch(InterruptedException ie){
			};
        
        
	}
	
	@AfterClass(enabled = false)
	public void signOut() {
		WebElement btnProfile = driver.findElement(By.xpath("//span[contains(@title,'Administrator(admin)')]"));
		btnProfile.click();
		
		WebElement btnSignOut = driver.findElement(By.linkText("Sign Out"));
		btnSignOut.click();
		
	}

	@AfterTest(enabled = false)
	public void quitDriver() {
		driver.quit();
	}
/*===================================================================================================================================================================*/	
/*-------------------------------------------------------------------------Test Methods------------------------------------------------------------------------------*/	

	//Test if login is successful
	@Test(priority = 0)
	public void testValidLogin() {
		
        Assert.assertEquals(driver.getTitle(), "Dashboard", "Homepage not found");
        System.out.println("Sign in successful.");
		
	}
	
	//Test if Quick Create Contact Form opens
	@Test(priority = 1)
	public void quickCreateContactForm() {
		
		   CommonMethods.quickCreate(driver, wait);
	       CommonMethods.quickCreateSelector(driver, wait, "Contact").click();
	       Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Contact", "Quick Create Contact form not opened.");
	       System.out.println("Quick Create Contact form open.");
	       CommonMethods.quickCreateFormCancel(driver, wait);

	}
	//Test if Quick Create Ticket Form opens	
	@Test(priority = 2)
	public void quickCreateTicketForm() {
		
		   CommonMethods.quickCreate(driver, wait);
	       CommonMethods.quickCreateSelector(driver, wait, "Ticket").click();
	       Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Ticket", "Quick Create Ticket form not opened.");
	       System.out.println("Quick Create Ticket form open.");
	       CommonMethods.quickCreateFormCancel(driver, wait);

	}
	//Test if Quick Create Organization Form opens
	@Test(priority = 3)
	public void quickCreateOrganizationForm() {
		
		   CommonMethods.quickCreate(driver, wait);
	       CommonMethods.quickCreateSelector(driver, wait, "Organization").click();
	       Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Organization", "Quick Create Organization form not opened.");
	       System.out.println("Quick Create Organization form open.");
	       CommonMethods.quickCreateFormCancel(driver, wait);
	}
	
	
	//Test if Quick Create Service Contract Form opens
	@Test(priority = 4)
	public void quickCreateServiceForm() {
	
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Service Contract").click();
		Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Service Contract", "Quick Create Service Contract form not opened.");
		System.out.println("Quick Create Service Contract form open.");
		CommonMethods.quickCreateFormCancel(driver, wait);
		
	}
	
	//Test if Sign out is successful
	@Test(priority = 5)
	public void testSignOut() {
		
		signOut();
		Assert.assertEquals(driver.getTitle(), "vtiger", "Login page title not vtiger");
		System.out.println("Account logged out.");
		signIn();
		
	}
	
	@Test(priority = 6)
	public void quickCreateEventForm() {
		
		CommonMethods.quickCreate(driver, wait);
	    CommonMethods.quickCreateSelector(driver, wait, "Event").click();
	    Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Event", "Quick Create Event form not opened.");
	    System.out.println("Quick Create Event form open.");
	    CommonMethods.quickCreateFormCancel(driver, wait);
	      
	}
	
	@Test(priority = 7)
	public void quickCreateTaskForm() {
		
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Task").click();
		Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Quick Create Task", "Quick Create Task form not opened.");
		System.out.println("Quick Create Task form open.");
		CommonMethods.quickCreateFormCancel(driver, wait);
	      
	}
	
	@Test(priority = 8)
	public void quickCreateDocUpload() {
		
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Document").click();
		CommonMethods.quickCreateDocSelector(driver, wait, "Upload").click();
		Assert.assertEquals(CommonMethods.getFormHeaders(driver, wait), "Upload Document to Vtiger", "Upload Document to Vtiger form not opened.");
		System.out.println("Upload Document to Vtiger form open.");
		CommonMethods.quickCreateFormCancel(driver, wait);
	      
	}
	
	@Test(priority = 9)
	public void quickCreateDocUrl() {
		
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Document").click();
		CommonMethods.quickCreateDocSelector(driver, wait, "FileUrl").click();
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/h4[1]"))).getText(),"New Document", "New Document form not opened.");
		System.out.println("New Document form open.");
		CommonMethods.quickCreateFormCancel(driver, wait);
	      
	}
	
	@Test(priority = 10)
	public void quickCreateDocNew() {
		
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Document").click();
		CommonMethods.quickCreateDocSelector(driver, wait, "Create New").click();
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/h4[1]"))).getText(),"New Document", "New Document form not opened.");
		System.out.println("New Document form open.");
		CommonMethods.quickCreateFormCancel(driver, wait);	      
	}
	
	@Test(priority = 11)
	public void quickCreateTicket(){
		
		String title = "Ticket 1";
		String priority = "Low";
		String status = "Open";
		String assignedTo = "Support Group";
		String description = "Description";
		
		CommonMethods.quickCreate(driver, wait);
		CommonMethods.quickCreateSelector(driver, wait, "Ticket").click();
		QuickCreateTicket.title(driver, wait, title);
		QuickCreateTicket.priority(driver, wait, priority);
		QuickCreateTicket.status(driver, wait, status);
		QuickCreateTicket.assignedTo(driver, wait, assignedTo);
		QuickCreateTicket.description(driver, wait, description);
		CommonMethods.quickCreateFormSave(driver, wait);
		NavigationMenu.navMenu(driver, wait).click();
		NavigationMenu.navMenuOpt(driver, "Support");

		
	}
	@Test(priority =12)
	public void test() {
		Actions action = new Actions(driver);
		NavigationMenu.navMenu(driver, wait).click();
		NavigationMenu.navMenuOpt(driver, "Marketing");
		driver.findElement(By.linkText("Contacts")).click();
/*		NavigationMenu.navMenuOpt(driver, "Sales");
		action.moveToElement(driver.findElement(By.linkText("Contacts"))).build().perform();
		NavigationMenu.navMenuOpt(driver, "Inventory");
		action.moveToElement(driver.findElement(By.linkText("Contacts"))).build().perform();*/
		NavigationMenu.navMenu(driver, wait).click();
		NavigationMenu.navMenuOpt(driver, "Support");
		driver.findElement(By.linkText("Contacts")).click();
		NavigationMenu.navMenuOpt(driver, "Projects");
		NavigationMenu.navMenuOpt(driver, "Tools");
		//sadfasd
	}
		

}
