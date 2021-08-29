package nicomed.loads;

import nicomed.loads.model.transport.Autotrain;
import nicomed.loads.model.transport.Trailer;
import nicomed.loads.model.transport.Truck;
import nicomed.loads.service.transport.AutotrainServiceImpl;
import nicomed.loads.service.transport.IAutotrainService;

public class Main {
    public static void main(String[] args) {
//        IAutotrainService service = new AutotrainServiceImpl(initTransport());
//        System.out.println(service.getX1());
        System.out.println(initTransport());
    }

    private static Autotrain initTransport() {
        Truck truck = Truck.builder()
                .name("TestTruck")
                .mass0(8300)
                .massX1(5510)
                .massX2(2520)
                .distOsi(3600)
                .distSedlo(560)
                .build();
        Trailer trailer = Trailer.builder()
                .name("TestTrailer")
                .mass0(7250)
                .massSedlo(1280)
                .massTel(5710)
                .distBort(1700)
                .distOsi(7700)
                .distL(13620)
                .distW(2480)
                .distH(2520)
                .build();
        Autotrain autotrain = Autotrain.builder()
                .truck(truck)
                .trailer(trailer)
                .build();
        return autotrain;
    }
}
