package racingcar.view.inputview;

public enum InputViewType {

    NAMES_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ROUND_REQUEST("시도할 횟수는 몇 회인가요?");

    private final String message;

    InputViewType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}