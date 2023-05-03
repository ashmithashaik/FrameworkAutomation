package vtiger.practice;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadDataFromExcel 
{
    public static void main(String[] args) throws IOException  
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("Organization");
		Row r = sh.getRow(7);
		Cell ce = r.getCell(2);
		String value = ce.getStringCellValue();
		System.out.println(value);
		wb.close();

	}
}
