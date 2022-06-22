package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 22 )
문제 : java baekjoon 7562
문제접근 : N x N 크기의 맵에서 체스의 나이트가 이동해서 타겟위치까지 최소 몇 번을 움직여서 이동할 수 있는지 최소횟수를 구한다.
 */

class algorithm {

    static int dx[] = {-1,-2,-2,-1,1,2,2,1}; // 체스에서 나이트의 이동 (행)의 변화
    static int dy[] = {-2,-1,1,2,2,1,-1,-2}; // 체스에서 나이트의 이동 (열)의 변화

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int length = Integer.parseInt(br.readLine());

            int[][] map = new int[length][length]; // 체스판의 크기
            boolean[][] visited = new boolean[length][length]; // 방문처리를 저장할 변수
            int[][] move = new int[length][length]; // 움직인 횟수를 저장하는 배열

            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int nowX = Integer.parseInt(stk.nextToken()); // 현재 있는 위치의 행
            int nowY = Integer.parseInt(stk.nextToken()); // 현재 있는 위치의 열

            stk = new StringTokenizer(br.readLine()," ");

            int targetX = Integer.parseInt(stk.nextToken()); // 이동할 행
            int targetY = Integer.parseInt(stk.nextToken()); // 이동할 열

            bfs(map,nowX,nowY,targetX,targetY,visited,move);

            System.out.println(move[targetX][targetY]);

        }

    }

    private static void bfs(int[][] map,int nowX,int nowY,int targetX, int targetY,boolean[][] visited,int[][] move){
        Queue<int[]> que = new LinkedList<>();
        queAdd(que,nowX,nowY); // 큐에 배열로 넣기
        visited[nowX][nowY] = true; // 해당 좌표에 방문 처리
        move[nowX][nowY] = 0; // 처음 위치는 0번 이동 후 도달 가능(처음은 0으로 세팅)

        while(!que.isEmpty()){
            int v[] = que.poll();

            int nextX = 0; // 다음에 이동할 위치의 행
            int nextY = 0; // 다음에 이동할 위치의 열
            for(int i=0;i<dx.length;i++){
                nextX = v[0] + dx[i];
                nextY = v[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length){
                    continue;
                } // map을 벗어나면 그대로 진행
                else{
                    if(!visited[nextX][nextY]) { // 해당위치를 처음 방문하는 거면
                        move[nextX][nextY] = move[v[0]][v[1]] + 1; // 이전 위치에 도달한 이동 횟수에 + 1
                        queAdd(que, nextX, nextY); // 다음 이동위치를 큐에 저장
                        visited[nextX][nextY] = true; // 방문처리
                        if (nextX == targetX && nextY == targetY) { // 이동한 곳이 타겟위치와 같으면 종료
                            return;
                        }
                    }
                }
            }
        }

    }

    private static void queAdd(Queue<int[]> que,int first,int second){
        int[] add = new int[2];
        add[0] = first;
        add[1] = second;
        que.add(add);
    }

}
