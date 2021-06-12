import java.util.ArrayList;

public class AppMain {
    public static void main(String[] args) {

        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        ArrayList<Flight> flightData = new ArrayList<>();

        InitialData loadInformation = new InitialData();
        loadInformation.returnData(aircraftList,flightData);

        //MAIN MENU
        Menu start = new Menu();
        start.mainMenu();



        /*
        ExcelGenerator generate = new ExcelGenerator("FlightList.xlsx", "flights");

        generate.generate(flightData);

        GeneratePDF flightPDF = new GeneratePDF();
        flightPDF.FlightPDF(flightData);
        */
    }
}
