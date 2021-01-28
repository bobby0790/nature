package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Xlsreader extends Library
{
	@DataProvider
	public Object[][] getData() throws Exception
	{
		try 
		{
			//Get the full path of the package of the current class
			String sPacakgePath = this.getClass().getPackage().getName();

			//Get only package name by splitting it with dot symbol
			String sPackageName = sPacakgePath.substring(sPacakgePath.lastIndexOf(".")+1);
			
			String sTestDataFileName = testDataPath+sPackageName+".xlsx";
			String sTestDataSheetName = this.getClass().getSimpleName();
			return getTestData(sTestDataFileName, sTestDataSheetName, "Y");
		}
		catch (Exception e) 
		{
			System.out.println("unable to get data" +e);
		}
		return null;

	}
	
	
	// Check if the Tc/suite is runnable
	public boolean IsTCRunnable(String fileName, String sheetName,String Name) throws Exception 
	{
		boolean IsExecutable=false;
		int iRowCount=getRowCount(fileName, sheetName);
		//System.out.println(iRowCount);
		for(int i=0;i<=iRowCount;i++)
		{
			String TcName=getCellData(fileName,sheetName, i,1);
			String TcRunFlag=getCellData(fileName,sheetName, i,2);
//			System.out.println(i);
//			System.out.println(TcName);
//			System.out.println(TcRunFlag);
			if(TcName.equalsIgnoreCase(Name))
			{
				if(TcRunFlag.equalsIgnoreCase("Y"))
				{
					IsExecutable=true;
				}
			}
		}
		return IsExecutable;		
	}



	// Get data from the XLS file 
	public Object[][] getTestData(String fileName, String sheetName,String runFlag) throws Exception 
	{

		Object data[][] = null;
		String sID = null;
		String sRunFlag = null;

		int rowCount = getRowCount(fileName, sheetName);
		if (rowCount <= 0)
			return data;
		// System.out.println("row count"+rowCount);

		int columnCount = getColumnCount(fileName, sheetName);
		if (columnCount <= 0)
			return data;
		// System.out.println("col count= "+columnCount);

		data = new Object[0][0];
		int x = -1;
		int y;
		int z = 0;
		for (int i = 1; i <= rowCount - 1; i++) 
		{
			sID = getCellData(fileName, sheetName, i, 0);
			sRunFlag = getCellData(fileName, sheetName, i, 1);

			//System.out.println("cell value of----------- ["+i+"]= "+sID+sRunFlag);
			if (sID.equalsIgnoreCase("")
					|| sRunFlag.equalsIgnoreCase(""))

			{
				return data;
			}

			if (sRunFlag.equalsIgnoreCase(runFlag))

			{
				y = 0;
				x++;
				z++;
				data = (Object[][]) resizeArray(data, z);// resizing the array

				for (int k = 0; k < data.length; k++) 
				{
					if (data[k] == null)
						data[k] = new Object[columnCount-1]; // set this value
					// according to the
					// no of columns in
					// the excel sheet
					else
						data[k] = (Object[]) resizeArray(data[k], columnCount-1);
				}

				for (int j = 0; j <= columnCount - 1; j++) 
				{
					if(j!=1) 
					{
						data[x][y] = getCellData(fileName, sheetName, i, j);
						//System.out.println("cell value of xy== [" + x + "," + y	+ "]= " + data[x][y]);
						y++;
					}
				}
			}

			//System.out.println();
		}

		return data;
	}



	// ResizeArray
	public Object resizeArray(Object oldArray, int newSize) 
	{
		int oldSize = java.lang.reflect.Array.getLength(oldArray);
		Class elementType = oldArray.getClass().getComponentType();
		Object newArray = java.lang.reflect.Array.newInstance(elementType,newSize);
		int preserveLength = Math.min(oldSize, newSize);
		if (preserveLength > 0)
			System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
		return newArray;

	}

	// This method is to get the sheet

	public XSSFSheet getSheet(String fileName, String sheetName)throws Exception 
	{
		try
		{
			// Load workbook
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));

			// Load sheet- Here we are loading sheet only
			XSSFSheet sheet = workbook.getSheet(sheetName);
			workbook.close();
			return sheet;

		} catch (Exception e)
		{

			throw (e);

		}

	}

	// This method is to add the sheet
	public boolean addSheet(String fileName, String sheetName)throws Exception 
	{
		boolean status=false;
		if (!IsSheetExist(fileName, sheetName)) 
		{
			try
			{
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
				workbook.createSheet(sheetName);	
				FileOutputStream fileOut = new FileOutputStream(fileName);
				workbook.write(fileOut);
				fileOut.flush();
				fileOut.close();
				return true;

			}
			catch (Exception e) 
			{
				return status;
			}
		}
		System.out.println(sheetName+" Sheet is already exist in the file "+fileName);
		return status;  

	}

	// This method is to delete the sheet
	public boolean deleteSheet(String fileName, String sheetName)throws Exception 
	{
		boolean status=false;
		if (IsSheetExist(fileName, sheetName)) 
		{
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));

				int index = workbook.getSheetIndex(sheetName);
				if(index==-1)
					return false;

				workbook.removeSheetAt(index);	
				FileOutputStream fileOut = new FileOutputStream(fileName);
				workbook.write(fileOut);
				fileOut.flush();
				fileOut.close();
				System.out.println(sheetName+" Sheet is deleted from the file "+fileName);
				return true;

			}
			catch (Exception e) 
			{
				return status;
			}
		}
		return status; 
	}	

	// This method is to get row count the sheet
	public int getRowCount(String fileName, String sheetName) throws Exception 
	{
		try 
		{
			XSSFWorkbook WorkBook = new XSSFWorkbook(new FileInputStream(fileName));

			int index = WorkBook.getSheetIndex(sheetName);
			if(index==-1)
				return -1;

			XSSFSheet sheet = WorkBook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;

		}
		catch (Exception e) 
		{
			return -2;
		}

	}	

	public int getColumnCount(String fileName, String sheetName)
			throws FileNotFoundException, IOException, Exception 
	{

		if (IsSheetExist(fileName, sheetName)) 
		{
			try 
			{
				XSSFSheet sheet = getSheet(fileName, sheetName);
				XSSFRow row = sheet.getRow(0);
				if (row == null) {
					return -1;
				}
				else
				{
					int columnCount = row.getLastCellNum();
					return columnCount;
				}
			} 
			catch (NullPointerException e) 
			{

				return -2;
			}
		}
		return -3;

	}

	public boolean IsFileExist(String fileName) 
	{
		boolean bool = false;

		try
		{
			// create new file object
			File f = new File(fileName);
			// tests if file exists
			bool = f.exists();
			return bool;
		}
		catch (Exception e) 
		{
			return bool;
		}

	}
	
	
	public void createWorkBook(String fileName, String sheetName) throws IOException 
	{

		XSSFWorkbook WorkBook = new XSSFWorkbook();
		WorkBook.createSheet(sheetName);
		FileOutputStream fileOut = new FileOutputStream(fileName);
		WorkBook.write(fileOut);
		fileOut.close();

	}

	// find whether sheets exists
	public boolean IsSheetExist(String fileName, String sheetName)
			throws FileNotFoundException, IOException 
	{

		if (IsFileExist(fileName)) 
		{
			// Load workbook
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
			// Load sheet- Here we are loading first sheetonly
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				index = workbook.getSheetIndex(sheetName.toUpperCase());
				if (index == -2) {
					workbook.close();
					return false;
				} else {
					workbook.close();
					return true;
				}
			} else {
				workbook.close();
				return true;
			}
		}
		return false;
	}

	// returns the data from a cell
	public String getCellData(String fileName, String sheetName, int row, int column) throws Exception 
	{
		Object result = null;
		int rowCount = getRowCount(fileName, sheetName);
		if (rowCount <= 0)
			return "";

		int columnCount = getColumnCount(fileName, sheetName);		
		if (columnCount <= 0)
			return "";


		try
		{
			XSSFSheet sheet = getSheet(fileName, sheetName);
			Cell cell = sheet.getRow(row).getCell(column);

			int cell_Type = cell.getCellType();

			switch (cell_Type) 
			{
			case 0:
				// result=cell.getNumericCellValue();
				result = ((int) (cell.getNumericCellValue()));
				break;

			case 1:
				result = cell.getStringCellValue();
				break;

			case 3:
				result = "";
				break;

			case 4:
				result = String.valueOf(cell.getBooleanCellValue());
				break;
			}
		}
		catch (NullPointerException e) 
		{
			result = "";
			return result.toString();
		}
		return result.toString();

	}

	// Set the data to a cell
	public boolean setCellData(String fileName, String sheetName, int row, int column, String value) throws Exception 
	{
		if (IsSheetExist(fileName, sheetName)) 
		{
			try 
			{
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
				XSSFSheet sheet = workbook.getSheet(sheetName);
				XSSFRow Row = sheet.createRow(row - 1);
				XSSFCell Cell = Row.createCell(column - 1);
				Cell.setCellValue(value);
				FileOutputStream fileOut = new FileOutputStream(fileName);
				workbook.write(fileOut);
				fileOut.close();
				return true;
			}
			catch (Exception e) 
			{
				return false;
			}
		}
		return false;
	}

	public boolean addColumn(String fileName,String sheetName, String colName) {
		// System.out.println("**************addColumn*********************");

		try {
			XSSFWorkbook WorkBook = new XSSFWorkbook(new FileInputStream(fileName));

			int index = WorkBook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = WorkBook.createCellStyle();
			// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			XSSFSheet sheet = WorkBook.getSheetAt(index);

			XSSFRow row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);

			XSSFCell cell;
			// cell = row.getCell();
			// if (cell == null)
			// System.out.println(row.getLastCellNum());
			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());

			cell.setCellValue(colName);
			cell.setCellStyle(style);

			FileOutputStream fileOut = new FileOutputStream(fileName);
			WorkBook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	
	public boolean setcellData(String fileName, String sheetName, String colName, int rowNum, String data) 
	{
		try 
		{
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			XSSFSheet sheet = workbook.getSheetAt(index);

			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			Cell cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			cell.setCellValue(data);

			FileOutputStream fileOut = new FileOutputStream(fileName);

			workbook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
