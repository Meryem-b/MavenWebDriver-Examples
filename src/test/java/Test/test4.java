package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/radio-button"); //link yazmak için radio butonlar
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		
		// bunu normalsekilde ccsile yaptım
		
		WebElement yesRadioButton = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
		boolean  isEnabled= yesRadioButton.isEnabled(); // buradaki element tıklanabiliyorsa bize true dönecek
		if(isEnabled) {
			yesRadioButton.click(); //tıkladı ve oraya yes yazdırdı
			System.out.println("clicked yesRadio Button."); 
		}
		
		/////////////////////////
		
		// tıklı olup olmaıdıgnı da su sekilde görebiliriz
		WebElement yesRadioButtonLabel = driver.findElement(new By.ByCssSelector("input[id='yesRadio']")); //css html kısmında btıklama yeri buraya denk geliyor.yukardaki yere degil
		boolean isSelected = yesRadioButtonLabel.isSelected();
		if(isSelected) {
			System.out.println("yes radio button is selected");
		}
		
				
		/////////////////////////
				
		WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3")); //css ile buldum
		System.out.println(output.getText()); //console da  clicked yesRadio Button.You have selected Yes yazdırdı.webde yazan şeyi yazdı
		
		/////////////////////////
		
		/////////////////////////
		// no yazan kısım tıklanmıyor yani disable. css olmadan yaptım. false dönecek yani tıklanmıyor diyor
		
		WebElement noRadioButton = driver.findElement(By.id("noRadio")); 
		System.out.println(noRadioButton.isEnabled()); //false döndü yani tıklanmıyor
		
		TimeUnit.SECONDS.sleep(1); //bunları aralara koy ki hızlı hızlı bitmesin
		driver.quit(); //chrome ekranını kapatır
			
		
	}
}