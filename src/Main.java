import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2003 수들의 합 2
    // 배열의 부분수열 중 합이 M이 되는 경우의 수를 리턴하는 문제
    // 시간초과가 발생하는 것 같아서 조치를 취했다. 합이 M을 넘으면 그 뒤로는
    // 양수만 더해지므로 M이 넘기 때문에 절대 경우의 수에 포함되지 않으므로 바로 그 순간
    // break를 걸어준다.
    // 근데 이것만으로는 시간초과를 막기 힘들었다.
    // 그래서 이중 for문과 비슷한 투포인터를 활용하여 문제를 다시 해결했다.
    // start와 end를 처음에 0에 위치시키고 대상숫자를 넘어설때까지 end를 뒤로 이동시키며
    // 더하고 대상숫자를 넘어서면 start를 이동시키면서 빼주면서
    // 총 몇번의 대상 숫자와 같은 합계가 나오는지 확인한다.
    // 투 포인터를 활용하면 이중 for문과 같은 효과를 구현하다
    // 시간적으로 O(n^2) -> O(n)의 시간에 구현할 수 있다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(two_pointer(arr,M));

    }

    private static int two_pointer(int[] arr,int M) {
        int cnt = 0;

        int start = 0;
        int end = 0;
        int sum = 0;
        while(true){

            if(sum >= M){
                sum -= arr[start++];
            }
            else if(end >= arr.length){
                break;
            }
            else {
                sum += arr[end++];
            }

            if(sum == M) cnt++;
//            System.out.println("start = " + start + " end = " + end + " sum = " + sum);
        }





        return cnt;
    }

}