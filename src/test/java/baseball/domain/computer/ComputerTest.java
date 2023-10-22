package baseball.domain.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private static final Computer computer = new Computer();

    @Test
    @DisplayName("사용자가 정답을 입력하면 참을 반환합니다.")
    void isAnswer() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(3);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(3);

        // WHEN
        boolean answer = computer.isAnswer(userInputs, randomNumbers);

        // THEN
        assertThat(answer).isEqualTo(true);
    }

    @Test
    @DisplayName("볼,스트라이크 상태 문자열 반환합니다.")
    void showResult() {
    }

    @Test
    @DisplayName("볼, 스트라이크 여부를 판별합니다.")
    void testBallAndStrike() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(3);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(3);
        randomNumbers.add(2);
        randomNumbers.add(1);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 여부를 판별합니다.")
    void testBall() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(8);
        userInputs.add(3);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(9);
        randomNumbers.add(5);
        randomNumbers.add(1);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 여부를 판별합니다.")
    void testStrike() {
        // GIVEN
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(2);
        userInputs.add(9);
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(1);
        randomNumbers.add(2);
        randomNumbers.add(7);

        // WHEN
        computer.countBallAndStrike(userInputs, randomNumbers);
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        // THEN
        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(2);
    }
}