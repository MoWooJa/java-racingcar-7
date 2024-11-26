package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionType;
import racingcar.exception.InputException;
import racingcar.model.parser.InputCarNamesParser;

class InputCarNamesParserTest {

    InputCarNamesParser inputCarNamesParser = new InputCarNamesParser();

    @ParameterizedTest
    @MethodSource("generateCarNamesInputException")
    void 이름_입력_예외(String input, String message) {
        assertThatThrownBy(() -> inputCarNamesParser.parse(input))
                .isInstanceOf(InputException.class).hasMessage(message);

    }

    static Stream<Arguments> generateCarNamesInputException() {
        return Stream.of(
                Arguments.of("12,준팍,도밥,고니,수아,,",
                        InputException.INVALID_INPUT + ExceptionType.NAME_LENGTH_EXCEPTION.getAnnounce()),
                Arguments.of("12,준팍,도밥,고니,수아,&ab,",
                        InputException.INVALID_INPUT + ExceptionType.INVALID_CAR_NAMES_CHAR_EXCEPTION.getAnnounce()),
                Arguments.of("12,준팍,도밥,고니,수아,  ,",
                        InputException.INVALID_INPUT + ExceptionType.INVALID_CAR_NAMES_CHAR_EXCEPTION.getAnnounce()),
                Arguments.of("12,준팍,도밥,고니,수아,ㄱㄴ,",
                        InputException.INVALID_INPUT + ExceptionType.INVALID_CAR_NAMES_CHAR_EXCEPTION.getAnnounce())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 이름_정상_입력(String input) {
        assertThatCode(() -> inputCarNamesParser.parse(input))
                .doesNotThrowAnyException();
    }

}