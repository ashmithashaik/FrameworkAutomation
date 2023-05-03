package vtiger.practice;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
public class CreateMultipleOrgwithMultipleIndustryWithBaseClass extends BaseClass
{
	@Test(dataProvider = "multipleOrg")
	
		public void createMultipleOrgTest(String ORGNAME, String INDUSTRY) 
	{	
	            //Step 1:click on Create Organization Look Up Image
				
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				//Step-2:Create Organization with Mandatory fields
				
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(ORGNAME, INDUSTRY);

				
				//Step 3:Validate
				
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				if (OrgHeader.contains(ORGNAME))
				{
					System.out.println("=== PASS ===");
				} else 
				{
					System.out.println("=== FAIL ===");
				}
				
	}
	
	@DataProvider(name = "multipleOrg")
	public Object[][] getData() throws EncryptedDocumentException, IOException 
    {
		return eUtil.readMultipleDataFromExcel("Data");
	}
}
