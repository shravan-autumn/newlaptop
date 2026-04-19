package datadriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

	@Test
	public void fileUploadTest() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("https://www.naukri.com/registration/createAccount");
		 driver.findElement(By.xpath("//div[@class='textWrap']")).click();
		 // Add your file upload logic here	
		 driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		 
	}
}
