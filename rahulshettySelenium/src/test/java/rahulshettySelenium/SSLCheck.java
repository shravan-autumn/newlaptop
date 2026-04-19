package rahulshettySelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
public static void main(String[] args) {
	ChromeOptions op=new ChromeOptions();
	op.setAcceptInsecureCerts(true);
	WebDriver driver = new ChromeDriver(op);
	driver.get("https://expired.badssl.com/");
}}