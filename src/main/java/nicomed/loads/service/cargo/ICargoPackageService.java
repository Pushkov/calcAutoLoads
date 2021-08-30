package nicomed.loads.service.cargo;

import nicomed.loads.model.cargo.CargoPackage;
import nicomed.loads.model.cargo.CargoUnit;

import java.util.List;

public interface ICargoPackageService {
    CargoPackage getPackage();
    CargoUnit getCargoUnit(CargoUnit unit);
    CargoUnit getCargoUnit(int index);
    void addCargoUnit(CargoUnit unit);
    void removeCargoUnit(CargoUnit unit);
    void saveCargoUnit(CargoUnit unit);
}
