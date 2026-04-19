package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.BaseClass;
import genericUtility.iConstantUtility;
import genericUtility.webdriverUtility;

public class loginPage extends BaseClass {
	// WebDriver driver;

	public loginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToWebsite() {
		driver.get(iConstantUtility.url);

	}

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptCookiesButton;

	public void acceptCookiesIfPresent() {
		try {
			if (acceptCookiesButton.isDisplayed()) {
				acceptCookiesButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FindBy(id = "CustomerEmail")
	private WebElement emailTextField;

	@FindBy(id = "CustomerPassword")
	private WebElement passwordTextField;

	@FindBy(xpath = "(//snake-border-button[@role='button'])[2]")
	private WebElement loginButton;

	@FindBy(xpath = "(//snake-border-button[@role='button'])[3]")
	private WebElement createAccountLink;

	@FindBy(id = "RegisterForm-FirstName")
	private WebElement firstNameTextField;

	@FindBy(id = "RegisterForm-LastName")
	private WebElement lastNameTextField;

	@FindBy(id = "RegisterForm-email")
	private WebElement registerEmailTextField;

	@FindBy(id = "RegisterForm-password")
	private WebElement registerPasswordTextField;

	@FindBy(id = "myCheckbox_reg")
	private WebElement checkbox;

	@FindBy(xpath = "//button[@id='registerSubmit']")
	private WebElement signupButton;

	@FindBy(xpath = "//h1[@class='customer__title']")
	private WebElement accountTitle;

	@FindBy(xpath = "//a[@href='/account/logout']")
	private WebElement logoutLink;

	public WebElement getAcceptCookiesButton() {
		return acceptCookiesButton;
	}

	public void setAcceptCookiesButton(WebElement acceptCookiesButton) {
		this.acceptCookiesButton = acceptCookiesButton;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(WebElement emailTextField) {
		this.emailTextField = emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	public void setCreateAccountLink(WebElement createAccountLink) {
		this.createAccountLink = createAccountLink;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(WebElement firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(WebElement lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public WebElement getRegisterEmailTextField() {
		return registerEmailTextField;
	}

	public void setRegisterEmailTextField(WebElement registerEmailTextField) {
		this.registerEmailTextField = registerEmailTextField;
	}

	public WebElement getRegisterPasswordTextField() {
		return registerPasswordTextField;
	}

	public void setRegisterPasswordTextField(WebElement registerPasswordTextField) {
		this.registerPasswordTextField = registerPasswordTextField;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(WebElement checkbox) {
		this.checkbox = checkbox;
	}

	public WebElement getSignupButton() {
		return signupButton;
	}

	public void setSignupButton(WebElement signupButton) {
		this.signupButton = signupButton;
	}

	public WebElement getAccountTitle() {
		return accountTitle;
	}

	public void setAccountTitle(WebElement accountTitle) {
		this.accountTitle = accountTitle;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}
	
	public void createAccount(String firstName, String lastName, String email, String password) throws InterruptedException {
		createAccountLink.click();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		registerEmailTextField.sendKeys(email);
		registerPasswordTextField.sendKeys(password);
		webdriverUtility.scrollToElement(driver, signupButton);
		checkbox.click();
		signupButton.click();
		Thread.sleep(20000);

	}

	public void login(String email, String password) throws Exception {
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();
		Thread.sleep(20000);

	}
	
	
	
}
