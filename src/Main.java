package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 07 - 22 )
문제 : java baekjoon 2606 바이러스
문제접근 : 컴퓨터끼리의 연결 정보가 주어지면 1번과 연결된 컴퓨터의 수 구하기
*/

class Main {

    static int[][] graph;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수

        visited = new boolean[N+1];
        graph = new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수

        for(int i=0;i<M;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int one = Integer.parseInt(stk.nextToken());
            int two = Integer.parseInt(stk.nextToken());
            graph[one][two] = 1;
            graph[two][one] = 1;
        }

        bfs(1); // 1번과 연결된 컴퓨터의 수 구하기

        System.out.println(answer-1);
    }

    private static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int v = que.poll();
            System.out.println(v);
            answer++;


            for(int i=1;i< graph.length;i++){
                if(graph[v][i] == 1 && !visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}