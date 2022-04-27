package core;

import java.util.*;

public class TestObjectGenerator {
    public static Car generateCar(String inputCarName, int position) {
        CarName carName = CarName.create(inputCarName);
        Car car = Car.create(carName);
        for (int i = 0; i < position; i++) {
            car = car.move(Car.BASE_MOVE_VALUE);
        }
        return car;
    }

    public static Cars generateCars(int count) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(generateCar("a", 0));
        }
        return Cars.fromCars(carList);
    }

    public static Cars generateCarsAtPosition(int count, int position) {
        Cars cars = generateCars(count);
        for (int i = 0; i < position; i++) {
            cars = cars.moveBy(generateMovablePowerSupply());
        }
        return cars;
    }

    public static PowerSupply generateMovablePowerSupply() {
        return () -> Car.BASE_MOVE_VALUE;
    }

    public static RacingGame generateRacingGame() {
        PowerSupply movablePowerSupply = generateMovablePowerSupply();
        return new RacingGame(movablePowerSupply);
    }

    public static List<CarName> generateCarNames() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(CarName.create("a"));
        carNames.add(CarName.create("b"));
        carNames.add(CarName.create("c"));
        return carNames;
    }

    public static Winners generateWinners() {
        Car car1 = generateCar("a", 4);
        Car car2 = generateCar("b", 4);
        Car car3 = generateCar("c", 2);
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = Cars.fromCars(carList);
        PositionBoard positionBoard = PositionBoard.create(cars);
        positionBoard.recordPosition(cars);
        return Winners.decideWinners(positionBoard);
    }

    public static Map<PositionTableKey, List<Integer>> generateInitialPositionTable(Cars cars) {
        Map<PositionTableKey, List<Integer>> positionTable = new HashMap<>();
        for (Car car : cars.getCars()) {
            positionTable.put(PositionTableKey.of(car), new ArrayList<>());
        }
        return positionTable;
    }
}
