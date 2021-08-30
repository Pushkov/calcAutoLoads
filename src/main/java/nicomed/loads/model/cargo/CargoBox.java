package nicomed.loads.model.cargo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import nicomed.loads.enums.CargoType;

import static nicomed.loads.enums.CargoType.BOX;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CargoBox extends Cargo {
    private final CargoType type = BOX;
    private int length;
    private int wight;
    private int height;

    @Override
    public String toString() {
        return "CargoBox{ "
                + "type - " + this.getType() + ", "
                + "name - " + this.getName() + ", "
                + "mass - " + this.getMass() + ", "
                + "length - " + this.length + ", "
                + "wight - " + this.wight + ", "
                + "height - " + this.height + " }"
                ;
    }
}
