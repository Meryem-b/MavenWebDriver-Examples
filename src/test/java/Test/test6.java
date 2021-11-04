//DİNAMİK ELEMENTLER NEDİR VE NASIL BULUNUR
// SAYFAYI HER YENİLEDİĞİNDE İD  DEGİŞİYOR VE YAZDIGINLA TEKRAR ACILMIYOR FARKLI YAKLAŞIM ŞEKİLLERİ VAR BUNLARA
//XPATH KULLANMAK MAKUL BURADA İD DEGİŞİYOR ÇÜNKÜ


// xpath yolu ile bulmaya çalışıcağız burada
package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test6 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize(); 
		
		// 								    XPATH 
		//    //div demek tüm divlere bak demek.
		//    //div/button demek ise bütün divler içerisinde button taglerine bak.burada 3 tane buldu.(tek tıklama için bakıyorum)
		//    //div/button[contains(text(), 'Click Me')]   xpath içinde contains metodunu bu sekilde kullanabilrisin.ama yine 3 tane verdi.(örnek amaclı kalsın bu burada)
		//    //div/button[starts-with(text(), 'Click Me')]  ile buldum. starts-with kalıbı yani click me ile baslayanı bul diyor.
		//    //div[last()]/button   ile de yazabilirdim ama ben yukardakini seçtim
		WebElement  dynamicClickButton = driver.findElement(By.xpath("//div/button[starts-with(text(), 'Click Me')]"));
		dynamicClickButton.click();
	
		
		//////////////////////////////////////////////////////////
		
		//string ifadesinin burada yazdırmak istersem
		WebElement message = driver.findElement(By.id("dynamicClickMessage"));
		String messageText = message.getText();
		System.out.println(messageText);
		
		
	}
}