import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // programmers 줄 서는 방법
    // 어제 대충 자릿수를 구해서 하면 되지 않을가 싶었는데 모든 경우에 통용되는 로직을
    // 모르겠어서 결국 로직을 알아보고서야 해결했다 ㅠㅠ 이해하는데 너무 오래 걸렸다...


    public static void main(String[] args) throws IOException {

        int n = 3;
        long k = 5;

        ArrayList<Integer> list = new ArrayList<>();

        int[] answer = new int[n];

        long factorial = 1;
        for(int i=1;i<=n;i++){
            factorial *= i; // n!을 구함 -> 가능한 모든 경우의 수
            list.add(i);
        }
        k = k-1; // 배열의 idx는 0부터 시작이므로 k=5라면 전체 경우의 수 중 4번째 걸 구해야 한다.

        int idx= 0;
        while(n > 0){ // n--를 해가면서 n번째 까지의 idx를 추가해야 한다. ex) n=3이면 3번째 idx까지 지정
            factorial /= n; // n번째 자리수를 결정

            answer[idx++] = list.get((int) (k/factorial));

            list.remove((int) (k / factorial));
            k %= factorial;

            n--;
        }
        // 처음에 factorial = 2가 되고 (2번째 자리수를 결정한다는 것)
        // answer[idx = 0] = list.get((int) k=5/factorial=2)
        //                 = list.get((int) 2)
        //                 = list.get(2) = 3
        // 그 후 list.remove로 3을 제외한다. 이미 줄 세웠으므로
        // k = 5 % factorial = 2 -> k=1로 변경
        // n = 3에서 2로 변경

        // 2번째 while 문
        // factorial = 1이 되고
        // answer[idx = 1] = list.get((int) k=1/factorial=1)
        //                 = list.get(1) = 1
        // 그 후 list.remove로 1을 제외한다.
        // k = 1 % 1 = 0이 된다.

        // 이런 식으로 n번째 자리를 결정하기 위해서 k/factorial의 list idx를 결정한다.


        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }




    }
}