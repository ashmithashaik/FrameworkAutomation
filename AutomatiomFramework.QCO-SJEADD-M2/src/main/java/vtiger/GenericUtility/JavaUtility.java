package vtiger.GenericUtility;
import java.util.Date;
import java.util.Random;
/**
 * This class consists of generic methods are related java
 * @author ashmitha
 */

public class JavaUtility 
{
	/**
	 * @author ashmitha
	 * This method will generate Random number for every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
        int num = r.nextInt(1000);
        return num;
	}
	/**
	 * this method will generate system date
	 * @author ashmitha
	 * @return 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	/**
	 * This method will generate system date in specific format
	 * @return
	 */
	public String getSystemDateinFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String date = day+"-"+month+"-"+year+" "+time;
		return date;
	}

}
