package appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class scrollDemo extends BaseTest {

	@Test
	public void scroll() throws Exception {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//Method 1: scroll to element
		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"WebView\"));"));
		//Method 2: scroll to end [action in different class]
		scrollToEnd();

	}
}