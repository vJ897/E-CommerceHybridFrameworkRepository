package utils;

import java.util.Date;
import java.util.Random;

public class Utils {
	
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_LOAD_TIME = 5;
	
	public static String generateEmailWithTimeStamp() {	
		Date dateE = new Date();
		String timestampE = dateE.toString().replace(" ","_").replace(":","_");
		return "winteriscoming"+ timestampE +"@gmail.com";
	}
	public static String generatePasswordWithTimeStamp() {	
		Date dateP = new Date();
		String timestampP = dateP.toString().replace(" ","_").replace(":","_");
		return "King@"+ timestampP +"007";
	}
	public static String generateRandomTelephoneNumber(){	
		Random random = new Random();
		StringBuilder teleNumber = new StringBuilder("9");
		// Telephone number will start with 9
		for(int i=1; i<=9; i++) {
			int digit = random.nextInt(10);
		//generate a random digit between 0 and 9	
			teleNumber.append(digit);	
		}
		return teleNumber.toString();
		//.toString() will convert the StringBuilder to a String 
	}
//	public static Object[][] getDataFromExcel(String sheetName) {
//		
//		File excelFile = new File(System.getProperty("user.dir")+"/files/loginIds.xlsx");
//		XSSFWorkbook workbook = null;
//		try{
//		FileInputStream excel = new FileInputStream(excelFile);
//		 workbook = new XSSFWorkbook(excel);
//		}catch (Throwable e) {
//			e.printStackTrace();
//		}
//		
//		XSSFSheet sheet = workbook.getSheet(sheetName);
//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(0).getLastCellNum();
//		
//		Object[][] data = new Object[rows][cols];
//		
//		for(int i=0;i<rows;i++) {
//			XSSFRow row = sheet.getRow(i+1);
//			for(int j=0;j<cols;j++) {
//				XSSFCell cell = row.getCell(j);
//				CellType cellType = cell.getCellType();
//				
//				switch(cellType) {
//				case STRING:
//					data[i][j] = cell.getStringCellValue();
//					break;
//				case NUMERIC:
//					data[i][j]= Integer.toString((int)cell.getNumericCellValue());
//					break;
//				case BOOLEAN:
//					data[i][j] = cell.getBooleanCellValue();
//					break;
//					
//				}
//			}
//		}		
//		return data;		
//	}
}
	
	


