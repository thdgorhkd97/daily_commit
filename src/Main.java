import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 2579 계단 오르기(baekjoon)

//    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//    마지막 도착 계단은 반드시 밟아야 한다.
//    따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다.
//    하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

    // 동적계획법 문제인데 마지막 계단을 반드시 밟아야 한다는 조건때문에 dp로만 만들어지는게 아니라
    // stair[T] 원소를 더해야 하는 조건을 추가했다.
    // 동적계획법을 많이 풀면서 어느정도 일정한 규칙에 따라서 원소를 채워가는 형식에는
    // 어느정도 익숙해진것 같은데 원소의 개수가 초과되는 ArrayIndexOutOfBound 오류가
    // 자주 발생해서 이 오류를 위해 if문으로 분기문을 만들어야 하는 게 번거로운 것 같다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] stair = new int[T+1];

        for(int i=1;i<=T;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[T+1];

        dp[0] = stair[0];
        dp[1] = stair[1];
        if(T >= 2 ) {
            dp[2] = stair[1] + stair[2];

            for (int i = 3; i <= T; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
            }
        }

        System.out.println(dp[T]);

    }
}