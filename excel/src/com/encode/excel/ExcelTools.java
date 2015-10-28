package com.encode.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.encode.tools.DecodeTool;

public class ExcelTools {
	public static void main(String[] args) throws InvalidFormatException, IOException, GeneralSecurityException  {
		DecodeTool decodeTool = new DecodeTool();
		decodeTool.init(DecodeTool.salt);
		if(args.length <= 1){
			System.out.println("输入文件地址！");
			System.exit(0);
		}else{
			
			Workbook wb = new XSSFWorkbook(new File(args[0]));
			int x = wb.getNumberOfSheets();
			
			Workbook wbc = new XSSFWorkbook(); //or new HSSFWorkbook();
			
			for(int j = 0; j < x; j++){
				Sheet s = wb.getSheetAt(j);
				if(!"SQL".equals(s.getSheetName())){
					Sheet sheet = wbc.createSheet(s.getSheetName());
					
					if(s.getLastRowNum() != 0){
						Row row = sheet.createRow(0);
						for(Iterator<Cell> it = s.getRow(0).cellIterator();it.hasNext();){
							Cell cell = it.next();
							row.createCell(cell.getColumnIndex()).setCellValue(cell.toString());
						}
						for (int i = 1; i <= s.getLastRowNum(); i++) {
							if(s.getRow(i).getCell(0) == null){
								break;
							}
							
							Row rowone = sheet.createRow(i);
							int count = 0;
							for(Iterator<Cell> it = s.getRow(i).cellIterator();it.hasNext();){
								Cell cell = it.next();
								if(Integer.valueOf(args[1]) == count){
									String mobile = decodeTool.decrypt(String.valueOf(cell));
									rowone.createCell(count).setCellValue(mobile);
								}else{
									rowone.createCell(count).setCellValue(String.valueOf(cell));
								}
								count++;
							}
							
							
						}
					}
				}
			}
			
			FileOutputStream fileOut = new FileOutputStream("D:/生日-明文.xlsx");
			wbc.write(fileOut);
			fileOut.close();
			wbc.close();
			wb.close();
		}
	}
}
