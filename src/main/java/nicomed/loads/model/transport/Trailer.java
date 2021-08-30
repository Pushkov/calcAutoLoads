package nicomed.loads.model.transport;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trailer implements Serializable {
    private String name = "";
    private int mass0 = -1,
            massTel = -1,
            massSedlo = -1,
            distOsi = -1,
            distBort = -1,
            distL = -1,
            distW = -1,
            distH = -1;
}
