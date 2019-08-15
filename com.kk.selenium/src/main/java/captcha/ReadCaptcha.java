package captcha;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ReadCaptcha {
	public static void main(String[] args) throws IOException, TesseractException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\selenium\\selenium\\chromedriver-win32\\chromedriver.exe");	
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		driver.findElement(By.className("h_menu_drop_button")).click();
		driver.findElement(By.className("search_btn")).click();
		
//		driver.findElement(By.xpath("\\button[text()='LOGIN']")).click();
		
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.id("nlpCaptchaImg"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/captcha.png";
		
		FileHandler.copy(src, new File(path));
		
		ITesseract img = new Tesseract();
		String txt = img.doOCR(new File(path));
		
		
		

	}
}