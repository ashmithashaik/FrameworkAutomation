package vtiger.GenericUtility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * This class consists of all Basic Configuration Annotations
 * @author ashmitha
 *
 */

public class BaseClass 
{
   public JavaUtility jUtil = new JavaUtility();
   public ExcelDataUtility eUtil = new ExcelDataUtility();
   public WebDriverUtility wUtil = new WebDriverUtility();
   public PropertyFileUtility pUtil = new PropertyFileUtility();
   public WebDriver driver = null;
   public static WebDriver sDriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println(" --- Database Connection Successful ---");
	}
	
	@BeforeClass(groups = {"SmokeSuite","Regression Suite"})
	public void bcConfig() throws IOException 
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		System.setProperty("WebDriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
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
		sDriver=driver;//take Screenshot
		wUtil.maximiseWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = {"SmokeSuite","Regression Suite"})
	public void bmConfig() throws IOException 
	{
	    String USERNAME = pUtil.readDatafromPropertyFile("username");
	    String PASSWORD = pUtil.readDatafromPropertyFile("password");
	    
	    LoginPage lp = new LoginPage(driver);
	    lp.LoginOperation(USERNAME, PASSWORD);
	    System.out.println(" --- Login is Successful ---");
	}
	
	@AfterMethod(groups = {"SmokeSuite","Regression Suite"})
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		Thread.sleep(4000);
		hp.logOutOfApp(driver);
		System.out.println(" --- Logout is Successful ---");
		
	}
	
	@AfterClass(groups = {"SmokeSuite","Regression Suite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println(" --- browser closed Successfully ---");
	}
	
	@AfterSuite(groups ={"SmokeSuite","Regression Suite"})
	public void asConfig()
	{
		System.out.println(" --- Database closed Successfully ---");
	}
}
