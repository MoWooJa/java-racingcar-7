package racingcar.view;

import java.util.List;

public class RoundView implements OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private final List<String> roundResult;

    private RoundView(List<String> roundResult) {
        this.roundResult = roundResult;
    }

    public static RoundView of(List<String> roundResult) {
        return new RoundView(roundResult);
    }

    private void showRound() {
        for (String result : roundResult) {
            System.out.println(result);
        }
        System.out.println();
    }

    @Override
    public void display() {
        System.out.println(RESULT_MESSAGE);
        showRound();
    }
}
