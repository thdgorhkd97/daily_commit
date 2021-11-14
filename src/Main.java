import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 실전 모의 코딩테스트
    // 세균 증식
    // max_virus 면 주변 칸을 증가시켜 나간다.
    // 이게 max_virus와 같다면 주변 모든 칸을 퍼져나가야 하는데 이 부분을
    // 구현하기가 매우 어려웠다..
    // 단순히 상하좌우만 보면 되는 게 아니라
    // max_virus와 같은 인접한 모든 칸을 확인하고 그 주변칸에 +1을 해야 하는 것이라서
    // 이 부분을 해결할 수 있는 방법을 공부해 봐야 할 것이다.

    public static void main(String[] args) {

        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};

        int[][] map = new int[rows+1][columns+1];

        for(int i=0;i< queries.length;i++){
            System.out.println(queries[i][0] + " " + queries[i][1]);
            if(map[queries[i][0]][queries[i][1]] < max_virus)map[queries[i][0]][queries[i][1]]++;
            else chain(map,queries[i][0],queries[i][1],max_virus);
        }




    }

    public static void chain(int[][] map, int y, int x, int max_virus) {

        if(y-1 > 0 && map[y-1][x] < max_virus){
            map[y-1][x]++;
        }
        else if(y-2 > 0 && map[y-1][x] == max_virus){
            chain(map,y-2,x,max_virus);
        }
        if(x-1 > 0 && map[y][x-1] < max_virus){
            map[y][x-1]++;
        }
        else if(x-2 > 0 && map[y][x-1] == max_virus){
            chain(map,y,x-2,max_virus);
        }
        if(y+1 < map.length && map[y+1][x] < max_virus){
            map[y+1][x]++;
        }
        else if(y+2 < map.length && map[y+1][x] == max_virus){
            chain(map,y+2,x,max_virus);
        }
        if(x+2 <map[0].length && map[y][x+1] < max_virus){
            map[y][x+2]++;
        }
        else if(x+1 <map[0].length && map[y][x+1] == max_virus){
            chain(map,y,x+1,max_virus);
        }



    }




}