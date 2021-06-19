import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BitBar {
	protected RemoteWebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("bitbar_apiKey", "Er8VOV1f4ZwNmXbJkTOyBQFXRP1UzmBD"); // Please change this to your API key
		capabilities.setCapability("bitbar_device", "['Asus']");
		capabilities.setCapability("bitbar_app", "143115697"); // Please change this to appropriate app
		capabilities.setCapability("bitbar_target", "android");
		capabilities.setCapability("bitbar_target", "android");
		capabilities.setCapability("bitbar_project", "Cricket Rankings");
		capabilities.setCapability("bitbar_testrun", "Cricket Rankings Test");

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10"); 
		capabilities.setCapability("deviceName","Android Phone");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.apppark.cricketdictionary2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity",".MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("https://appium.bitbar.com/wd/hub"), capabilities);
	}

	  @Test
	  public void test_cricket_definition() throws Exception {
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//android.widget.TextView[@text='About Cricket']")).click();
		  WebElement eleCricketDef = driver.findElement(By.xpath("//android.view.View"));
		  String boolTest = eleCricketDef.getAttribute("text");
		  Assert.assertEquals(boolTest.contains("Cricket is played with a bat and ball"), true );
		  driver.navigate().back();
		}
	  
	  @Test
	  public void test_cricket_matches_type() throws Exception {
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//android.widget.TextView[@text='Types of Matches']")).click();
		  List<WebElement> eleCricketDef = driver.findElements(By.className("android.widget.TextView"));
		  System.out.println(eleCricketDef.size());
		  
//		  String boolTest = eleCricketDef.getAttribute("text");
//		  Assert.assertEquals(boolTest.contains("Cricket is played with a bat and ball"), true );
		}
	  
	  @AfterClass
	  public void teardown(){
	  	//close the app
	  	driver.quit();
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

}


