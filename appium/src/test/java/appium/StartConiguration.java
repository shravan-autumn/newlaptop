package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class StartConiguration {

	@Test
	public void firstTest() throws Exception {
		// To run appium server programmatically
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\OrCon\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).build();
		service.start();
		// To set capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Shravan1");
		options.setApp("C:\\Users\\OrCon\\eclipse-workspace\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		AndroidDriver driver = new AndroidDriver(new URI("http://0.0.0.0:4723").toURL(), options);
		
		// Automation code goes here
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		Thread.sleep(5000);
		
		driver.quit();
		service.stop();
	}
}
