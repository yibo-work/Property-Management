package com.utils;


import com.pojo.Data;
import com.pojo.Prop;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Excel 导出工具
 *
 * @author Clrvn
 */
public class XSSFWriteExtUtil {

    private XSSFWriteExtUtil() {
    }

    public static void writeToExcel(List<Data> dataList, String fileName, List<String> header) {
        if (dataList != null && dataList.size() > 0) {

            try (FileOutputStream os = new FileOutputStream(fileName)) {
                SXSSFWorkbook wb = new SXSSFWorkbook(100);
                SXSSFSheet sheet = (SXSSFSheet) wb.createSheet();
                int startRow = 0;
                Row headerRow = sheet.createRow(startRow);
                if (null != header && header.size() > 0) {
                    for (int i = 0; i < header.size(); ++i) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellType(1);
                        cell.setCellValue(String.valueOf(header.get(i)));
                    }

                    ++startRow;
                }

                for (Data data : dataList) {
                    Row row = sheet.createRow(startRow);
                    int col = 0;
                    List<Prop> collect = data.getPropList().stream().sorted(Comparator.comparingInt(Prop::getOrder)).collect(Collectors.toList());
                    for (Prop prop : collect) {
                        String listCell = prop.getValue();
                        Cell cell = row.createCell(col);
                        if (null == listCell) {
                            cell.setCellType(3);
                            cell.setCellValue("");
                        } else {
                            cell.setCellType(1);
                            cell.setCellValue(listCell);
                        }
                        col++;
                    }

                    ++startRow;
                    if (startRow % 100 == 0) {
                        sheet.flushRows();
                    }
                }
                wb.write(os);
            } catch (Exception var23) {
                var23.printStackTrace();
            }
        }
    }

}
