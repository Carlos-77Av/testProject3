import java.util.ArrayList;

public class InitialData {

    public void returnFlightList(ArrayList<Flight> flightData){
        Flight flight = new Flight(1, "Taca", "rf56", "San Salvador", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);

        flight = new Flight(2, "Delta", "rf50", "Hong Kong", "6/11/2021", "7:00", "16:00");
        flightData.add(flight);

        flight = new Flight(3, "Avianca", "rf85", "New Jersey", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);

        flight = new Flight(4, "Delta", "rf54", "New York", "6/11/2021", "5:00", "11:00");
        flightData.add(flight);

        flight = new Flight(5, "United", "rf56", "Paris", "6/11/2021", "6:00", "14:00");
        flightData.add(flight);
    }

    public void returnAirline(ArrayList<Airline> AirlineData){
        Airline airline = new Airline();
        airline.setName("Taca");
        AirlineData.add(airline);

        airline = new Airline();
        airline.setName("Delta");
        AirlineData.add(airline);

        airline = new Airline();
        airline.setName("Avianca");
        AirlineData.add(airline);


        airline = new Airline();
        airline.setName("United");
        AirlineData.add(airline);
    }

    public void returnData(ArrayList<Aircraft> aircraftList, ArrayList<Flight> flightData){
        //Adding some aircraft
        Aircraft aircraft = new Aircraft("R45", 350, "250km");
        aircraftList.add(aircraft);

        aircraft = new Aircraft("R50", 300, "360km");
        aircraftList.add(aircraft);



        //Adding some flights
        Flight flight = new Flight(1, "Taca", "rf56", "San Salvador", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);

        flight = new Flight(2, "Delta", "rf50", "Hong Kong", "6/11/2021", "7:00", "16:00");
        flightData.add(flight);

        flight = new Flight(3, "Avianca", "rf85", "New Jersey", "6/11/2021", "7:00", "12:00");
        flightData.add(flight);

        flight = new Flight(4, "Delta", "rf54", "New York", "6/11/2021", "5:00", "11:00");
        flightData.add(flight);

        flight = new Flight(5, "United", "rf56", "Paris", "6/11/2021", "6:00", "14:00");
        flightData.add(flight);
    }
}
