package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 25 )
문제 : java baekjoon 7576
문제접근 : bfs를 구현하는데 1에 인접한 0을 1로 바꿔나가면서 얼마나 걸릴지를 계산하는 문제인데
        -1로 둘러싸인 0을 어떻게 처리할지가 참 문제가 되는 것 같다...

 */

class algorithm {

    static int[][] tomato;
    static int day = 0;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1}; // 상하좌우
    static List<int[]> list = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());

        tomato = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");

            for(int j=0;j<M;j++){
                tomato[i][j]  = Integer.parseInt(stk.nextToken());
            }
        }

        boolean allTomato = false; // 모든 토마토가 익었는지 확인하는 변수
        int row = 0;
        int column = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomato[i][j] == 1){
                    allTomato  = true;
                    row = i;
                    column = j;
                    int[] add = new int[2];
                    add[0] = row;
                    add[1] = column;
                    list.add(add);
                }
            }
        }

        if(!allTomato){
            System.out.println("0");
        }
        else{
            while(true){
                day++;
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(!visited[i][j] && tomato[i][j] == 1){
                            visited[i][j] = true;
                            bfs(i,j);
                        }
                    }
                }

                System.out.println(" day " + day);
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        System.out.print(tomato[i][j] + " ");
                    }
                    System.out.println();
                }

                if(day == 10) break;

                if(tomatoNo0()){
                    break;
                }
            }
        }

        System.out.println(day);

    }
    private static boolean tomatoNo0(){
        for(int i=0;i< tomato.length;i++){
            for(int j=0;j< tomato[0].length;j++){
                if(tomato[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(int row,int column){

        int nextX = 0;
        int nextY = 0;
        for(int i=0;i<dx.length;i++){
            nextX = row + dx[i];
            nextY = column + dy[i];

            if(nextX < 0 || nextY < 0 || nextY >= tomato[0].length || nextX >= tomato.length){
                continue;
            }
            else{
                if(tomato[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    tomato[nextX][nextY] = 1;
                }
            }
        }

    }

    private static void queAdd(Queue<int[]> que,int first,int second){
        int[]  add = new int[2];
        add[0] = first;
        add[1] = second;
        que.add(add);
    }
}

