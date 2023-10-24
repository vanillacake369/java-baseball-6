package baseball;

import baseball.domain.game.GameOption;
import baseball.domain.game.GameService;
import baseball.domain.user.User;
import baseball.domain.utils.RandomGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static GameService gameService = GameService.getInstance();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 랜덤수 리스트 생성
            List<Integer> randomNumbers = RandomGenerator.getRandomNumbers();

            System.out.println(randomNumbers.toString());

            // 게임 싸이클 시작
            gameService.startGame(randomNumbers);

            // 게임 완료 후
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 재시작 여부
            String userOption = Console.readLine();
            Integer wouldRestartGame = User.getWouldRestartGame(userOption);
            System.out.println(wouldRestartGame);

            // 재시작 / 종료 실행
            if (wouldRestartGame == GameOption.END.getOption()) {
                // 게임 종료 안내
                System.out.println("게임 종료");
                break;
            }
        }

    }

    // 인스턴스 메모리 해제
    private static void closeAll() {
        gameService = null; //gc가 collect 할 수 있게함
        Console.close();
    }
}