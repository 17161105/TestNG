package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenu {
	static WebElement navElement=null;

	
	
	public static WebElement navMenu(WebDriver driver, WebDriverWait wait) {
		navElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")));
		return navElement;
	}
	
	public static void navMenuOpt(WebDriver driver, String navMenuOption) {
		Actions action = new Actions(driver);	
		switch (navMenuOption) {
		case "Support": 
			navElement = driver.findElement(By.id("SUPPORT_modules_dropdownMenu"));
			break;
		case "Marketing":
			navElement = driver.findElement(By.id("MARKETING_modules_dropdownMenu"));
			break;
		case "Sales":
			navElement = driver.findElement(By.id("SALES_modules_dropdownMenu"));
			break;
		case "Inventory":
			navElement = driver.findElement(By.id("INVENTORY_modules_dropdownMenu"));
			break;
		case "Projects":
			navElement = driver.findElement(By.id("PROJECT_modules_dropdownMenu"));
			break;
		case "Tools":
			navElement = driver.findElement(By.id("TOOLS_modules_dropdownMenu"));
			break;
		default:
			break;
		}
		action.moveToElement(navElement).build().perform();
	}
	
	public static WebElement navMenuOptSub(WebDriver driver, WebDriverWait wait, String navMenuOptionSub) {
		switch (navMenuOptionSub) {
		case "Contacts":
			navElement = driver.findElement(By.linkText("Contacts"));
			break;
		case "Organizations":
			navElement = driver.findElement(By.linkText("Organizations"));
			break;
		case "Tickets":
			navElement = driver.findElement(By.linkText("Tickets"));
			break;
		case "FAQ":
			navElement = driver.findElement(By.linkText("FAQ"));
			break;
		case "Service Contracts":
			navElement = driver.findElement(By.linkText("Service Contracts"));
			break;
		default:
			break;
		}
		return navElement;
	}
	
	public static void navMenuForms(WebDriver driver, WebDriverWait wait, String navMenuOption, String navMenuOptSub) {
		navMenu(driver, wait).click();
		navMenuOpt(driver, navMenuOption);
		navMenuOptSub(driver, wait, navMenuOptSub).click();
	}
	
	public static void btnSearch(WebDriver driver, WebDriverWait wait) {
		
		driver.findElement(By.xpath("//button[@class='btn btn-success btn-sm']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void searchCriteria(WebDriver driver, WebDriverWait wait, String searchCriteria, String searchString) {
		
		switch (searchCriteria) {
		case "Ticket Title":
			navElement = driver.findElement(By.name("ticket_title"));
			break;
		case "Ticket Status":
			navElement = driver.findElement(By.name("ticketstatus"));
			break;
		default:
			break;
		}
		navElement.sendKeys(searchString);
	}
	public static void table(WebDriver driver, WebDriverWait wait, String ticketTitle) {
		
		
	}
	

}
