package vtiger.practice;
import java.io.IOException;

import vtiger.GenericUtility.ExcelDataUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
public class GenericUtilityPractice 
{
    public static void main(String[] args) throws IOException 
	{
		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateinFormat());
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value1 = pUtil.readDatafromPropertyFile("url");
		System.out.println(value1);
		
		ExcelDataUtility eUtil = new ExcelDataUtility();
		String value2 = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(value2);

	}

}
