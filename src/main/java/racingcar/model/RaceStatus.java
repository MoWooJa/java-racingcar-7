package racingcar.model;

import java.util.List;

public class RaceStatus {

    public static final String CAR_STATUS_FORMAT = " : ";
    public static final String POSITION_MARKER = "-";
    public static final int MIN_POSITION = 0;

    public final List<CarStatus> raceStatus;

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

    public List<String> getLeaders() {
        int leadPosition = getLeadPosition();
        return raceStatus.stream()
                .filter(carStatus -> carStatus.getPosition() == leadPosition)
                .map(CarStatus::getName).toList();
    }

    private int getLeadPosition() {
        int leadPosition = MIN_POSITION;
        for (CarStatus status : raceStatus) {
            leadPosition = getLeadPosition(status.getPosition(), leadPosition);
        }
        return leadPosition;
    }

    private int getLeadPosition(int position, int leadPosition) {
        if (leadPosition < position) {
            leadPosition = position;
        }
        return leadPosition;
    }

    public static void main(String[] args) {
        RaceStatus test = new RaceStatus(List.of(new CarStatus("dd", 9),
                new CarStatus("tt", 9), new CarStatus("ss", 8)));
        System.out.println(test.getLeadPosition());
        System.out.println(test.raceStatus.stream().filter(h -> h.getPosition() == test.getLeadPosition())
                .map(CarStatus::getName).toList()
                .toString());
    }
}
