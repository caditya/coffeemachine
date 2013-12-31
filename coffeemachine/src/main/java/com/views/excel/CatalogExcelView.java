package com.views.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import machine.coffee.bean.*;

class CatalogExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                            HttpServletRequest request, HttpServletResponse response)
                            throws Exception {
    List<CoffeeXML> coffeeList = (List<CoffeeXML>) model.get("coffeecatalog");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet();
        if(coffeeList==null){
        	coffeeList = new ArrayList<CoffeeXML>();
        	coffeeList.add(new CoffeeXML("Coffee-800",80));
        	coffeeList.add(new CoffeeXML("Coffee-900",90));
        }
        
        for (short i = 0; i < coffeeList.size(); i++) {
            CoffeeXML coffee = coffeeList.get(i);
            HSSFRow row = sheet.createRow(i);
            addStringCell(row, 0, coffee.getName());
            addStringCell(row, 1, ""+coffee.getQuantity());
            
        }
    }

    private HSSFCell addStringCell(HSSFRow row, int index, String value) {
        HSSFCell cell = row.createCell((short) index);
        cell.setCellValue(new HSSFRichTextString(value));
        return cell;
    }

    private HSSFCell addDateCell(HSSFRow row, int index, Date date,
        HSSFCellStyle dateStyle) {
        HSSFCell cell = row.createCell((short) index);
        cell.setCellValue(date);
        cell.setCellStyle(dateStyle);
        return cell;
    }
}
