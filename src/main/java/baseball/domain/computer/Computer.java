package baseball.domain.computer;

import baseball.domain.game.Input;
import baseball.domain.user.User;

import java.util.List;
import java.util.Objects;

public class Computer {
    private int ballCount;
    private int strikeCount;

    // 사용자가 정답을 입력하면 참을 반환
    public boolean isAnswer(List<Integer> userInputs, List<Integer> randomNumbers) {
        countBallAndStrike(randomNumbers, userInputs);
        if (this.strikeCount == Input.NUMLENGTH.getLength())
            return true;
        return false;
    }

    // 볼, 스트라이크 여부를 판별
    public void countBallAndStrike(List<Integer> randomNumbers, List<Integer> userInputs) {
        for (int i = 0; i < Input.NUMLENGTH.getLength(); i++) {
            for (int j = 0; j < Input.NUMLENGTH.getLength(); j++) {
                if (Objects.equals(randomNumbers.get(i), userInputs.get(j))) {
                    if (i == j) {
                        this.strikeCount++;
                    } else
                        this.ballCount++;
                }
            }
        }
    }

    // 볼,스트라이크 상태 문자열 반환
    public String showResult() {
        if (ballCount > 0 && strikeCount > 0) {
            // return 볼 && 스트라이크
            return String.format("$s볼 $s스트라이크", ballCount, strikeCount);
        }
        if (strikeCount > 0) {
            // return 스트라이크
            return String.format("$s스트라이크", strikeCount);
        }
        if (ballCount > 0) {
            // return 볼
            return String.format("$s볼", ballCount);
        } else {
            return "낫싱";
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    // 상태 초기화
    protected void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

}
