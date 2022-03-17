import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 1931 회의실 배정

    // 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
    // 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
    // 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    // 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

    // 회의시간이 주어지고 가장 많은 회의를 진행할 수 있도록 할 때 몇개의 회의를 할수 있겠느냐라는 문제다.
    // 종료시간이 최대한 짧아야지 다른 회의의 시작이 빨라지기 때문에 회의의 종료시간을 기준으로
    // 정렬하고 다음 회의들의 시작 시간이 이전 회의의 종료 시간보다 다음인지를 확인하여
    // 진행할 수 있는 회의인지를 확인하는 식으로 로직을 진행하였다.
    // 근데 도저히 이상한 부분을 모르겠는데 계속해서 문제가 안 풀리길래 결국 풀이를 보고 말았는데
    // 문제에서 시작과 동시에 끝나는 회의가 존재한다는 점에서 회의의 시작시간과 종료시간이 같을 때를 대비해서
    // 회의의 시작 시간에 대한 정렬 또한 필요하다는 것을 알게 되었다.
    // 시작 시간에 대한 정렬이 없어서 문제가 해결되지 않는 것이었다 ㅠㅠ'

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for(int i=0;i<N;i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(stk.nextToken());
            time[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int answer = 0;

        int end = 0;
        for(int i=0;i<time.length;i++){
            if(end <= time[i][0]){
                end = time[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
