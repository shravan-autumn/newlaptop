package appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {

	@Test
	public void longPress() throws Exception {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		// we can use this action in pom class as well :)
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//		    "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000
//		));
		longpress(ele);
		WebElement popup = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']"));
		Assert.assertTrue(popup.isDisplayed());
	}
}