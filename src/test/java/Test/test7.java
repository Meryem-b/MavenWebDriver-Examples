//DİNAMİK ELEMENTLER2 
// SAYFAYI HER YENİLEDİĞİNDE İD  DEGİŞİYOR VE YAZDIGINLA TEKRAR ACILMIYOR FARKLI YAKLAŞIM ŞEKİLLERİ VAR BUNLARA
//XPATH KULLANMAK MAKUL BURADA İD DEGİŞİYOR ÇÜNKÜ

// xpath yolu ile bulmaya çalışıcağız burada
package test;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test7 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize(); 
		
		// 						 XPATH 
		//    //div demek tüm divlere bak demek.
		// 	  //div/p
		// id ile kullansam hata olurdu çünkü dinamik o yüzden xpath kullandım
		
		WebElement textElement = driver.findElement(By.xpath("//div/p"));
	
		//////////////////////////////////////////////////////////

		//string ifadesinin burada yazdırmak istersem
		String text = textElement.getText();
		System.out.println(text);
		
		//////////////////////////////////////////////////////////
		// will enable 5 second için bekleme işlemi:
		
		WebElement firstButton = driver.findElement(By.id("enableAfter"));
		// 5 sn beklemek için aşagıdaki
		WebDriverWait wait  = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(firstButton)); //şuna kadar bekle demek.burada expected clasını kullanarak şu duruma kadar bekle gibi bir sey diyoruz.
		//sayfa acıldıktan sonra 5 sn bekleyecek yani tıklanabilene kadar diyor 44.satır ve tıklayacak.
		firstButton.click();
	
		
		//////////////////////////////////////////////////////////
		
		
	
	}
}