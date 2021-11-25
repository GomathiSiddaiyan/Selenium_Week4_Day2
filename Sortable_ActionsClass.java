package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable_ActionsClass {

	public static void main(String[] args) {
		// Sortable_ActionsClass
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// drag object is inside the iframe tag so switch to frame
		driver.switchTo().frame(0);
		System.out.println("Getting into the Frame by using switchTo().frame() ");

		// get xpath for items which u want to move
		WebElement firstItem = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement secondItem = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));

		// find the location of secondItem or firstItem to move
		Point secondItemLoc = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]")).getLocation();
		int x = secondItemLoc.getX();
		int y = secondItemLoc.getY();
//		int x = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]")).getLocation().getX();
//		int y = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]")).getLocation().getY();

		// Action class to perform drag and drop so that items will move and sort
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(firstItem, x, y).perform();
		System.out.println("Sorting two items done successfully");

	}
}
