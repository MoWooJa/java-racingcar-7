package racingcar.model.car;

import java.util.List;

public class Cars {

    public static final int INITIAL_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Cars::generateCar).toList();
        return new Cars(cars);
    }

    private static Car generateCar(String name) {
        return new Car(name, INITIAL_POSITION);
    }
}
