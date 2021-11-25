package week4.day2;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		//FrameHandling
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
		
		//First analyse the frame or normal element - if it is frame then use switchTo().frame(index)
		
		//I am inside a frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		String frame1 = driver.findElement(By.id("Click")).getText();
		System.out.println("Text displaying in frame 1 : "+frame1);
		driver.switchTo().defaultContent();
		
		//I am inside a nested frame
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		String frame2 = driver.findElement(By.id("Click1")).getText();
		System.out.println("Text displaying in frame 2 : "+frame2);
		driver.switchTo().defaultContent();
		
		//Find total number of frames.
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		int size=totalFrames.size();
		System.out.println("Total frames: "+size);
		
	}}
