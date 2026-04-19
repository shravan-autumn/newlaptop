package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	public homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='header__heading-link link link--text focus-inset header__heading_link-mt desk-head-logo']//img[@alt='HYPHEN']")
	@CacheLookup
	private WebElement logo;

	@FindBy(xpath = "//span[normalize-space()='New Launches']")
	@CacheLookup
	private WebElement newLaunches;

	@FindBy(xpath = "//span[normalize-space()='About Us']")
	@CacheLookup
	private WebElement aboutus;

	@FindBy(xpath = "//li[@class='slider__item active-slide']//a[@class='shop_anc'][normalize-space()='SHOP NOW']")
	@CacheLookup
	private WebElement herobanner;

	public WebElement getLogo() {
		return logo;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}

	public WebElement getNewLaunches() {
		return newLaunches;
	}

	public void setNewLaunches(WebElement newLaunches) {
		this.newLaunches = newLaunches;
	}

	public WebElement getAboutus() {
		return aboutus;
	}

	public void setAboutus(WebElement aboutus) {
		this.aboutus = aboutus;
	}

	public WebElement getHerobanner() {
		return herobanner; 
	}

	public void setHerobanner(WebElement herobanner) {
		this.herobanner = herobanner;
	}

}
