import java.util.*;

public class Main {

    // programmers level 3 - 스티커 모으기 (2)
    // 원형으로 연결된 스티커에서 인접한 스티커들은 뜯지 못하기 때문에 맨 처음을 뜯는 경우와 안 뜯는 경우로 나눴다.
    // 처음에는 단순히 맨 처음을 뜯고(맨 뒤는 뜯지 않아야 한다) 그 이후로 한 칸씩 뛰면서 뜯는 것과
    // 맨 처음을 뜯지 않고(맨 뒤를 뜯어야 한다) 그 이후로 한칸씩 뛰어가며 뜯는 것을 비교했는데
    // 이렇게 하니 특수한 케이스를 포함할 수 없었다.(홀수번째만 뜯어가야 하는 케이스 ex 1 5 2 9 3
    // 그래서 동적 계획법을 구상했다.
    // 직전을 뜯으면 현재를 뜯을 수 없으므로 dp[i-1] 이고 전전을 뜯으면 현재를 뜯을 수 있으므로 dp[i-2] + sticker[i] 가 된다.
    // 즉 동적 계획법을 구상하고 맨 앞을 뜯는 것과 안 뜯는 것 중에서 max 값을 구한다.

    public static void main(String[] args) {

        int[] sticker = {14,6,5,11,3,9,2,10};

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        // 첫 번째 스티커를 뜯었을 때
        // 첫번째거 뜯으니까 맨 뒤는 넣지 않는다.
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i=2;i< sticker.length-1;i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+ sticker[i]);
        }

        // 첫 번째 스티커를 뜯지 않았을 때
        // 첫번째를 뜯지 않았으니까 맨 뒤를 뜯는다.
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }

        int answer = Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);

        System.out.println(answer);

    }
}