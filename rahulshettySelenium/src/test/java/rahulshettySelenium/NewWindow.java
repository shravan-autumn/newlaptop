package rahulshettySelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	driver.switchTo().newWindow(WindowType.TAB);
	Set<String> all = driver.getWindowHandles();
	Iterator<String> it = all.iterator();
	String parent = it.next();
	String child=it.next();
	driver.switchTo().window(child);
	driver.get("https://rahulshettyacademy.com/");
	String name=driver.findElement(By.xpath("(//h3[@class=\"font-bold text-lg group-hover:text-primary transition-colors leading-tight\"])[1]")).getText();
	driver.switchTo().window(parent);
	WebElement text = driver.findElement(By.xpath("//input[@name='name']"));
	text.sendKeys(name);

	System.out.println(text.getRect().getDimension().getHeight());
	System.out.println(text.getRect().getDimension().getWidth());

}
}
