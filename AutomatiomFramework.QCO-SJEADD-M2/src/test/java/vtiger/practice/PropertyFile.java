package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public String getDataFromProperties(String data) throws IOException
	{
		
		    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	        //Step 2:create object of properties class from java.util
	        Properties pObj = new Properties();
	        //Step 3:Load the file input stream into properties
	        pObj.load(fis);
	        String datas =  pObj.getProperty(data);
	        return datas;
	        
	}

}
