package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;
    private RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = inputCarName();
        int count = inputRacingCount();
        racingStart(cars,count);
    }

    private List<Car> inputCarName() {
        String inputCars = inputView.inputCarName();
        return InputParser.StringToCarParser(inputCars);
    }

    private int inputRacingCount() {
        String inputCount = inputView.inputRacingCount();
        return InputParser.StringToIntParser(inputCount);
    }

    private void racingStart(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            racingService.racingGetRandom(cars);
            StringBuilder racingProgress =racingService.createGameProgressView(cars);
            outputView.displayRacingProgress(racingProgress);
        }
        racingWinnerResult(cars);
    }

    private void racingWinnerResult(List<Car> cars) {
        StringBuilder winners = racingService.getRacingWinner(cars);
        outputView.displayWinners(winners);
    }


}
