import javax.swing.text.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // programmers level 2 - 게임 맵 최단거리
    // 정확성 성공, 효율성 실패
    // bfs를 문제에 적용하는 게 어려워서 구글링과 유튜브를 통해 공부하고 다시 해보았다.
    // queue를 활용하여 이동가능한 방향을 큐에 넣고 방문처리를 하는 방식을 문제에 적용하였다.
    // 다만 이동할 수 있는 모든 경우의 수를 구해서 하다 보니 효율성은 떨어진 것 같다.
    // 내일도 효율성에 대해서만 고민하는 것이 아니라 처음부터 다시 해봐야겠다.

    public static void main(String[] args) {

        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };



        boolean[][] visited = new boolean[maps.length+1 ][maps[0].length+1];
        int answer = 0;

        answer = bfs(0,0,visited,maps);

        System.out.println(answer);


    }

    public static int bfs(int y, int x, boolean[][] visited, int[][] maps){
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qy.offer(y);
        qx.offer(x);
        qc.offer(1);
        visited[x][y] = true;
        int cnt = -1;

        while(!qy.isEmpty()){
            int cy = qy.poll();
            int cx = qx.poll();
            int cc = qc.poll();

            visited[cy][cx] = true;

            if(cy == maps.length-1 && cx == maps[0].length-1) {
                cnt = cc;
                break;
            }

            // 상
            if(can_move(cy-1,cx,maps,visited)) {
//                System.out.println((cy-1) + " , " + cx + " 로 위로 이동 ");
                qy.offer(cy - 1);
                qx.offer(cx);
                qc.offer(cc + 1);
            }
            // 하
            if(can_move(cy+1,cx,maps,visited)){
//                System.out.println((cy+1) + " , " + cx + " 로 아래로 이동 ");
                qy.offer(cy+1);
                qx.offer(cx);
                qc.offer(cc+1);}
            // 좌
            if(can_move(cy,cx-1,maps,visited)) {

//                System.out.println((cy) + " , " + (cx-1) + " 로 왼쪽으로 이동 ");
                qy.offer(cy);
                qx.offer(cx - 1);
                qc.offer(cc + 1);
            }
            // 우
            if(can_move(cy,cx+1,maps,visited)) {

//                System.out.println((cy) + " , " + (cx+1) + " 로 오른쪽으로 이동 ");
                qy.offer(cy);
                qx.offer(cx+1);
                qc.offer(cc+1);
            }
        }


        return cnt;
    }

    public static boolean can_move(int y, int x, int[][] maps,boolean[][] visited){
        if(y<0 || y >= maps.length || x <0 || x >= maps[0].length) return false;
        if(maps[y][x] == 0) return false;
        if(visited[y][x] == true) return false;
        return true;
    }
}
