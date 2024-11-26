package racingcar.model.domain;

import java.util.List;

public class RacingJudge {
    public List<String> getWinners(List<RaceStatus> raceResult) {
        // 확장성,,? 일반성,,? 위해 RaceStatus는 winner를 특정 x 선두를 뽑도록
        // judge에서는 결과의 마지막 뽑아서 우승자 뽑도록 특정함
        RaceStatus lastRoundRace = raceResult.getLast();
        return lastRoundRace.getLeaders();
    }
}
