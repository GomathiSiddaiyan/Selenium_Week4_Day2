package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class droppable_ActionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// drag object is inside the iframe tag so switch to frame
		driver.switchTo().frame(0);
		System.out.println("Getting into the Frame by using switchTo().frame() ");
		
		//find source and target element and store it in webElement
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		//Actions class and perform by method drag and drop
		Actions bul = new Actions(driver);
		bul.dragAndDrop(Source, target).perform();
		System.out.println("Drag and drop in targeted location is successful");

	}

}
