package test;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class test3 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/automation-practice-form"); //link yazmak için
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:

		
		// bunu normalsekilde ccs olmadan yaptım
		// arama yaparken #permanentAddress diye aradım ama kodda # koymadım 
		WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		boolean isEnabled = sportCheckbox.isEnabled(); // tıklı olup olmadıgını bu sekilde bulabiliriz.bu element tıklanabilir mi der
		//bu yukarıdaki boolean döner bize
		System.out.println(isEnabled); // true dondü bir yere tıklamadı
		
		
		//////////////////////////////////////////
		
		// dogru ise tıklat demek için ise if(isEnabled){ sportChecBox.click(); } yaptım ama exception hata verdi
		//bende bu yüzden try catch kullandım yani try da tıklamıyor ama catch de hata adını yazınca onu görmezden gelip tıklıyor
		
		
		WebElement sportCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for ='hobbies-checkbox-1']"));
		try { 
			sportCheckbox.click(); //buna tıklatınca altta yazdıgım elemenleli hatayı verdi.bende try
			//cathc kullandım ki hata verince görmezden gel ve altakini çalıştır desin diye
		} catch (ElementClickInterceptedException e ) {
			sportCheckboxLabel.click(); //suan tıkladı
			System.out.println("Entered catch block!");
		}
		
		
		
		//////////////////////////////////////////
		
		// bu sportCheckbox ın seçili olup  olmadını kontrol etme isSelected ile olur 
		boolean isSelected = sportCheckbox.isSelected();
		System.out.println(isSelected);
		

	}

}


