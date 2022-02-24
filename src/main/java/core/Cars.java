package core;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<String> carNames) {
        List<Car> receivedCars = new ArrayList<>();
        for (String carName : carNames) {
            receivedCars.add(new Car(carName));
        }

        return new Cars(receivedCars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public boolean isValid() {
        return cars.stream().allMatch(Car::isValid);
    }

    public void printPositions() {
        cars.forEach(Car::printPosition);
    }

    public List<Car> getCars() {
        return cars;
    }
}
