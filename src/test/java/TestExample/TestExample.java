package TestExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;	

public class TestExample {		
	    private static WebDriver driver;
		private static JavascriptExecutor js;
		private static String nodeURL;
		
		@BeforeClass
		public void beforeTest() throws MalformedURLException {
	        nodeURL = "http://10.10.105.228:5555/wd/hub";
	    	DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
	  		js = (JavascriptExecutor) driver;
        }
	  	
		@Test
		public void Login() throws Exception {
	        driver.get("https://nid.naver.com/nidlogin.login");
	        Thread.sleep(2000);
	        js.executeScript("document.querySelector('#id').value = 'apzz0928';");
	        System.out.println("ID �Է�");
	        Thread.sleep(2000);
	        js.executeScript("document.querySelector('#pw').value = 'qordlf!@34';");
	        System.out.println("PW �Է�");
	        Thread.sleep(2000);
	        js.executeScript("document.querySelector('.btn_global').click();");
	        System.out.println("�α���");
	        Thread.sleep(2000);
	    }
		
		@AfterClass
		public void afterTest() {
			driver.close();
		}		
}	