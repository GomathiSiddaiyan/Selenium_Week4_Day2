package week4.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Selectable_ActionsClass {

	public static void main(String[] args) {
		// Selectable_ActionsClass
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		// drag object is inside the iframe tag so switch to frame
		driver.switchTo().frame(0);
		
		//find all elements xpath and store it in webElement
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		//Actions class and perform by method clickAndHold
		System.out.println("Selecting multiple values by clickAndHold method");
		Actions builder= new Actions(driver);
		builder.clickAndHold(item1).moveToElement(item5).release().perform();
		
		//Select multiple items in another method- KeyDown
		//Deselect the selected items by another method
		System.out.println("Another method to select multiple items using keyDown()");
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();
		
		
		
	}}
