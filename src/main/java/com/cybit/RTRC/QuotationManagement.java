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

public class QuotationManagement {
	static ExtentTest test;
	static ExtentReports report;
	static String injury = "yes";
	
	public static void main(String[] args) throws Exception {
		  WebElement email,pwd,submit;
		  
		
	       // System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			report = new ExtentReports("./Report/QuotationManagement.html");
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
	     quotation(driver);
		 
	  }
		
	
	private static void quotation(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverWait wait = new WebDriverWait (driver, 15);
		 
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Quotation Management')]")));
		menu.click();
	    Thread.sleep(2000);
	    
	    WebElement createQuo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/a[1]")));
	    createQuo.click();
	    Thread.sleep(2000);
	    
	    Select selEmp =new Select(driver.findElement(By.xpath("//select[@id='customer_id']")));
    	selEmp.selectByIndex(1);
	    Thread.sleep(2000);
	    
	 /*   WebElement cust_address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_addr']")));
	    cust_address.sendKeys(Data.address);
	    Thread.sleep(2000);*/
	    
	    WebElement ref = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='reference']")));
	    ref.sendKeys(Data.ref);
	    Thread.sleep(2000);
	    
	    WebElement refDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ref_date']")));
	    refDate.sendKeys(Data.refDate);
	    Thread.sleep(2000);
	    
	   /* WebElement cusDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_details']")));
	    cusDetails.sendKeys(Data.cusDetails);
	    Thread.sleep(2000);*/
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollTo(0, 250)");
	    
