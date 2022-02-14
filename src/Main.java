import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 1912 연속합
//    n개의 정수로 이루어진 임의의 수열이 주어진다.
//    우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
//
//    예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
//    여기서 정답은 12+21인 33이 정답이 된다.
    // 2중 for문으로 시작하는 지점부터 끝지점까지 합을 구해서 max값과 비교하는 방식으로 하는 것은
    // n이 100000이하이기 때문에 O(n^2)에서 시간초과가 날 것이라 생각했다.
    // (주석처리한 부분은 n이 작은 경우에 가능한 2중 for문으로 해결한 부분이다)
    // 그래서 n이 크기 때문에 동적 계획법을 이용해야 한다고 생각했고 해당 인덱스까지 더해진 것과
    // 해당 인덱스의 값의 대소 비교를 해서 더 큰 값을 계속 취하는 식으로 진행하였다.

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

//        int max = 0;

//        for(int i=1;i<n;i++){
//            int sum = arr[i];
//            for(int j=i+1;j<=n;j++){
//                sum += arr[j];
//                max = Math.max(max, sum);
//            }
//
//        }

        int[] dp = new int[n+1];

        dp[1] = arr[1];
        int max = arr[1];
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }
}