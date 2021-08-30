package nicomed.loads;

import nicomed.loads.enums.TransportType;
import nicomed.loads.model.cargo.CargoBox;
import nicomed.loads.model.cargo.CargoUnit;
import nicomed.loads.model.transport.Autotrain;
import nicomed.loads.model.transport.Trailer;
import nicomed.loads.model.transport.Transport;
import nicomed.loads.model.transport.Truck;
import nicomed.loads.service.cargo.CargoPackageServiceImpl;
import nicomed.loads.service.cargo.ICargoPackageService;
import nicomed.loads.service.transport.AutotrainServiceImpl;
import nicomed.loads.service.transport.IAutotrainService;


public class Main {
    private static ICargoPackageService cargoPackageService;
    private static ICalculations calculations;

    public static void main(String[] args) {
        cargoPackageService = new CargoPackageServiceImpl();
        calculations = new CalculationsManager();

            System.out.println("\nТРАНСПОРТ:");
            Transport transport = initTransport();
            System.out.println(transport);
            IAutotrainService service = new AutotrainServiceImpl((Autotrain) transport);
            System.out.println("итоговая x1 - " + service.getX1());
            System.out.println("итоговая x2 - " + service.getX2());
            System.out.println("итоговая x3 - " + service.getX3());
            System.out.println("\nГРУЗ:");
            CargoBox box = initCargo();
//            System.out.println(box);
            CargoUnit unit = CargoUnit.builder()
                    .unit(
                            CargoBox.builder().name("box1").build()
                    )
                    .qty(5)
                    .build();
            CargoUnit unit1 = CargoUnit.builder()
                    .unit(
                            CargoBox.builder().name("box2").build()
                    )
                    .qty(6)
                    .build();
//            System.out.println(unit);
            cargoPackageService.addCargoUnit(unit);
            cargoPackageService.addCargoUnit(unit1);
            System.out.println(cargoPackageService.getPackage());
            System.out.println("****************");
            CargoUnit edited = cargoPackageService.getCargoUnit(unit);
            edited.getUnit().setName("edit1");
            cargoPackageService.saveCargoUnit(edited);
            System.out.println(cargoPackageService.getPackage());

            calculations.getVariantsList(cargoPackageService.getPackage(),transport, null);

    }

    private static CargoBox initCargo() {
        return CargoBox.builder()
                .name("box1")
                .mass(1500)
                .length(1100)
                .wight(800)
                .height(1000)
                .build();

    }

    private static Autotrain initTransport() {
        Truck truck = Truck.builder()
                .name("TestTruck")
                .mass0(8000)
                .massX1(5500)
                .massX2(2500)
                .distOsi(3600)
                .distSedlo(550)
                .build();
        Trailer trailer = Trailer.builder()
                .name("TestTrailer")
                .mass0(7000)
                .massSedlo(1250)
                .massTel(5750)
                .distBort(1700)
                .distOsi(7700)
                .distL(13620)
                .distW(2480)
                .distH(2640)
                .build();
        return Autotrain.builder()
                .type(TransportType.TRUCK)
                .truck(truck)
                .trailer(trailer)
                .emptyX1(5500)
                .emptyX2(3700)
                .emptyX3(5800)
                .isOverrideLoad(false)
                .build();
    }
}
