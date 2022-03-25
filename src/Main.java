import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java
    // graph와 tree 에서 문제를 풀면서 접했던 문제에 사용된 개념을 다시 정리했다.
    // graph에서는 다익스트라를 정리했다.
    // 다익스트라는 간선에 가중치가 있을 때 한 정점에서 각 정점까지의 거리를 구하는 알고리즘이다.
    // 순서로 간략하게 표현하자면
    // 1. distance[n+1]을 Integer.MAX_VALUE로 초기화한다.
    // 2. 시작노드의 거리와 check를 0과 true로 변경
    // 3. 시작노드와 연결된 노드들의 distance를 연결된 거리로 갱신
    // 4. 방문하지 않은 노드 중 distance 값이 최소인 노드를 찾는다
    // 5. 그 최소의 노드의 인덱스를 minIdx라 하면, check[minIdx] = true로 바꾸고
    //    minIdx와 연결되고 방문하지 않은 노드의 distance값을 갱신한다.
    //    이때 다른 정점을 거치는 거리가 더 짧다면 이를 바꾼다.

    // findLevel과 findChain을 구현했다.
    // findLevel은 트리구조에서 각 노드가 몇 번째 깊이에 있는지를 확인하려 했다.
    // 해당 문제를 통해 각 노드의 깊이를 구할 수 잇다. 기본적인 bfs에서 큐의 크기만큼
    // 도는 for문을 추가한다.

    // findChain은 그래프에서 서로 연결된 노드를 구하는 로직이다.
    // 어떤 노드마다 해당 노드와 연결된 노드가 무엇인지를 구한다.
    // bfs로 독립된 그래프 모양에서 연결된 다른 노드들을 함께 구한다.

    static int n = 8;
    static int[][] graph;
    static int level = 0;

    public static void main(String[] args) throws IOException {

        graph = new int[n+1][n+1];

        // 참조하는 데 사용한 블로그에 있는 예시 그래프
        addLineWeight(1,2,3);
        addLineWeight(1,5,4);
        addLineWeight(1,4,4);
        addLineWeight(2,3,2);
        addLineWeight(3,4,1);
        addLineWeight(4,5,2);
        addLineWeight(5,6,4);
        addLineWeight(4,7,6);
        addLineWeight(7,6,3);
        addLineWeight(3,8,3);
        addLineWeight(6,8,2);

        dijkstra(1);




//        addLine(0,1);
//        addLine(0,2);
//        addLine(1,3);
//        addLine(1,4);

        /*
        for(int i=0;i<n;i++){

            System.out.print(i + " 의 연결 : ");
            findChain(i,visited);
            System.out.println();
        }
         */

        // boolean[] visited = new boolean[n];

        // findLevel(0,visited);


    }

    private static void dijkstra(int v){
        int[] distance = new int[n+1];
        boolean[] check = new boolean[n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[v] = 0;
        check[v] = true;

        for(int i=1;i<n+1;i++){
            if(!check[i] && graph[v][i] != 0){
                distance[i] = graph[v][i];
            }
        } // 직접적으로 연결된 노드의 거리 계산

        for(int a=0;a<n-1;a++){
            // 모든 노드가 true일 때까지 반복문을 도는 부분을
            // n개의 노드 중에서 n-1개의 노드를 본다와 같은 의미로 볼 수 있다.
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i] != Integer.MAX_VALUE){
                    if(distance[i] < min){
                        min = distance[i];
                        minIdx = i;
                    }
                }
            } // 방문하지 않은 노드 중 distance가 최소인 것을 찾는다.

            check[minIdx] = true; // distance가 최소인 check를 true로 변경
            for(int i=1;i<n+1;i++){
                if(!check[i] && graph[minIdx][i] != 0){
                    // distance가 최소인 idx와 연결되고 방문하지 않은 노드를 거치는 거리 비교
                    if(distance[i] > distance[minIdx] + graph[minIdx][i]){
                        distance[i] = distance[minIdx] + graph[minIdx][i];
                    }
                }
            }
        }

        for(int i=1;i<n+1;i++){
            System.out.println(distance[i]);
        }



    }
    private static void findLevel(int start, boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);


        while(!que.isEmpty()){

            System.out.println(" level = " + level + " -------------- " );

            int qsize = que.size();
            for(int i=0;i<qsize;i++){
                int v = que.poll();
                System.out.println(v + " ");

                for(int j=0;j<n;j++){
                    if(graph[v][j] == 1 && !visited[j]){
                        que.add(j);
                        visited[j] = true;
                    }
                }
            }

            level++;
        }


    }

    private static void findChain(int start,boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int v = que.poll();
            System.out.print(v +  " ");

            for(int i=0;i<n;i++){
                if(graph[v][i] == 1 &&!visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void addLine(int a, int b){
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    private static void addLineWeight(int a,int b,int w){
        graph[a][b] = w;
        graph[b][a] = w;
    }
}
