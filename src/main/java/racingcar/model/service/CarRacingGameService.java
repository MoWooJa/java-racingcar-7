package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.RaceStatus;
import racingcar.model.domain.RacingJudge;
import racingcar.model.domain.Round;
import racingcar.model.domain.car.Cars;

public class CarRacingGameService {

    private final CarRacing carRacing;
    private final RacingJudge racingJudge;
    private List<RaceStatus> racingResult;

    public CarRacingGameService(CarRacing carRacing, RacingJudge racingJudge) {
        this.carRacing = carRacing;
        this.racingJudge = racingJudge;
    }

    public List<RaceStatus> race(Cars cars, Round round) {
        racingResult = carRacing.race(cars, round);
        return racingResult;
    }

    public List<String> getWinners() {
        return racingJudge.getWinners(racingResult);
    }
}
