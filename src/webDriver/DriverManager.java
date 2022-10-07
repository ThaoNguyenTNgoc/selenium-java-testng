package webDriver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public abstract class DriverManager {
//add
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver= new ChromeDriver();
		driver.manage().window(). maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30 TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void TC_01_() {
		
		//Sẽ đóng tab đang đứng nếu có nhiều tab 
		// Nếu chỉ có 1 tab thì đóng browser
		driver.close();
		//Không quan tâm bảo nhiêu tab => đóng browser
		driver.quit();
		//- Có thể lưu nó vào 1 biến để sử dụng cho các step sau
		//- Có thể sử dụng luôn (ko cần tạo biến)
		
		// cách này clear code hơn
		WebElement emailTextbox =driver.findElement(By.xpath("//input[@id='email']"));
		
//		emailTextbox.clear();
//		emailTextbox.sendKeys("");
		
		
		//bad code
//		driver.findElement(By.xpath("//input[@id='email']")).clear();
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
//		
		// Có thể sử dụng luôn (ko cần tạo biến)
		driver.findElement(By.xpath("//input[@id='email']")).click();
		
		//Tìm nhiều elements
		List<WebElement> checkboxes= driver.findElements(By.xpath(projectPath));
		
				// Mở ra 1 url
		driver.get("https://www.facebook.com/");
		
		//Click vào link :Tiếng việt
		
		
		//Trả về Url của page hiện tại
		driver.getCurrentUrl();
		
		//Có thể lưu vào 1 biến đê sử dụng nhiều lần
		
//		String vietnamesePageUrl = driver.getCurrentUrl();
//		Assert.assertEquals(vietnamesePageUrl, "https://vi-vn.facebook.com/");
		
		// - Có thể sử dụng luôn (ko cần tạo biến)
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		
		//Verify tương đối
		Assert.assertTrue(driver.getPageSource().contains("Facebook"));
		
		//Trả về title của page hiện tại
		Assert.assertEquals(driver.getTitle(),"Facebook");
		
//		Lấy ra được ID của tab hiện tại
		String loginWindowID = driver.getWindowHandle();
		
//		Lấy ra ID của tất cả các tab
		String allIDs = driver.getWindowHandle();
		
		//Cookie/Cache
		Options opt= driver.manage();
		
		//Login thành công=> lưu lại
		opt.getCookies();
		
		//Testcase khác => set cookie vào lại => không cần phải login lại
		opt.logs();
		
		Timeouts time = opt.timeouts();
		
		//Khonagr thời gian chờ 1 element xuất hiện
		time.implicitlyWait(15,TimeUnit.SECONDS);
		time.implicitlyWait(5000,TimeUnit.MILLISECONDS);
		time.implicitlyWait(5000000,TimeUnit.MICROSECONDS);
		
		//Khoảng thời gian chờ page lòa
		time.implicitlyWait(5,TimeUnit.SECONDS);
		
		Window win = opt.window();
		


		
	}

}
