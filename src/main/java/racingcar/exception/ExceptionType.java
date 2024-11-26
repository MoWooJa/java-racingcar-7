package racingcar.exception;

public enum ExceptionType {

    NAME_LENGTH_EXCEPTION("이름은 5자 이하 1자 이상으로 가능합니다."),
    NAMES_LENGTH_EXCEPTION("최대 입력 가능 이름 개수는 100개 입니다."),
    INVALID_CAR_NAMES_CHAR_EXCEPTION("한글(자음 모음은 불가),영어,숫자의 조합으로 "
            + "이름이 이루어져야 하며 이외 입력은 구분자(,)만 가능합니다."),

    INVALID_ROUND_EXCEPTION("시도 횟수는 1000이하 0 이상 숫자만 입력 가능합니다.");

    private final String announce;

    ExceptionType(String announce) {
        this.announce = announce;
    }

    public String getAnnounce() {
        return this.announce;
    }
}
