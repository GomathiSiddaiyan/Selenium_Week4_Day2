package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_LeafGround {

	public static void main(String[] args) throws IOException {
		// FrameHandling

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		// First analyse the frame or normal element - if it is frame then use
		// switchTo().frame(index)

		// I am inside a frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		String frame1 = driver.findElement(By.id("Click")).getText();
		System.out.println("Text displaying in frame 1 : " + frame1);

		// Taking Screenshot of the click me button of first frame
		// Step:1 Find the element
		WebElement buttonEle = driver.findElement(By.id("Click"));
		// Step:2 Take a Screenshot
		File sourceSS = buttonEle.getScreenshotAs(OutputType.FILE);
		// Step:3 Give Folder name and file name
		File dest = new File("Snapshots/snap3.png");
		// Step:4 Store it in your folder
		FileUtils.copyFile(sourceSS, dest);
		driver.switchTo().defaultContent();

		// Find total number of frames.
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		int size = totalFrames.size();
		System.out.println("Total frames: " + size);
	}

}
