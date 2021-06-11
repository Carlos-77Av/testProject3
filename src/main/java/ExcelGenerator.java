import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@AllArgsConstructor
public class ExcelGenerator {
    private String nameExcel;
    private String sheet;

    public void generate(List<Flight> flightData){
        try {
            XSSFWorkbook book = new XSSFWorkbook();
            XSSFSheet sheet1 = book.createSheet(sheet);

            //Heading of the document
            String[] header = {"No FLIGHT",	"AIRLINE", "TYPE AIRCRAFT", "SOURCE", "DESTINATION DATE", "DEPARTURE TIME",	"ARRIVAL TIME"};

            //Adding style to the excel sheet
            CellStyle style = book.createCellStyle();
            Font font = book.createFont();
            font.setBold(true);
            style.setFont(font);


            //Generating data for the document
            //Header
            XSSFRow row = sheet1.createRow(0);
            for (int i = 0; i < header.length; i++){
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(header[i]);
            }

            //content
            int count = 0;

            for (Flight data: flightData){
                row = sheet1.createRow(++count);

                XSSFCell cell = row.createCell(0);
                cell.setCellValue(data.getNoFlight());

                cell = row.createCell(1);
                cell.setCellValue(data.getAirline());

                cell = row.createCell(2);
                cell.setCellValue(data.getTypeAircraft());

                cell = row.createCell(3);
                cell.setCellValue(data.getSource());

                cell = row.createCell(4);
                cell.setCellValue(data.getDate());

                cell = row.createCell(5);
                cell.setCellValue(data.getDepartureTime());

                cell = row.createCell(6);
                cell.setCellValue(data.getArrivalTime());
            }

            try{
                OutputStream fileOut = new FileOutputStream(nameExcel);
                System.out.println("The excel file has been created successfully...\n");
                book.write(fileOut);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
