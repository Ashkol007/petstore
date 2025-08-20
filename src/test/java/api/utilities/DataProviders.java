package api.utilities;


import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String path;
	
	@DataProvider(name="Data")
	public String [][] getAllData() throws IOException{
		
			path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
			
			ExcelUtility xlutil = new ExcelUtility(path);
			
			int row = xlutil.getRowCount("Sheet1");
			int cell = xlutil.getCellCount("Sheet1",1);
			
			String [][] xldata = new String [row][cell];
			
			for(int i=1;i<=row;i++) {
				
				for(int c=0;c<cell;c++) {
					
					  xldata[i-1][c] = xlutil.getCellData("Sheet1",i,c);
				}
				
			}
			
			return xldata;
		
	}
	
	
	  @DataProvider(name = "UserNames")
	    public String[] getUserNames() throws IOException {
	        
	        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";

			ExcelUtility xl = new ExcelUtility(path);

	        int rownum = xl.getRowCount("Sheet1");
	        String apidata[] = new String[rownum];

	        for (int i = 1; i <= rownum; i++) {
	            apidata[i - 1] = xl.getCellData("Sheet1", i, 1); 
	            // column 1 → "UserName" (based on your Excel file)
	        }

	        return apidata;
	    }

}
