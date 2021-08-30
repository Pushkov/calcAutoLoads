package nicomed.loads.model.cargo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class CargoUnit implements Serializable {
    private Cargo unit;
    private int qty;

//    public CargoUnit(Cargo unit, int qty) {
//        this.unit = unit;
//        this.qty = qty;
//    }

    @Override
    public String toString() {
        return "CargoUnit:{ "
                + "Погрузочная единица: " + unit.toString() + ", "
                + "Количество: " + qty + " шт. }";
    }
}
