package racingcar;

import racingcar.config.Config;
import racingcar.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = Config.createController();
        controller.run();
    }
}
