package nicomed.loads.model.transport;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import nicomed.loads.enums.TransportType;

import java.io.Serializable;

import static nicomed.loads.enums.TransportType.AUTO_TRAIN;

@Getter
@Setter
@Slf4j
@SuperBuilder
public class Autotrain extends Transport implements Serializable {
    private final TransportType type = AUTO_TRAIN;
    private Truck truck;
    private Trailer trailer;
    private int emptyX1;
    private int emptyX2;
    private int emptyX3;
    private boolean isOverrideLoad;

    @Override
    public String toString() {
        return "Автопоезд:\n"
                + "Тип: " + this.getType() + "\n"
                + "Переопределенные нагрузки: " + isOverrideLoad + "\n"
                + "Нагрузка на переднюю ось тягача: " + emptyX1 + " кг.\n"
                + "Нагрузка на заднюю ось тягача: " + emptyX2 + " кг.\n"
                + "Нагрузка на тележку полуприцепа: " + emptyX3 + " кг.\n"
                + "Состав автопоезда:\n{\n"
                + " - " + truck.toString() + "\n"
                + " - " + trailer.toString() + "\n}";
    }
}
