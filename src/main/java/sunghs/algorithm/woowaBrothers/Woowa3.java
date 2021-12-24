package sunghs.algorithm.woowaBrothers;

/**
 * 포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠습니다.
 * 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었습니다. 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 합니다. 페이지 번호 게임의 규칙은 아래와 같습니다.
 * <p>
 * 1. 책을 임의로 펼칩니다.
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구합니다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구합니다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 합니다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자입니다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않습니다.
 * 포비와 크롱이 펼친 페이지가 들어있는 배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성해주세요.
 * <p>
 * 제한사항
 * pobi와 crong의 길이는 2입니다.
 * pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있습니다.
 * 입출력 예
 * pobi	crong	result
 * [97, 98]	[197, 198]	0
 * [131, 132]	[211, 212]	1
 * [99, 102]	[211, 212]	-1
 * 입출력 예 설명
 * 입출력 예 #1
 * 포비의 점수는 72점, 크롱의 점수도 72점이므로 무승부입니다.
 * <p>
 * 이름	왼쪽 페이지 각 자리 숫자의 합	왼쪽 각 자리 숫자의 곱	오른쪽 페이지 각 자리 숫자의 합	오른쪽 각 자리 숫자의 곱
 * 포비	16	63	17	72
 * 크롱	17	63	18	72
 * 입출력 예 #2
 * 포비의 점수는 6점, 크롱의 점수는 5점이므로 포비의 승리입니다.
 * <p>
 * 이름	왼쪽 페이지 각 자리 숫자의 합	왼쪽 각 자리 숫자의 곱	오른쪽 페이지 각 자리 숫자의 합	오른쪽 각 자리 숫자의 곱
 * 포비	5	3	6	6
 * 크롱	4	2	5	4
 * 입출력 예 #3
 * 포비가 펼친 페이지의 왼쪽 페이지 번호는 99, 오른쪽 페이지 번호는 102입니다. 올바른 페이지 번호가 아니므로 예외사항에 해당됩니다.
 */
public class Woowa3 {
    public static int solve(int[] pobi, int[] crong) {
        // 포비, 크롱 왼쪽 번호가 홀수면서 각 오른쪽번호가 반드시 왼쪽번호의 + 1 이어야 함
        if (pobi[0] % 2 == 1 && crong[0] % 2 == 1 && pobi[0] + 1 == pobi[1] && crong[0] + 1 == crong[1]) {
            int leftPobi = Math.max(sum(pobi[0]), mul(pobi[0]));
            int rightPobi = Math.max(sum(pobi[1]), mul(pobi[1]));
            int leftCrong = Math.max(sum(crong[0]), mul(crong[0]));
            int rightCrong = Math.max(sum(crong[1]), mul(crong[1]));

            int maxPobi = Math.max(leftPobi, rightPobi);
            int maxCrong = Math.max(leftCrong, rightCrong);

            if (maxPobi > maxCrong) {
                return 1;
            } else if (maxPobi == maxCrong) {
                return 0;
            } else {
                return 2;
            }
        } else {
            return -1;
        }
    }

    /**
     * 각자릿수의 합
     * @param digit 숫자
     * @return 자릿수의 합
     */
    private static int sum(int digit) {
        int result = 0;
        while (digit != 0) {
            result += digit % 10;
            digit /= 10;
        }
        return result;
    }

    /**
     * 각자릿수의 곱
     * @param digit 숫자
     * @return 자릿수의 곱
     */
    private static int mul(int digit) {
        int result = 1;
        while (digit != 0) {
            result *= digit % 10;
            digit /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Woowa3.solve(new int[]{97, 98}, new int[]{197, 198}));
        System.out.println(Woowa3.solve(new int[]{131, 132}, new int[]{211, 212}));
        System.out.println(Woowa3.solve(new int[]{99, 102}, new int[]{211, 212}));
    }
}
