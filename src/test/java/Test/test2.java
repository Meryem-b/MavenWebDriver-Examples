package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {
	public static void main(String[] args) throws InterruptedException {

		//checbox tıklı olup olmadıgını kontrol etme testi
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/checkbox"); //link yazmak için
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		
	 // checkbox tıklama için
	    String homeCheckBoxCssValue = "label[for ='tree-node-home'] span.rct-checkbox svg";
		WebElement homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
		homeCheckBox.click();
		
	// checkbox tıklı mı degil mi kontrol için ise
	//class sürekli degişiyor uncheck ve check oluyor html sayfasından bakınca o yüzden classs da 
	//rct-icon rct-icon-check kısım degişip duruyor bende class yazdım attribute kısmına
		
	   homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue)); //bunu tekrar yazmassam hata verir. yani tekrar kodda aratıcam ilk 
	   String homeCheckBoxClassName = homeCheckBox.getAttribute("class");
	   
	   if(homeCheckBoxClassName.equals("rct-icon rct-icon-check")) {
		   System.out.println("checkbox is checked");
	   }else {
		   System.out.println("checkbox is not checked");
	   }
	
		
	   TimeUnit.SECONDS.sleep(1); //bunları aralara koy ki hızlı hızlı bitmesin
	   driver.quit(); //chrome ekranını kapatır
		
		
		
		
	}

}


