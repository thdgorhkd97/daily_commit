import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 차이를 최대로

//    N개의 정수로 이루어진 배열 A가 주어진다.
//    이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
//    |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

    // 배열 A를 순열로 순서를 바꿔가면서 가능한 경우의 수를 모두 구한 다음
    // 최대값을 비교한다.
    // 처음에 순열로 구해야 하는 것을 조합으로 구했다가 시간이 많이 걸렸다..


    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int[] num = new int[N];
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }


        int[] result = new int[N];
        boolean[] visited = new boolean[N];
        int depth = 0;
        combination(num,result,visited,depth);

        System.out.println(max);

    }
    private static void combination(int[] num,int[] result,boolean[] visited,int depth){
        if(depth == result.length){
            int sum = 0;
            for(int i=0;i< result.length-1 ;i++){
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max,sum);

            return ;
        }

        for(int i=0;i<num.length;i++){
            if(!visited[i]){
                result[depth] = num[i];
                visited[i] = true;
                combination(num,result,visited,depth+1);
                visited[i] = false;
            }
        }
    }
}