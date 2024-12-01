package racingcar.util.exception;

public enum ErrorMessage {
    NON_INPUT_EMPTY("[ERROR] 값을 입력해주세요."),
    INPUT_SIZE_OVER("[ERROR] 자동차 이름은 5자를 넘을 수 없습니다."),
    NON_INPUT_NUMERIC("[ERROR] 숫자가 아닌 값은 입력할 수 없습니다."),
    NON_INPUT_ZERO("[ERROR] 0이하의 값을 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
