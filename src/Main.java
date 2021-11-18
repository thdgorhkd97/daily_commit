import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 2 - 게임 맵 최단거리
    // bfs를 활용한 대표적인 거리 찾기 문제였다.
    // 좌표를 활용하다 보니 bfs만 이용하는 것에서 조금 더 나아가는 문제였다.
    // 나는 class P를 추가하였는데 찾아보니 그냥 x,y로 2번 체크하신 분도 있고 cnt같은 변수로해서 거리까지 한 번에
    // 계산하는 식으로 하신 분들도 계셨다.
    // 현재 좌표에서 상하좌우 한칸씩 이동했을 때 막혀있거나 맵을 벗어나는 경우가 아니라면
    // 큐에 넣고 그 곳으로 이동하는 식으로 진행하면서 cnt를 1씩 더해 나간다.
    // 아예 클래스를 하나 추가해서 해본 건 처음이었는데 생각보다 까다로웠다.

    static class P{
        int x;
        int y;
        P(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };

        boolean[][] check = new boolean[maps.length][maps[0].length];

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        Queue<P> que = new LinkedList<>();

        que.offer(new P(0,0));
        check[0][0] = true;

        while(!que.isEmpty()){
            P p = que.poll();
            int curX = p.x;
            int curY = p.y;

            for(int i=0;i<4;i++){
                int nowX = curX + dx[i];
                int nowY = curY + dy[i];

                if(nowX<0||nowX>= maps.length||nowY<0||nowY>=maps[0].length) continue;
                if(maps[nowX][nowY]==0) continue;
                if(!check[nowX][nowY]){
                    que.offer(new P(nowX,nowY));
                    maps[nowX][nowY]=maps[curX][curY]+1;
                    check[nowX][nowY]= true;
                }
            }
        }

//        for(int i=0;i<maps.length;i++){
//            for(int j=0;j<maps[0].length;j++){
//                System.out.print(maps[i][j] + " ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        answer = maps[maps.length-1][maps[0].length-1];
        System.out.println(answer);





   }
}