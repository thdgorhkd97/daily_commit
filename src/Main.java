import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // N과 M 만들기
    // dfs를 활용한 n개의 수 중 r 개를 뽑는 문제다.
    // dfs를 통해 depth를 두어 몇 번째로 뽑는 건지 visited 배열을 통해 해당 원소를
    // 이미 뽑았는지 아닌지를 확인하는 것으로 구할 수 있는데
    // 방문여부를 확인하는 visited 배열을 사용하지 않으면 중복을 허용하는 중복 수열을
    // 구하는 것도 가능하다.

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];
        int[] result = new int[N];

        for(int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }

        boolean[] visited = new boolean[N];

        int depth = 0;

        dfs(arr,result,depth,M,visited);

        System.out.println(sb.toString());
    }

    public static void dfs(int[] arr,int[] result, int depth,int M, boolean[] visited){
        if(depth == M){
            for(int i=0;i<M;i++){
                 sb.append(result[i]).append(' ');
            }
            sb.append('\n');

            return ;
        }

        for(int i=0;i<arr.length;i++){
            result[depth] = arr[i];
            dfs(arr,result,depth+1,M,visited);
        }

        /* 중복을 허용하지 않는 순열 코드
        // 해당 코드에서 visited라는 방문여부를 확인하는 boolean 배열을 제외하면
        // 해당 원소를 뽑았는지 확인하지 않기 때문에 중복을 허용하는 순열을 뽑는다.
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                dfs(arr,result,depth+1,M,visited);
                visited[i] = false;
            }
        }
         */
    }
}
