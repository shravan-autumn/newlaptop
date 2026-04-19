package rahulshettySelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class calender {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String monthNum = "5";
		String month = "May";
		String date = "24";
		String year = "2027";
		String[] listt = { monthNum, date, year };
		driver.findElement(By.xpath("//div[@class=\"react-date-picker__inputGroup\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__label\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__label\"]")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		// driver.findElement(By.xpath("//abbr[text()='" + month + "']")).click();
		driver.findElements(
				By.xpath("//button[@class=\"react-calendar__tile react-calendar__year-view__months__month\"]"))
				.get(Integer.parseInt(monthNum) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
		List<WebElement> out = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")); // common
																												// element
		for (int i = 0; i < out.size(); i++) {
			System.out.println(out.get(i).getAttribute("value")); // value du value store atundu
			Assert.assertEquals(out.get(i).getAttribute("value"), listt[i]);
		}

	}
}
