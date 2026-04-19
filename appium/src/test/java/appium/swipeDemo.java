package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class swipeDemo extends BaseTest {

	@Test
	public void swipe() throws Exception {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'1. Photos\']")).click();
		WebElement firstImage=driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		//Swipe action
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) firstImage).getId(),
//			    "direction", "left",
//			    "percent", 0.75
//			));
		swipeAction(firstImage, "left");
		WebElement firstImage1=driver.findElement(By.xpath("//android.widget.ImageView[1]"));

		Assert.assertEquals(firstImage1.getAttribute("focusable"), "false");
	}

}
