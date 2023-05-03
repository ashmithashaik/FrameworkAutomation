package vtiger.GenericUtility;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
/**
 * This class contains all the generic methods related to Web driver actions
 * @author ashmitha
 *
 */

public class WebDriverUtility
{
	/**
	 * This method will maximize the Window
	 * @param driver
	 */
public void maximiseWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method will minimize window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method will wait for 10 seconds for the page to get loaded
 * @param driver
 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait for an element to become clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will wait for an element to become visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will handle dropdown with the help of index
 * @param element
 * @param index
 */
public void handleDropdown(WebElement element,int index)
{
	Select s = new Select(element);
	s.selectByIndex(index);
}
/**
 * This method will handle dropdown with the help of value
 * @param element
 * @param value
 */
public void handleDropdown(WebElement element,String value)
{
  Select s = new Select(element);
  s.selectByValue(value);
}
/**
 * This method will handle drop down with help of visible text
 * @param text
 * @param element
 */
public void handleDropdown(String text,WebElement element)
{
	Select s = new Select(element);
	s.selectByVisibleText(text);
}
/**
 * This method will perform mouse hover action on a web element
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method will perform right click anywhere on the web page
 * @param driver
 */
public void rightClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
}
/**
 * This method will perform right click on a web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will perform double click anywhere on the web page
 * @param driver
 */
public void doubleClikAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}
/**
 * This method will perform double click on a web element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This method will perform drag and drop operation
 * @param driver
 * @param srcEle
 * @param dstEle
 */
public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(srcEle, dstEle).perform();
	
}
/**
 * This method will press and release the enter key
 * @throws AWTException
 */
public void pressEnter() throws AWTException
{
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method will handle frame based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will handle based on name or ID
 * @param driver
 * @param nameOrId
 */
public void switchToFrame(WebDriver driver,String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * This method will handle frame based on web element
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method switch the control to immediate parent 
 * @param driver
 */
public void switchToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * This method switch the control to default frame
 * @param driver
 */
public void switchToDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method will accept the alert pop up
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will dismiss the alert pop up
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will get the alert text
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * This method  will take screenshot and return the path of destination
 * @param driver
 * @param ScreenShotName
 * @return
 * @throws IOException 
 */
public String takeScreenShot(WebDriver driver,String ScreenShotName) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\ScreenShots\\"+ScreenShotName+".png");
	Files.copy(src, dst);
	
	return dst.getAbsolutePath();//used in extent reports
	//D:\selenium batch\AutomatiomFramework.QCO-SJEADD-M1\ScreenShots/Name.png
}
/**
 * This method will perform random scroll action
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)", " ");
}
public void switchToWindow(WebDriver driver,String paritalWinTitle)
{
	//Step 1:Capture all the window IDs
	Set<String> allWinIDs = driver.getWindowHandles();
	
	//Step 2:Navigate to each window ID
	for(String winID:allWinIDs)
	{
		//Step 3:switch to each window and capture the title
		String actTitle = driver.switchTo().window(winID).getTitle();
		
		//Step 4:compare the title with required title
		if(actTitle.contains(paritalWinTitle))
		{
			break;
		}
	}
	
}
}
