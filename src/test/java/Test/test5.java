//CİFT TIKLAMA,SAĞ TIKLAMA NASIL YAPILIR

package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test5 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://demoqa.com/buttons"); //link yazmak için clikler
		driver.manage().window().maximize(); //sayfa ilk açılınca kücük acılıyor default olarak onu büyütmek için:
		
		//////////////////////////////////////////////////////////
		
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		//cift tıklama gerçekleştirmek için 
		Actions action = new Actions(driver);  //clasımın adı actions   //action. yazınca orada cıkanları kullanabilirsin  
		action.doubleClick(doubleClickButton).perform(); //clik işlemini bu sekilde gerçekleştirmiş olucaz
		
		//////////////////////////////////////////////////////////
		
		//string ifadesinin burada yazdırmak istersem
		WebElement message = driver.findElement(By.id("doubleClickMessage"));
		String messageText = message.getText();
		System.out.println(messageText);
		
		//////////////////////////////////////////////////////////
		
		WebElement 	rightClickButton = driver.findElement(By.id("rightClickBtn"));
		//sag tıklama gerçekleştirmek için 
		action.contextClick(rightClickButton).perform(); //righ click hali 
		
		//////////////////////////////////////////////////////////
		
		//right click string ifadesinin burada yazdırmak istersem
		WebElement message2 = driver.findElement(By.id("rightClickMessage"));
		String messageText2 = message2.getText();
		System.out.println(messageText2);
		
	}
}