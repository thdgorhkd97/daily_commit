import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 가장 먼 노드
    // 그래프에서 1과 가장 거리가 먼 노드의 개수를 구하는 문제
    // bfs를 활용해서 1과의 거리 차이를 구했는 데 테스트 케이스 9개중 2개가
    // 메모리 초과가 나왔다.
    // bfs를 활용할 때 변수를 써서 +1을 했는데 그렇게 안하고 distance 변수를 활용하여
    // 지금 큐에 담겨있는 변수에 +1을 해야 햇다.

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        int[][] graph = new int[n+1][n+1];
        int[] distance = new int[n+1];
        boolean[] check = new boolean[n+1];
        int num=1;

        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]][edge[i][1]] = 1;
            graph[edge[i][1]][edge[i][0]] = 1;
        }

        bfs(1,distance,check,num,graph);

        int answer = 0;
        Arrays.sort(distance);
        for(int i=0;i< distance.length;i++){
            if(distance[i] == distance[n]){
                answer++;
            }
        }

    }
    public static void bfs(int start, int[] distance, boolean[] check,int num,int[][] graph){
        Queue<Integer> que = new LinkedList<>();
        check[start] = true;
        que.offer(start);

        while(!que.isEmpty()){
            int cur = que.poll();

            System.out.println(cur + " " + distance[cur]);

            for(int i=1;i<graph.length;i++){
                if(graph[cur][i] == 1 && !check[i]){
                    que.add(i);
                    distance[i] = distance[cur] + 1;
                    check[i] = true;
                }
            }
        }

    }
}