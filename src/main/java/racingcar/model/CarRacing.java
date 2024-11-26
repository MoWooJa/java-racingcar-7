package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.car.Cars;

public class CarRacing {
    public List<RaceStatus> race(Cars cars, Round round) {
        List<RaceStatus> raceResult = new ArrayList<>();
        while (round.isDone()) {
            cars.moveCars();
            round.oneRoundDone();
            raceResult.add(cars.getRaceStatus());
        }
        return Collections.unmodifiableList(raceResult);
    }
}
