package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements RandomGenerater{
    private String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public void addMove() {
        move++;
    }

    public void startRandomMove() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
            move++;
        }
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }
}
