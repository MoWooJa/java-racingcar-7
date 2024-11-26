package racingcar.model.parser;

import racingcar.exception.ExceptionType;
import racingcar.exception.InputException;
import racingcar.model.Round;

public class InputRoundParser {

    public static final int MAX_ROUND = 1000;

    public Round parseToRound(String inputRound) {
        return new Round(validateAndParse(inputRound));
    }

    private static int validateAndParse(String inputRound) {
        try {
            int round = Integer.parseInt(inputRound);
            validateRange(round);
            return round;
        } catch (NumberFormatException e) {
            throw new InputException(ExceptionType.INVALID_ROUND_EXCEPTION.getAnnounce());
        }
    }

    private static void validateRange(int round) {
        if (round > MAX_ROUND || round < 0) {
            throw new InputException(ExceptionType.INVALID_ROUND_EXCEPTION.getAnnounce());
        }
    }
}
