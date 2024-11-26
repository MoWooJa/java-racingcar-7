package racingcar.view.outputview;

import java.util.List;

public class WinnerView implements OutputView {

    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";
    public static final int ONLY_ONE_WINNER = 1;
    public static final String SEPARATOR = ", ";

    private final List<String> winners;

    public WinnerView(List<String> winners) {
        this.winners = winners;
    }

    private String formatWinners() {
        if (onlyOnewWinner()) {
            return winners.getFirst();
        }
        return String.join(SEPARATOR, winners);
    }

    private boolean onlyOnewWinner() {
        return winners.size() == ONLY_ONE_WINNER;
    }

    @Override
    public void display() {
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, formatWinners()));
    }
}
