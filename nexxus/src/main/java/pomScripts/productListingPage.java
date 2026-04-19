package pomScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;

public class productListingPage extends BaseClass {
	WebDriver driver;
	WebDriverWait wait;

	public productListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	public void plpNavigation() {
		homePage hp = new homePage(driver);
		hp.getOurProductsMenu().click();
		hp.getShopAllProducts().click();
	}
	@FindBy(xpath = "//h3[@class='card__heading custom-collection-card-heading h5']")
	private List<WebElement> productTitle;
	@FindBy(xpath = "//select[@name='option-size']")
	private WebElement variantDropdown;
	@FindBy(xpath = "//button[@name='add']")
	private WebElement addToCartButton;

	public List<WebElement> getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(List<WebElement> productTitle) {
		this.productTitle = productTitle;
	}

	public WebElement getVariantDropdown() {
		return variantDropdown;
	}

	public void setVariantDropdown(WebElement bestsellersVariantDropdown) {
		this.variantDropdown = bestsellersVariantDropdown;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(WebElement bestsellersAddToCartButton) {
		this.addToCartButton = bestsellersAddToCartButton;
	}
	
	public void selectVariantAndAddToCart() throws Exception {
		webdriverUtility.scrollToElement(driver, variantDropdown);
		variantDropdown.click();
		webdriverUtility.selectByIndex(variantDropdown, 1);
		Thread.sleep(2000);
		addToCartButton.click();
	}
	
	//Search_PLP
	@FindBy(xpath = "//span[@class='price-item price-item--sale price-item--last']")
	private List<WebElement> discountedPrice;
	@FindBy(xpath = "(//a[@class='breadcrumbs__link'])[2]")
	private WebElement searchResultBreadcrumb;

	public List<WebElement> getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(List<WebElement> discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public WebElement getSearchResultBreadcrumb() {
		return searchResultBreadcrumb;
	}

	public void setSearchResultBreadcrumb(WebElement searchResultBreadcrumb) {
		this.searchResultBreadcrumb = searchResultBreadcrumb;
	}
	
	public void searchForAProduct(String a) {
		homePage hp = new homePage(driver);
		webdriverUtility.scrollToElement(driver, hp.getSearchIcon());
		hp.getSearchIcon().click();
		hp.getSearchInputField().sendKeys(a);
		hp.getSearchButton().click();
	}
	
	
}
