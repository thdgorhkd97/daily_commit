package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 24 )
문제 : java baekjoon 10026
문제접근 : 적록색약 bfs에서 주어진 문제에 대해 적록색약인 사람과 아닌 사람을 구분해서 bfs 구현...

 */

class algorithm {

    static int[] add = new int[2];
    static int normalPeopleSection = 0;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1}; // 상하좌우
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] graph = new char[N][N];

        for(int i=0;i<N;i++){
            graph[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    normalPeopleSection++;
                    normalPeople(i,j,graph);
                    System.out.println("---------");
                }
            }
        }

        System.out.println(normalPeopleSection);

    }

    private static void normalPeople(int row,int column,char[][] graph){
        Queue<int[]> que = new LinkedList<>();
        add[0] = row;
        add[1] = column;
        que.add(add);
        visited[row][column] = true;

        while(!que.isEmpty()){
            int v[] = que.poll();
            char color = graph[v[0]][v[1]];

            System.out.println(v[0] + " , " + v[1]);
            for(int i=0;i<dx.length;i++){
                int nextX = v[0] + dx[i];
                int nextY = v[1] + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX< graph.length && nextY< graph.length && graph[nextX][nextY] == color && !visited[nextX][nextY]){
                    add[0] = nextX;
                    add[1] = nextY;
                    visited[nextX][nextY] = true;
                    que.add(add);
                }
            }

        }

    }


}

