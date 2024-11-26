package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.ExceptionType;
import racingcar.exception.InputException;

public class InputCarNamesParser {

    private static final String VALID_INPUT_REGEX = "[^a-zA-Z0-9가-힣,]";
    public static final int MAX_NAME_LENGTH = 5;
    public static final String SEPARATOR = ",";
    public static final int MAX_NUMBER_OF_NAMES = 100;
    public static final String EMPTY_NAME_FINDER_REGEX = ",,";

    public List<String> parse(String namesInput) {
        validateInValidCharacter(namesInput);
        validateEmptyName(namesInput);
        validateNumberOfNames(namesInput);
        return Arrays.stream(namesInput.split(SEPARATOR))
                .peek(this::validateNameLength)
                .toList();
    }

    private static void validateEmptyName(String namesInput) {
        Pattern pattern = Pattern.compile(EMPTY_NAME_FINDER_REGEX);
        Matcher matcher = pattern.matcher(namesInput);
        if (matcher.find()) {
            throw new InputException(ExceptionType.NAME_LENGTH_EXCEPTION.getAnnounce());
        }
    }

    private void validateNumberOfNames(String namesInput) {
        if (namesInput.split(SEPARATOR).length > MAX_NUMBER_OF_NAMES) {
            throw new InputException(ExceptionType.NAMES_LENGTH_EXCEPTION.getAnnounce());
        }
    }

    private void validateInValidCharacter(String input) {
        Pattern pattern = Pattern.compile(VALID_INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InputException(ExceptionType.INVALID_CAR_NAMES_CHAR_EXCEPTION.getAnnounce());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InputException(ExceptionType.NAME_LENGTH_EXCEPTION.getAnnounce());
        }
    }
}
