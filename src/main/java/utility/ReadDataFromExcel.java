package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadDataFromExcel {

    public static Map<String, List<String>> getExcelData(String filePath, String SheetName) {

        // String filepath =
        // System.getProperty("user.dir").concat("//src//main//resources//inputData.xlsx");
        Map<String, List<String>> map = new HashMap<>();
        try {

            FileInputStream file = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(file);
            Sheet sheet = wb.getSheet(SheetName);
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                Cell keyValue = row.getCell(0);
                String Keyvalue = keyValue.getStringCellValue();

                List<String> list = new ArrayList<>();
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                list.add(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                list.add(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case BOOLEAN:
                                list.add(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case FORMULA:
                                list.add(cell.getCellFormula());
                                break;
                            case BLANK:
                                list.add("");
                                break;
                            case ERROR:
                                list.add("Error: " + cell.getErrorCellValue());
                                break;

                            default:
                                break;
                        }
                    }
                }

                map.put(Keyvalue, list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
