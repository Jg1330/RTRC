package com.cybit.RTRC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.graph.models.Print;
import com.microsoft.graph.models.SearchAggregation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamplerManagement {
	static ExtentTest test;
	static ExtentReports report;
	static String injury = "yes";
	
	public static void main(String[] args) throws Exception {
		  WebElement email,pwd,submit;
		  
		
	      //  System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			report = new ExtentReports("./Report/SamplerManagement.html");
			test = report.startTest("Starting Test case");

			ChromeOptions options = new ChromeOptions();
		 options.addArguments("start-maximized");
		 options.addArguments("disable-infobars");
		 options.addArguments("--disable-extensions");
		 options.addArguments("--remote-allow-origins=*");
		    WebDriver driver = new ChromeDriver(options);
		    driver.manage().window().maximize();
		    test.log(LogStatus.PASS, "maximize has done");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		    System.out.println("Login");
		    driver.get("http://app.sampleify.in:4567/samples");
		    test.log(LogStatus.PASS, "Navigate to Alkylaminehse");
		   
		    WebDriverWait wait = new WebDriverWait (driver, 15);
			email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			email.sendKeys(Data.email);
			Thread.sleep(2000);
			
			pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			pwd.sendKeys(Data.password);
			Thread.sleep(2000);
			
			submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign In')]")));
			submit.click();
			Thread.sleep(2000);
			 test.log(LogStatus.PASS, "User login Successfully");
	
			// Logout(driver);
	     sample(driver);
		 
	  }
		
	
	private static void sample(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverWait wait = new WebDriverWait (driver, 15);
		 
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'All Samples')]")));
		menu.click();
	    Thread.sleep(2000);
	    
	    WebElement createQuo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[1]")));
	    createQuo.click();
	    Thread.sleep(2000);
	    
	    WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
	    name.sendKeys(Data.name);
	    Thread.sleep(2000);
	    
	    Select selcat =new Select(driver.findElement(By.xpath("//select[@id='sample_category']")));
    	selcat.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    Select selpro =new Select(driver.findElement(By.xpath("//select[@id='product']")));
    	selpro.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    Select seltemp =new Select(driver.findElement(By.xpath("//select[@id='master_template']")));
    	seltemp.selectByIndex(16);
	    Thread.sleep(2000);
	    
	    WebElement sub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    sub.click();
	    Thread.sleep(2000);
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    Thread.sleep(2000);
	    
	    WebElement intialization = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[3]")));
	    intialization.click();
	    Thread.sleep(2000);
	  
	    WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
	    ok.click();
	    Thread.sleep(2000);  
	    
	    WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign Out')]")));
		icon.click();
	    Thread.sleep(2000);
	    
	    driver.navigate().refresh();
	    
	    headlogin(driver);
	  
	}

	private static void headlogin(WebDriver driver) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email.sendKeys(Data.emailhead);
		Thread.sleep(2000);
		
		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		pwd.sendKeys(Data.passwordhead);
		Thread.sleep(2000);
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign In')]")));
		submit.click();
		Thread.sleep(2000);
		
		 test.log(LogStatus.PASS, "Head login Successfully");
		 
		 addSamplData(driver);
	}
	
	private static void addSamplData(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[7]/a[1]")));
		view.click();
		Thread.sleep(2000);
		
		WebElement addResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[3]")));
		addResult.click();
		Thread.sleep(2000);
		
		WebElement d1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/input[1]")));
		d1.sendKeys(Data.diameter1);
		Thread.sleep(2000);
		
		WebElement d2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/input[1]")));
		d2.sendKeys(Data.diameter2);
		Thread.sleep(2000);
		
		WebElement d3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[4]/div[1]/input[1]")));
		d3.sendKeys(Data.diameter3);
		Thread.sleep(2000);
		
		WebElement d4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[5]/div[1]/input[1]")));
		d4.sendKeys(Data.diameter4);
		Thread.sleep(2000);
		
		WebElement o1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/input[1]")));
		o1.sendKeys(Data.original1);
		Thread.sleep(2000);
		
		WebElement o2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/input[1]")));
		o2.sendKeys(Data.original2);
		Thread.sleep(2000);
		
		WebElement o3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[4]/div[1]/input[1]")));
		o3.sendKeys(Data.original3);
		Thread.sleep(2000);
		
		WebElement o4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[5]/div[1]/input[1]")));
		o4.sendKeys(Data.original4);
		Thread.sleep(2000);
		
		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[1]/input[1]")));
		e1.sendKeys(Data.elong1);
		Thread.sleep(2000);
		
		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[3]/div[1]/input[1]")));
		e2.sendKeys(Data.elong2);
		Thread.sleep(2000);
		
		WebElement e3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[4]/div[1]/input[1]")));
		e3.sendKeys(Data.elong3);
		Thread.sleep(2000);
		
		WebElement e4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[5]/div[1]/input[1]")));
		e4.sendKeys(Data.elong4);
		Thread.sleep(2000);
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		    Thread.sleep(2000);
		
		WebElement cal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[2]")));
		cal.click();
		Thread.sleep(2000);
		
		test.log(LogStatus.PASS, "Calculate Successfully");
		
		WebElement back = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[1]")));
		back.click();
		Thread.sleep(2000);
		
		WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[4]")));
		state.click();
		Thread.sleep(2000);
		
		WebElement remark = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='remarks']")));
		remark.sendKeys(Data.remark);
		Thread.sleep(2000);
		
		WebElement createReq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/input[4]")));
		createReq.click();
		Thread.sleep(2000);
		
	    WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign Out')]")));
		icon.click();
	    Thread.sleep(2000);
	    
	    driver.navigate().refresh();
	    
	    analystlogin(driver);
	  
		
	}
	private static void analystlogin(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email.sendKeys(Data.analystemail);
		Thread.sleep(2000);
		
		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		pwd.sendKeys(Data.passwordhead);
		Thread.sleep(2000);
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign In')]")));
		submit.click();
		Thread.sleep(2000);
		
		 test.log(LogStatus.PASS, "Analyst login Successfully");
		 
		 addapprovel(driver);
	}

	private static void addapprovel(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement request = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[7]/a[1]")));
		request.click();
		Thread.sleep(2000);
		
		WebElement textapproval = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='comment']")));
		textapproval.sendKeys(Data.approvedmsg);
		Thread.sleep(2000);
		
		WebElement approve = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/a[1]")));
		approve.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Approved Successfully");
		
		WebElement stateinit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[4]")));
		stateinit.click();
		Thread.sleep(2000);
		
		WebElement remark = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='remarks']")));
		remark.sendKeys(Data.remark);
		Thread.sleep(2000);
		
		WebElement createReq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/input[4]")));
		createReq.click();
		Thread.sleep(2000);
		
		WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign Out')]")));
		icon.click();
	    Thread.sleep(2000);
	    
	    driver.navigate().refresh();
	    
	    headloginprint(driver);
		
	}
	
   private static void headloginprint(WebDriver driver) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email.sendKeys(Data.emailhead);
		Thread.sleep(2000);
		
		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		pwd.sendKeys(Data.passwordhead);
		Thread.sleep(2000);
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign In')]")));
		submit.click();
		Thread.sleep(2000);
		
		 test.log(LogStatus.PASS, "Head login Successfully");
		 
		print(driver);
		 
		
	}
   
   private static void print(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[7]/a[1]")));
		view.click();
		Thread.sleep(2000);
		
		WebElement textapproval = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='comment']")));
		textapproval.sendKeys(Data.approvedmsg);
		Thread.sleep(2000);
		
		WebElement approve = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/a[1]")));
		approve.click();
		Thread.sleep(2000);
		
		test.log(LogStatus.PASS, "Approved Successfully");
		
		WebElement sampleprint = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[4]")));
		sampleprint.click();
		Thread.sleep(2000);
		
		WebElement print = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/a[1]")));
		print.click();
		Thread.sleep(5000);		 
				
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download-link']")));
		download.click();
		Thread.sleep(2000);	
		
		 test.log(LogStatus.PASS, "Download Sample Successfully");
				 
		Logout(driver);		
				 
				
   }

	private static void Logout(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		
		WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign Out')]")));
		icon.click();
	    Thread.sleep(2000);
	   
		    
	    report.endTest(test);
	    report.flush();
	    driver.close();
	   
	}
	
}




