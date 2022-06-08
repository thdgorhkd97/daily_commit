package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : baekjoon 1520 내리막 길
작성자 : 송해광( 2022 - 06 - 08)
문제접근 : 처음에는 단순히 dfs만 활용해서 루트를 찾아가면서 내려갔는데 시간초과가 발생했고 알아보니 dp를 통해서 저장해 가면서 해야 했다
걸린 시간 : 80분
 */

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int[][] dp; // 이동 가능한 경로를 저장하기 위한 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken()); // 주어지는 배열의 행 수
        int M = Integer.parseInt(stk.nextToken()); // 주어지는 배열의 열 수

        int[][] map = new int[N+1][M+1]; // 1부터 인덱스를 활용하기 위해 +1 로 크기 설정
        dp = new int[N+1][M+1]; // 1부터 인덱스를 활용하기 위해 +1 로 크기 설정

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                dp[i][j] = -1; // dp를 -1로 초기화( 나중에 중복 체크 위함 )
            }
        }

        dfs(map, 1, 1); // 시작점인 1,1 부터 시작

        System.out.println(dp[1][1]);
    }

    private static int dfs(int[][] map, int row, int column) {
        if (row == map.length-1  && column == map[0].length-1 ) { // 마지막에 도달했으면 종료
            return 1;
        }

        if(dp[row][column] != -1){ // dp[][]가 != -1이면 이미 방문했다는 것이므로 그냥 그 인덱스에 저장된 수 반환
            return dp[row][column];
        }
        else {
            dp[row][column] = 0; // -1이면 처음 접근하는 인덱스이므로 0으로 초기화(나중에 다시 방문 X)
            for (int i = 0; i < dx.length; i++) {
                int nextX = row + dx[i]; // 현재 인덱스에서 상하좌우 확인
                int nextY = column + dy[i]; // 현재 인덱스에서 상하좌우 확인

                if (nextX < 1 || nextY < 1 || nextX > map.length-1 || nextY > map[0].length-1) {
                    continue;
                } // 만약 현재 인덱스의 상하좌우로 이동한 지점이 배열의 크기를 벗어나면 continue

                if (map[row][column] > map[nextX][nextY]) { // 이동한 점이 원래 지점보다 작다면 내리막길이니까
                    dp[row][column] += dfs(map, nextX, nextY); // 현재 지점은 dfs로 재귀로 보내 현재 지점을 더한다
                }
            }
        }
        return dp[row][column];
    }


}
