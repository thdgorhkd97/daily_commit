import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 11048 이동하기
    // 이렇게 이동하는 문제는 몇 번 풀어봤는데 만약 이 문제에서 오른쪽, 아래 , 오른쪽 아래
    // 이렇게 3가지가 아니라 왼쪽으로 이동하는 경우도 포함해야 한다면 상당히 어려울 것 같다
    // 일단 오른쪽, 아래, 오른쪽 아래 이렇게 3가지로만 이동하는 경우에는
    // dp의 위, 왼쪽위, 왼쪽 중에서 가장 큰 것과 map의 해당 위치를 더한 것이 가장 큰 값이므로
    // 해당 경로를 통해 오는 게 가장 많은 걸 챙길 수 있는 경로이다.
    // 예를 들어, 위가 가장 크다면 해당 위치를 방문할때는 위에서 내려오는 게 가장 크다는 것이다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] map = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] dp = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1])) + map[i][j];
            }
        }

//        for(int i=1;i<=N;i++){
//            for(int j=1;j<=M;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N][M]);




    }
}
