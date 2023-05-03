package vtiger.practice;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Excel_Data 
{
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sh =book.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String cellData = df.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return cellData;
	}

}
