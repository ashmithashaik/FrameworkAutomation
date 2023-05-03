package vtiger.OrganizationsTests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
public class CreateNewOrganizationTest extends BaseClass
{
	@Test(groups = "SmokeSuite")
	public void createNewOrgTest()throws InterruptedException, IOException
	{
		
				String ORGNAME = eUtil.readDataFromExcel("Organization",1,2)+jUtil.getRandomNumber();
				
		       // Step 3: Navigate to Organizations LInk
				
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				
				//Step 4:click on Create Organization Look Up Image
				
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				//Step-5:Create Organization with Mandatory fields
				
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(ORGNAME);
				
				//Step 6:Validate
				
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				
				//Step 7:Logout
				hp.logOutOfApp(driver);
				System.out.println("Signout successfull");
				driver.close();
	}
	@Test(groups = "Regression Suite")
	public void demoOrg()
	{
		System.out.println("This is demo");
	}

}
