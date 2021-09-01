package nicomed.loads;

import nicomed.loads.calculate.IIntDistributionGenerate;
import nicomed.loads.calculate.IntDistributionGenerator;
import nicomed.loads.model.cargo.CargoPackage;
import nicomed.loads.model.limits.Limits;
import nicomed.loads.model.transport.Transport;

import java.util.List;

public class CalculationsManager implements ICalculations {


    IIntDistributionGenerate intGenerator;


    @Override
    public void getVariantsList(CargoPackage pack, Transport transport, Limits limits) {
        intGenerator = new IntDistributionGenerator();
        List<List<Integer>> list = intGenerator.getIntegerRaspredList(10, 2);
        list.forEach(System.out::println);
    }


}
