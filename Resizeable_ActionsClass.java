package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable_ActionsClass {

	public static void main(String[] args) {

		// Resizeable_ActionsClass
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// drag object is inside the iframe tag so switch to frame
		driver.switchTo().frame(0);
		System.out.println("Getting into the Frame by using switchTo().frame() ");
		
		WebElement ele = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		System.out.println("Find the location of the ele to click and drag so that it will resize");
		
		Point eleSourceLocation = ele.getLocation();
		System.out.println("Source element location is: "+eleSourceLocation);
		
//		int x= eleLocation.getX();
//		int y = eleLocation.getY();
//		
		//Actions class moving the element to resize
		Actions builder= new Actions(driver);
		//builder.dragAndDropBy(ele, 415, 235).perform();
		builder.clickAndHold(ele).moveByOffset(225,135).perform();
		System.out.println("Resize the element is done");
		
		
		
		
	}
}
