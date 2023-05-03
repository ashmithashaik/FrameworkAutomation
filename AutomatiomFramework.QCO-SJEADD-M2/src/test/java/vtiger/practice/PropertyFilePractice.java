package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice 
{

	public static void main(String[] args) throws IOException  
	{
		//Step 1: Load the file into FileinputStream to make it java readable
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
       
        //Step 2:create object of properties class from java.util
        Properties pObj = new Properties();
        
        //Step 3:Load the file input stream into properties
        pObj.load(fis);
        
        //Step 4:fetch data using key
        String BROWSER = pObj.getProperty("browser");
        System.out.println(BROWSER);
	}

}
