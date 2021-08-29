package nicomed.loads.service.transport;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nicomed.loads.model.transport.Autotrain;
import nicomed.loads.model.transport.Trailer;
import nicomed.loads.model.transport.Truck;

@Slf4j
@AllArgsConstructor
public class AutotrainServiceImpl implements IAutotrainService {
    private final Autotrain autotrain;

    @Override
    public void setTruck(Truck truck) {
        autotrain.setTruck(truck);
    }

    @Override
    public void clearTruck() {
        autotrain.setTruck(new Truck());
    }

    @Override
    public void setTrailer(Trailer trailer) {
        autotrain.setTrailer(trailer);
    }

    @Override
    public void clearTrailer() {
        autotrain.setTrailer(new Trailer());
    }

    @Override
    public boolean isOverrideLoads() {
        return autotrain.isOverrideLoad();
    }

    @Override
    public void setOverrideLoads(boolean override) {
        autotrain.setOverrideLoad(override);
    }

    @Override
    public void setX1(int x1) {
autotrain.setEmptyX1(x1);
    }

    @Override
    public void setX2(int x2) {
autotrain.setEmptyX2(x2);
    }

    @Override
    public void setX3(int x3) {
autotrain.setEmptyX3(x3);
    }

    @Override
    public int getX1() {
        int loadX1 = 0;
        if (!isOverrideLoads()) {
            if (isTruckEmpty()) {
                loadX1 = 0;
            } else {
                Truck truck = autotrain.getTruck();
                Trailer trailer = autotrain.getTrailer();
                loadX1 = autotrain.getTruck().getMassX1();
                if (!isTrailerEmpty()) {
                    loadX1 += Math.round((trailer.getMassSedlo() * truck.getDistSedlo()) / truck.getDistOsi());
                }
            }
        } else {
            loadX1 = autotrain.getEmptyX1();
        }
        log.info("AutoTrain loadX1: " + loadX1);
        return loadX1;
    }

    @Override
    public int getX2() {
        int loadX2 = 0;
        return 0;
    }

    @Override
    public int getX3() {
        return 0;
    }

    private boolean isTruckEmpty() {
        return "".equals(autotrain.getTruck().getName()) || autotrain.getTruck().getName() == null;
    }

    private boolean isTrailerEmpty() {
        return "".equals(autotrain.getTrailer().getName()) || autotrain.getTrailer().getName() == null;
    }
}
