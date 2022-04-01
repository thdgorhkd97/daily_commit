import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java bfs로 최단 거리 찾기 & 도형이 이중 배열로 주어질 때 회전 시키기
    // 여태껏 문제를 풀면서 헷갈렸던 개념을 다시 잡으려고 어떤 문제를 푼게 아니라
    // 해당 개념을 체크하기 위해서 필요 부분만 확인했다
    // bfs로 거리를 찾는 건 좌표에서 상하좌우를 확인하면서 좌표 내에 위치한다면
    // 이전의 거리 값 + 1로 하면서 체크해 나간다

    // 도형을 회전 시키는 건 잘 몰라서 조금 알아보았다
    // 2중 for문으로 주어지는 상황이라면 2중 for문을 돌리면서
    // 90도씩 돌린다고 생각하면 된다.
    //        for (int i = 0; i < key.length; i++) {
    //            for (int j = 0; j < key.length; j++) {
    //                result[i][j] = key[key.length - 1 - j][i];
    //            }
    //        }
    // 새로운 배열의 맨 윗줄을 해당 배열의 왼쪽줄부터 채워나가는 식으로 하는 것이다.

    static class P {
        int x;
        int y;
        int cost;
        P(int x,int y,int cost){
            this.x = x;
            this.cost = cost;
            this.y = y;
        }
    }

    static int idx = 0;

    public static void main(String[] args) throws IOException {

        /*
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        boolean[][] check = new boolean[maps.length][maps.length];

        // 좌 상 우 하
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};

        check[0][0] = true;
        Queue<P> que = new LinkedList<>();
        que.add(new P(0,0,0));

        while(!que.isEmpty()){
            P point = que.poll();

            int curX = point.x;
            int curY = point.y;

            for(int i=0;i<dx.length;i++){
                int nowX = curX + dx[i];
                int nowY = curY + dy[i];

                if(nowX < 0 || nowY < 0 || nowX > maps.length-1 || nowY > maps.length-1) continue;
                if(!check[nowX][nowY] && maps[nowX][nowY] == 1){
                    que.add(new P(nowX,nowY,point.cost+1));
                    check[nowX][nowY] = true;
                }
            }
        }
         */

        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}};

        rotate90(key);




    }

    public static void rotate90(int[][] key){
        idx++;
        int[][] result = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                result[i][j] = key[key.length - 1 - j][i];
            }
        }

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        if(idx == 4) return ;
        rotate90(result);
    }

}
