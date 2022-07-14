package com.flipkart.org;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobilePurchase {

	public static WebDriver driver;

	public String url = "https://www.flipkart.com/";

	@BeforeClass
	public static void browserlaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\eclipse-workspace\\Employee\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		System.out.println("Setup process completed");
		Thread.sleep(5000);
	}

	@AfterClass
	public static void browserQuit() {
		// driver.quit();
		System.out.println("Browser completed");
	}

	@Test
	public void method1() {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		;

	}

	@Test
	public void method2()

	{
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test
	public void method3() throws Exception, IOException {
		driver.get("https://www.flipkart.com/");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("RealMe mobiles");
		WebElement enter = driver.findElement(By.xpath("//button[@type='submit']"));
		enter.click();
		WebElement searc = driver.findElement(By.name("q"));
		String p = searc.getAttribute("value");
		Thread.sleep(3000);
		System.out.println(p);
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject1\\src\\main\\resources\\Excelfiles\\Text3.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("sample");
		XSSFRow r = s.createRow(1);
		XSSFCell c = r.createCell(1);
		c.setCellValue(p);
		w.write(f1);
		
		/*
		 * File file = new
		 * File("C:\\Users\\rajap\\eclipse-workspace\\Junit\\driver\\test cases (1).xlsx"
		 * ); FileOutputStream f = new FileOutputStream(file); XSSFWorkbook work = new
		 * XSSFWorkbook(); XSSFSheet sheet = work.createSheet("mobile name"); XSSFRow
		 * row = sheet.createRow(0); XSSFCell cell = row.createCell(0); cell.
		 * setCellValue(text1); work.write(f); work.close();
		 */
	}

	@Test
	public void method4() throws Exception {
		driver.get("https://www.flipkart.com/search?q=Realme%20mobile&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		String s3 = driver.findElement(By.xpath("(//div[contains(@class,'rR')])[1]")).getText();

		String pwin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();

		for (String x : allwin) {
			if (!x.equals(pwin)) {
				driver.switchTo().window(x);
			}
		}

		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject1\\src\\main\\resources\\Excelfiles\\Text3.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("sample1");
		XSSFRow r = s.createRow(2);
		XSSFCell c = r.createCell(2);
		c.setCellValue(s3);
		w.write(f1);
	}

	@Test
	public void method5() throws Throwable {
		driver.get("https://www.flipkart.com/realme-c11-2021-cool-blue-32-gb/p/itmbd856acb97c38?pid=MOBG4BEG3HG78BDG&lid=LSTMOBG4BEG3HG78BDGOBNGF8&marketplace=FLIPKART&q=Realme+mobile&store=tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=c5c84512-f01f-47ee-99d8-eaccc64553bd.MOBG4BEG3HG78BDG.SEARCH&ppt=sp&ppn=sp&ssid=4cmjppqsdc0000001657723315760&qH=fc22fcb613ec0535");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject1\\Screenshot\\fk.png");
		FileUtils.copyFile(source, target);
		

	}

}
