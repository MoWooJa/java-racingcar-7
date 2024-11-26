package racingcar.model;

import java.util.List;

public class RaceStatus {

    public static final String CAR_STATUS_FORMAT = " : ";
    public static final String POSITION_MARKER = "-";
    private final List<CarStatus> raceStatus;

    public RaceStatus(List<CarStatus> raceStatus) {
        this.raceStatus = raceStatus;
    }

    public List<String> getRoundResult() {
        return raceStatus.stream()
                .map(this::roundResultFormatting)
                .toList();
    }

    private String roundResultFormatting(CarStatus carStatus) {
        String name = carStatus.getName();
        String positionResult = getRoundPositionResult(carStatus);
        return name + CAR_STATUS_FORMAT + positionResult;
    }

    private String getRoundPositionResult(CarStatus carStatus) {
        int position = carStatus.getPosition();
        return POSITION_MARKER.repeat(position);
    }
}
