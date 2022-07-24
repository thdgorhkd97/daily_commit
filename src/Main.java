package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 07 - 24 )
문제 : java baekjoon 1743 음식물 피하기
문제접근 : 2차원 배열에서 음식물위치가 주어지면 가장 큰 덩어리의 크기를 구하기
*/

class Main {

    static int[][] hallway; // 음식물의 위치가 주어지는 2차원 배열
    static boolean[][] visited; // 방문처리할 2차원 배열
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1}; // 상하좌우
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken()); // 통로의 세로
        int M = Integer.parseInt(stk.nextToken()); // 통로의 가로
        int K = Integer.parseInt(stk.nextToken()); // 음식물 쓰레기의 개수

        hallway = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0;i<K;i++){
            stk = new StringTokenizer(br.readLine()," ");

            int r = Integer.parseInt(stk.nextToken()); // 음식물이 떨어진 좌표의 행
            int c = Integer.parseInt(stk.nextToken()); // 음식물이 떨어진 좌표의 열

            hallway[r][c] = 1;

        }

        for(int i=1;i<=N;i++){ // N+1 로 받았으니까범위 수정
            for(int j=1;j<=M;j++){ // M+1로 받았기에 범위 수정
                if(hallway[i][j]== 1 && !visited[i][j]){ // 음식물이 위치해있고 방문하지 않았다면
                    cnt = 0;
                    bfs(i,j); // 해당 위치를 기준으로 BFS 시작

                    answer = Math.max(answer,cnt);
                }
            }
        }

        System.out.println(answer);


    }

    public static void bfs(int row,int column){
        Queue<int[]> que = new LinkedList<>();
        addque(row,column,que); // que에 row,column을 가지는 int[] 배열 넣기
        visited[row][column] = true;

        cnt++; // 처음 bfs로 들어오면 하나 추가
        while(!que.isEmpty()){
            int[] v = que.poll();

            for(int i=0;i<dx.length;i++){
                int nextX = v[0] + dx[i]; // 다음 이동할 행
                int nextY = v[1] + dy[i]; // 다음 이동할 열

                if(nextX < 1 || nextY < 1 || nextX >= hallway.length || nextY >= hallway[0].length){
                    continue;
                } // 복도의 크기를 벗어나면 그대로 진행
                else{
                    if(hallway[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        addque(nextX,nextY,que);

                        visited[nextX][nextY] = true;
                        cnt++;
                    }
                }
            }
        }


    }

    public static void addque(int row,int column,Queue<int[]> que){
        int[] add = new int[2];
        add[0] = row;
        add[1] = column;
        que.add(add);
    }
}
