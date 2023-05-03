package vtiger.practice;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lanuch_Browserthroughpropertyfile {
	public static void main(String[] args) throws IOException {
		/* Read data from PropertiesFile */
		PropertyFile CD = new PropertyFile();
		String USERNAME = CD.getDataFromProperties("username");
		String PASSWORD = CD.getDataFromProperties("password");
		String URL = CD.getDataFromProperties("url");
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(URL);
		/* Configuration */
		System.setProperty("WebDriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		/* Login Operation */
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.close();
	}
}
