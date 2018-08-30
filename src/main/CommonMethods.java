package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {
	
	public static WebElement quickCreateSelector(WebDriver driver, WebDriverWait wait, String quickCreateOption)
	{
		
		//quickCreateOption = "quickCreateTicket";
		WebElement btnCreateSelect = null;
		switch (quickCreateOption) {
		case "Ticket":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/nav/div[1]/div/div[3]/ul/li[1]/div/ul/li[2]/div/div[1]/div[3]/a/span")));
			break;
		case "Contact":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='quick-create-module'][contains(text(),'Contact')]")));
			break;
		case "Organization":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='quick-create-module'][contains(text(),'Organization')]")));
			break;
		case "Service Contract":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='quick-create-module'][contains(text(),'Service Contract')]")));
			break;
		case "Event":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menubar_quickCreate_Events\"]/span")));
			break;
		case "Task":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Task')]")));
			break;
		case "Document":
			btnCreateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menubar_quickCreate_Documents']//span[@class='quick-create-module']")));
			break;
		default:
			break;
		}
		return btnCreateSelect;
		
	}
	
	public static WebElement quickCreateDocSelector(WebDriver driver, WebDriverWait wait, String quickCreateDocOpt ) {
		
		WebElement btnQuickCreateDoc = null;
				
		switch (quickCreateDocOpt) {
		case "Upload":
			btnQuickCreateDoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'To Vtiger')]")));
			break;
		case "FileUrl":
			btnQuickCreateDoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"javascript:Documents_Index_Js.createDocument('E')\"]")));
			break;
		case "Create New":
			btnQuickCreateDoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Create New Document')]")));
			break;
		default:
			break;
		}
		return btnQuickCreateDoc;
		
	}
	
	public static void quickCreate(WebDriver driver, WebDriverWait wait) {
		
		WebElement btnQuickCreate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menubar_quickCreate']"))); 
		btnQuickCreate.click();
	    Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains(text(),'Quick Create')]"))).getText(), "Quick Create", "Quick Create Menu not opened.");
	    System.out.println("Quick Create menu open.");
		
	}
	
	public static void quickCreateFormCancel(WebDriver driver, WebDriverWait wait) {
		
	       WebElement btnCancel = driver.findElement(By.className("cancelLink"));
	       btnCancel.click();
	       
	}
	
	public static String getFormHeaders(WebDriver driver, WebDriverWait wait) {
		
			String quickCreateFormHeader = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/form[1]/div[1]/div[1]/h4[1]"))).getText();
			
		return quickCreateFormHeader;
		
	}
	
	public static void quickCreateFormSave(WebDriver driver, WebDriverWait wait) {
		WebElement btnTicketSave = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/form[1]/div[3]/center[1]/button[2]/strong[1]"));
		btnTicketSave.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
