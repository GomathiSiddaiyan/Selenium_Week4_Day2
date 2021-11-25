package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_Alert {

	public static void main(String[] args) throws InterruptedException {
		// Frame_Alert
//		1) Load the URL
//	2) Click on Try It Button (Hint: It is inside a frame)
//	3) Switch to the alert
//	4) Type your name on the alert
//	5) Click Ok on the alert
//	6) Get the text appearing on the browser
//	7) Check if your name exist there !!

//		1) Load the URL	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//Thread.sleep(2000);
//	2) Click on Try It Button (Hint: It is inside a frame)
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//body[@contenteditable='false']/button[text()='Try it']")).click();

//	3) Switch to the alert		
//	4) Type your name on the alert
		String str = "Gomathi";
		driver.switchTo().alert().sendKeys("Gomathi");
//	5) Click Ok on the alert
		driver.switchTo().alert().accept();

//	6) Get the text appearing on the browser
		String text = driver.findElement(By.id("demo")).getText();

//	7) Check if your name exist there !!
		if (text.contains(str)) {
			System.out.println("Yes the text is same");
			System.out.println("Displaying the text :"+text);
		} else {
			System.out.println("Text not present");
		}
	}
}
