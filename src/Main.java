package src;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 06 - 17 )
공부 : dfs 공부 -> 재귀 & 스택 활용
 */

public class Main {

    static boolean[] visited = new boolean[6]; // 방문처리를 표현할 배열
    static int[][] graph = new int[6][6]; // 그래프의 연결을 표현할 2차원 배열
    static Stack<Integer> stack = new Stack<>(); // dfs에 쓰일 스택 자료구조

    public static void main(String[] args) throws IOException {

        addLine(graph,0,1);
        addLine(graph,0,2);
        addLine(graph,0,3);
        addLine(graph,0,4);
        addLine(graph,2,5);

        /*
        dfsByRecursion(0);
        dfsByStack(0);
         */
    }

    private static void dfsByRecursion(int start){
        visited[start] = true; // 해당 정점을 방문처리하고

        System.out.print(start + " ");

        for(int i=start;i<6;i++){
            if(!visited[i] && graph[start][i] == 1){ // 연결된 정점을 방문하지 않았으면
                dfsByRecursion(i);
            }
        }
    } // dfs를 재귀로 구현

    private static void dfsByStack(int start) {

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()){
            int v = stack.pop();

            System.out.print(v + " ");

            for(int i=start;i<6;i++){
                if(!visited[i] && graph[start][i] == 1){ // 연결된 정점을 방문하지 않았으면
                    dfsByStack(i);
                }
            }
        }

    } // dfs를 스택으로 구현

    private static void addLine(int[][] graph, int a, int b) {
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
}
