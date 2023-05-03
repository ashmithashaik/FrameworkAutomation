package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
  @FindBy(xpath="//img[@title='Create Contact...']")
  private WebElement CreateContactLookUpImg;
  
  public ContactPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getCreateContactLookUpImg() 
{
	return CreateContactLookUpImg;
}

//Business library
/**
 * This method will click on create contact Look UP Image
 */
public void clickOnCreateContactLookUpImg()
{
	CreateContactLookUpImg.click();
}
  
}