	 /*   WebElement quo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='quotation_number']")));
	    String value = quo.getAttribute("value");
	    System.out.print(">>"+value);
	    int i = Integer.parseInt(value);
	    System.out.print(">>"+i);
	    int j = i + 0000001;
	    String qou1 = String.valueOf(j);
	    System.out.print(">>"+j);
	    quo.clear();
	    quo.sendKeys("00000"+qou1);
	    Thread.sleep(2000);*/
	  
	    
	    WebElement dueDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='due_date']")));
	    dueDate.sendKeys(Data.dueDate);
	    Thread.sleep(2000);
	  
	  /*  WebElement billAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='bill_to_address']")));
	    billAddress.sendKeys(Data.billAddress);
	    Thread.sleep(2000);
	    
	    WebElement shipAddress = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='ship_to_address']")));
	    shipAddress.sendKeys(Data.shipAddress);
	    Thread.sleep(2000);*/
	    
	    WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[5]/button[1]")));
	    add.click();
	    Thread.sleep(2000);
	    
	    Select proDesc =new Select(driver.findElement(By.xpath("//table[2]/tr[3]/td[1]/select[1]")));
	    proDesc.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    Select testStudy =new Select(driver.findElement(By.xpath("//table[2]/tr[3]/td[2]/select[1]")));
	    testStudy.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    WebElement charge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[3]/input[1]")));
	    charge.clear();
	    charge.sendKeys(Data.charges);
	    Thread.sleep(2000);
	  
	    WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[4]/input[1]")));
	    quantity.sendKeys(Data.quantity);
	    Thread.sleep(2000);
	  
	    WebElement remark = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[6]/input[1]")));
	    remark.sendKeys(Data.remark);
	    Thread.sleep(2000);
	    
	    WebElement add1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[5]/button[1]")));
	    add1.click();
	    Thread.sleep(2000);
	    
	    WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[4]/td[7]/a[1]")));
	    delete.click();
	    Thread.sleep(2000);
	    
	    driver.switchTo().alert().accept();
	    
	    WebElement sub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    sub.click();
	    Thread.sleep(2000);
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    Thread.sleep(2000);
	    
	    invoice(driver);
	  
	}


	private static void invoice(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		 
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Invoice Management')]")));
		menu.click();
	    Thread.sleep(2000);
	    
	    WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/a[1]")));
		add.click();
	    Thread.sleep(2000);
	    
	    Select selEmp =new Select(driver.findElement(By.xpath("//select[@id='customer_id']")));
    	selEmp.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    WebElement pno = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='our_praposal_no']")));
		pno.sendKeys(Data.pno);
	    Thread.sleep(2000);
	    
	    WebElement rno = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ref_no']")));
		rno.sendKeys(Data.rno);
	    Thread.sleep(2000);
	    
	    WebElement rdate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ref_date']")));
		rdate.sendKeys(Data.rdate);
	    Thread.sleep(2000);
	    
	    WebElement addrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Row')]")));
		addrow.click();
	    Thread.sleep(2000);
	  
	    Select proDesc =new Select(driver.findElement(By.xpath("//table[2]/tr[3]/td[1]/select[1]")));
	    proDesc.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    WebElement hsc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[2]/input")));
	    hsc.sendKeys(Data.hsc);
	    Thread.sleep(2000);
	    
	    WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[3]/input[1]")));
	    quantity.sendKeys(Data.quantity);
	    Thread.sleep(2000);
	    
	    WebElement charge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[3]/td[4]/input[1]")));
	    charge.sendKeys(Data.charges);
	    Thread.sleep(2000);
	  
	    WebElement addrow1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Row')]")));
		addrow1.click();
	    Thread.sleep(2000);
	    
	    WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[2]/tr[4]/td[6]/a[1]")));
	    delete.click();
	    Thread.sleep(2000);
	    
	    driver.switchTo().alert().accept();
	    
	    WebElement sub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    sub.click();
	    Thread.sleep(2000);
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    Thread.sleep(2000);
	    
	    TestRequest(driver);
	}


	private static void TestRequest(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait (driver, 15);
		 
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Test Request & Contract Review')]")));
		menu.click();
	    Thread.sleep(2000);
	    
	    WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/a[1]")));
		add.click();
	    Thread.sleep(2000);
	    
	    WebElement selInvoice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-invoice_id-container']")));
	    selInvoice.click();
	    Thread.sleep(2000);
	    
	    WebElement actionbysearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")));
	    actionbysearch.sendKeys(Data.hsc);
	    actionbysearch.click();
	    Thread.sleep(2000);
	  
	    List<WebElement> allElements=driver.findElements(By.xpath("//ul[@id='select2-invoice_id-results']"));

	    for(WebElement ele :allElements) {
	       System.out.println(ele.getText());
	       String s1= ele.getText();
	      ele.click();
	     Thread.sleep(2000);
	      
	    }
	    
	    WebElement tanno = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='tan_no']")));
	    tanno.sendKeys(Data.tno);
	    Thread.sleep(2000);
	    
	    WebElement panno = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pan_no']")));
	    panno.sendKeys(Data.pno);
	    Thread.sleep(2000);
	    
	    WebElement addreport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='addr_report']")));
	    addreport.sendKeys(Data.address);
	    Thread.sleep(2000);
	    
	    WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='itrYes']")));
		yes.click();
	    Thread.sleep(2000);
	    
	    WebElement giveadd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='give_addr']")));
	    giveadd.sendKeys(Data.address);
	    Thread.sleep(2000);
	    
	    WebElement disadd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='add_dis_report']")));
	    disadd.sendKeys(Data.billAddress);
	    Thread.sleep(2000);
	    
	    WebElement sampDesc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='sample_des']")));
	    sampDesc.sendKeys(Data.desc);
	    Thread.sleep(2000);
	    
	    WebElement due = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='due_date']")));
	    due.sendKeys(Data.rdate);
	    Thread.sleep(2000);
	    
	    Select test1 =new Select(driver.findElement(By.xpath("//table[4]/tr[3]/td[1]/select[1]")));
	    test1.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    Select method1 =new Select(driver.findElement(By.xpath("//table[4]/tr[3]/td[2]/select[1]")));
	    method1.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    Select details1 =new Select(driver.findElement(By.xpath("//table[4]/tr[3]/td[3]/select[1]")));
	    details1.selectByIndex(1);
	    Thread.sleep(2000);
	    
	    WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[4]/tr[4]/td[5]/a[1]")));
		delete.click();
	    Thread.sleep(2000);
	  
	    driver.switchTo().alert().accept();
	    
	    WebElement deliveryby = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='delivery_by']")));
	    deliveryby.sendKeys(Data.ref);
	    Thread.sleep(2000);
	    
	    WebElement method = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='spec_selected']")));
	    method.sendKeys(Data.method);
	    Thread.sleep(2000);
	    
	    WebElement route = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='bis_details']")));
	    route.sendKeys(Data.route);
	    Thread.sleep(2000);

	    WebElement detail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='significant_point_details']")));
	    detail.sendKeys(Data.details);
	    Thread.sleep(2000);
	  
	    WebElement sub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    sub.click();
	    Thread.sleep(2000);
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	    Thread.sleep(2000);
	    
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




