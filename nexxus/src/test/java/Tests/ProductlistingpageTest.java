package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.webdriverUtility;
import pomScripts.cartDrawer;
import pomScripts.homePage;
import pomScripts.loginPage;
import pomScripts.productDetailsPage;
import pomScripts.productListingPage;

public class ProductlistingpageTest extends BaseClass {

	loginPage lp;
	homePage hp;
	productDetailsPage pdp;
	productListingPage plp;
	cartDrawer c;


	// Case 1: Verify if user is able to navigate to PLP by clicking on mega-menu
	// options
	@Test(priority = 1)
	public void hpToPlpNavigation() {
		plp = new productListingPage(driver);
		plp.plpNavigation();
		String expectedUrl = "https://nexxus.in/collections/all";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	// Case 2: Verify if user is able to click on 1st product card and navigate to PDP
		@Test(priority = 2)
		public void productCardNavigation() throws Exception {
			String product = "PROMEND OIL RESURRECTION";
			for (WebElement pro : plp.getProductTitle()) {

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
		// Case 3: Verify if user is able to click on add to cart button in bestsellers
		// section and product is added to cart drawer
		@Test(priority = 12)
		public void addToCartFromPLP() throws Exception {
			String product = "PROMEND OIL RESURRECTION";
			plp.selectVariantAndAddToCart();
			c = new cartDrawer(driver);
			webdriverUtility.waitUntilElementIsVisible(c.getProductTitleCartDrawer());
			String actualProduct = c.getProductTitleCartDrawer().getText();
			Assert.assertEquals(actualProduct, product, "Product is not added to cart drawer");
			Thread.sleep(2000);
			c.closeCartDrawer();
		}
		
		//Case 4: Verify if user is able to search product using search bar and navigated to relevant search result page
		@Test(priority = 13)
		public void searchProductFromPLP() throws Exception {
			String a="oil";
			plp.searchForAProduct(a);
			String searchPLP=plp.getSearchResultBreadcrumb().getText();
			System.out.println(searchPLP);
			Assert.assertTrue(searchPLP.toLowerCase().contains(a), "User is not navigated to search result page");
			
		}
		
}
