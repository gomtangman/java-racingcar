package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<CarName> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::create)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveBy(PowerSupply powerSupply) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(powerSupply.supply()));
        }
        return Cars.fromCars(movedCars);
    }

    public List<CarName> names() {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<String> ids() {
        return cars.stream()
                .map(Car::getId)
                .collect(Collectors.toList());
    }

    public CarName findCarNameById(String id) {
        return cars.stream()
                .filter(car -> car.isSameId(id))
                .map(Car::getCarName)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
