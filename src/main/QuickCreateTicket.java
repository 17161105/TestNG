package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickCreateTicket {
	
	public static void title(WebDriver driver, WebDriverWait wait, String title) {
		
		WebElement txtTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("HelpDesk_editView_fieldName_ticket_title")));
		txtTitle.sendKeys(title);
	}
	
	public static void priority(WebDriver driver, WebDriverWait wait, String priority) {
		Select txtPriority = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/select[1]"))));
		txtPriority.selectByValue(priority);
	}
	
	public static void status(WebDriver driver, WebDriverWait wait, String status) {
		Select picklistStatus = new Select (driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/select[1]")));
		picklistStatus.selectByVisibleText(status);
	}
	
	public static void assignedTo(WebDriver driver, WebDriverWait wait, String assignedTo) {
		Select picklistAssignedTo = new Select (driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/form/div[2]/div/div[1]/div/table/tbody/tr[1]/td[4]/select")));
		picklistAssignedTo.selectByVisibleText(assignedTo);
	}
	
	public static String description(WebDriver driver, WebDriverWait wait, String description) {
		WebElement txtDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("HelpDesk_editView_fieldName_description")));
		txtDescription.sendKeys(description);
		return description;
		
	}

}
