package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow xr;
	public XSSFCell xc;
	public String path;
	public FileInputStream fi;
	public FileOutputStream fo;
	
	public ExcelUtility(String path){
	    this.path = path;
	}
	
	
	public int getRowCount(String sheetname) throws IOException {
	     
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	
	public int getCellCount(String sheetname,int rownum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		int colcount = ws.getRow(rownum).getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
		
	}
	
	
	public String getCellData(String sheetname,int rownum,int cellnum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		xr= ws.getRow(rownum);
		xc = xr.getCell(cellnum);
		
		DataFormatter formatter = new DataFormatter();
	    String xd = formatter.formatCellValue(xc);
		
	    wb.close();
		fi.close();
		
		return xd;
	}
	
	
	
	
	
	

}
