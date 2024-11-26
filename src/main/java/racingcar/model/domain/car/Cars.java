package racingcar.model.domain.car;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.model.domain.RaceStatus;
import racingcar.util.RandomNumberGenerator;

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

    public void moveCars() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        car.move(RandomNumberGenerator.generateRandomNumber());
    }

    public RaceStatus getRaceStatus() {
        List<CarStatus> carsStatus = cars.stream().map(Car::getStatus).toList();
        return new RaceStatus(carsStatus);
    }
}
