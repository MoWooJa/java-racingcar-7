package racingcar.view.outputview;

import java.util.List;

public class OutputViewFactory {

    public static final String TYPE_ERROR_MESSAGE = "잘못된 출력 뷰 타입을 입력하셨습니다.";

    private OutputViewFactory() {
    }

    public OutputView createOutputViewOf(OutPutViewType outPutViewType, List<String> resultForDisplay) {
        if (outPutViewType == OutPutViewType.ROUND) {
            return new RoundView(resultForDisplay);
        }
        if (outPutViewType == OutPutViewType.WINNER) {
            return new WinnerView(resultForDisplay);
        }
        throw new RuntimeException(TYPE_ERROR_MESSAGE);
    }
}
