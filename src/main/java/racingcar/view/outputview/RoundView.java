package racingcar.view.outputview;

import java.util.List;
import racingcar.model.domain.RaceStatus;

public class RoundView implements OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";

    private void showRound(List<String> roundResult) {
        for (String result : roundResult) {
            System.out.println(result);
        }
        System.out.println();
    }

    @Override
    public void display(List<?> racingResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.println();
        for (RaceStatus raceStatus : (List<RaceStatus>) racingResult) {
            showRound(raceStatus.getRoundResult());
        }
    }
}
