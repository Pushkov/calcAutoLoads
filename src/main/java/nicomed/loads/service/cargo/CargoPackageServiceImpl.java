package nicomed.loads.service.cargo;

import nicomed.loads.model.cargo.CargoPackage;
import nicomed.loads.model.cargo.CargoUnit;

import java.util.List;

public class CargoPackageServiceImpl implements ICargoPackageService {
    private final CargoPackage cargoPackage;
    private final List<CargoUnit> pack;

    public CargoPackageServiceImpl() {
        cargoPackage = new CargoPackage();
        pack = cargoPackage.getPack();
    }

    @Override
    public CargoPackage getPackage() {
        return cargoPackage;
    }

    @Override
    public CargoUnit getCargoUnit(CargoUnit unit) {
        if (pack.contains(unit)) {
            int index = pack.indexOf(unit);
            CargoUnit result = pack.get(index);
            pack.remove(index);
            return result;
        }
        return null;
    }

    @Override
    public CargoUnit getCargoUnit(int index) {
        return pack.get(index);
    }

    @Override
    public void addCargoUnit(CargoUnit unit) {
        pack.add(unit);
    }

    @Override
    public void removeCargoUnit(CargoUnit unit) {
        pack.remove(unit);
    }

    @Override
    public void saveCargoUnit(CargoUnit unit) {
        addCargoUnit(unit);
    }
}
