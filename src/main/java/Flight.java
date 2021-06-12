import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
@AllArgsConstructor
public class Flight {
    private int noFlight;
    private String airline;
    private String typeAircraft;
    private String origin;
    private String date;
    private String departureTime;
    private String arrivalTime;
}

