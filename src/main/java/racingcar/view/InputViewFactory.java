package racingcar.view;

public class InputViewFactory {

    private InputViewFactory() {
    }

    public static InputView createNamesInputVIew() {
        return new InputView(InputViewType.NAMES_REQUEST.getMessage());
    }

    public static InputView createNumberOfRoundInputVIew() {
        return new InputView(InputViewType.NUMBER_OF_ROUND_REQUEST.getMessage());
    }
}
