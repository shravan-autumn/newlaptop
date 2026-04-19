package datadriven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadDownload {

	@Test
	public void downloadupload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		// download
		driver.findElement(By.className("button")).click();
		// upload
		driver.findElement(By.id("fileinput")).sendKeys("C:\\Users\\OrCon\\Downloads\\download.xlsx");

		// wait for success message to show
		By toast = By.cssSelector(".Toastify__toast-body");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
		String text = driver.findElement(toast).getText();
		Assert.assertEquals("Updated Excel Data Successfully.", text);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toast));

		List<WebElement> fruitnames = driver.findElements(By.xpath("//div[@data-column-id='2']"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@data-column-id='4']"));
		for (int i = 0; i < fruitnames.size(); i++) {
			if (fruitnames.get(i).getText().contains("Apple")) {
				System.out.println(allPrice.get(i).getText());
			}
		}
	}
}
