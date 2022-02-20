import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2231 분해합

//    어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
//    어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
//    예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
//    물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
//    자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

    // 가장 작은 생성자를 구해야 하기 때문에 for문을 1부터 돌면서 해당 숫자에 대한 분해합이 N과 일치하는지
    // 확인하는 식으로 진행하였다. 근데 문제 자체는 되게 간단한데 for문을 N번 돌아야만 하는건가 싶어서
    // 시간을 줄일 수 있는 방법에 대해서 더 고민해보았다.
    // 분해합을 구하는 방법은 줄일 부분이 없는 것 같다. 각 자릿수를 구해야 하기 때문에 Array로 바꿔서 더하는 방식을
    // 생각했지만 array에 넣고 index를 돌면서 더하나 다른 변수에 대입하고 나눠가면서 더하나 시간은 같다.
    // 그렇다면 분해합으로 될 수 있는 범위가 나눠질 가능성이 있을까? 라고 생각했는데 처음에 나는
    // 절반 이상이면 괜찮겠지라고 생각했는데 이건 느낌이었고 좀 더 알아보니
    // 분해합이라는 건 각 수에 자릿수를 더한 것이기 떄문에 각 자릿수는 0~9 까지니까 최댓값은 9이다.
    // 따라서 N - ( 9 * 자리수 ) 를 시작 인덱스로 지정하는 것이 가능하다는 소리다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        /*
        for(int i=N/2;i<=N;i++){
            if(BoonHaeHap(i,N)){
                answer = i;
                break;
            }
        }
         */

        int cnt = 0,number = N;
        while(number > 0){ // 자릿수 구하기
            number = number / 10;
            cnt++;
        }

        for(int i= (N - (cnt * 9));i<=N;i++){
            if(BoonHaeHap(i,N)){
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }

    static public boolean BoonHaeHap(int num,int N){

        int boonhaehap = num;

        int number = num;
        while(num > 0){
            boonhaehap += num % 10;
            num = num / 10;
        }

//        System.out.println(number+" 의 분해합 = " + boonhaehap);
        if(boonhaehap == N) return true;
        else return false;
    }
}