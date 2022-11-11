package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		
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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Nandhu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement LeadId = driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')]//a)[1]"));
		driver.executeScript("arguments[0].click()", LeadId);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Bosch");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
		
		
		
		
	}

}