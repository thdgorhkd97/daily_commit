import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // bfs 문제인데 커뮤러닝에서 풀이를 진행하는 걸 보고야 풀었다.
    // bfs로 하긴 했는데 한 두개씩 되지 않는 경우가 있었다.
    // 다른 bfs와 같이 방문여부, 갈 수 있는 큐에다가 카운트를 추가해서
    // 3개를 동시에 고려해야 하는 문제여서 좀 더 신경쓰이는 게 많은 문제였다.
    // bfs를 구현하는 걸 안다고 생각했는데 고려할 게 늘어나고 단순한 숫자 하나가 아닌
    // 좌표 형태로 주어지니까 생각해야 할 게 많았다.
    // 좀 더 복잡한 개념에 대한 문제를 해야 할 것 같다.

    static class Position{

        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValid(int width, int height){
            if(x <0 || x>=width) return false;
            if(y < 0 || y>= height) return false;
            return true;
        }
    }
    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int mapHeight = maps.length;
        int mapWidth = maps[0].length;

        Queue<Position> queue = new LinkedList<>();
        int[][] count = new int[mapHeight][mapWidth];
        boolean[][] visited = new boolean[mapHeight][mapWidth];

        queue.offer(new Position(0,0));
        count[0][0] = 1;
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            int currentCnt = count[current.y][current.x];

            final int[][] moving = {{0,-1},{0,1},{-1,0},{1,0}};

            for(int i=0;i<moving.length;i++){
                Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
                if(!moved.isValid(mapWidth,mapHeight)) continue;
                if(visited[moved.y][moved.x]) continue;
                if(maps[moved.y][moved.x] == 0) continue;

                count[moved.y][moved.x] = currentCnt + 1;
                visited[moved.y][moved.x] = true;
                queue.offer(moved);
            }
        }

        int answer = count[mapHeight-1][mapWidth-1];
        if(answer == 0) answer = -1;
        System.out.println(answer);
    }

}