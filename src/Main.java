package src;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 06 - 18 )
문제 : java baekjoon 2606
문제 접근 : 컴퓨터끼리 연결된 간선이 주어지면 1번 컴퓨터와 연결된 컴퓨터 대수를 구하는 문제
          이므로 bfs(1) 을 해서 1번과 연결된 컴퓨터를 구한다.
 */

public class Main {

    static int[][] graph;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 간선의 수

        graph = new int[N+1][N+1]; // 컴퓨터의 번호는 1번부터 시작하므로

        for(int i=0;i<M;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int computer1 = Integer.parseInt(stk.nextToken()); // 연결되는 한쪽 컴퓨터
            int computer2 = Integer.parseInt(stk.nextToken()); // 연결된 나머지 컴퓨터

            graph[computer1][computer2] = 1;
            graph[computer2][computer1] = 1; // 인접행렬에 컴퓨터 연결을 저장
        }

        boolean[] visited = new boolean[N+1];
        bfs(1,visited);

        System.out.println(answer-1); // 1번과 연결되어 있는 컴퓨터 대수가 필요한데 1번이 포함되니까 -1

    }
    private static void bfs(int start,boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int v = que.poll();

            answer++; // 1번과 연결된 다른 컴퓨터이므로 +1 ( v가 나올때마다)
            for(int i=1;i<= graph.length-1;i++){
                if(graph[v][i] == 1 && !visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
