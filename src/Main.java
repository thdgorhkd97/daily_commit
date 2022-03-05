import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // S 교육 coding test 문제 중 하나
    // N이 주어지고 각 식단이 주어지면 겹치지 않는 식단 중에서 3끼 식사의 칼로리 합이 2000에서 2500인 경우의 수 구하기
    // 각 식단의 칼로리가 주어진다.

    // 이 문제를 나는 3중 for문을 활용해서 겹치지 않는 식단 부분을 해결하였는데 시간초과를 우려해서 시간을
    // 줄이려고 해서 문제를 제출했는데 이게 실제로 실행시간에 유의미한 차이가 있는지 확인해보고자 한다.

    // 1번 실험. N = 3000
    // sum이 2500을 넘어가면 break 하는 부분이 없을 때 4초
    // sum이 2500을 넘어가면 break 하는 부분이 있을 때 0초

    // 2번 실험. N = 6000
    // sum이 2500을 넘어가면 break 하는 부분이 없을 때 37초
    // sum이 2500을 넘어가면 break 하는 부분이 있을 때 0초

    // money 배열에 50정도씩 계속 더해가면서 값을 넣은 거라서 원소의 값이 더 차이나는
    // 실제 케이스에서는 좀 더 이 차이가 줄어들 수도 있겠지만 우선 시간을 줄이는 부분은
    // 확실하다고 생각한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int[] money = new int[N];

//        for(int i=0;i<N;i++){
//            money[i] = Integer.parseInt(stk.nextToken());
//        }

        Arrays.sort(money);

        long beforeTime = System.currentTimeMillis();

        int value = 200;

        for(int i=0;i<N;i++){
            money[i] = value;
            value += 50;
        }

        int cnt = 0;
        for(int i=0;i<money.length;i++){
            for(int j=i+1;j<money.length;j++){
                for(int k=j+1;k<money.length;k++){
                    int sum = money[i] + money[j] + money[k];
                    if(sum>=2000 && sum <= 2500){
                        cnt++;
                    }
                    else if (sum > 2500) {
                        // money[k] 이후로는 money[k]보다 크기 때문에 sum이 2500을 초과하면
                        // 더 이상 i j 는 고정된 채로 k만 증가시키면서 확인할 필요가 없다.
                        // 3중 for문의 시간을 줄이기 위해서 추가한 부분
                        break;

                    }

                }
            }
        }

        System.out.println("정답 : " + cnt);

        long afterTime = System.currentTimeMillis();
        long DiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간 : " + DiffTime);

    }
}
