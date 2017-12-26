package com.dyi.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class ExcelUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    public static void main(String[] args)throws IOException{
        FileInputStream in =null;
        OutputStream os = null;
        String fileName = "C:\\Users\\WYB\\Desktop\\石静测试.xls";
        String targetFileName = "C:\\Users\\WYB\\Desktop\\石静测试结果.xls";
        try {

            File file = new File(fileName);
            in = new FileInputStream(file);
            HSSFWorkbook book = new HSSFWorkbook(in);
            HSSFSheet sheet = book.getSheet("Sheet1");
            sheet.setColumnWidth(0, 25*250);
            sheet.setColumnWidth(1, 25*250);
            sheet.setColumnWidth(2, 25*250);
            sheet.setColumnWidth(3, 25*250);
            sheet.setColumnWidth(4, 25*250);
            sheet.getRow(0).getPhysicalNumberOfCells();
            //保存文

            os = new FileOutputStream(targetFileName);
            book.write(os);
            os.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            if(os!=null){
                os.close();
            }
            if(in!=null){
                in.close();
            }
        }


    }
}