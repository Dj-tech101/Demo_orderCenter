package XlutilityPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class DataProviderName {

	String path;

	public DataProviderName(String path) {

		this.path = path;

		// TODO Auto-generated constructor stub
	}

	public String[][] getdataProvider(String path) throws EncryptedDocumentException, IOException {

xlutility xl= new xlutility(path);
		
		
		int row=xl.getrow();
		int col=xl.getcoloumn();
		
		
		String [][]data= new String[row][col];
		
				
				
				for (int i = 1; i <=row ; i++) {
			
					
					for (int j = 0; j < col; j++) {
						
						data[i-1][j]=xl.getcellValue(i, j)
;
						}
		}
				return data;
	}
		// String data[][]= new String[][];

	
}
