import java.util.ArrayList;

public class FormatterString {
    public StringBuilder buildTitle(String title){
        StringBuilder str = new StringBuilder();
        str.append("\n\t::::::::::::::::::::::::::: ").append(title);
        str.append(" ::::::::::::::::::::::::::: \n");

        return str;
    }

    public StringBuilder buildOption(String[] opc){
        int count = 0;
        StringBuilder str = new StringBuilder();

        for (String op: opc){
            str.append("\t\t").append(++count).append(") ");
            str.append(op.toUpperCase()).append("\n");
        }
        str.append("\n\t:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\n");
        str.append("Enter the number that represent the option need: ");
        return str;
    }

    public void clear(){
        for (int i = 0; i<=15; i++){
            System.out.println("\n");
        }
    }

    public StringBuilder flightList(ArrayList<Flight> flightData){
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (Flight data: flightData){
            str.append(++count).append(") -> \t|\t");
            str.append(String.format("%-2s", data.getNoFlight())).append("\t|\t");
            str.append(String.format("%-20s", data.getAirline())).append("\t|\t");
            str.append(String.format("%-6s", data.getTypeAircraft())).append("\t|\t");
            str.append(String.format("%-15s", data.getOrigin())).append("\t|\t");
            str.append(String.format("%-10s", data.getDate())).append("\t|\t");
            str.append(String.format("%-5s", data.getArrivalTime())).append("\t|\t");
            str.append(String.format("%-5s", data.getDepartureTime())).append("\t|\n");
        }
        return str;
    }

}
