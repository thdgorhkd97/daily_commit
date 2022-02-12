import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 10844 baekjoon 쉬운 계단 수

    // 45656이란 수를 보자.
    // 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
    // N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

    // 처음에는 dfs로 접근해서 하나 차이나는 경우를 더해가면서 자릿수가 N이 될때까지 반복하는 식으로
    // 접근했었는데 잘 풀리지 않았다... 그래서 결국 고민하다가 어떻게 접근해야 하는지 확인을 하고 말았다
    // dp로 접근해서 동적계획법으로 풀었어야 하는데 길이와 0,9일때를 신경써야 했다.
    // 2차원배열인 dp 의 의미는 dp[길이][마지막 자리수의 계단 수] 이렇게 된다.
    // 맨 마지막 수가 0이거나 9라면 위아래가 아니라 1과 8만 올수있기때문에 이 경우를 제외하고는
    // dp[i][j] = dp[i-1][j-1] + dp[i+1][j+1] 로 처리되어야 한다.
    // 동적 계획법 문제인데 이걸 처리하는 게 생각보다 어려웠다.
    // 동적 계획법을 많이 해봐서 조금 한다고 생각했는데 여러 분야에 응용이 가능하기 때문에
    // 역시 끝까지 해봐야 알 것 같다 ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        for(int i=1; i<= 9; i++){
            dp[1][i] = 1; // 길이가 1이면 무조건 1이 된다(초기화)
        }

        for(int i=2; i<= N;i++){
            for(int j=0;j<=9;j++){
                if(j== 0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }
                else {
                    dp[i][j] = ( dp[i-1][j-1] + dp[i-1][j+1] ) % 1000000000;
                }
            }
        }

        long answer = 0;
        for(int i=0;i<10;i++){
            answer += dp[N][i];
        }

        System.out.println(answer % 1000000000);

    }
}