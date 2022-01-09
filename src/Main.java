import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 11047번 동전 0
    // 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
    // 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
    // 가지고 있는 동전을 활용해서 특정 금액을 최소의 동전개수를 이용해 만드는 문제
    // 최소의 동전을 활용하기 위해서는 큰 단위의 동전을 많이 사용해야 하니까 가장 큰 단위부터
    // 채워가면서 활용하는 간단한 문제라고 생각했다.
    // 처음에는 아래처럼 코드를 구현했는데 이런식으로하니 idx가 -1까지 가다보니 배열 범위를 벗어난다ㅠㅠ
//    while(K != 0){
//        K -= money[idx];
//        coin++;
//
//        if(K == 0) break;
//        while(K < money[idx]){
//            idx--;
//        }
//    }

    // 그 후에는 아래처럼 구현했다. idx로 가장 큰 단위를 구하고 for문을 돌렸는데 계속 오류가 발생했다.
    // 단위만큼의 숫자를 빼는 등 로직이 맞는 것 같아서 한참 헤맸는데 idx가 아닌 i를 가지고 확인해야 했다.
    // 어차피 초기 i=idx로 설정을 해놓은 상ㅇ태고 for문을 돌면서 i를 통해 확인을 해야 하는데
    // idx만 체크하니까 가장 큰 단위에서만 계산이 발생했다.
//    for(int i=idx;i>=0;i--){
//        if(money[idx] <= K){
//            coin += (K / money[idx]);
//            K = K % money[idx];
//        }
//    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str," ");

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[] money = new int[N];

        int coin = 0;
        int idx = 0;

        for(int i=0;i<N;i++){
            int delimeter = Integer.parseInt(br.readLine());
            money[i] = delimeter;
        }

        for(int i=N-1;i>=0;i--){
            if(money[i] <= K){
                idx = i;
                break;
            }
        }

        for(int i=idx;i>=0;i--){
            if(money[i] <= K){
                coin += (K / money[i]);
                K = K % money[i];
            }
        }

        System.out.println(coin);
    }
}