package vtiger.GenericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of generic method related to Property File
 * @author ashmitha
 */
public class PropertyFileUtility
{
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
