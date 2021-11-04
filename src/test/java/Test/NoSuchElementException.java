//Handle No Such Element Exception

package Test;
import java.time.Duration; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementException {
	public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("acceptInsecureCerts");
			options.addArguments("--ignore-certificate-errors");

			WebDriver driver = new ChromeDriver(options);
			
			driver.get("https://learn.letskodeit.com");
			driver.manage().window().maximize(); 
//------------------------------------------------------------------------------------------------------------------------
			//bu alttaki implicit olanı yazmadıgım zaman NoSuchElementException hatası alıyorum.
			//hatanın kalkıp elementi ulması için alttaki kodu yazdım ve hata kalktı.elementi bulup mail kısmını yazabildi.
	       	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //bulunamayan elementi bulur.
//------------------------------------------------------------------------------------------------------------------------
	  
		   //1.Timing Issues
	     	
			driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		    driver.findElement(By.id("email")).sendKeys("mwettmm@hotmail.com");
// yukarıdaki  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); olan kodu yazmak 
//istemezsem bu alttaki gibi email kısmını hata almadan yazabilirim.aynı mantık.
//alttakini yazmak istersem yukarıdaki 	driver.manage().timeouts()... olanı ve driver.findElement(By.id("email")).sendKeys("mwettmm@hotmail.com"); kaldırırım

		 // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		// WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		//  emailField.sendKeys("sdv");


//------------------------------------------------------------------------------------------------------------------------
		  		  
			
			//2. Incorrect locator or type of locator
		 //   driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
			
		  //3. Element is in iFrame
			
			Thread.sleep(3000);
			driver.quit();
			
			

		}

	}

			
			
			