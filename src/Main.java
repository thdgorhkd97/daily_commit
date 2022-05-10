import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java 골드바흐의 추측
    // 에라토스테네스의 체를 구현하는데 생각보다 오래걸렸다 ㅠㅠ
    // 저 부분을 소수인지 아닌지를 나는 확인을 따로 했는데 그게 시간을 많이 잡는 것 같다
    // 골드바흐의 추측을 하다 끝났는데 내일 마무리 해야겠다..

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[1000001]; // 소수를 false로 남게 한다
        EratosTenes(isPrime);

        for(int i=0;i<isPrime.length;i++){
            if(!isPrime[i]) System.out.println(i);
        }

        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n== 0) break;

            goldbache(n,isPrime);
        }




    }

    private static void EratosTenes(boolean[] isPrime) {

        // 소수는 false
        // 1은 소수가 아니므로 제외
        isPrime[0] = isPrime[1] = true;

        for(int i=2; i*i<=isPrime.length-1; i++){
            // prime[i]가 소수라면
            if(!isPrime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=isPrime.length-1; j+=i) isPrime[j] = true;
            }
        }


    }

    private static void goldbache(int n,boolean[] isPrime) {

        // 처음은 for(int i=0;i<n;i++)
        // 시간이 너무 많이 걸려서 boolean[] isPrime을 봤는데...

    }
}
