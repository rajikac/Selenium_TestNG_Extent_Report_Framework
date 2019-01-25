package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Obj_Homepage {

	public WebDriver driver;

	public Obj_Homepage(WebDriver driver) {

		this.driver = driver;
	}

	By navBar = By.xpath(".//ul[@class='hl-cat-nav__container']");
	By login = By.xpath(".//a[contains(text(),'Sign in')]");

	public WebElement checkNavigationBar() {

		return driver.findElement(navBar);

	}

	public WebElement clickLoginLink() {

		return driver.findElement(login);
	}

}
