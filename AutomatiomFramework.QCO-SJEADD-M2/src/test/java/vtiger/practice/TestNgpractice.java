package vtiger.practice;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNgpractice 
{
@Test
public void createUser()
{
	Assert.fail();
	System.out.println("created User");
}
	@Test(dependsOnMethods = "createUser")
	public void modifyUser()
{
	System.out.println("modified User");	
}
	@Test
	public void deleteUser()
	{
		System.out.println("deleted User");
	}
}
