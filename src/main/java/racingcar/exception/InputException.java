package racingcar.exception;

public class InputException extends IllegalArgumentException {

    public static final String INVALID_INPUT = "[ERROR] 잘못된 입력입니다. ";

    public InputException(String message) {
        super(INVALID_INPUT + message);
    }
}
