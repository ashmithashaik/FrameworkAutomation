package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
  @FindBy(name = "lastname")
  private WebElement LastNameEdt;
  
  @FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
  private WebElement SaveBtn;
  
  @FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
  private WebElement OrgLookUpImg;
  
  @FindBy(name = "search_text")
  private WebElement OrgSearchEdt;
  
  @FindBy(xpath="//input[@name='search']")
  private WebElement OrgSearchBtn;
  
  public CreateNewContactPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getLastNameEdt() 
{
	return LastNameEdt;
}

public WebElement getSaveBtn() 
{
	return SaveBtn;
}

public WebElement getOrgSearchEdt()
{
	return OrgSearchEdt;
}

public WebElement getOrgSearchBtn()
{
	return OrgSearchBtn;
}

//Business library 
public void createNewContact(String LASTNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
}
public void createNewContactPage(WebDriver driver,String LASTNAME,String ORGNAME)
{
	LastNameEdt.sendKeys(LASTNAME);
	OrgLookUpImg.click();
	switchToWindow(driver,"Accounts");
	OrgSearchEdt.sendKeys(ORGNAME);
	OrgSearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	switchToWindow(driver,"Contacts");
	SaveBtn.click();
	
} 
}
