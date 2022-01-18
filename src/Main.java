import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // programmers 줄 서는 방법
//    사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
//    k번째 방법을 return하는 solution 함수를 완성해주세요.
//    예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
//        [1, 2, 3]         [1, 3, 2]
//        [2, 3, 1]         [3, 1, 2]
//        [2, 1, 3]         [3, 2, 1]

    // n명을 세웠을 때 나열하는 순서 중 k번째 방법을 구해야 하기 때문에 먼저 사전 순서대로
    // n명을 세우는 방법을 구하기 위해 순열을 활용했다.
    // 원래 n명중 n명을 구하는 조합을 구할때 사전순서를 챙기지 않는 순열을 주로 활용했는데
    // 문제에서 사전 순서를 원하기 때문에 순서를 챙기기 위해서 visited[i]를 활용한
    // 순열을 활용했다.
    // 나는 이중배열에 result[n!][n]을 만들어서 사전 순서로 이루어지는 사람 순서를
    // result배열에 모두 집어넣고 k번째를 구해야하니 result[k-1][0]...result[k-1][n-1]을 구했다.
    // 이 결과 정확성테스트 12/14 성공(2가지는 메모리 초과) 효율성 테스트 실패가 나왔다.
    // n!의 결과가 나오기 때문에 n이 20이하의 자연수라해도 20!이 되어 엄청 크다ㅠㅠ
    // 아예 시간을 줄이기 위해서는 순열을 이용한 방법은 옳지 않은 것 같다.
    // 그래서 고민을 해봤는데 다르게 생각해보면 k번째 방법만 구하면 되기 때문에 k에 따라서
    // 앞자리나 특정 자리의 수를 결정하는 것이 가능하지 않을까 싶다.
    // 근데 확실한 로직이 떠오르지는 않아서 조금 더 고민해봐야 할 것 같다.


    static int[] arr;
    static boolean[] visited;
    static int[][] result;
    static int idx = 0;

    public static void main(String[] args) throws IOException {

        int n = 3;
        long k = 5;

        int[] answer = new int[n];
        int[] output = new int[n];
        visited = new boolean[n];

        arr = new int[n];

        int factorial = 1;
        for(int i=n;i>=1;i--){
            factorial *= i;
        }

        result = new int[factorial][n];

        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

        perm(arr,output,visited,0,n,n);

        for(int i=0;i<n;i++){
            answer[i] = result[(int)k-1][i];
        }

    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth,int n,int r){
        if(depth==r){
            for(int i=0;i< output.length;i++){
                result[idx][i] = output[i];
            }
            idx++;
            return;

        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i] = false;
            }
        }
    }


}