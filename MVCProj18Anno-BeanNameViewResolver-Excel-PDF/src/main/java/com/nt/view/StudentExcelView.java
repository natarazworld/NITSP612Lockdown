package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.StudentDTO;

@Component("excelView")
public class StudentExcelView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, 
			                                            Workbook workbook, HttpServletRequest request,
			                                               HttpServletResponse response) throws Exception {
		//Read Model Attributes
		List<StudentDTO>listDTO= (List<StudentDTO>) model.get("studentsInfo");
		//create WorkSheet
		Sheet 	sheet=workbook.createSheet("Students Report");
		//add rows with cells having DTO class objects data in cells
		int i=0;
		for(StudentDTO dto:listDTO) {
			
			Row row=sheet.createRow(i);
			row.createCell(0).setCellValue(dto.getSno());
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getSadd());
			row.createCell(3).setCellValue(dto.getAvg());
			i++;
			
		}//for

	}//method
}//class
