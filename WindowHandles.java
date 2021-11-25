package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws IOException {
		// WindowHandles		
//		1) Open the browser with URL: https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2
//			2) Click on the first book link
//			3) Print the number of window handles 
//			4) Switch the control to the second window
//			5) Print the title of the new window
//			6) Close all browsers

		
//		1) Open the browser with URL: https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
		String win1 = driver.getTitle();
		System.out.println("The window 1 title is: "+win1);
		String WinHandle1=driver.getWindowHandle();
		System.out.println("The Window handle 1 is: "+WinHandle1);
		
//		2) Click on the first book link
		driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")).click();
		
//		3) Print the number of window handles 
		Set<String> allWindowHandles=driver.getWindowHandles();
		System.out.println("The Number of window Handles: "+ allWindowHandles.size());
		
//		4) Switch the control to the second window
		List<String> allHandles= new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(allHandles.get(1));
		
//		5) Print the title of the new window
		System.out.println("The Title of current page: "+driver.getTitle());
		
		//Take Screenshot::
		File SourceScreenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destScreenShot= new File("Snapshots/snap1.png");
		FileUtils.copyFile(SourceScreenshotAs, destScreenShot);
//		6) Close all browsers
		driver.quit();
		
		
		
	}}
