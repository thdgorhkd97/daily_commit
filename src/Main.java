import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 1748 수 이어쓰기 1

    // 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
    // 1234567891011121314151617181920212223...
    // 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

    // 처음에는 StringBuffer를 활용해서 N까지의 숫자를 string으로 바꿔서
    // sb.append()를 해서 sb.toString().length를 return 했는데 메모리 초과가 발생한다..

    // 두번째 방법은 for문으로 해서 10 보다 작으면 1자리니까 answer에 1만 더하고
    // 10 <= N < 100 이면 두자리수니까 answer에 2를 더하고 이런 식으로
    // N까지의 for문 중 i의 자리수를 체크해서 더한다.
    // 근데 이렇게 하면 O(N)이라 그런지 답이 잘 나오지 않는다.'

    // 결국 풀이 방법에 대해서 알아보니까 단순히 if - else를 활용하는 것이 아니라
    // 자릿수를 구하기 위해서 자릿수가 언제 바뀌는지만 확인해서 변경하는 식으로 한다.
    // i를 10,100으로 나눴을 때 몫이 0이면 자릿수가 바뀐다.
    // 즉, 자릿수가 바뀔때마다 다음 나눠야 하는 수는 10을 곱하고 다음에 더해줘야 할 자리수는 1을 더한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        /*
        StringBuffer sb = new StringBuffer();

        for(int i=1;i<=N;i++){
            sb.append(String.valueOf(i));
        }

        System.out.println(sb.toString().length());
         */

        /*
        long answer = 0;
        for(int i=1;i<=N;i++){
            if(i < 10) answer += 1;
            else if(10 <= i && i<=99) answer+=2;
            else if(100 <= i && i<=999) answer+=3;
            else if(1000 <= i && i<=9999) answer+=4;
            else if(10000 <= i && i<=99999) answer+=5;
            else if(100000 <= i && i<=999999) answer+=6;
            else if(1000000 <= i && i<=9999999) answer+=7;
            else if(10000000 <= i && i<=99999999) answer+=7;
            else if(i==100000000) answer += 8;
        }

        System.out.println(answer);
        */

        int cnt = 0;
        int plus = 1;
        int num = 10;
        for(int i=1;i<=N;i++){
            if(i % num == 0){
                plus++;
                num *= 10;
            }
            cnt += plus;
        }
        System.out.println(cnt);



    }


}