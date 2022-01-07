import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//              X가 3으로 나누어 떨어지면, 3으로 나눈다.
//              X가 2로 나누어 떨어지면, 2로 나눈다.
//              1을 뺀다.
//    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

//              X = 10 인 경우
//            1
//            1
//            2         오답  정답
//            5     :    0    3
//            6     :    1    2
//            7     :    0    3
//            8     :    1    3
//            9     :    2    2
//            10    :    1    3

    // baekjoon 1로 만들기
    // 먼저 내가 잘못 생각한 부분은 빨리 1로 만들어야 하기 때문에 최대한 3으로 나누거나 2로 나누는 경우를 먼저 체크했다는 것이다.
    // 예시에서도 나오지만 10의 경우 2로 먼저 나눠서 5로 가는 거보다 1을 먼저 빼고 9를 3으로 나누는 경우가 더 최소의 경우다.
    // 따라서 3가지의 경우를 모두 체크할 수 있어야 하기 때문에 동적계획법을 활용한다.
    // 이런 부분에서 내가 가장 먼저 생각한 부분은 2의 배수라면 dp[i/2]와 dp[i-1] 중 더 작은 값에서 1을 더해야 한다는 것인데
    // 로직은 맞는 것 같은데 오답이 생겼다...
    // 그래서 답과 비교해보니 답은 내 생각과는 다르게 dp[i] = dp[i-1] + 1을 if문 밖으로 빼서 계산하고 Math.min을 확인했다.
    // 내 경우와 다른게 뭘까 싶어서 10을 넣어서 확인했는데 5에서부터 정답과 달랐다....
    // 생각해보니까 5의 경우 if에 걸리지 않으니까 if에 해당해야만 초기화를 하는 나의 코드에서는 5에 대한 경우에 0을 삽입하는 걸 확인할 수 있었다.
    // 그렇기 때문에 dp[i] = dp[i-1]+1 을 if문 밖으로 빼서 2나 3의 배수가 아닐 경우 1을 더한다는 문제의 조건을 챙겼어야 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X+1];

        dp[0] = 0;
        dp[1] = 0;

        // 내가 생각한 코드
//        for(int i=2;i<=X;i++){
//            if(i % 2 == 0){
//                dp[i] = Math.min(dp[i-1]+1,dp[i/2]+1);
//            }
//            if(i % 3 == 0){
//                dp[i] = Math.min(dp[i-1]+1,dp[i/3]+1);
//            }
//        }

        // 정답 코드
        for (int i = 2; i <= X; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        for(int i=2;i<=X;i++){
            System.out.println(dp[i]);
        }

    }



}