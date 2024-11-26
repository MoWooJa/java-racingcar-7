package racingcar.model.car;

public class Car {

    public static final int MOVEABLE = 4;

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
}
