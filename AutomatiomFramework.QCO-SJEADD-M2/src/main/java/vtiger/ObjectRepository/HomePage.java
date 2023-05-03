package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;
public class HomePage extends WebDriverUtility
{
   @FindBy(xpath="(//a[text()='Organizations'])[1]")
   private WebElement OrganizationsLnk; 
   
   @FindBy(xpath="(//a[text()='Contacts'])[1]")
   private WebElement ContactsLnk;
   
   @FindBy(xpath="(//a[text()='Opportunities'])[1]")
   private WebElement OpportunitiesLnk;
  
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement AdministratorImg;
   
   @FindBy(xpath="//a[text()='Sign Out']")
   private WebElement SignOutLnk;
   
   public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
    
   public WebElement getOpportunities() 
   {
	return OpportunitiesLnk;
   }

public WebElement getAdministratorImg() 
{
	return AdministratorImg;
}

public WebElement getSignOutLink() 
{
	return SignOutLnk;
}

public WebElement getOrganizations()
{
	return OrganizationsLnk;
}

public WebElement getContacts()
{
	return ContactsLnk;
}

//Business Library
/**
 * This method will click on organization link
 */
public void clickOnOrgLink()
{
	OrganizationsLnk.click();
}
/**
 * This method will clik on contact link
 */
public void clickOnContactLink()
{
	ContactsLnk.click();	
}
/**
 * This method will perform sign out operation
 * @param driver
 */
public void logOutOfApp(WebDriver driver)
{
	mouseHoverAction(driver, AdministratorImg );
	SignOutLnk.click();
	
}   
}
