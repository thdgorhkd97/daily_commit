package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 06 )
문제 : java baekjoon 16948 데스 나이트
문제접근 : 데스나이트의 이동가능한 규약에 따라서 이동함에 따라 해당 위치에 몇 번 이동후 도착할 수 있는가
 */

class algorithm {

    static int[] dx = {-2,-2,0,0,2,2}; // 데스 나이트의 이동 가능 경로 <행>
    static int[] dy = {-1,1,-2,2,-1,1}; // 데스 나이트의 이동 가능 경로 <열>
    static boolean[][] visited; // 방문 여부를 저장할 2차원 배열
    static int[][] move; // 각 지점까지 도달하기 위한 이동 횟수를 저장하는 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] chess = new int[N][N]; // 2차원 배열 ( 체스판의 크기)

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int r1 = Integer.parseInt(stk.nextToken()); // 시작점의 행
        int c1 = Integer.parseInt(stk.nextToken()); // 시작점의 열
        int r2 = Integer.parseInt(stk.nextToken()); // 도착지점의 행
        int c2 = Integer.parseInt(stk.nextToken()); // 도착지점의 열

        visited = new boolean[N][N];
        move = new int[N][N];

        bfs(r1,c1,r2,c2);

        if(move[r2][c2] == 0) System.out.println("-1");
        else System.out.println(move[r2][c2]);

    }
    private static void bfs(int r1,int c1,int r2,int c2){
        Queue<int[]> que = new LinkedList<>();
        int[] add= new int[2];
        add[0] = r1;
        add[1] = c1;
        que.add(add);
        visited[r1][c1] = true; // 출발지점을 방문처리
        move[r1][c1] = 0; // 출발지점의 이동횟수는 0

        while(!que.isEmpty()){
            int[] v= que.poll();

            for(int i=0;i<dx.length;i++){
                int nextX = v[0] + dx[i]; // 다음 이동가능한 행
                int nextY = v[1] + dy[i]; // 다음 이동가능한 열

                if(nextX < 0 || nextY < 0 || nextY>=move.length || nextX>=move.length){
                    continue;
                } // 다음 이동경로가 체스판을 벗어나면 무시하고 진행
                else{
                    if(!visited[nextX][nextY]){ // 다음 이동 칸을 방문한 적 없다면
                        move[nextX][nextY] = move[v[0]][v[1]] + 1; // 현재 위치에서 +1 (이동횟수)
                        visited[nextX][nextY] = true; // 방문처리
                        int[] addque = new int[2];
                        addque[0] = nextX;
                        addque[1] = nextY;
                        que.add(addque); // 다음 이동위치를 큐에 넣어 다시 반복
                    }
                }
            }
        }


    }
}
