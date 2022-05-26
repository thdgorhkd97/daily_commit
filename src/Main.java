package src; // daily 폴더를 source root로 인식시켰기 때문에


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java 17427 약수의 합 2
    // N이하의 정수에 대해서 약수의 합을 더하는 프로그램
    // 처음에는 N이하의 모든 정수에 대해서 1부터 for문을 돌면서 약수면 더해나가면서
    // Math.sqrt(N) 까지만 확인하기 때문에 시간이 괜찮을 줄 알았는데 시간초과가 반드시
    // 발생하게 된다.(N이 십만까지 가능하기 때문에)
    // 도저히 dp같은 시간을 줄일 수 있는 방법에 대해 모르겠어서 알아봤는데
    // for문을 돌면서 직접 계산하는 건 시간초과가 발생하기 때문에 약수의 합을 구하는 방식보다
    // 배수를 구하는 식으로 가야한다.
    // 즉, N이하의 정수들을 배수로 가지는 게 몇번인지 구해보자
    // ex) N = 7이면 1~7의 수가 1부터 7까지를 배수로 가지는 게 몇 번인지 구하면 된다.

    static long answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        /*
        for(int i=2;i<=N;i++){
            for(int j=1;j<=Math.sqrt(i);j++){
                if(i % j == 0){
                    answer += j;
                    if(i/j != Math.sqrt(i)) answer += i/j;
                }
            }
//            System.out.println(i + " 까지의 " + answer);
        }

         */

        for(int i=1;i<=N;i++){
            answer += i * (N/i);
        }
        System.out.println(answer);
    }




}