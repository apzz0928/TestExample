package TestExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import com.codeborne.selenide.testng.ScreenShooter;

public class CopyOfTestExample {		
	private static String baseUrl;
	
	@BeforeClass
	public void beforeTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/driver/chromedriver.exe");
		System.setProperty("selenide.browser", "Chrome");
		baseUrl = "http://www.nexon.com/Home/Game.aspx";
        String urlToRemoteWD = "http://10.10.105.228:4444/wd/hub";
        RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD),DesiredCapabilities.chrome());
        WebDriverRunner.setWebDriver(driver);
        ScreenShooter.captureSuccessfulTests = true;
    }
	@Test
	public void Login() throws InterruptedException{
        open(baseUrl);
        Thread.sleep(1000);
        $(By.linkText("ID 로그인")).click();
        $("#txtNexonID").setValue("apzz0928@gmail.com");
        $("#txtPWD").setValue("qordlf!@34");
        $("#btnLogin").click();
        $("img[alt='다음에하기'").click();
        $(".button01").click();
        $(".join").waitUntil(text("회원가입"), 3000);
    }
	@AfterClass
	public void afterTest() {
		closeWebDriver();
	}		
}	