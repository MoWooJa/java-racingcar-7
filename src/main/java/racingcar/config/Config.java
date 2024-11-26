package racingcar.config;

import racingcar.controller.Controller;
import racingcar.model.domain.RacingJudge;
import racingcar.model.service.CarRacing;
import racingcar.model.service.CarRacingGameService;
import racingcar.view.inputview.InputView;

public class Config {

    private static CarRacing carRacing() {
        return new CarRacing();
    }

    private static RacingJudge racingJudge() {
        return new RacingJudge();
    }

    private static CarRacingGameService carRacingGameService() {
        return new CarRacingGameService(carRacing(), racingJudge());
    }

    private static InputView inputView() {
        return new InputView(null);
    }

    public static Controller createController() {
        return new Controller(inputView(), null, carRacingGameService());
    }
}
