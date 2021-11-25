package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa_Website {
	public static void main(String[] args) throws InterruptedException {
		// Nykaa_Website
//		Pseudocode:
//			1) Go to https://www.nykaa.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

//			2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandMouseHover = driver.findElement(By.xpath("//div[@id='headerMenu']//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brandMouseHover).perform();
		System.out.println("Mouse hover on brand header");
		String windowHandle1 = driver.getWindowHandle();
		System.out.println("The first windows handle: " + windowHandle1);
		System.out.println("The title of the first page: " + driver.getTitle());
//			3) Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();

//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("The title of second page: " + driver.getTitle());

//			5) Click sort By and select customer top rated
		driver.findElement(By.className("arrow-icon")).click();
		driver.findElement(By.xpath("(//div[@id='filter-sort']//span)[5]")).click();
		System.out.println("Click on sort by: customer top rated ");

//			6) Click Category and click Hair->Click haircare->Shampoo
		// driver.findElement(By.id("first-filter")).click();
		driver.findElement(By.xpath("//div[@id='first-filter']/div[1]/span[text()='Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='control control-checkbox']/div[1]/span[text()='Shampoo']"))
				.click();
		System.out.println("Clicked on Category--> Hair--> Hair Care--> Shampoo");
//			7) Click->Concern->Color Protection
		driver.findElement(By.xpath("(//div[@class='filter-open css-nbw8dp'])[6]")).click();
		driver.findElement(By.xpath("//div[@class='control-value']/span[text()='Color Protection']")).click();
		System.out.println("Clicked on Concern--> Color Protection");

//			8)check whether the Filter is applied with Shampoo
		String filter1 = driver.findElement(By.xpath("//div[@id='filters-listing']//span[text()='Shampoo']")).getText();
		if (filter1.contains("Shampoo")) {
			System.out.println("Yes the filter is applied with Shampoo");
		} else {
			System.out.println("No the filter is not applied with shampoo");
		}

//			9) Click on L'Oreal Paris Colour Protect Shampoo
		//div[contains(text(),'Colour Protect Shampoo')]
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
		//driver.findElement(By.xpath("//div[@id='product-list-wrap']//div[1]")).click();
		System.out.println("Clicked on the first product- loreal paris colour protection shampoo");

//			10) GO to the new window and select size as 175ml
		System.out.println("Handling second page and dropdown for size of mileliter");
		Set<String> allwindowHandles = driver.getWindowHandles();
		int sizeOfWindowHandles = allwindowHandles.size();
		System.out.println("Total no of Windows handle: " + sizeOfWindowHandles);
		List<String> windowHandle2 = new ArrayList<String>(allwindowHandles);
		driver.switchTo().window(windowHandle2.get(1));
		WebElement sizeML = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropdown = new Select(sizeML);
		dropdown.selectByValue("1");
		System.out.println("Came to 2nd page and selected 360 ml");
//			11) Print the MRP of the product
		String mrpFirst = driver.findElement(By.xpath("//div[@id='app']//h1/following-sibling::div[2]/span[2]"))
				.getText();
		String mrp = mrpFirst.replaceAll("\\D", " ");
		System.out.println("The first product price: " + mrp);

//			12) Click on ADD to BAG
		driver.findElement(By.xpath("//button[@type='button']/span[text()='ADD TO BAG']")).click();
		System.out.println("Clicked on Add to bag");

//			13) Go to Shopping Bag 
		driver.findElement(By.className("cart-count")).click();
		System.out.println("Clicked on Shopping bag");

//			14) Print the Grand Total amount
		Thread.sleep(1000);
		System.out.println("Entering into frame to print grand total and proceed");
		driver.switchTo().frame(0);
		String total = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div")).getText();
		// String total = driver.findElement(By.xpath("(//div[@class='table-row
		// ']//div)[2]")).getText();
		String grandTotal = total.replaceAll("\\D", "");
		System.out.println("Printing the Grand Total in Shopping bag section: " + grandTotal);

//			15) Click Proceed
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();
		System.out.println("Printed grand total and proceed");

//			16) Click on Continue as Guest
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		System.out.println("Clicked on Continue as Guest");
//			17) Check if this grand total is the same in step 14
		String lastPageGrandTotal = driver
				.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[2]/span"))
				.getText();
		String verifyGrandTotal = lastPageGrandTotal.replaceAll("\\D", "");
		System.out.println("Grand total on last Page: " + verifyGrandTotal);

		if (verifyGrandTotal.equals(grandTotal)) {
			System.out.println("Yes the Grand total is correct");
		} else {
			System.out.println("No the Grand total is wrong");
		}

//			18) Close all windows
		driver.quit();
	}
}
