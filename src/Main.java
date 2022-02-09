import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 11053 가장 긴 증가하는 부분 수열
    // LIS를 활용하는 문제인데 처음에는 조금 잘못 접근했던 것 같다.
    // 처음에는 이중 for문을 이용해서 더 작은 수를 카운트했었는데 그렇게 하니
    // 단순히 대소관계만 비교하게 되어 증가수열을 구할 수 없었다.
    // 그러고 조금 더 생각해보니까 사실상 알고자 하는 인덱스의 원소를 기준으로
    // 그 이전의 원소들을 비교해보면서 크기는 더 크고 LIS의 크기는 더 작다면 그때를 기준으로
    // 1을 더해야 한다고 생각했다.
    // 증가하는 수열을 구해야 하는 것이기 때문에 수를 고르고 안 고르고를 선택할 수 있게 하기
    // 위해서 LIS에 1을 더해서 LIS를 구해가야 한다.

    // java에서 LIS에 대해서 조금 표현해보고자 한다
    // LIS를 동적계획법을 이용해 구하는 방식은 O(n^2)의 시간 복잡도를 가진다.
    // ( 2중 for문을 활용하기 때문이다)
    // 단, 이분탐색을 활용하면 O(log N)이 가능한데 이분탐색을 활용한 LIS의 풀이법은 조금 더...

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] LIS = new int[N+1];
        int[] arr = new int[N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        LIS[1] = 1;

        for(int i=2;i<=N;i++){
            LIS[i] = 1;
            for(int j=1;j < i;j++){
                if(arr[i] > arr[j] && LIS[i] <= LIS[j]){
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        int max = 0;

        for(int i=1;i<=N;i++){
            max = Math.max(LIS[i],max);
        }

        System.out.println(max);







    }
}