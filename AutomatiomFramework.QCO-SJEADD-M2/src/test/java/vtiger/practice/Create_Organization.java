package vtiger.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelDataUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.LoginPage;
public class Create_Organization 
{
	public static void main(String[] args) throws Exception 
	{
		//Create object of all utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelDataUtility eUtil = new ExcelDataUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		String BROWSER  = pUtil.readDatafromPropertyFile("browser");
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		String URL      = pUtil.readDatafromPropertyFile("url");
		String ORGANIZATIONNAME = eUtil.readDataFromExcel("Organization",1,2)+jUtil.getRandomNumber();
		System.setProperty("WebDriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();*/
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("inavalid browser name");
		}
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();*/
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginOperation(USERNAME, PASSWORD);
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGANIZATIONNAME);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");
		driver.close();
		
	}

}
