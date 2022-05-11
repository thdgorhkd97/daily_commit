import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 9020 골드바흐의 추측
    // 정해진 수를 2로 나눈다음 해당 수의 양쪽을 +1/ -1해가면서
    // 그 두 수가 소수인지를 파악한다.
    // 양쪽에 +1/-1을 했기 때문에 합은 무조건 맞을 것이고 두 수가 소수인지는
    // isPrime[] 배열에서 해당하는 인덱스가 true/false 를 확인하면 되기 때문에
    // 내가 처음에 생각했던 합이 일치하는지를 파악하고 그게 소수인지를 보는 것보다
    // 훨씬 단순하게 구현가능했다

    public static boolean[] isPrime = new boolean[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Erathostenes(); // 에라토스테네스의 체로 isPrime의 범위에 있는 소수를 판별

        int T = Integer.parseInt(br.readLine());	// 테스트케이스

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int first_partition = n / 2;
            int second_partition = n / 2;

            while (true) {

                // 두 파티션이 모두 소수일 경우
                if (!isPrime[first_partition] && !isPrime[second_partition]) {
                    System.out.println(first_partition + " " + second_partition);
                    break;
                }
                first_partition--;
                second_partition++;
            }
        }

    }

    // 에라토스테네스의 체
    public static void Erathostenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i])
                continue;
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }

}