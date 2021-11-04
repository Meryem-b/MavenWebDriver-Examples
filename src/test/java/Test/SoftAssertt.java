package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertt {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/");

		TimeUnit.SECONDS.sleep(3);
		// Thread.sleep(5000);

		WebElement searchBox = driver.findElement(By.name("q"));

		TimeUnit.SECONDS.sleep(3);

		searchBox.sendKeys("selenium web driver");

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(driver.findElement(By.name("q")).getAttribute("name"), "q1");

		TimeUnit.SECONDS.sleep(3);

		searchBox.submit();

		TimeUnit.SECONDS.sleep(3);

		softAssert.assertNull(driver.findElement(By.name("q")));

		driver.quit();

		softAssert.assertAll();

	}

}
