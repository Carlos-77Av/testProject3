import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GeneratePDF {
        public String FlightPDF(List<Flight> flightData){
            final String[] header= {"No FLIGHT",	"AIRLINE", "TYPE AIRCRAFT", "SOURCE", "DESTINATION DATE", "DEPARTURE TIME",	"ARRIVAL TIME"};
            //Create the document
            Document document = new Document(PageSize.A3.rotate());
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
                table.setWidthPercentage(100);
                table.getDefaultCell().setUseAscender(true);
                table.getDefaultCell().setUseDescender(true);


                //Add table header
                for (String s : header) {
                    table.addCell(s);
                }

                //Add the content
                for (Flight data: flightData){
                    table.addCell(Integer.toString(data.getNoFlight()));
                    table.addCell(data.getAirline());
                    table.addCell(data.getTypeAircraft());
                    table.addCell(data.getOrigin());
                    table.addCell(data.getDate());
                    table.addCell(data.getDepartureTime());
                    table.addCell(data.getArrivalTime());
                }

                //Add the table to the document
                document.add(table);


                //Information about climate
                Weather climate = new Weather();
                Paragraph clime = new Paragraph("\n\n" + climate.CurrentWeather() +"\n\n",
                        FontFactory.getFont("arial",
                                14,
                                Font.BOLD,
                                BaseColor.DARK_GRAY));

                //Add the clime information in the PDF
                document.add(clime);

                //Close document
                document.close();
                System.out.println("The PDF file was created correctly...\n");



            }catch (FileNotFoundException | DocumentException ex){
                System.out.println("An error has occurred");
            }
            return "test.pdf";
        }
}
