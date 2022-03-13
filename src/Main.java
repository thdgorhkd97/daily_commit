import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // sk 계열사 코딩 테스트 4번 문제
    // 코딩 테스트 당시에는 문제를 해결하지 못했는데 문제를 마무리한 지금도 모든 경우에
    // 해당하는 풀이법은 아닐 것 같다는 느낌이다.
    // 간단히 말하면 문제 자체는 트리에서 각 정점사이의 거리를 내면 되는 문제인데
    // 내가 한 방식은 단순히 두 정점에서 첫번째 노드까지의 거리를 더하는 방식이다.
    // 이 경우에 두 정점의 공통조상이 첫번째 노드인 경우는 해결되는데
    // 만약 그 전에 만나게 되는 구조라면 거리가 맞지 않는다. 이럴 경우에
    // 공통 조상에서 첫번재 노드까지의 거리를 빼거나 해야 하는데
    // 이 부분을 아직 처리하지 못했다...
    // 트리구조에서 각 정점사이의 최단거리를 구하는 것 내일 그 부분에 대해서만 고민해보자.

    static int depth = 0;

    static int[] edgeDepth;

    public static void main(String[] args) throws IOException {

        int n = 5;

        int[][] edges = {{0,1},{0,2},{1,3},{1,4}};

        int[][] graph = new int[n][n];
        edgeDepth = new int[n];

        for(int i=0;i< edges.length;i++){
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }


        boolean[] visited = new boolean[graph.length];
        bfs(0,graph,visited);

//        for(int i=0;i<edgeDepth.length;i++){
//            System.out.println(edgeDepth[i] + " ");
//        }

        long answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){

                    if(i != j && j!=k && i!= k ) {
                        if (distance(i, j, graph) + distance(j, k, graph) == distance(i, k, graph)) {
                            //System.out.println(i + " " + j + " " + k + " " + distance(i, j, graph) + " " + distance(k, j, graph) + " " + distance(i, k, graph));
                            answer++;
                        }
                    }
                }
            }
        }

//        System.out.println(answer);


    }

    private static void bfs(int startPoint,int[][] graph,boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();

        visited[startPoint] = true;
        queue.offer(startPoint);

        int depth = 0; //시작지점으로부터의 거리

        while ( !queue.isEmpty() ){

            int qSize = queue.size();
            System.out.println("====================depth " + depth + "==========================");
            for(int i=1; i<=qSize; i++){
                int pos = queue.poll();
                edgeDepth[pos] = depth;
                System.out.println(pos);

                for(int j=0; j< graph.length; j++){
                    if( graph[pos][j]==1 && !visited[j] ){
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }

            depth++;

        }

    }

    private static int distance(int a, int b, int[][] graph){

        if(graph[a][b] == 1){ //직접 연결
            return 1;
        }
        else{
            return edgeDepth[a] + edgeDepth[b];
        }

    }

}