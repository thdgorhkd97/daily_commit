import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1149 RGB 거리

//    RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//    집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
//    아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//    1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//    N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//    i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    // 동적 계획법으로 아래로 내려가면서 더해서 최소값이 나오도록 하는 로직이 필요하다
    // 근데 규칙에서 그 이전의 색깔을 포함하지 않아야 하기 때문에 dp[i][0]을 구할때는
    // dp[i-1][1], dp[i-1][2] 에 home[i][0] 를 더해서 최소값을 구한다.
    // 즉 아래로 내려가면서 같은 색이 아닌 다른 색에서 내려오는 거에서
    // 최소값을 확보할 수 있도록 한것이다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] home = new int[N][3];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            StringTokenizer stk = new StringTokenizer(str," ");

            for(int j=0;j<3;j++){
                home[i][j] = Integer.parseInt(stk.nextToken());
            }

        }

        int[][] dp = new int[N][3];

        dp[0][0] = home[0][0];
        dp[0][1] = home[0][1];
        dp[0][2] = home[0][2];

        for(int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + home[i][2];
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]));

    }
}