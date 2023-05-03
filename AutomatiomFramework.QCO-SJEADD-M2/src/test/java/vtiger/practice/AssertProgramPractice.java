package vtiger.practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertProgramPractice 
{
	@Test
   public void assertPractice()
   {
	   SoftAssert sa = new SoftAssert();
	   
	   System.out.println("step-1");
	   System.out.println("step-2");
	   sa.assertEquals(1, 0);
	   System.out.println("step-3");
	   sa.assertTrue(false);
	   System.out.println("step-4");
	   sa.assertAll();//log all the assertion failures
   }
	@Test
	public void practice()
	{
		System.out.println("Second script step-1");
		System.out.println("Second script step-2");
	}
}
