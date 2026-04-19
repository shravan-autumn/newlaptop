package datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDrivenMain {

	@DataProvider(name = "data")
	public Object[][] data() throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\OrCon\\OneDrive\\ドキュメント\\datadriven.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("test2");

		int totalRows = sheet.getPhysicalNumberOfRows(); // includes header
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[totalRows - 1][totalCols];

		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i < totalRows; i++) { // skip header

			for (int j = 0; j < totalCols; j++) {
				data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		book.close();
		fis.close();
		return data;
	}

	@Test(dataProvider = "data")
	public void test(String greeting, String communication, String id) {
		System.out.println(greeting);
		System.out.println(communication);
		System.out.println(id);
	}
}
