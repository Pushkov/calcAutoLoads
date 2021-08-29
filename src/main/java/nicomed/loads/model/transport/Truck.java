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
    private int mass0,
            massX1,
            massX2,
            distOsi,
            distSedlo;
}
