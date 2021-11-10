package com.techproed.excelautomation;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day14_ReadExcel {

      /*
* Import the apache poi dependency in your pom file
Create resources directory under java folder(right click on java and create the folder)
Add the excel file on the resources folder
Create a new package: excelautomation
Create a new class : ReadExcel
Create a new test method : readExcel()
Store the path of the  file in a string
Open the file
Open the workbook using fileinputstream
Open the first worksheet
Go to first row
Go to first cell on that first row and print
Go to second cell on that first row and print
Go to 2nd row first cell
Go to 3rd row 2nd cell-chain the row and cell
Find the number of row
Find the number of used row
Print country, capitol key value pairs as map object*/

    @Test
    public void readExcel() throws IOException {
//      Store the path of the  file in a string
        String path = "src/test/java/resources/Capitals.xlsx";// ./src/test/java/resources/Capital.xlsx does not work!!!
        // Important: right click on the excel>>Copy path/reference>>path from repository root

//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0); // Index starts from 0 unlike xpaths
//        Go to first row
        Row firstRow = sheet.getRow(0);
//        Go to first cell on that first row and print
        Cell firstCell = sheet.getRow(0).getCell(0); //1st cell in the 1st row in the first sheet (specified above)
        //or
        Cell firstCell2 = firstRow.getCell(0);
        System.out.println(firstCell);

//        Go to second cell on that first row and print
        System.out.println(firstRow.getCell(1));
//        Go to 2nd row first cell
        Cell row2Cell1 = sheet.getRow(1).getCell(0);
        System.out.println(row2Cell1);

//        Go to 3rd row 2nd cell-chain the row and cell
        Cell row3cell2 = sheet.getRow(2).getCell(1);
        System.out.println(row3cell2);
// since "cell" is a Cell object; when we assert, the test fails. We have to convert the cell to String.
        //Assert.assertEquals(row3cell2, "Paris"); // fails becasue of the reason above!!!
        // That's why we have to compare same data types and we can do this by changing with cell.toString()
        Assert.assertEquals(row3cell2.toString(), "Paris-R2C1");
//        Find the number of row
        int numberOfRows = sheet.getLastRowNum() + 1; // since index starts from 0
        System.out.println(numberOfRows);
//        Find the number of used row
        int numberOfUsedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfUsedRows);

//        Print country, capital key value pairs as map object
        Map<String, String> worldCapitals = new HashMap();
        //getRow(1).getCell(0) gives country-- getRow(1).getCell(1) gives capital. And rows increase
        // we exclude  titles so we start from index 1

        /*
         * Starting row number : 1- cause row is Header
         * Ending Row Number  : lastRowNumber - sheet.getLastRowNum()+1;
         *
         * USA sheet.getRow(1).getCell(0)
         * France sheet.getRow(2).getCell(0)
         * England sheet.getRow(3).getCell(0)
         *
         * D.C - sheet.getRow(1).getCell(1)
         * Paris- sheet.getRow(2).getCell(1)
         * London- sheet.getRow(3).getCell(1)
         *
         * sheet.getRow(rowNumber).getCell(columnNumber)
         * */

        for (int rowNumber = 1; rowNumber < sheet.getLastRowNum() + 1; rowNumber++) {
            String countries = sheet.getRow(rowNumber).getCell(0).toString();
            String capitals = sheet.getRow(rowNumber).getCell(0).toString();
            System.out.println("COUNTRIES : " + countries);
            System.out.println("CAPITALS : " + capitals);
            worldCapitals.put(countries, capitals);//adding the countries and capitals in the map
//            if (countries.equals("Norway")){
//                break;
//            }
        }
        System.out.println(worldCapitals);
    }

    @Test
    public void utils(){
// Lets use some ExcelUtil methods
// So we do not have to write all the codes in the previous class.
// Those codes are already written in our ExcelUtil class.
    ExcelUtil excelUtil = new ExcelUtil("src/test/java/resources/Capitals.xlsx", "capitals_sheet");
                        // we should add the parameters path and sheetName

    System.out.println("Column count = "+excelUtil.columnCount());
    System.out.println(excelUtil.getDataList());// prints all in key=value

    // get row number
        System.out.println(excelUtil.rowCount());

   // get data from row 9 column 2 -- Berlin
        System.out.println(excelUtil.getCellData(8,1));
    }



}
