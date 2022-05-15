package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 11726 2xn 타일링
    // 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오

    // 일단 감이 안 잡혀서 n=2,n=3,n=4 일때를 직접 구해봤다
    // n = 5일때까지는 값을 구할 수 있었는데 n=6 부터는 값을 구한 게 확실히 다른 경우가
    // 없는건지 확신을 할 수 없었다.
    // 근데 테스트케이스를 보면 n=9일때가 있어서 n=5일때까지의 규칙과
    // n=9 일때를 인위적으로 비교해보았다
    // 그래서 솔직히 dp[i] = dp[i-1] + dp[n-2] 라는 규칙을 100% 확신하고 사용하지 못했다 ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // n = 2 -> 2
        // n = 3 -> 3
        // n = 4 -> 5
        // n = 5 -> 8

        // n = 6 -> ? 13?
        // n = 7 -> ? 21?
        // n = 8 -> ? 34?

        // n = 9 -> 55

        if(N == 1) {
            System.out.print("1");
        }
        else if(N==2){
            System.out.print("2");
        }
        else {

            int[] dp = new int[N + 1];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }

            System.out.print(dp[N] % 10007);
        }

    }
}