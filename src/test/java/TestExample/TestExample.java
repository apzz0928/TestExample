package TestExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestExample {		
	private static String baseUrl, nodeURL;
	
	@BeforeClass
	public void beforeTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/driver/chromedriver.exe");
		System.setProperty("selenide.browser", "Chrome");	 
		System.setProperty("selenide.browser", "Chrome");
			baseUrl = "https://nid.naver.com/nidlogin.login";
	        nodeURL = "http://10.10.105.228:5555/wd/hub";
	        
	        String urlToRemoteWD = "http://10.10.105.228:4444/wd/hub";
	        RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD),DesiredCapabilities.chrome());
	        WebDriverRunner.setWebDriver(driver);
	        
	        /*
	    	DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			*/
    }
	@Test
	public void Login() throws Exception {
        open(baseUrl);
        Thread.sleep(3000);
        System.out.println("------------------start-----------------");
        $("#id").setValue("apzz0928");
        $("#pw").setValue("qordlf!@34");
        $(".btn_global").click();
        Thread.sleep(3000);
        $("#query").val("selenide");
        $("#search_btn").click();
        System.out.println("------------------end-----------------");
    }
	@AfterClass
	public void afterTest() {
		closeWebDriver();
	}		
}	