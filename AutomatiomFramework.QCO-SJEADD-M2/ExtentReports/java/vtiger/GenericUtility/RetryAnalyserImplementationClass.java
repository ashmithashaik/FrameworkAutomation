package vtiger.GenericUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is an implementation class for IRetryAnalyzer Interface of TestNG
 * @author ashmitha
 *
 */
public class RetryAnalyserImplementationClass implements IRetryAnalyzer
{
    int count=0;
    int retryCount =3;
	public boolean retry(ITestResult result) 
	{
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
