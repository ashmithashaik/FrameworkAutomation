package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

    public OrganizationPage(WebDriver driver)
    {
	     PageFactory.initElements(driver, this);
    }

	public WebElement getCreateOrgLookUpImg() 
	{
		return CreateOrgLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create organization look up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
    
    
}

