package dtaDrvn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

//import javax.imageio.stream.FileImageOutputStream;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppachPoi {

	public void appachPoi() throws IOException{

		FileInputStream excell=new FileInputStream("/home/mac/Downloads/appachpoi.xlsx");
		Workbook workbook=new XSSFWorkbook(excell);
		org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheetAt(0);
             
		Iterator<Row> rowIterator= sheet.iterator();


		while(rowIterator.hasNext()) {
			Row rowvalue=	rowIterator.next();
			Iterator<Cell> columnIterator= rowvalue.iterator();

			while(columnIterator.hasNext()) {
				Cell cellValue= columnIterator.next();
				System.out.println(cellValue);
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		AppachPoi usingPoi=new AppachPoi();
		usingPoi.appachPoi();

	}

}
