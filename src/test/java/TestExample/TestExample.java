package TestExample;

import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;	
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestExample {		
	/*    
	private static WebDriver driver;
	private static JavascriptExecutor js;
	private static String Test;
	*/
	private static String nodeURL;
	/*   
	public static void elementWait(String selector, String word){
		WebDriverWait wait = new WebDriverWait(driver, 10);
  		switch(selector){
	  		case "id":
		  		wait.until(ExpectedConditions.elementToBeClickable(By.id(word)));
		  		break;
	  		case "class":
		  		wait.until(ExpectedConditions.elementToBeClickable(By.className(word)));	  
	  			break;
	  		case "name":
	  			wait.until(ExpectedConditions.elementToBeClickable(By.name(word)));
	  			break;
	  		case "css":
		  		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(word)));	
	  			break;
	  		case "linkText":
		  		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(word)));	  	
	  			break;
	  		case "text":
		  		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(word)));
	  			break;
	  		case "tagName":
	  			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(word)));
	  			break;
	  		}
		}*/
		
		@BeforeClass
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver", "D:/Selenium/driver/chromedriver.exe");
			System.setProperty("selenide.browser", "Chrome");	        
        }
	  	
		@Test
		public void Login() throws Exception {
	        open("https://nid.naver.com/nidlogin.login");
	        Thread.sleep(3000);
	        $("#id").setValue("apzz0928");
	        $("#pw").setValue("qordlf!@34");
	        $(".btn_global").click();
	        Thread.sleep(3000);
	        $("#query").val("selenide");
	        $("#search_btn").click();
	    }
		
		@AfterClass
		public void afterTest() {
			closeWebDriver();
		}		
}	