package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//parent::li)[3]")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9843847772");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
			String ID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).getText();
		
		Thread.sleep(1000);
			WebElement Lead_ID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"));
			driver.executeScript("arguments[0].click()", Lead_ID);
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//parent::li)[3]")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(ID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String Result = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		if(Result.equals("No records to display")) {
			System.out.println("Deleted Successfully");
		}
		
		Thread.sleep(2000);
				driver.close();
		
	}

}