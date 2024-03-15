package utills;


import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Properties;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

public class ReadData {


    public static  Properties excelProp;


    public void setNewData(List<String> vals,String name) throws Exception {
        File src = new File(excelProp.getProperty("Excel_File_Location"));
        FileInputStream fi = new FileInputStream(src);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.createSheet(name);
        Row header = sheet.createRow(0);
        Cell hederCell = header.createCell(0);
        hederCell.setCellValue(name);

        for (int i = 0; i <  vals.size(); i++) {
            Row row = sheet.createRow(i+1);
            Cell cell = row.getCell(0, CREATE_NULL_AS_BLANK);
            cell.setCellValue(vals.get(i));

        }
        try {
            FileOutputStream out = new FileOutputStream(src);
            wb.write(out);
            wb.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setData(List<String> vars,String vals,String sheetName,int colnum) throws Exception{

        File src = new File(excelProp.getProperty("Excel_File_Location"));
        FileInputStream fi = new FileInputStream(src);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheet(sheetName);
        sheet.getRow(0).getCell(colnum, CREATE_NULL_AS_BLANK).setCellValue(vals);

        for (int i = 0; i <  vars.size(); i++) {
            sheet.getRow(i+1).getCell(colnum, CREATE_NULL_AS_BLANK).setCellValue(vars.get(i));

        }
        try {
            FileOutputStream out = new FileOutputStream(src);
            wb.write(out);
            wb.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }


    public static void main(String[] args) throws IOException {

        FileInputStream fi = new FileInputStream("C:\\Users\\kamal\\Documents\\Book1.xlsx");
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheetAt(0);
        int i = sheet.getLastRowNum();
        System.out.println(i);
        int j = sheet.getRow(0).getLastCellNum();
        System.out.println(j);


    }


}
