import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // JAVA - BOJ 거리

    // 어제부터 고민해보다가 결국 방법을 조금 알아보게 되었다 ㅠㅠ
    // 처음부터 2중 for문은 고려하지 않았는데 N이 1000이하라는 점 시간 제한이 엄격하지 않다는 점에서
    // 2중 for문을 사용하는 것이 괜찮다는 걸 보았고 min으로 dp를 채워나갔다
    // 근데 애초에 dp 배열을 Integer.MAX_VALUE로 채워서 dp를 채워나가다가
    // dp[N-1]이 Integer.MAX 면 -1 해당 인덱스에 거쳐가지 않았다는 것이므로 -1을 반환하면 되겠다
    // 싶었는데 전체를 출력해보니까 일단 dp가 초기화된 인덱스 이후로 이상한 값이 들어갔다..
    // 분명 dp[i]에 진입하지 않는데 dp[i]가 그대로 Integer.MAX가 아니라 절댓값이 크게 차이나지 않는
    // 음수값이 들어갔다.. 아마도 int범위를 넘어가서 뭔가 문제가 생겼나 싶은데
    // 그 과정에서 어떤 문제인지 까지는 도저히 모르겠다 ㅠㅠ
    // 그래서 MAX_VALUE가 아닌 비슷한 큰수를 넣음으로써 해결했다.


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] ch = new char[N];

        String str = br.readLine();

        ch = str.toCharArray();

        int[] dp = new int[N];
        Arrays.fill(dp,2100000000);
        dp[0] = 0;


        for(int i=0;i<N-1;i++){
            int pos = i;
            char c = ch[pos];

            switch(c){
                case 'B' :
                    for(int j=i+1;j<N;j++){
                        int nextIdx = j;
                        char next = ch[j];
                        if(next == 'O'){
                            dp[nextIdx] = Math.min(dp[nextIdx], dp[pos] + (nextIdx-pos) * (nextIdx-pos));
                        }
                    }
                    break;
                case 'O' :
                    for(int j=i+1;j<str.length();j++){
                        int nextIdx = j;
                        char next = ch[j];
                        if(next == 'J'){
                            dp[nextIdx] = Math.min(dp[nextIdx], dp[pos] + (nextIdx-pos) * (nextIdx-pos));
                        }
                    }
                    break;
                case 'J' :
                    for(int j=i+1;j<str.length();j++){
                        int nextIdx = j;
                        char next = ch[j];
                        if(next == 'B'){
                            dp[nextIdx] = Math.min(dp[nextIdx], dp[pos] + (nextIdx-pos) * (nextIdx-pos));
                        }
                    }
                    break;
            }
        }

        if(dp[N-1] != 2100000000){
            System.out.println(dp[N-1]);
        }
        else System.out.println("-1");








    }
}
