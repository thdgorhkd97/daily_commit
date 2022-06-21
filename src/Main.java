package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 21 )
문제 : java baekjoon 1012
문제접근 : 2차원배열의 크기가 주어지고 배추의 위치가 쭉 주어지면 연결된 배추 영역마다
        1마리의 지렁이를 놔둔다고 가정했을 때 몇 마리의 벌레가 필요할까?
        bfs로 2차원 배열을 돌면서 visited[i][j]가 false고 field[i][j] == 1이면
        bfs로 넣고 인접한 배추가 있다면 해당 위치의 방문처리를 한다.
 */

class algorithm {

    static List<Integer> list = new ArrayList<>();
    static int worm = 0; // 배추밭에 필요한 벌레의 수를 저장할 변수
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1}; // 상하좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 전체 테스트케이스의 수

        for(int i=0;i<T;i++){ // 테스트케이스 수만큼 for문 돌기
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int M = Integer.parseInt(stk.nextToken()); // 배추밭 배열의 행의 크기
            int N = Integer.parseInt(stk.nextToken()); // 배추밭 배열의 열의 크기
            int K = Integer.parseInt(stk.nextToken()); // 배추의 개수

            int[][] field = new int[M][N]; // 주어진 크기만큼 배추밭의 2차원 배열 선언

            for(int j=0;j<K;j++){ // 배추의 개수만큼 for문을 돌며 입력받아 저장
                stk = new StringTokenizer(br.readLine()," ");
                int row = Integer.parseInt(stk.nextToken());
                int column = Integer.parseInt(stk.nextToken());

                field[row][column] = 1; // 배추밭에 배추의 위치를 1로 저장(field[row][column] = 1이면 배추가 있다)
            }

            boolean[][] visited = new boolean[M][N]; // 방문처리 할 배추밭과 같은 크기의 boolean 배열

            worm = 0; // 벌레의 수 초기화

            for(int j=0;j<M;j++){
                for(int k=0;k<N;k++){
                    if(!visited[j][k] && field[j][k] == 1) { // 방문하지 않았고 배추가 존재하는 위치면
                        bfs(j,k,visited,field); // 해당 위치와 연결된 다른 배추들을 체크하기 위해 bfs
                        worm++; // bfs를 호출할 때마다 벌레 1마리가 추가로 필요하다
                    }
                }
            } // 크기만큼 돌면서 bfs를 호출할 때마다 worm+1

            list.add(worm);

        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }





    }
    private static void bfs(int row,int column,boolean[][] visited,int[][] field){

        Queue<int[]> que = new LinkedList<>();
        int[] add = new int[2];
        add[0] = row;
        add[1] = column;
        que.add(add);
        visited[row][column] = true;

        while(!que.isEmpty()){
            int[] v = que.poll();

            int nextX = 0;
            int nextY = 0;

            for(int i=0;i<dx.length;i++){
                nextX = v[0] + dx[i];
                nextY = v[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= visited.length || nextY >= visited[0].length){
                    continue;
                }
                else{
                    if(field[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        int[] queAdd = new int[2];
                        queAdd[0] = nextX;
                        queAdd[1] = nextY;
                        que.add(queAdd);
                    }
                }
            }

        }
    }
}
