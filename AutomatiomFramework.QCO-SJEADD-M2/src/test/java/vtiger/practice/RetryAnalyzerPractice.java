package vtiger.practice;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RetryAnalyzerPractice 
{
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementationClass.class)
	public void AnalyzerPractice()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
