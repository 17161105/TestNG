package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenu {
	static WebElement navElement;

	
	
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
	//navElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[1]/div[2]/div[5]/div[1]"));

	}
	
	

}
