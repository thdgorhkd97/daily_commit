package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : JAVA baekjoon 10971 외판원 순회 2

작성자 : 송해광 ( 2022 - 06 - 10 )

문제정보 : 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다. (길이 없을 수도 있다)
이제 한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외) 이런 여행 경로는 여러 가지가 있을 수 있는데, 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
걸린시간 : 40분

문제접근 : 전체 마을 수(N)이 10이하기 때문에 순열로 모든 마을 이동 경로를 구한후에 cost[][] 배열을 통해서
각각의 마을로 이동하는 경비를 더해가며 계산해도 괜찮다고 판단하였다.

 */

public class Main {

    static int tripCost = Integer.MAX_VALUE; // 각 여행경로 별 여행경비를 저장하는 변수
    // Math.min()을 통해서 현재값과 비교해가면서 최소값을 갱신해 나간다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N+1][N+1]; // 1번 도시부터 시작하기위해 크기 지정 ( +1 )

        for(int i=1;i<=N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            for(int j=1;j<=N;j++){
                cost[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] arr = new int[N]; // 순열로 모든 여행경로를 만들기 위해 배열 저장(N이 10이하이기 때문에 가능)
        for(int i=0;i<N;i++){
            arr[i] = i+1; // 1번 도시부터 시작하기 위해서 +1로 저장
        }

        int[] result = new int[N]; // 순열을 저장하기 위한 배열
        int depth = 0; // 순열의 depth 값
        boolean[] visited = new boolean[N];
        int r = N; // 구하고자하는 순열의 길이 값 ( N에 대한 순열 값이 필요 )
        combination(arr,result,depth,visited,r,cost); // 순열

        System.out.println(tripCost);
    }

    private static void combination(int[] arr, int[] result, int depth, boolean[] visited, int r,int[][] cost) {
        if(depth == r){ // depth가 r이면 여행경로에 대한 계산이 완료된 경우
            costCalculate(result,cost); // 해당 여행경로에 대해 여행경비를 계산

            return ;
        }

        for(int i=0;i<arr.length;i++){ // 순열 계산식
            if(!visited[i]){
                result[depth] = arr[i];
                visited[i] = true;
                combination(arr,result,depth+1,visited,r,cost); // depth+1로 재귀
                visited[i] = false;
            }
        }
    }

    private static void costCalculate(int[] result, int[][] cost) {
        int costSum = 0; // 각 여행경로에 대한 여행경비 저장 변수
        for(int i=0;i<result.length-1;i++){ // 다음경로가 필요하므로 result.length-1까지만 일단 돌고
            costSum += cost[result[i]][result[i+1]]; // 다음 마을에 대한 이동 경비를 더한다
            if(cost[result[i]][result[i+1]] == 0) return ; // 단 cost[i][j] ==0 이면 i마을에서 j마을로 가는 경로가 존재하지 않는 것
        }
        costSum += cost[result[result.length-1]][result[0]]; // 마지막마을에서 다시 처음 마을로 돌아와야 하기 때문에
        if(cost[result[result.length-1]][result[0]] == 0) return ; // 단 cost[i][j] ==0 이면 i마을에서 j마을로 가는 경로가 존재하지 않는 것

        tripCost = Math.min(tripCost,costSum); // tripCost 값과 비교해서 최소값을 저장

    } // 여행경로에 대한 여행경비 계산
}

