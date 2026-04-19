package rahulshettySelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandelusingIterator {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@class=\"blinkingText\"]")).click();
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it = all.iterator();
		String parentId = it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		String a=driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText();
		System.out.println(a);
		String email=driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].split("with")[0].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(email);
		
	}
}
