package rahulshettySelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterRedirectionsDynamic {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement footer = driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]"));
		// search inside footer or we can directly use
		// //div[@id="gf-BIG"]//table/tbody/tr/td[1]/ul
		WebElement footerele = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerele.findElements(By.tagName("a")).size()); // to get size
		for (int i = 1; i < footerele.findElements(By.tagName("a")).size(); i++) {
			String newtab = Keys.chord(Keys.CONTROL, Keys.ENTER);// open new tab
			footerele.findElements(By.tagName("a")).get(i).sendKeys(newtab);
		}
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}
}
