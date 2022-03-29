import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 카드 구매하기
    // 1 2 3 ... N 까지의 카드팩이 있고 N개의 카드를 구매할 때의 최대값을 구하라
    // 처음에는 N개를 만들 수 있는 N까지의 수를 이용한 경우의 수를 구해서 해당 경우의 수에 해당하는
    // 금액 중 최소를 구하고자 하였다. 근데 해당 방법으로 하면 너무나 복잡해져서 결국 방법을 찾아보았다
    // dp 방식을 활용하되 경우의 수를 구하는 것이 아니라 어차피 경우의 수에 대한 금액을 구하는 것이므로
    // 바로 금액을 구하는 dp 방식을 활용하면 된다.
    // dp의 방식은 카드 x개가 들어있는 카드팩을 구매하게 되면 그 이후로는 카드 N-x개를 구입한다.
    // dp[i] = dp[i-n] + money[n] 으로 구해야 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] money = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        for(int i=1;i<=money.length-1;i++){
            money[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = 0;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j] + money[j]);
//                System.out.println(i + " 번째 " + dp[i]);
            }
        }

        System.out.println(dp[N]);









    }
}
