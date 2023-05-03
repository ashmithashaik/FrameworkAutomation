package vtiger.OrganizationsTests;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelDataUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
public class CreateMultipleOrgWithIndustryTest 
{
	JavaUtility jUtil = new JavaUtility();
	ExcelDataUtility eUtil = new ExcelDataUtility();
	
	@Test(dataProvider = "multipleOrg")
	public void createMultipleOrgTest(String ORG, String INDUSTRY) throws IOException
	{
		       // Create Object of all Utilities
				PropertyFileUtility pUtil = new PropertyFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				// Read all the required Data
				String BROWSER = pUtil.readDatafromPropertyFile("browser");
				String URL = pUtil.readDatafromPropertyFile("url");
				String USERNAME = pUtil.readDatafromPropertyFile("username");
				String PASSWORD = pUtil.readDatafromPropertyFile("password");
				
			    String ORGNAME= ORG+jUtil.getRandomNumber();
				
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
				
				
				

				// Step 1: launch the browser - RUNTIME POLYMORPHISM
				
				LoginPage LP = new LoginPage(driver);
				LP.LoginOperation(USERNAME, PASSWORD);
				

				// Step 3: Navigate to Organizations LInk
				
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				
				
				//Step 4:click on Create Organization Look Up Image
				
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				//Step-5:Create Organization with Mandatory fields
				
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(ORGNAME, INDUSTRY);

				
				//Step 6:Validate
				
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				if (OrgHeader.contains(ORGNAME))
				{
					System.out.println("=== PASS ===");
				} else 
				{
					System.out.println("=== FAIL ===");
				}
				//Step 7:Logout
				
			
				hp.logOutOfApp(driver);
				System.out.println("Signout successfull");
				driver.close();
	}
	@DataProvider(name = "multipleOrg")
	public Object[][] getData() throws EncryptedDocumentException, IOException 
    {
		return eUtil.readMultipleDataFromExcel("Data");
	}
}
