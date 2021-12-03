import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 배달
    // 처음에는 한 마을에서 다른 마을까지의 최소거리를 구하는 과정을 어떻게 해야 할까 고민했는데
    // 그래프 알고리즘 중에서 플로이드 와샬 알고리즘(모든 정점 사이의 최단거리를 구하는 알고리즘)으로 구했다.
//    for (int k = 0; k < N; k++) { // 거쳐가는 정점
//        for (int i = 0; i < N; i++) { // 시작 정점
//            for (int j = 0; j < N; j++) { // 도착 정점
//                if(i == j) continue;
//                if (map[i][j] > map[i][k] + map[k][j]) {
//                    map[i][j] = map[i][k] + map[k][j];
//                }
//            }
//        }
//    }
    // 그 후에는 첫번째 마을에서의 거리가 K 이하인 것을 구하면 되는 문제였다.
    // 플로이드 와샬 알고리즘을 사용해야 한다는 것을 인지하지 못했고
    // 문제의 조건 중에서 마을 사이를 잇는 간선이 여러개 있다는 것을 인지하지 못해서
    // 마을을 잇는 간선 중 가장 가중치가 작은 간선만을 취하는 조건을 뒤늦게 추가하였다.

    public static void main(String[] args) {

        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

        int K = 3;

        int[][] map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {  //i==j일땐 0;
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = 500001;      //K가 500000이하 자연수이므로
            }
        }


        for(int i=0;i<road.length;i++){ //직접적으로 연결된 간선에 대한 표현
            if(map[road[i][0] - 1][road[i][1] - 1] < road[i][2])  continue; // 연결된 간선이 2개 이상이면 작은 거리값만 취할 수 있도록
            map[road[i][0]-1][road[i][1]-1] = road[i][2]; // 마을간의 가중치 연결
            map[road[i][1]-1][road[i][0]-1] = road[i][2]; // 마을간의 가중치 연결
        }

        for (int k = 0; k < N; k++) { // 거쳐가는 정점
            for (int i = 0; i < N; i++) { // 시작 정점
                for (int j = 0; j < N; j++) { // 도착 정점
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = 0;

        for(int i=0; i<N;i++){ // 첫번째 마을에서의 거리가 K이하인 마을의 수 구하기
            if(map[0][i] <= K) answer++;
        }




    }
}