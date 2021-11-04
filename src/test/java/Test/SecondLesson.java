package Test;

import java.util.concurrent.TimeUnit; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondLesson {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCerts");
		options.addArguments("--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);

	
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		//TimeUnit.SECONDS.sleep(5); //açıldıktan sonra bekleme kısmı
		//Thread.sleep(5000);
				
		

		driver.findElement(By.className("signin")).click();
		
		driver.findElement(By.id("login1")).sendKeys("meryem");

		driver.findElement(By.id("password")).sendKeys("ldpcfovmep");

		driver.findElement(By.name("proceed")).click();

	
		TimeUnit.SECONDS.sleep(3);

		driver.quit();
	}

}

		
		
		