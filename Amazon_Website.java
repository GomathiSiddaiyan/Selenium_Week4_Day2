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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Website {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Amazon_Website
//		Amazon:
//			1.Load the URL https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		String firstPage = driver.getWindowHandle();
		System.out.println("Window handle 1: " + firstPage);
		String firstPageTitle = driver.getTitle();
		System.out.println("The First Page Title: " + firstPageTitle);
//			2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//div[@id='suggestions']//div[1]")).click();

//			3.Get the price of the first product
		Thread.sleep(1000);
		String productPrice = driver.findElement(By.xpath("//span[@class='a-price-symbol']/following-sibling::span"))
				.getText();
		System.out.println("The First Product Price is: " + productPrice);

//			4. Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("(//div[@class='a-row a-size-small']//span[2]/a)[1]")).getText();
		System.out.println("The no of customers RATING : " + rating);

//			5. click on the stars 
		driver.findElement(By.xpath("(//div[@class='a-row a-size-small']//span/span/a/i)[1]")).click();

//			6. Get the percentage of ratings for the 5 star.
		String PercentageOfRating = driver.findElement(By.xpath("(//table[@id='histogramTable']//td[3]/span/a)[1]"))
				.getText();
		System.out.println("Percentage of ratings for the 5 star: " + PercentageOfRating);

//			7. Click the first text link of the first image
		driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none']/h2/a/span)[1]")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int windowSize = allWindowHandles.size();
		System.out.println("The total size of the Window is: " + windowSize);
		List<String> secondPage = new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(secondPage.get(1));

//			8. Take a screen shot of the product displayed
		// Taking Screenshot of the click me button of first frame
		System.out.println("Taking a screen shot of the product displayed");
		// Step:1 Find the element
		// WebElement imgEle =
		// driver.findElement(By.id("//div[@id='imgTagWrapperId']/img[@alt='OnePlus 9
		// Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']"));
		// Step:2 Take a Screenshot
		File sourceSS = driver.getScreenshotAs(OutputType.FILE);
		// Step:3 Give Folder name and file name
		File dest = new File("Snapshots/snap4.png");
		// Step:4 Store it in your folder
		FileUtils.copyFile(sourceSS, dest);
		driver.switchTo().defaultContent();

//			9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		System.out.println("Clicked on 'Add to Cart' button");

//			10. Get the cart subtotal and verify if it is correct.
		Thread.sleep(3000);
		//String totalPrice = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		String totalPrice =driver.findElement(By.xpath(
				"//div[@id='hlb-subcart']//span/span[@class='a-color-price hlb-price a-inline-block a-text-bold']"))
				.getText();
		System.out.println("The cart subtotal price is: " + totalPrice);
		// Thread.sleep(2000);
		String doublePrice = totalPrice.replaceAll("[?]", " ");
		System.out.println("Price in decimal(double)" + doublePrice);
		//double sub=Double.parseDouble(doublePrice);
		float sub = Float.parseFloat(doublePrice);
		int subTotalPrice = (int) sub;
		System.out.println("Price without decimal point(integer):" + subTotalPrice);
		
		System.out.println("SubTotal: " + subTotalPrice);
		// System.out.println(subTotalPrice);
		if (productPrice.equals(subTotalPrice)) {
			System.out.println("Yes the product price and subtotal price are same" + subTotalPrice);
		} else {
			System.out.println("No the product price and subtotal price are different");
		}
	}

}
