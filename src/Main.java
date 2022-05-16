package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // bfs 문제
    // 주어지는 matrix 2차원 배열에 대해서 연결된 1의 개수를 오름차순으로 반환

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int[][] matrix = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    bfs(matrix,visited,i,j);
                }
            }
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    private static void bfs(int[][] matrix,boolean[][] visited,int row, int column){
        int cnt = 0;
        visited[row][column] = true;
        Queue<int[]> que = new LinkedList<>();
        int[] add = {row,column};
        que.add(add);

        int[] dy = {0,0,-1,1}; // 상하좌우
        int[] dx = {-1,1,0,0}; // 상하좌우

        while(!que.isEmpty()){
            add = que.poll();
            cnt++;

//            System.out.println(add[0] + " " + add[1] + " 에서 시작");
            for(int i=0;i<4;i++){
                int moveX = add[0] + dx[i];
                int moveY = add[1] + dy[i];
                if(moveX >=0 && moveX < matrix.length && moveY >=0 && moveY < matrix[0].length && !visited[moveX][moveY] && matrix[moveX][moveY]==1){

                    int[] riverLocate = new int[2];
                    riverLocate[0] = moveX;
                    riverLocate[1] = moveY;
                    visited[moveX][moveY] = true;
                    que.add(riverLocate);
                }
            }

        }
        list.add(cnt);
    }
}