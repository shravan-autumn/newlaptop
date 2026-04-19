package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellaneous extends BaseTest {

	@Test
	public void firstTest() throws Exception {

		//adb shell dumpsys window | find "mCurrentFocus" >>windows
		//App package and app activity
		Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		// Rotate the device to landscape mode
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		 driver.rotate(landscape);
		 Thread.sleep(2000);
		 DeviceRotation portrait = new DeviceRotation(0, 0, 0);
		 driver.rotate(portrait);
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.LinearLayout[2]")).click();
		String actulTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actulTitle, "WiFi settings");
		//copy paste
		//copy to clipboard
		driver.setClipboardText("Shravan");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
}
