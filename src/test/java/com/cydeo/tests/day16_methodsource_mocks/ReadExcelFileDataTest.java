package com.cydeo.tests.day16_methodsource_mocks;

import com.cydeo.utils.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ReadExcelFileDataTest {

    @Test
    public void readBookItUsersTest() {
        String filePath = "src/test/resources/BookItQa3.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(filePath,"QA3");
        System.out.println("columns = " + excelUtil.getColumnsNames());

        int rowsCount = excelUtil.rowCount();
        System.out.println("rowsCount = " + rowsCount);

        System.out.println(excelUtil.getCellData(1,1));
        
        List<Map<String,String>> data = excelUtil.getDataList();
        System.out.println("data = " + data);
    }

}
