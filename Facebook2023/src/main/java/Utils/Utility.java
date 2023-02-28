package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility { 
	
	public static String getDataFromexcelSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException, IllegalStateException {
		
		String data;
		
		 String path = "C:\\Users\\HP\\Desktop\\excell.xlsx";
	    	
	     InputStream file = new FileInputStream(path);
	     	
	     Workbook book = WorkbookFactory.create(file);
		    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm  ");

	     try 
	     {
	      data = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	     }
	     catch (IllegalStateException e) {
	    	 
	    	 double data1 = book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
	         System.out.println(data1);
	    	 data = Double.toString(data1);
	     }
	     
//      catch (IllegalStateException e) {
//	    	 
//	    	 double data1 = book.getSheet(sheet).getRow(row).getCell(cell)
//	         System.out.println(data1);
//	    	 data = Double.toString(data1);
//	     }
	     
	     return data;
	     
	}
	
	public static String captureScreenShot(WebDriver driver ,String testID) throws IOException {
		
		    LocalDateTime DateObj = LocalDateTime.now();
		    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm  ");
		    String datetime = pattern.format(DateObj);
		    System.out.println( datetime);

      	  TakesScreenshot sc= (TakesScreenshot)driver;  //object 
	
          File takesc=sc.getScreenshotAs(OutputType.FILE);
	
	      File store =new File("C:\\Users\\HP\\Documents\\selenium Sreenshot\\" +(datetime + testID )+".jpg");
	
	      FileHandler.copy(takesc, store);
	
	      return testID;
	
	}
	
 }


	