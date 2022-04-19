import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1182 부분수열의 합

    // 부분수열의 의미를 잘못 생각해서 시간이 상당히 오래 걸렸다.
    // 순서대로만이 아니라 하나 떨어지더라도 부분수열로 쳐야 하기 때문에 2중 for문으로
    // 투포인터와 같이 부분수열을 구하는 건 옳지 않았다.
    // 해당 방법이 왜 옳지 않은지 알아내는데 한참 걸렸다...

    // dfs로 원소를 선택하거나 선택하지 않는 경우를 따져야 했다.
    // 단 dfs로 부분수열을 구하는 경우 공집합도 포함되기 때문에 answer-1을 해줘야 했다.

    // java 암호만들기 어제 문제 같은 경우는 따로 정렬을 해서 list를 다시 만드는 게 아니라
    // 애초에 정렬을 하고 sb에 답이 되는 string을 추가해 나가는 식으로 하면 메모리가 초과되지 않는다
    static int answer = 0 ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];

        stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            arr[i]  = Integer.parseInt(stk.nextToken());
        }

        /*
        int answer = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum = 0;

//                System.out.println(i + " 에서 " + j + " 까지 ");
                for(int k=i;k<=j;k++){
                    sum += arr[k];
                }
                if(sum == S) answer++;
            }
        }

        System.out.println(answer);
         */

        dfs(0,0,N,S,arr);
        if(S==0) System.out.println(answer-1);
        else System.out.println(answer);
    }
    private static void dfs(int depth,int sum,int N,int S,int[] arr){
        if(depth == N){
            if(sum == S) answer++;
            return ;
        }

        dfs(depth+1,sum+arr[depth],N,S,arr);
        dfs(depth+1,sum,N,S,arr);
    }
}