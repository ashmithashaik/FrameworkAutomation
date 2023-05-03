package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vtiger.GenericUtility.WebDriverUtility;
public class CreateNewOrganizationPage extends WebDriverUtility
{
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() 
	{
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() 
	{
		return IndustryDropDown;
	}

	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will create a new Org with mandatory fields N save
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * This method will create a new Org with industry fields N save
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrg(String ORGNAME,String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDown,INDUSTRY);
		SaveBtn.click();
	}	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

