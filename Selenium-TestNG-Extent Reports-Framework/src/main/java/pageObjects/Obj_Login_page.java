package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Obj_Login_page {
	
	public WebDriver driver;
	
	public Obj_Login_page(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By username = By.id("userid");
	By password = By.id("pass");
	By signBttn = By.id("sgnBt");
	By loginError = By.xpath(".//p[@id='errf']");
	
	public WebElement enterUsername() {
		
		return driver.findElement(username);
		
	}
	
	public WebElement enterPassword() {
		
		return driver.findElement(password);
		
	}

	public WebElement clickSignInButton() {
		
		return driver.findElement(signBttn);
		
	}
	
	public WebElement loginError() {
		
		return driver.findElement(loginError);
		
	}

}
