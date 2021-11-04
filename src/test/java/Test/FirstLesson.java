package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstLesson {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://www.google.com/"); //link yazmak için
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		// google girince cookies kısmı açılıyor burayı geçmek için bu alttaki 3 kodu yaz
		driver.findElement(By.xpath("//*[@id=\"vc3jof\"]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"tbTubd\"]/div/li[45]")).click();
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
		
		 
		//TimeUnit.SECONDS.sleep(5); //açıldıktan sonra bekleme kısmı
		//Thread.sleep(5000);
		
			
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.click();
		
		TimeUnit.SECONDS.sleep(3); //bunları aralara koy ki hızlı hızlı bitmesin
		
		searchBox.sendKeys("selenium webdriver");
		searchBox.submit();
		
		TimeUnit.SECONDS.sleep(2);
		
		driver.quit(); //chrome ekranını kapatır
		
		
		
	}

}
