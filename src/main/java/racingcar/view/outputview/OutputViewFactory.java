package racingcar.view.outputview;

public class OutputViewFactory {

    public static final String TYPE_ERROR_MESSAGE = "잘못된 출력 뷰 타입을 입력하셨습니다.";

    private OutputViewFactory() {
    }

    public static OutputView createOutputViewOf(OutPutViewType outPutViewType) {
        if (outPutViewType == OutPutViewType.ROUND) {
            return new RoundView();
        }
        if (outPutViewType == OutPutViewType.WINNER) {
            return new WinnerView();
        }
        throw new RuntimeException(TYPE_ERROR_MESSAGE);
    }
}
