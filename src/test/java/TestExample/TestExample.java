package TestExample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestExample {		
	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/driver/chromedriver.exe");
		System.setProperty("selenide.browser", "Chrome");	        
    }
	@Test
	public void Login() throws Exception {
        open("https://nid.naver.com/nidlogin.login");
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