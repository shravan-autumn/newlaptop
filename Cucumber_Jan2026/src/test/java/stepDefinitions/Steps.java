package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homepage;

public class Steps extends baseClass {

    String br = "chrome";

    @Before
    public void setup() {
        if (br.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        hp = new homepage(driver);
    }

    @Given("Launch the browser")
    public void launch_the_browser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @Then("Logo is displayed")
    public void logo_is_displayed() {
        Assert.assertTrue(hp.getLogo().isDisplayed());
    }

    @When("User clicks on New Launches link")
    public void user_clicks_on_new_launches_link() {
        hp.getNewLaunches().click();
    }

    @Then("User is redirected to New Launches page")
    public void new_launches_page() {
        String expected = "https://letshyphen.com/collections/new-launch";
        Assert.assertEquals(expected, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @When("User clicks on About Us link")
    public void user_clicks_on_about_us_link() {
        hp.getAboutus().click();
    }

    @Then("User is redirected to About Us page")
    public void about_us_page() {
        String expected = "https://letshyphen.com/pages/about-us";
        Assert.assertEquals(expected, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @When("User clicks on Hero Banner")
    public void user_clicks_on_hero_banner() {
        hp.getHerobanner().click();
    }

    @Then("User is redirected to All Collections page")
    public void all_collection_page() {
        String expected = "https://letshyphen.com/collections/all";
        Assert.assertEquals(expected, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
