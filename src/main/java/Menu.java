import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final String[] mainOption = {"Flight", "Aircraft", "AIRLINE"};
    private final String[] flightOption = {"See the list of flights", "Register a new flight", "Generate a report"};


    public void mainMenu(ArrayList<Aircraft> aircraftList, ArrayList<Flight> flightData){
        FormatterString str = new FormatterString();
        System.out.println("\n\t\t\t\t\tWELCOME TO CONTROL FLIGHT SYSTEM");
        System.out.println(str.buildTitle("MAIN MENU"));
        System.out.print(str.buildOption(mainOption));
        Scanner read = new Scanner(System.in);
        boolean incorrectMain;
        do {
            incorrectMain = false;
            String opc = read.next();
            switch (opc){
                case "1":
                    flightMenu(read, flightData, aircraftList);
                    break;

                default:
                    System.out.println("Option does not exist.");
                    incorrectMain = true;
            }
        }while(incorrectMain);

    }

    public void flightMenu(Scanner read, ArrayList<Flight> flightData, ArrayList<Aircraft> aircraftList){
        FormatterString str = new FormatterString();
        str.clear();
        System.out.println(str.buildTitle("FLIGHT MENU"));
        System.out.print(str.buildOption(flightOption));

        boolean incorrectFlight;
        do {
            incorrectFlight = false;
            String opc = read.next();
            switch (opc){
                case "1":
                    System.out.println(str.flightList(flightData));

                    break;

                case "2":
                    str.clear();
                    System.out.println(str.buildTitle("new flight"));

                    // ------------------------------ Number of flight -----------------------------
                    System.out.print("Enter the number of the flight: ");
                    String nFlight = read.next();
                    System.out.print("\nDo you want to select an airline saved? (Y/N): ");
                    String airlineName;
                    char decision = read.next().charAt(0);
                    if (decision == 'y' || decision == 'Y'){
                        //Loading the information of airlines
                        InitialData load = new InitialData();
                        ArrayList<Airline> airlineList = new ArrayList<>();
                        load.returnAirline(airlineList);

                        //ArrayList to save all the information
                        ArrayList<String> option = new ArrayList<>();
                        System.out.println();
                        int count = 0;
                        for (Airline data: airlineList){
                            option.add(data.getName());
                            System.out.println(++count + ") -> " +  data.getName());
                        }

                        System.out.print("\nEnter the number that represent the option need: ");
                        airlineName = option.get((Integer.parseInt(read.next())) - 1);
                        System.out.println("You entered " + airlineName + "\n");
                    }
                    else{
                        System.out.print("\nEnter the airline name: ");
                        airlineName = read.next();
                    }

                    // ------------------------------ aircraft type -----------------------------
                    String aircraftType;
                    System.out.print("\nDo you want to select an aircraft saved? (Y/N): ");
                    decision = read.next().charAt(0);
                    if (decision == 'y' || decision == 'Y'){
                        //Loading the information of airlines

                        //ArrayList to save all the information
                        ArrayList<String> option = new ArrayList<>();
                        System.out.println();
                        int count = 0;
                        for (Aircraft data: aircraftList){
                            option.add(data.getModel());
                            System.out.println(++count + ") -> " +  data.getModel());
                        }

                        System.out.print("\nEnter the number that represent the option need: ");
                        aircraftType = option.get((Integer.parseInt(read.next())) - 1);
                        System.out.println("You entered " + aircraftType + "\n");
                    }
                    else{
                        System.out.print("\nEnter the aircraft name: ");
                        aircraftType = read.next();
                    }


                    // ------------------------------ Origin -----------------------------

                    System.out.print("Enter the origin: ");
                    read.nextLine();
                    String origin = read.nextLine();
                    System.out.println("");

                    // ------------------------------ Date -----------------------------
                    System.out.print("Enter the date on the following structure (MM/DD/YYYY): ");
                    String date = read.next();
                    System.out.println();

                    // ------------------------------ Departure Time -----------------------------
                    System.out.print("Enter the departure time on the following structure (hh:mm a.m/p.m): ");
                    read.nextLine();
                    String departureTime = read.nextLine();
                    System.out.println();

                    // ------------------------------ Arrival Time -----------------------------
                    System.out.print("Enter the arrival time on the following structure (hh:mm a.m/p.m): ");
                    String arrivalTime = read.nextLine();
                    System.out.println();

                    //Saving the new flight
                    Flight newFlight = new Flight(Integer.parseInt(nFlight), airlineName, aircraftType, origin, date, departureTime, arrivalTime);
                    flightData.add(newFlight);

                    mainMenu(aircraftList,flightData);

                    break;

                case "3":
                    //Generate the information
                    GeneratePDF flightPDF = new GeneratePDF();
                    flightPDF.FlightPDF(flightData);

                    System.out.println("Do you want to send the report in a mail? (Y/N):");
                    char answer = read.next().toUpperCase().charAt(0);


                    break;

                default:
                    System.out.println("Option does not exist.");
                    incorrectFlight = true;
            }
        }while(incorrectFlight);
    }

}
