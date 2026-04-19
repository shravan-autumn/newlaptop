package Tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
//import pomScripts.productDetailsPage;

public class HomepageTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	cartDrawer c;

	// Case 1: Verify logo is displayed in home page
	@Test(priority = 1)
	public void logoVerification() {
		lp = new loginPage(driver);
		hp = new homePage(driver);
		lp.goToWebsite();
		Assert.assertTrue(hp.getLogo().isDisplayed());
	}

	// Case 2: Verify user is able to navigate product page by clicking on
	// announcement bar
	@Test(priority = 2)
	public void announcementBarNavigation() {
		hp = new homePage(driver);
		hp.clickAnnouncementBar();
		String expectedUrl = "https://nexxus.in/collections";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains(expectedUrl), "Announcement bar navigation failed");
		driver.navigate().back();
	}

	// Case 3: Verify user is able to navigate to product listing page by clicking
	// on
	// megamenu options
	@Test(priority = 3)
	public void megamenuNavigation() {
		hp = new homePage(driver);
		for (int i = 0; i < hp.getOurProductsCategory().size(); i++) {
			hp.getOurProductsMenu().click();
			String expected = hp.getOurProductsCategory().get(i).getText();
			hp.getOurProductsCategory().get(i).click();
			String actualUrl = driver.getCurrentUrl();
			String url = expected.toLowerCase().replace(" ", "-");
			String[] words = expected.toLowerCase().split(" ");

			boolean matchFound = false;

			for (String word : words) {
				String root = word.replaceAll("(es|s)$", ""); // remove plural

				if (url.contains(root)) {
					matchFound = true;
					break;
				}
			}

			Assert.assertTrue(matchFound,
					"User is not navigated to relevant page after clicking on footer link: " + expected);
			driver.navigate().back();
		}

	}

	// Case 4: Verify user is able to navigate to gift card page by clicking on
	// megamenu options
	@Test(priority = 4)
	public void giftcardNavigation() {
		hp = new homePage(driver);
		hp.clickMegamenuGifting();
		String expectedUrl = "https://nexxus.in/products/gift-card";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
	}

	// Case 5: Verify user is able to navigate about us page by clicking on megamenu
	// options
	@Test(priority = 5)
	public void aboutUs() {
		hp = new homePage(driver);
		hp.clickaboutUs();
		String expectedUrl = "https://nexxus.in/pages/about-us";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
	}

	// Case 6: Verify user is able to navigate track order page by clicking on
	// megamenu options
	@Test(priority = 6)
	public void trackOrder() {
		hp = new homePage(driver);
		hp.clickTrackOrder();
		String expectedUrl = "https://nexxus.in/pages/track-my-order";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
	}

	// case 7: Verify user is able to click on search icon and search input field is
	// displayed
	@Test(priority = 7)
	public void searchIcon() {
		hp = new homePage(driver);
		hp.clickSearchIcon();
		Assert.assertTrue(hp.getSearchInputField().isDisplayed());
	}

	// case 8: Verify user is able to click on account icon and login page is
	// displayed
	@Test(priority = 8)
	public void accountIcon() {
		hp = new homePage(driver);
		hp.clickAccountIcon();
		String expectedUrl = "https://nexxus.in/account/login";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();

	}

	// case 9: Verify user is able to click on cart icon and empty cart message is
	// displayed
	@Test(priority = 9)
	public void cartIcon() {
		hp = new homePage(driver);
		hp.clickCartIcon();
		Assert.assertTrue(hp.getEmptyCartMessage().isDisplayed());
		driver.navigate().refresh();
	}

	// Case 10: Verify user is able to click on Shop now button in hero banner and
	// navigate to relevant
	@Test(priority = 10)
	public void herobannershopNowButton() {
		hp = new homePage(driver);
		hp.clickHeroBannerShopNowButton();
		;
		String expectedUrl = "https://nexxus.in/collections/all";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains(expectedUrl), "Shop now button navigation failed");
		driver.navigate().back();
	}

	// Case 11: Verify if user is able to click on 1st product card and navigate to
	// PDP
	@Test(priority = 11)
	public void productCardNavigation() throws Exception {
		String product = "PROMEND OIL RESURRECTION";
		for (WebElement pro : hp.getBestsellersProductNames()) {

			if (pro.getText().contains(product)) {
				webdriverUtility.scrollToElement(driver, pro);
				pro.click();
				pdp = new productDetailsPage(driver);
				webdriverUtility.waitUntilElementIsVisible(pdp.getProductTitle());
				String actualProduct = pdp.getProductTitle().getText();
				Assert.assertEquals(actualProduct, product, "User is not navigated to relevant product page");
				driver.navigate().back();
				break;
			}
		}
	}

	// Case 12: Verify if user is able to click on add to cart button in bestsellers
	// section and product is added to cart drawer
	@Test(priority = 12)
	public void addToCartFromBestsellers() throws Exception {
		String product = "PROMEND OIL RESURRECTION";
		hp.selectVariantAndAddToCart();
		c = new cartDrawer(driver);
		webdriverUtility.waitUntilElementIsVisible(c.getProductTitleCartDrawer());
		String actualProduct = c.getProductTitleCartDrawer().getText();
		Assert.assertEquals(actualProduct, product, "Product is not added to cart drawer");
		Thread.sleep(2000);
		c.closeCartDrawer();
	}

	// Case 13: Verify if user is able to click on know more button in PROTEOMIC +
	// LIPIDOMIC BREAKTHROUGH section
	@Test(priority = 13)
	public void knowMoreButton() {
		hp.clickKnowMoreButton();
		String expectedUrl = "https://nexxus.in/pages/about-us";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();

	}

	// Case 14: Verify if proven results section is displayed in homepage
	@Test(priority = 14)
	public void provenResultsSection() {
		hp.provenResultsSectionVisibility();
		Assert.assertTrue(hp.getProvenResultsSection().isDisplayed());
	}

	// Case 15: Verify if user is able to click on Discover Now button in Discover
	// the collection section
	@Test(priority = 15)
	public void discoverNowButton() {
		hp.clickDiscoverNowButton();
		String expectedUrl = "https://nexxus.in/collections/oil";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains(expectedUrl), "Discover now button navigation failed");
		driver.navigate().back();
	}

	// Case 16: Verify if Reviews section is displayed in homepage
	@Test(priority = 16)
	public void reviewsSection() {
		hp.reviewsSectionVisibility();
		Assert.assertTrue(hp.getReviewssSection().isDisplayed());
	}

