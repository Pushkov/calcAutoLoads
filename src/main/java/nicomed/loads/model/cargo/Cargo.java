package nicomed.loads.model.cargo;

import lombok.*;
import lombok.experimental.SuperBuilder;
import nicomed.loads.enums.CargoType;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode
public abstract class Cargo implements Serializable {
    private final CargoType type;
    private String name;
    private int mass;

}
