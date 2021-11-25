package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class draggable_ActionsClass {

	public static void main(String[] args) {
		// draggable_ActionsClass
// 

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		System.out.println("Action class- drag and drop method");
		// drag object is inside the iframe tag so switch to frame
		driver.switchTo().frame(0);
//		Point divLoc = driver.findElement(By.xpath("//body[@style='cursor: auto;']")).getLocation();
//		System.out.println("The Entire frame Location"+divLoc);
		
		//Get the source location without using getLocation also we can perform further steps		
		Point sourceLoc = driver.findElement(By.id("draggable")).getLocation();
		System.out.println("Source Location point is: " + sourceLoc);

		WebElement Source = driver.findElement(By.id("draggable"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(Source, 100, 50).perform();
		System.out.println("Drag and drop made successful");

	}
}
