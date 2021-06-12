import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Aircraft {
    private String model;
    private int capacity;
    private String distanceCapacity;
}
