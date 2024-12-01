package racingcar.util.validate;

import racingcar.util.exception.ErrorMessage;

public class Validate {
    public static void validateInputCars(String input) {
        validateInputIsEmpty(input);
        if (input.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIZE_OVER.getMessage());
        }
    }

    private static void validateInputIsEmpty(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.NON_INPUT_EMPTY.getMessage());
        }
    }

    public static void validateInputCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_INPUT_ZERO.getMessage());
        }
    }
}
