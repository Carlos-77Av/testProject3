import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GeneratePDF {
        public void FlightPDF(List<Flight> flightData){
            final String[] header= {"No FLIGHT",	"AIRLINE", "TYPE AIRCRAFT", "SOURCE", "DESTINATION DATE", "DEPARTURE TIME",	"ARRIVAL TIME"};
            //Create the document
            Document document = new Document();
            try {
                FileOutputStream pdfFile = new FileOutputStream("test.pdf");

                //Linking the file and document
                PdfWriter.getInstance(document, pdfFile);

                //Open document
                document.open();

                //Paragraph
                Paragraph title = new Paragraph("List of Scheduled Flights\n\n",
                        FontFactory.getFont("arial",
                                22,
                                Font.BOLD,
                                BaseColor.BLUE));

                document.add(title);

                //Creating a table for showing data
                PdfPTable table = new PdfPTable(7);

                //Add table header
                for (int i = 0; i < header.length; i++){
                    table.addCell(header[i]);
                }

                //Add the content
                for (Flight data: flightData){
                    table.addCell(Integer.toString(data.getNoFlight()));
                    table.addCell(data.getAirline());
                    table.addCell(data.getTypeAircraft());
                    table.addCell(data.getSource());
                    table.addCell(data.getDate());
                    table.addCell(data.getDepartureTime());
                    table.addCell(data.getArrivalTime());
                }

                //Add the table to the document
                document.add(table);

                //Close document
                document.close();
                System.out.println("The PDF file was created correctly...\n");

            }catch (FileNotFoundException | DocumentException ex){
                System.out.println("An error has occurred");
            }


        }
}
