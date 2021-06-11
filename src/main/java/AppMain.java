import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        ArrayList<Flight> flightData = new ArrayList<>();
        Flight flight = new Flight(1, "Taca", "rf56", "San Salvador", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);

        flight = new Flight(1, "Delta", "rf50", "Hong Kong", "6/11/2021", "7:00", "16:00");
        flightData.add(flight);


        flight = new Flight(1, "Avianca", "rf85", "New Jersey", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);


        flight = new Flight(1, "Delta", "rf54", "New York", "6/11/2021", "5:00", "11:00");
        flightData.add(flight);


        flight = new Flight(1, "United", "rf56", "Paris", "6/11/2021", "6:00", "14:00");
        flightData.add(flight);

        ExcelGenerator generate = new ExcelGenerator("FlightList.xlsx", "flights");
        generate.generate(flightData);

        GeneratePDF flightPDF = new GeneratePDF();
        flightPDF.FlightPDF(flightData);
    }
}
