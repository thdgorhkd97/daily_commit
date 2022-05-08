import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 15650
    // 전체 길이와 구하고자 하는 순열의 크기가 주어지면 중복을 제외한
    // 구하고자 하는 순열의 조합을 출력한다.
    // startIndex와 depth를 +1 해가면서 재귀호출하는 식으로 구현할 수 있고
    // 이제 순열이나 조합에 대해서는 상황에 맞게 활용할 수 있다고 생각한다.
    // 다만 순열이나 조합은 재귀호출을 통해서 구현하기 때문에 n이 10이상일 때는
    // 결코 사용하면 안 된다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }

        int r = M;
        int depth = 0;
        int[] result = new int[r];
        int start = 0;
        combination(arr,result,r,depth,start);

    }

    private static void combination(int[] arr,int[] result,int r, int depth, int start){
        if(depth == result.length){
            for(int i=0;i<result.length;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=start;i<arr.length;i++){
               result[depth] = arr[i];
               combination(arr,result,r,depth+1,i+1);

        }
    }

}