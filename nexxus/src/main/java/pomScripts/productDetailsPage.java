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

public class productDetailsPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	loginPage lp;
	homePage hp;
	productListingPage plp;

	public productDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	@FindBy(xpath = "//h1[@class='custom-product-title']")
	private WebElement productTitle;
	@FindBy(xpath = "//a[@class='price-container-anchor']")
	private WebElement viewCollectionLink;
	@FindBy(xpath = "//a[contains(text(),'Write A Review')]")
	private WebElement writeAReviewLink;
	@FindBy(xpath = "//button[@class='yotpo-icon-button']")
	private WebElement reviewCloseXButton;
	@FindBy(xpath = "//variant-selects[@id]//label")
	private List<WebElement> variantOption;
	@FindBy(xpath = "//div[@class='product-form__buttons ']")
	private WebElement addToCartButton;
	@FindBy(xpath = "(//button[@name='minus'])[2]")
	private WebElement quantityMinusButton;
	@FindBy(xpath = "(//button[@name='plus'])[2]")
	private WebElement quantityPlusButton;
	@FindBy(xpath = "//input[@value='1']")
	private WebElement quantityInputField;
	
	
	public WebElement getViewCollectionLink() {
		return viewCollectionLink;
	}

	public void setViewCollectionLink(WebElement viewCollectionLink) {
		this.viewCollectionLink = viewCollectionLink;
	}

	public WebElement getWriteAReviewLink() {
		return writeAReviewLink;
	}

	public void setWriteAReviewLink(WebElement writeAReviewLink) {
		this.writeAReviewLink = writeAReviewLink;
	}

	public WebElement getReviewCloseXButton() {
		return reviewCloseXButton;
	}

	public void setReviewCloseXButton(WebElement reviewCloseXButton) {
		this.reviewCloseXButton = reviewCloseXButton;
	}

	

	public List<WebElement> getVariantOption() {
		return variantOption;
	}

	public void setVariantOption(List<WebElement> variantOption) {
		this.variantOption = variantOption;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void setAddToCartButton(WebElement addToCartButton) {
		this.addToCartButton = addToCartButton;
	}

	public WebElement getQuantityMinusButton() {
		return quantityMinusButton;
	}

	public void setQuantityMinusButton(WebElement quantityMinusButton) {
		this.quantityMinusButton = quantityMinusButton;
	}

	public WebElement getQuantityPlusButton() {
		return quantityPlusButton;
	}

	public void setQuantityPlusButton(WebElement quantityPlusButton) {
		this.quantityPlusButton = quantityPlusButton;
	}

	public WebElement getQuantityInputField() {
		return quantityInputField;
	}

	public void setQuantityInputField(WebElement quantityInputField) {
		this.quantityInputField = quantityInputField;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(WebElement productTitle) {
		this.productTitle = productTitle;
	}
	
	public void searchForAProductAndNavigateToPDP(String a, String b) {
		hp = new homePage(driver);
		webdriverUtility.scrollToElement(driver, hp.getSearchIcon());
		hp.getSearchIcon().click();
		hp.getSearchInputField().sendKeys(a);
		hp.getSearchButton().click();
		plp=new productListingPage(driver);
		for (WebElement pro : plp.getProductTitle()) {

			if (pro.getText().contains(b)) {
				webdriverUtility.scrollToElement(driver, pro);
				pro.click();
				break;
			}
		}
		
	}
	public void clickOnViewCollectionLink() {
		webdriverUtility.scrollToElement(driver, viewCollectionLink);
		viewCollectionLink.click();
	}
	public void clickOnWriteAReviewLink() {
		webdriverUtility.scrollToElement(driver, writeAReviewLink);
		writeAReviewLink.click();
	}
	public void closeReviewPopUp() {
		reviewCloseXButton.click();
	}
	public void addToCartFromPDP() throws Exception {
		webdriverUtility.scrollToElement(driver, addToCartButton);
		variantOption.get(1).click();
		Thread.sleep(2000);
		addToCartButton.click();
	}
	public void increaseQuantityFromPDP() throws InterruptedException {
		Thread.sleep(2000);
		webdriverUtility.scrollToElement(driver, getQuantityPlusButton());
		getQuantityPlusButton().click();
	}
	public void decreaseQuantityFromPDP() throws InterruptedException {
		Thread.sleep(2000);
		webdriverUtility.scrollToElement(driver, getQuantityMinusButton());
		getQuantityMinusButton().click();
	}
	//pincode check PDP
		@FindBy(xpath = "//input[@id='pincode']")
		private WebElement pincodeTextField;
		@FindBy(xpath = "//button[@class='submit-pincode-button']")
		private WebElement checkButton;
		@FindBy(xpath = "//p[@id='response']")
		private WebElement pincodeSuccessMessage;
		
	
	public WebElement getPincodeTextField() {
			return pincodeTextField;
		}

		public void setPincodeTextField(WebElement pincodeTextField) {
			this.pincodeTextField = pincodeTextField;
		}

		public WebElement getCheckButton() {
			return checkButton;
		}

		public void setCheckButton(WebElement checkButton) {
			this.checkButton = checkButton;
		}

		public WebElement getPincodeSuccessMessage() {
			return pincodeSuccessMessage;
		}

		public void setPincodeSuccessMessage(WebElement pincodeSuccessMessage) {
			this.pincodeSuccessMessage = pincodeSuccessMessage;
		}

		public void validPincode() throws InterruptedException {
			webdriverUtility.scrollToElement(driver, pincodeTextField);
			pincodeTextField.sendKeys("560068");
			checkButton.click();
			Thread.sleep(2000);
		}
		
		@FindBy(xpath = "//h2[contains(text(),'PROVEN RESULTS')]")
		private WebElement provenResultsSection;
		@FindBy(xpath = "//p[@id='yotpo-headline-reviews']")
		private WebElement reviewSection;
		@FindBy(xpath = "//h2[@class='title inline-richtext h3']")
		private WebElement pairsWellSection;
		@FindBy(xpath = "//h2[@class='h2 product-faqs-section-title']")
		private WebElement faqsSection;

		public WebElement getProvenResultsSection() {
			return provenResultsSection;
		}

		public void setProvenResultsSection(WebElement provenResultsSection) {
			this.provenResultsSection = provenResultsSection;
		}

		public WebElement getReviewSection() {
			return reviewSection;
		}

		public void setReviewSection(WebElement reviewSection) {
			this.reviewSection = reviewSection;
		}

		public WebElement getPairsWellSection() {
			return pairsWellSection;
		}

		public void setPairsWellSection(WebElement pairsWellSection) {
			this.pairsWellSection = pairsWellSection;
		}

		public WebElement getFaqsSection() {
			return faqsSection;
		}

		public void setFaqsSection(WebElement faqsSection) {
			this.faqsSection = faqsSection;
		}
		public void scrollToProvenResultsSection() {
			webdriverUtility.scrollToElement(driver, provenResultsSection);
		}
		public void scrollToReviewSection() {
			webdriverUtility.scrollToElement(driver, reviewSection);
		}
		public void scrollToPairsWellSection() {
			webdriverUtility.scrollToElement(driver, pairsWellSection);
		}
		public void scrollToFaqsSection() {
			webdriverUtility.scrollToElement(driver, faqsSection);
		}
		public void clickAddtoCart1() throws Exception {
			webdriverUtility.scrollToElement(driver, addToCartButton);
			addToCartButton.click();
		}
		@FindBy(xpath = "//div[@class='pdp-buttons-container']//product-form")
		private WebElement addToCartButton2;

		public WebElement getAddToCartButton2() {
			return addToCartButton2;
		}

		public void setAddToCartButton2(WebElement addToCartButton2) {
			this.addToCartButton2 = addToCartButton2;
		}
		
		public void clickAddtoCart2() throws Exception {
			webdriverUtility.scrollToElement(driver, addToCartButton2);
			addToCartButton2.click();
		}
		//product price
		@FindBy(xpath = "//p[contains(text(),'View Collection')]//ancestor::div[@class='custom-product-price-container']//span[@class='price-item price-item--regular custom-price-item price--large']")
		private WebElement productPrice;

		public WebElement getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(WebElement productPrice) {
			this.productPrice = productPrice;
		}
		
}
