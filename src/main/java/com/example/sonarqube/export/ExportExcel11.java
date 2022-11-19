package com.example.sonarqube.export;

import com.example.sonarqube.entities.Issue;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportExcel11 {
public void exportexcel11(List<Issue> issueList) throws IOException {
        String excelFilePath = "E:\\JavaBooks.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for(Issue i : issueList){
                Row row = sheet.getRow(i.getPosition());
                Cell c11 = row.getCell(i.getPositionColonne());
                if(i.getTotal() != null)
                c11.setCellValue(i.getTotal());
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm_ss");

        String formattedDate = myDateObj.format(myFormatObj);
        try (FileOutputStream outputStream = new FileOutputStream("E:\\reposExcel\\JavaBooks" + formattedDate + ".xlsx")) {
        workbook.write(outputStream);
        }
        }
}
