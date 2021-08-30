package nicomed.loads.service.transport;

import nicomed.loads.model.transport.Trailer;
import nicomed.loads.model.transport.Truck;

public interface IAutotrainService {

    void setTruck(Truck truck);
    void clearTruck();
    void setTrailer(Trailer trailer);
    void clearTrailer();
    boolean isOverrideLoads();
    void setOverrideLoads(boolean override);
    void setX1(int x1);
    void setX2(int x2);
    void setX3(int x3);
    int getX1();
    int getX2();
    int getX3();
    boolean isTruckEmpty();
    boolean isTrailerEmpty();
}
