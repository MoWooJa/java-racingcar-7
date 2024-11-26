package racingcar.model.car;

import racingcar.model.RaceStatus;

public class Car {

    public static final int MOVEABLE = 4;
    public static final String SEPARATOR = ",";

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVEABLE) {
            position++;
        }
    }

    public RaceStatus getStatus() {
        return new RaceStatus(name, position);
    }
}
