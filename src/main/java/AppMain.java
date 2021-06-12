import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        ArrayList<Flight> flightData = new ArrayList<>();

        InitialData loadInformation = new InitialData(aircraftList,flightData);

        ExcelGenerator generate = new ExcelGenerator("FlightList.xlsx", "flights");
        generate.generate(flightData);

        GeneratePDF flightPDF = new GeneratePDF();
        flightPDF.FlightPDF(flightData);

    }
}
