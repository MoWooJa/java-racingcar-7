package racingcar.util.parser;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.exception.ErrorMessage;
import racingcar.util.validate.Validate;

public class InputParser {

    public static List<Car> StringToCarParser(String input) {
        String[]carsArray = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carsArray) {
            Validate.validateInputCars(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public static int StringToIntParser(String inputCount) {
        int count = 0;
        try {
            count = Integer.parseInt(inputCount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessage.NON_INPUT_NUMERIC.getMessage());
        }
        Validate.validateInputCount(count);
        return count;
    }
}
