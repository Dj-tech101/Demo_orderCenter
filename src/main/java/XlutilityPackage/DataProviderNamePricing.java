package XlutilityPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class DataProviderNamePricing {

	String path;

	public DataProviderNamePricing(String path) {

		this.path = path;

		// TODO Auto-generated constructor stub
	}

	public String[][] getdataProvider(String path,int a) throws EncryptedDocumentException, IOException {

xlutility xl= new xlutility(path);
		
		
		int row=xl.getrow();
		int col=xl.getcoloumn();
		
		System.out.println("row "+row);
		System.out.println("coloum"+col);
		
		String [][]data= new String[row][col];
				
				for (int i = a; i <=row ; i++) {
			
					
					for (int j = 0; j < col; j++) {
						
						data[i-1][j]=xl.getcellValue(i, j)
;
						}
		}
				return data;
	}
		// String data[][]= new String[][];

	
}
