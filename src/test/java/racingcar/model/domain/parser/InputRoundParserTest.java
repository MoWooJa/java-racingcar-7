package racingcar.model.domain.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionType;
import racingcar.exception.InputException;

class InputRoundParserTest {

    InputRoundParser inputRoundParser = new InputRoundParser();

    @ParameterizedTest
    @MethodSource("generateRoundInputException")
    void 라운드_입력_예외(String input) {
        assertThatThrownBy(() -> inputRoundParser.parseToRound(input))
                .isInstanceOf(InputException.class).hasMessage(InputException.INVALID_INPUT
                        + ExceptionType.INVALID_ROUND_EXCEPTION.getAnnounce());

    }

    static Stream<Arguments> generateRoundInputException() {
        return Stream.of(
                Arguments.of("1001"),
                Arguments.of("일"),
                Arguments.of("2,1"),
                Arguments.of("-2")
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void 이름_정상_입력(String input) {
        assertThatCode(() -> inputRoundParser.parseToRound(input))
                .doesNotThrowAnyException();
    }
}