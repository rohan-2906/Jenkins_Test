import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;


public class Check {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("hi");
		System.setProperty("webdriver.ie.driver","C:\\libraries\\IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Rohan\\Desktop\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
		
		
		
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	   capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability("allow-blocked-content", true);
		capabilities.setCapability("allowBlockedContent", true);
		WebDriver mdriver = new InternetExplorerDriver(capabilities);
		//WebDriver mdriver = new ChromeDriver();
		mdriver.get("https://www.google.co.in/");
		System.out.println(mdriver.getCurrentUrl());
		//while(mdriver.findElement(By.partialLinkText("Log in")).isDisplayed())
		TimeUnit.SECONDS.sleep(10);
		System.out.println("Hello");
		WebElement searchBox = mdriver.findElement(By.name("q"));
        searchBox.sendKeys("Pluralsight");
        WebElement searchButton = mdriver.findElement(By.name("btnK"));
        searchButton.click();
		System.out.println(mdriver.getCurrentUrl());	
		File scrFile = ((TakesScreenshot)mdriver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
          try {
			FileHandler.copy(scrFile, new File("screensho0t.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mdriver.close();
	}

}
