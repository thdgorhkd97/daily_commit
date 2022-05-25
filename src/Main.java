package src; // daily 폴더를 source root로 인식시켰기 때문에


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 18429 근손실
    // 운동 키트 적용순서의 모든 경우의 수에 대해서 K만큼 빼고 키트를 더했을 때 500을 모두 넘는
    // 운동 키트 적용순서의 경우의 수를 구하는 문제
    // 순열을 활용하기로 생각한 건 N이 8이하라는 조건이 있기 때문이다.
    // 순열을 이용해 모든 경우의 수를 구하는 과정에서 N이 8이하라면 빠른 시간에 처리할 수 있다는
    // 확신이 있는 것이므로 순열을 구해서 키트의 모든 경우의 수를 구하고
    // 해당하는 키트의 중량을 더하고 K만큼 빼는 것이 모두 500을 넘도록 구하는 것이다.

    static int answer = 0;
    static int minus = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        minus = K;

        int[] kit = new int[N];
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            kit[i] = Integer.parseInt(stk.nextToken());
        }

        int depth = 0;
        int[] result = new int[N];
        boolean[] visited = new boolean[N];
        combination(kit,result,depth,visited);

        System.out.println(answer);
    }

    private static void combination(int[] kit, int[] result, int depth, boolean[] visited) {
        if(depth == result.length){
            int weight = 500;
            boolean flag = true;
            for(int i=0;i<result.length;i++){
                if(weight - minus + result[i] < 500){
                    flag = false;
                    break;
                }

                weight = weight - minus + result[i];
            }

            if(flag) answer++;

            return ;
        }
        for(int i=0;i<kit.length;i++){
            if(!visited[i]){
                result[depth] = kit[i];
                visited[i] = true;
                combination(kit,result,depth+1,visited);
                visited[i] = false;
            }
        }
    }
}