package racingcar.model.domain;

public class Round {

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public boolean isDone() {
        return round == 0;
    }

    public void oneRoundDone() {
        round--;
    }
}
