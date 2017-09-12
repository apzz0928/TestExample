package TestExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import com.codeborne.selenide.testng.ScreenShooter;

public class CopyOfTestExample {		
	private static String baseUrl;
	
	@BeforeClass
	public void beforeTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/driver/chromedriver.exe");
		System.setProperty("selenide.browser", "Chrome");
		baseUrl = "https://nid.naver.com/nidlogin.login";
        String urlToRemoteWD = "http://10.10.105.228:4444/wd/hub";
        RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD),DesiredCapabilities.chrome());
        WebDriverRunner.setWebDriver(driver);
        ScreenShooter.captureSuccessfulTests = true;
    }
	@Test
	public void Login() throws InterruptedException{
        open(baseUrl);
        $("#id").setValue("apzz0928");
        $("#pw").setValue("qordlf!234");
        $(".btn_global").click();
        Thread.sleep(2000);
        $("#query").setValue("Selenide");
        $(".ico_search_submit").click();
        Thread.sleep(2000);
        $(".sh_blog_title").click();
        Thread.sleep(2000);
    }
	@AfterClass
	public void afterTest() {
		closeWebDriver();
	}		
}	