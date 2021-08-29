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
    private int mass0,
            massTel,
            massSedlo,
            distOsi,
            distBort,
            distL,
            distW,
            distH;
}
