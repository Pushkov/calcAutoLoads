package nicomed.loads;

import nicomed.loads.model.cargo.CargoPackage;
import nicomed.loads.model.limits.Limits;
import nicomed.loads.model.transport.Transport;

public interface ICalculations {
    void getVariantsList(CargoPackage pack, Transport transport, Limits limits);
}
