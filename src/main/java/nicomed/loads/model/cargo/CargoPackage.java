package nicomed.loads.model.cargo;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CargoPackage implements Serializable {
    private final List<CargoUnit> pack;

    public CargoPackage() {
        this.pack = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Погрузочный лист:"
                + pack.stream()
                .map(CargoUnit::toString)
                .collect(Collectors.joining("\n", "\n[\n", "\n]"));
    }
}
