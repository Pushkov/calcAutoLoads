package nicomed.loads.model.transport;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Truck implements Serializable {
    private String name = "";
    private int mass0 = -1,
            massX1 = -1,
            massX2 = -1,
            distOsi = -1,
            distSedlo = -1;
}
