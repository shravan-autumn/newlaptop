package rahulshettySelenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@id=\"search-field\"]")).sendKeys("to");
		List<WebElement> eleList = driver.findElements(By.xpath("//tr/td[1]"));
		// Filter using stream
		List<WebElement> filter = eleList.stream().filter(veg -> veg.getText().contains("to"))
				.collect(Collectors.toList());
		Assert.assertEquals(eleList.size(), filter.size());

	}

}
