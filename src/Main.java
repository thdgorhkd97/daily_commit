import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers level 3 - 입국심사

    // 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
    // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

    // 처음에는 큐를 만들어서 시간의 n배가 되면 사람의 심사가 끝났다는 것이기 때문에 그 다음 사람을 넣는 식으로 for문을 사용하기도 하고
    // 했는데 times의 길이가 정해져 있지 않고 수의 범위가 int를 범어나기 때문에 적절치 않은 방법이었다.
    // 근데 문제는 이분탐색으로 나뉘어 있길래 이걸 어떻게 이분탐색으로 할 수 있는건가 싶어서 한참을 고민하다 결국 길을 못찾고 찾아보았다.
    // 문제를 찾아보고는 이해하는 데도 시간이 꽤 걸렸다. 이분탐색의 개념이나 구현법은 알고있지만 이 문제를 풀어서 이분탐색으로 해결할 수 있는
    // 세팅을 하기가 상당히 어려웠다.

    // 계속 문제를 보니까 이해를 할 수 있었는데 이분탐색의 조건을 시간으로 해서 해당 시간동안 몇 명을 통과시킬 수 있는지를
    // 확인하는 것이 포인트였던 문제다.
    // 해결에 관한 멘트를 읽어보고 코드로 구현하였으며 직접 주석을 달면서 문제에 대한 이해를 확실시 했다.
    // 이렇게 문제를 많이 접하면서 어떤 개념을 활용할 수 있는 응용 문제에 대해 많이 보고 풀어보면서 익숙해져야 할 것 같다.

    public static void main(String[] args) throws IOException {

        int n = 6;
        int[] times = {7,10};

        long min = 0; // 최소의 시간 0초로 세팅
        Arrays.sort(times);
        long max = (long) times[times.length - 1] * n; // 가장 긴 시간을 가진 심사관에서만 n명이 심사를 다 받을 때(가능한 최대의 시간)

        long answer = 0;

        while(min <= max){ // 이분탐색의 종료 조건
            long mid = (min + max) / 2;
            long people = 0; // mid 시간 내에 심사를 통과하는 사람의 수

            for(int i=0;i<times.length;i++){
                people += mid / times[i]; // mid 시간내의 각 심사관이 통과시키는 사람의 수를 모두 더함
            } // people은 mid 시간에 통과한 사람의 수


            System.out.println(mid + " 시간동안 " + people + " 명이 통과 ");

            if(people >= n){ // mid 시간에 통과한 사람의 수가 n명보다 크면
                max = mid-1; // 더 짧은 시간내에 모두가 통과할 수 있는지 확인하기 위해서
                answer = mid; // 일단 정답은 mid로 초기화
            }
            else{ // mid 시간에 통과한 사람이 n명보다 작다면
                min = mid+1; // 시간이 더 필요하다는 의미이므로 mid를 늘려서 다시 체크
            }

        }

        System.out.println(answer);


    }
}