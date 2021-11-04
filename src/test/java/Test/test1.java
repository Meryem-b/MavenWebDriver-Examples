package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/text-box"); //link yazmak için
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		
		//findEelement metodu ile bulunuyor id  name class vs
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName.click();
		fullName.sendKeys("meryem sema "); //yazdırmak için
		
		
		//normal yukardaki gibi de olabilir ama bu css selector ile yapacagım esktra ornek amaclı  
		// WebElement mailName = driver.findElement(By.id("userEmail")); //bu olurdu ama secmedim bu yolu
			
		WebElement mailName = driver.findElement(new By.ByCssSelector(".mr-sm-2[id='userEmail']"));	
		mailName.click();
		mailName.sendKeys("msemaa1@hotmail.com"); 
		
		
		
		WebElement currentAddress = driver.findElement(new By.ByCssSelector(".form-control[placeholder ='Current Address']"));
		currentAddress.click();
		currentAddress.sendKeys("İstanbul /Türkiye");
		
		
		// bunu normalsekilde ccs olmadan yaptım
		// arama yaparken #permanentAddress diye aradım ama kodda # koymadım 
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		permanentAddress.click();
		permanentAddress.sendKeys("Ferah mahallesi Çamlıca");
		
		
		//button kısmı hatalı calıstı o yüzden try catch kullandım.aslında aynı css kodu yani 
		// ikiside aybı adres ama try calısmayınca trydaki hatayı görmeden gelip catch calsıyor.
		WebElement submitButton = driver.findElement(new By.ByCssSelector("button.btn"));
		
		WebElement submitButtonLabel = driver.findElement(new By.ByCssSelector(".btn[id='submit']"));

		try {
			submitButton.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			submitButtonLabel.click();
			
		}
		
	
		
		
		///////////////////////////////////////////////////////////////
		
		//çalıstıgında altta bilgileri cekmek için simdi devam edicem.bu sefer de xpath kullanacagım.
		// xpath de arama yaparken //div/p[@id='name'] yaptım @ kullanmmak zorunda ve // ile başla
		
		WebElement nameText = driver.findElement(By.xpath("//div/p[@id='name']"));
		String name = nameText.getText(); 	//yazan stringi alıyoruz
		System.out.println(name); //burada yazdırıyoruz ve consolede meryem sema yazıyor
		
		
		WebElement emailText = driver.findElement(By.xpath("//div/p[@id='email']"));
		String email = emailText.getText(); 	//yazan stringi alıyoruz
		System.out.println(email); //burada yazdırıyoruz ve consolede mail yazıyor
		
		
		TimeUnit.SECONDS.sleep(1); //bunları aralara koy ki hızlı hızlı bitmesin
		driver.quit(); //chrome ekranını kapatır
			
		   
	}

}


