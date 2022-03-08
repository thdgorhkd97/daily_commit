import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 피보나치 수
    // 재귀로 구현하려고 했는데 재귀로 구현하게 되면 n자체가 너무 크고 1234567의 나머지가
    // 저장되어야 하다보니 시간초과가 발생하게 된다.
    // 동적 계획법으로 해결했다.

    // programmers level 2 - 기능개발
    // 우선 각 기능별로 종료시킬 수 있는 모든 일자를 구한 뒤에 한번에 배포할 수 있는 기능의 수를 구한다,
    // 예를 들어 7 3 9 이렇게 있으면 두번째 기능은 3일만에 완료되었으므로
    // 첫번째 기능이 배포될때 두번째 기능까지 배포 가능하므로 2 1 이렇게 정답이 된다.
    // 기능이 완료되는 일자를 비교해가면서 한 번에 배포 가능한 기능을 list에 넣고
    // 마지막으로 남은 기능의 수를 넣으면 완성




    public static void main(String[] args) throws IOException {

        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};

        int length = progresses.length;
        int[] successDays = new int[length];

        for(int i=0;i<length;i++){ // 완료 일자 구하는 for문
            int day = 0;
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                day++;
            }
            successDays[i] = day;
        }

        int cnt = 1;
        int num = successDays[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i< successDays.length;i++){
            if(successDays[i] <= num){ // 이미 구현되어 있는 기능이 있는지 확인
                cnt++;
            }
            else{
                list.add(cnt);
                cnt = 1;
                num = successDays[i];
            }
        }

        list.add(cnt);

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        /* 피보나치 수
        int n = 5;

        int[] fibo = new int[n+1];

        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        if(n > 2){
            for(int i=3;i<=n;i++){
                fibo[i] = fibo[i-1] % 1234567 + fibo[i-2] % 1234567;
                System.out.println(i + " 번째 수는 " + fibo[i]);
            }
        }

        int answer = fibo[n] % 1234567;

         */

    }
}
