package nicomed.loads.model.transport;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Getter
@Setter
@Slf4j
@Builder
public class Autotrain implements ITransport, Serializable {
    private Truck truck;
    private Trailer trailer;
    private int emptyX1;
    private int emptyX2;
    private int emptyX3;
    private boolean isOverrideLoad;

    @Override
    public String toString() {
        return "Автопоезд:\n"
                + "Пользовательские нагрузки: " + isOverrideLoad + "\n"
                + "Нагрузка на переднюю ось тягача: " + emptyX1 + " кг.\n"
                + "Нагрузка на заднюю ось тягача: " + emptyX2 + " кг.\n"
                + "Нагрузка на тележку полуприцепа: " + emptyX3 + " кг.\n"
                + "Состав автопоезда:\n"
                + " - " + truck.toString() + "\n"
                + " - " + trailer.toString() + "\n";
    }
}
