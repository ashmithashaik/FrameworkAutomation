package vtiger.ContactsTests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
//@Listeners(vtiger.GenericUtility.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass
{
	//public static void main(String[] args) throws InterruptedException, IOException
	@Test
	public void contactWithOrgTest() throws IOException
	{
			
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
				String ORGNAME = eUtil.readDataFromExcel("Contacts",4,3)+jUtil.getRandomNumber();
		
				//step 3:Navigate to Organization link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				
				//step 4:click on Create Organization Look Up Image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				
				// Step 5: Create Organization with Mandatory fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(ORGNAME);
			    //Assert.fail();
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				
				//Step 8:Create Contact Using Same Organization Name
				     hp.clickOnContactLink();
				     
				//Step 9: Navigate create contact look up Image
				     ContactPage cp = new ContactPage(driver);
						cp.clickOnCreateContactLookUpImg();
						
				//Step 10:Create Contact
						CreateNewContactPage cncp = new CreateNewContactPage(driver);
						cncp.createNewContactPage(driver, LASTNAME, ORGNAME);
						//wUtil.takeScreenShot(driver, "Contact1");	
						
				
				//Step 17:Validate Contact 
						ContactInfoPage cip = new ContactInfoPage(driver);
						String ContactHeader = cip.getContactText();
						Assert.assertTrue(ContactHeader.contains(LASTNAME));
						
				//Step 18 logout
				
			    hp.logOutOfApp(driver);
				System.out.println("Signout successfull");
				driver.close();
	}

}
