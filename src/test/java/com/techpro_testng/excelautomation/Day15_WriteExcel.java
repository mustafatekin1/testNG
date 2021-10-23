package com.techpro_testng.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day15_WriteExcel {

    @Test
    public void writeExcel () throws IOException {
/*
Create a new class: WriteExcel
Create a new method: writeExcel()
Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Go to the first row
Create a cell on the 2nd index on the first row==> a new title in the 3rd column
Write “POPULATION” on that cell
Create a cell on the 2nd row 4th cell(index3), and write 150000
Create a cell on the 3rd row 4th cell(index3), and write 250000
Create a cell on the 4th row 4th cell(index3), and write 54000
Write and save the workbook
Close the file
Close the workbook
*/
//        Store the path of the file as string and open the file
        String path = "src/test/java/resources/Capitals.xlsx";
//        Open the workbook (Do not forget that it is 2 line)
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);
//        Go to the first row
        Row firstRow = sheet.getRow(0);
//        Create a cell on the 2nd index on the first row
        Cell row0C2 = sheet.getRow(0).createCell(2);
//        Write “POPULATION” on that cell
        row0C2.setCellValue("Population");
        System.out.println(row0C2);
//        Create a cell on the 2nd row 3rd cell(index3), and write 150000
        Cell row1Cell2 = sheet.getRow(1).createCell(2);
        row1Cell2.setCellValue("150000");

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
       // Cell row2Cell2 = sheet.getRow(2).createCell(2); We can create it shorter with one line:
        sheet.getRow(2).createCell(2).setCellValue("250000");
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        Cell row3Cell2 = sheet.getRow(3).createCell(2);
        row3Cell2.setCellValue(54000);// we can assign the value as integer also without ""
//        Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);// write(..) both writes and saves.
//        Close the file
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
//        Close the workbook

    }


}
