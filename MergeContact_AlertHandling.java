package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact_AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// MergeContact_AlertHandling

		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */

		// Pseudo Code

//		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//		  2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//		  3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

//		  4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		  5. Click on contacts Button
		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[text()='Contacts']")).click();

//		  6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Merge Contacts']")).click();

//		  7. Click on Widget of From Contact
		String windowHandle1 = driver.getWindowHandle();
		System.out.println("The 1st window handle reference: " + windowHandle1);
		String firstPage = driver.getTitle();
		System.out.println("The Title of the first page: " + firstPage);
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::img[@alt='Lookup']"))
				.click();

//		  8. Click on First Resulting Contact
		// Window Handling
		// Print the number of window handles
		Set<String> NoOfWindowHandles1 = driver.getWindowHandles();
		System.out.println("The Number of window Handles: " + NoOfWindowHandles1.size());

		// Switch the control to the second window
		List<String> WinHandle1 = new ArrayList<String>(NoOfWindowHandles1);
		driver.switchTo().window(WinHandle1.get(1));

		// Print the title of the new window
		System.out.println("The Title of current page: " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.className("linktext")).getText();
		driver.findElement(By.className("linktext")).click();

		driver.switchTo().window(windowHandle1);
		String windowHandle2 = driver.getWindowHandle();
		System.out.println("The 2nd window handle reference: " + windowHandle2);
		System.out.println("The Title of the Second page: " + driver.getTitle());

//		  9. Click on Widget of To Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following::img[@alt='Lookup']")).click();

//		  10. Click on Second Resulting Contact
		// Window Handling
		// Print the number of window handles
		Set<String> NoOfWindowHandles2 = driver.getWindowHandles();
		System.out.println("The Number of window Handles: " + NoOfWindowHandles2.size());

//			Switch the control to the second window
		List<String> WinHandle2 = new ArrayList<String>(NoOfWindowHandles2);
		driver.switchTo().window(WinHandle2.get(1));

//			 Print the title of the new window
		System.out.println("The Title of current page: " + driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
//		  11. Click on Merge button using Xpath Locator
		driver.switchTo().window(windowHandle1);
		Thread.sleep(2000);
		driver.findElement(By.className("buttonDangerous")).click();

//		  12. Accept the Alert
		// Alert handling
		driver.switchTo().alert().accept();
		String lastPage = driver.getTitle();
		System.out.println("The Title of the Last page: " + lastPage);

//		  13. Verify the title of the page
		if (lastPage.contains("View Contact | opentaps CRM")) {
			System.out.println("Successful");
			System.out.println("The Last page is: " + lastPage);
		} else {
			System.out.println("Not Successful");
		}

	}

}
