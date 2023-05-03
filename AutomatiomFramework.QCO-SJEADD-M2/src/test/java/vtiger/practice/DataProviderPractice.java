package vtiger.practice;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class DataProviderPractice
{
	@Test(dataProvider = "getData")
	public void sampleTest(String brandname,int price,int size)
	{
		System.out.println(brandname+" -- "+price+" -- "+size);
	}
	
   @DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[5][3];
		
		data[0][0] = "AvasaSets";
		data[0][1] = 1869;
		data[0][2] = 44;
		data[1][0] = "SIYHAS";
		data[1][1] = 3569;
		data[1][2] = 42;
		data[2][0] = "MIX N MATCH";
		data[2][1] = 2459;
		data[2][2] = 40;
		data[3][0] = "FUELLE";
		data[3][1] = 4568;
		data[3][2] = 38;
		data[4][0] = "BULE TREND";
		data[4][1] = 5000;
		data[4][2] = 36;
		return data;
	}

}