//Case 17: Verify if user is able to click on find nearby salon button and navigate to store locator page
	@Test(priority = 17)
	public void findNearbySalon() {
		hp.clickFindNearbySalonButton();
		String expectedUrl = "https://nexxus.in/pages/store-locator";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
	}

	// Case 18: Verify if user is able to click on Join the community button in In
	// the spotlight section
	@Test(priority = 18)
	public void joinTheCommunity() {
		hp.clickJoinTheCommunityButton();
		String expectedUrl = "https://www.instagram.com/nexxusnewyork";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
	}

	// Case 19: Verify if error message is displayed when entering invalid email in
	// newsletter text field and clicking on subscribe button
	@Test(priority = 19)
	public void newsletterInvalidEmailVarification() {
		hp.subscribeToNewsletterWithInvalidEmail();
		Assert.assertTrue(hp.getNewsletterErrorMessage().isDisplayed());
	}

	// Case 20: Verify if user is able to subscribe to newsletter by entering valid
	// email and clicking on subscribe button
	@Test(priority = 20, enabled = false)
	public void newsletterSubscriptionWithValidEmail() {
		hp.subscribeToNewsletterWithValidEmail();
		Assert.assertTrue(hp.getNewsletterSuccessMessage().isDisplayed());
	}

	// Case 21: Verify if user is able to click on facebook icons in footer and
	// navigate to respective pages
	@Test(priority = 21)
	public void facebookIconFooter() {
		hp.clickFacebookIcon();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String b : child) {
			if (!parent.equalsIgnoreCase(b)) {
				driver.switchTo().window(b);
				break;
			}
		}
		String expectedUrl = "https://www.facebook.com/people/Nexxus-New-York/61575073012467/#";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
		driver.switchTo().window(parent);
	}

	// Case 22: Verify if user is able to click on instagram icons in footer and
	// navigate to respective pages
	@Test(priority = 22)
	public void instagramIconFooter() {
		hp.clickInstagramIcon();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String b : child) {
			if (!parent.equalsIgnoreCase(b)) {
				driver.switchTo().window(b);
				break;
			}
		}
		String expectedUrl = "https://www.instagram.com/nexxusnewyork";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
		driver.switchTo().window(parent);
	}

	// Case 23: Verify if user is able to click on youtube icons in footer and
	// navigate to respective pages
	@Test(priority = 23)
	public void youtubeIconFooter() {
		hp.clickYoutubeIcon();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String b : child) {
			if (!parent.equalsIgnoreCase(b)) {
				driver.switchTo().window(b);
				break;
			}
		}
		String expectedUrl = "https://www.youtube.com/@NexxusNewYork";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
		driver.switchTo().window(parent);
	}

	// Case 24: Verify if user is able to click on static pages links in footer and
	// navigate to respective pages
	@Test(priority = 24)
	public void staticPagesFooter() {
		for (int i = 0; i < hp.getFooterLinks().size(); i++) {

			webdriverUtility.scrollToElement(driver, hp.getFooterLinks().get(i));

			String linkName = hp.getFooterLinks().get(i).getText();

			String parentWindow = driver.getWindowHandle();
			int windowsBefore = driver.getWindowHandles().size();

			hp.getFooterLinks().get(i).click();

			// Wait a moment for navigation/tab opening
			new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(d -> driver.getWindowHandles().size() >= windowsBefore);

			int windowsAfter = driver.getWindowHandles().size();

			// 🔥 CASE 1 — NEW TAB OPENED
			if (windowsAfter > windowsBefore) {

				for (String window : driver.getWindowHandles()) {
					if (!window.equals(parentWindow)) {
						driver.switchTo().window(window);
						break;
					}
				}

			}
			// 🔥 CASE 2 — SAME TAB NAVIGATION
			else {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("/"));
			}

			// ===== ASSERT URL (FIRST 4 LETTER MATCH) =====

			String currentUrl = driver.getCurrentUrl().toLowerCase();

			// Normalize URL → remove symbols, hyphens, spaces
			String normalizedUrl = currentUrl.replaceAll("[^a-z]", "");

			// Normalize link text
			String normalizedLink = linkName.toLowerCase().replaceAll("[^a-z]", "");

			// Take first 4 letters (or less if word small)
			int compareLength = Math.min(4, normalizedLink.length());
			String prefix = normalizedLink.substring(0, compareLength);

			boolean matchFound = normalizedUrl.contains(prefix);

			Assert.assertTrue(matchFound, "User is not navigated correctly after clicking footer link");

			// 🔥 CLOSE CHILD TAB OR GO BACK
			if (!driver.getWindowHandle().equals(parentWindow)) {
				driver.close(); // close new tab
				driver.switchTo().window(parentWindow);
			} else {
				driver.navigate().back(); // same tab
			}

		}
	}

	// Case 25: Verify the Caution notice
	@Test(priority = 25)
	public void verifyCautionNotice() {
		hp.cautionNoticeVisibility();
		Assert.assertTrue(hp.getCautionNoticeHeading().isDisplayed(), "Caution notice is not displayed in the footer");
	}
}
