package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCerts");
		options.addArguments("--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.testandquiz.com/");

		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.linkText("Login")).click();

		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.id("email")).sendKeys("test@test.com");

		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.name("password")).sendKeys("test");

		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.className("btn-primary")).submit();

		TimeUnit.SECONDS.sleep(3);

		String error = driver.findElement(By.className("error-mesg")).getText();

		if (error != null && error.startsWith("Sorry")) {
			driver.findElement(By.className("pull-right")).click();
			// driver.findElement(By.linkText("Sign Up")).click();

			TimeUnit.SECONDS.sleep(3);

			driver.findElement(By.name("re_email_id")).sendKeys("test@test.com");

			TimeUnit.SECONDS.sleep(3);

			driver.findElement(By.className("user-signup-btn-u")).submit();
		}
		TimeUnit.SECONDS.sleep(3);

		driver.quit();
	}

}
