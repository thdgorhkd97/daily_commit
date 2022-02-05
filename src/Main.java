import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2156 포도주 시식
    // 동적 계획법으로 푸는 문제라는 걸 파악하고 dp 배열을 활용해 해결하려 했다.
    // 근데 한 가지를 간과했던 부분이 있었다.
    // 문제 조건에서 3개의 연속된 포도주를 선택할 수 없기 때문에 연속된 3가지가 불가능 했는데
    // 처음에 내가 구현한 동적 계획법 코드(for문 내의 주석친 부분)을 확인해보면
    // 그 자리를 고르지 않고 이전 2잔을 고르는 OOX 의 경우 -> dp[i-1]
    // 직전 잔을 고르지 않고 그 자리를 고르는 OXO의 경우 -> dp[i-2] + alcohol[i]
    // 까지는 생각했었는데 한 가지 경우가 더 존재했다.
    // 바로 2잔 전을 선택하지 않고 직전 잔과 그 자리를 고르는 XOO 의 경우다
    // -> dp[i-3] + alcohol[i-1] + alcohol[i]가 있다.

    // 이 경우를 빼놓고 2가지 중 최대값을 고르니 정답이 옳지 않았고 하나의 경우는
    // XOO의 경우가 있다는 것을 알고 나서 구현하였다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] alcohol = new int[N+1];
        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(br.readLine());
            alcohol[i] = num;
        }

        int[] dp = new int[N+1];

        dp[1] = alcohol[1];
//        if(N==1) return alcohol[1];
        dp[2] = alcohol[1]+alcohol[2];
//        if(N==2) return dp[2];
        dp[3] = Math.max(dp[2],Math.max(dp[1]+alcohol[3],alcohol[2]+alcohol[3]));

        for(int i=3;i<=N;i++){
//            dp[i] = Math.max(dp[i-1],dp[i-2]+ alcohol[i]);
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+alcohol[i],dp[i-3]+alcohol[i-1]+alcohol[i]));
        }


        System.out.println(dp[N]);


    }
}