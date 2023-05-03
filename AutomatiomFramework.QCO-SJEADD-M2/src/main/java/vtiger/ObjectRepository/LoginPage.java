package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   @FindBy(xpath="//input[@name='user_name']")
   private WebElement UserName;
   
   @FindBy(xpath="//input[@name='user_password']")
   private WebElement Password;
   
   @FindBy(xpath="//input[@id='submitButton']")
   private WebElement LoginBtn;
   
   public  LoginPage(WebDriver driver)
   {
	 PageFactory.initElements(driver, this);
   }

public WebElement getUserName()
{
	return UserName;
}

public WebElement getPassword() 
{
	return Password;
}

public WebElement getLoginBtn() 
{
	return LoginBtn;
}

//Business Library
/**
 * This method is used to login operation
 * @param UserName
 * @param Password
 */
public void LoginOperation(String UserName,String Password)
{
	getUserName().sendKeys(UserName);
	getPassword().sendKeys(Password);
	getLoginBtn().click();
}
   
}
