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
        if (isOverrideLoads()) {
            loadX1 = autotrain.getEmptyX1();
        } else {
            if (!isTruckEmpty()) {
                Truck truck = autotrain.getTruck();
                loadX1 = truck.getMassX1();
                if (!isTrailerEmpty()) {
                    Trailer trailer = autotrain.getTrailer();
                    loadX1 += (trailer.getMassSedlo() * truck.getDistSedlo()) / truck.getDistOsi();
                }
            }
        }
        return loadX1;
    }

    @Override
    public int getX2() {
        int loadX2 = 0;
        if (isOverrideLoads()) {
            loadX2 = autotrain.getEmptyX2();
        } else {
            if (!isTruckEmpty()) {
                Truck truck = autotrain.getTruck();
                loadX2 = truck.getMassX2();
                if (!isTrailerEmpty()) {
                    Trailer trailer = autotrain.getTrailer();
                    loadX2 += (trailer.getMassSedlo() * (truck.getDistOsi() - truck.getDistSedlo())) / truck.getDistOsi();
                }
            }
        }

        return loadX2;
    }

    @Override
    public int getX3() {
        int loadX3 = 0;
        if (isOverrideLoads()) {
            loadX3 = autotrain.getEmptyX3();
        } else {
            if (!isTrailerEmpty()) {
                loadX3 = autotrain.getTrailer().getMassTel();
            }
        }
        return loadX3;
    }

    @Override
    public boolean isTruckEmpty() {
        Truck truck = autotrain.getTruck();
        return truck.getName().isEmpty()
                || truck.getMass0() <= 0
                || truck.getMassX1() <= 0
                || truck.getMassX2() <= 0
                || truck.getDistOsi() <= 0
                || truck.getDistSedlo() <= 0
                ;
    }

    @Override
    public boolean isTrailerEmpty() {
        Trailer trailer = autotrain.getTrailer();
        return trailer.getName().isEmpty()
                || trailer.getMass0() <= 0
                || trailer.getMassSedlo() <= 0
                || trailer.getMassTel() <= 0
                || trailer.getDistBort() <= 0
                || trailer.getDistOsi() <= 0
                || trailer.getDistL() <= 0
                || trailer.getDistW() <= 0
                || trailer.getDistH() <= 0
                ;
    }
}
