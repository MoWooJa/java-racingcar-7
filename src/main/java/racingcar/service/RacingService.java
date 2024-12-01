package racingcar.service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import racingcar.config.DomainFactory;
import racingcar.domain.Car;

public class RacingService {
    public RacingService(DomainFactory domainFactory) {
    }

    public void racingGetRandom(List<Car> cars) {
        for (Car car : cars) {
            car.startRandomMove();
        }
    }

    public StringBuilder createGameProgressView(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ").append(calculateMoveCount(car)).append("\n");
        }
        return sb;
    }

    private StringBuilder calculateMoveCount(Car car) {
        int moveNumCount = car.getMove();
        StringBuilder moveCount = new StringBuilder();
        for (int i = 0; i < moveNumCount; i++) {
            moveCount.append("-");
        }
        return moveCount;
    }

    public StringBuilder getRacingWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");

        Deque<String> winners = new ArrayDeque<>();
        int maxWinningCount = 0;

        for (Car car : cars) {
            int carMoveCount = car.getMove();
            if (carMoveCount == maxWinningCount) {
                winners.addLast(", " + car.getName());
            }
            if (carMoveCount > maxWinningCount) {
                maxWinningCount = carMoveCount;
                winners.clear();
                winners.add(car.getName());
            }
        }
        for (String winner : winners) {
            sb.append(winner);
        }
        return sb;
    }
}
