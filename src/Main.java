import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    // java baekjoon 16194 카드 구매하기 2
    // 처음에는 단순히 구하고자 하는 N을 곱해서 만들 수 있는 것에 대해서만 고려했다.
    // 즉 N이 10이면 1,2,5,10 만 보면서 몫을 곱해서 최소를 구했는데 틀렸다는 걸 보니
    // 숨겨진 테스트 케이스에 대해서는 이것저것 합쳐서 답으로 도출되는 경우가 있는 것으로 보인다.

    // 결국 주어진 N을 만들 수 있는 모든 경우의 수에 대해서 고려해야 했다.
    // dp에 저장된 값에서 dp[i] = dp[i-j] + arr[j] 를 통해 구했다.
    // ex) dp[5] = dp[3] + arr[2] 이건 5장을 만들 수 있는 경우를 구하려면
    //     for문을 돌면서 i-j 장을 만들 수 있는 최소의 경우에 j 장의 가격을 더해서
    //     최소값을 구하는 식으로 for문을 돈다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i=1;i<=N;i++){
            dp[i] = arr[i];
            for(int j=1;j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j] + arr[j]);
            }

        }

        System.out.println(dp[N]);

    }
}