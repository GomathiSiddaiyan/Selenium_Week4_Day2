package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSample {

	public static void main(String[] args) throws InterruptedException {
		// FrameSample
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		//First analyse the frame or normal element - if it is frame then use switchTo().frame(index)
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		String topic="Learning Frame concept in chercher.tech";
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys(topic);		
		System.out.println("In frame 1- I have entered the text: "+topic);
		driver.switchTo().defaultContent();
		
		//Entering into the nested frame
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		System.out.println("In frame 2- I clicked on the check box");
		driver.switchTo().defaultContent();
		
		//Entering into third frame
		driver.switchTo().frame("frame2");
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select animal= new Select(dropdown);
		animal.selectByValue("big baby cat");
		System.out.println("In frame 3- dropdown option i selected :");
	}}
