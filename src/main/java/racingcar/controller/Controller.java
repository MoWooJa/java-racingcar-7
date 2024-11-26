package racingcar.controller;

import racingcar.model.domain.Round;
import racingcar.model.domain.car.Cars;
import racingcar.model.domain.parser.InputCarNamesParser;
import racingcar.model.domain.parser.InputRoundParser;
import racingcar.model.service.CarRacingGameService;
import racingcar.view.inputview.InputView;
import racingcar.view.inputview.InputViewFactory;
import racingcar.view.outputview.OutPutViewType;
import racingcar.view.outputview.OutputView;
import racingcar.view.outputview.OutputViewFactory;

public class Controller {

    InputView inputView;
    OutputView outputView;
    CarRacingGameService carRacingGameService;

    public Controller(InputView inputView, OutputView outputView, CarRacingGameService carRacingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carRacingGameService = carRacingGameService;
    }

    public void run() {
        racingAndShowRound();
        showWinners();
    }

    private void showWinners() {
        outputView = OutputViewFactory.createOutputViewOf(OutPutViewType.WINNER);
        outputView.display(carRacingGameService.getWinners());
    }

    private void racingAndShowRound() {
        outputView = OutputViewFactory.createOutputViewOf(OutPutViewType.ROUND);
        outputView.display(carRacingGameService.race(getCars(), getRound()));
    }

    private Cars getCars() {
        inputView = InputViewFactory.createNamesInputVIew();
        String inputNames = inputView.getInput();
        InputCarNamesParser inputCarNamesParser = new InputCarNamesParser();
        return Cars.of(inputCarNamesParser.parse(inputNames));
    }

    private Round getRound() {
        inputView = InputViewFactory.createNumberOfRoundInputVIew();
        String inputRound = inputView.getInput();
        InputRoundParser inputRoundParser = new InputRoundParser();
        return inputRoundParser.parseToRound(inputRound);
    }
}
