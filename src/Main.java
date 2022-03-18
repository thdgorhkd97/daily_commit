import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 다익스트라 알고리즘
    // 다익스트라 알고리즘을 활용한 문제를 풀었는데 조금 흔들리는 것 같아서 개념을 다시 정리하기로 했다.
    // 다익스트라 알고리즘은 양의 간선 가중치를 가진 경우에만 해당하기 때문에 실생활에서 유용하다.
    // 먼저 그래프를 무한대로 초기화하고 가중치를 넣은 다음 한 정점에서 다른 정점까지의 거리를
    // 모두 구하는 알고리즘이다.
    // 최단 거리를 저장할 배열(distance)와 노드 방문 여부를 저장한 배열(check)를 만들고
    // 방문하지 않았고 초기 값이 무한대가 아니면 최단 거리 배열을 graph의 값으로 바꾼다.
    // 모든 노드를 돌면서 다른 노드를 거쳐서 가는 경우와 비교한다.

    static int[][] graph = new int[6][6];
    static int n = 6;

    public static void main(String[] args) throws IOException {

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        addLine(0,1,7);
        addLine(0,2,9);
        addLine(0,5,14);
        addLine(1,2,10);
        addLine(1,3,15);
        addLine(2,3,11);
        addLine(2,5,2);
        addLine(3,4,6);
        addLine(4,5,9);

        dijkstra(0);

    }

    private static void dijkstra(int v){
        int[] distance = new int[n];
        boolean[] check = new boolean[n];

        Arrays.fill(distance,Integer.MAX_VALUE); // 시작점을 0으로 초기화할 것이기 때문에 기본 초기화는 Integer.Max로 한다.

        distance[v] = 0; // 시작점 초기화
        check[v] = true; // 방문했다는 표시

//        for(int i=0; i<n; ++i){ if(distance[i] == 2147483647)
//            System.out.print("∞ ");
//            else System.out.print(distance[i]+" "); }
//        System.out.println("");

        for(int i=0;i<n;i++){
            if(!check[i] && graph[v][i] != Integer.MAX_VALUE){ // 방문한 적 없고 무한대가 아니면 직접 연결이기때문에 거리를 입력
                distance[i] = graph[v][i];
            }
        }

        for(int i=0; i<n; ++i){ if(distance[i] == 2147483647)
            System.out.print("∞ ");
        else System.out.print(distance[i]+" "); }
        System.out.println("");

        for(int i=0;i<n-1;i++){
            int min = Integer.MAX_VALUE;
            int min_idx = -1;

            for(int j=0;j<n;j++){ // 해당 노드의 최소값 찾기
                if(!check[j]){
                    if(distance[j] < min){
                        min = distance[j];
                        min_idx = j;
                    }
                }
            }

            check[min_idx] = true;
            for(int j=0;j<n;j++){ // 다른 노드를 거치는 거랑 비교
                if(!check[j] && graph[min_idx][j] != Integer.MAX_VALUE){
                    if(distance[min_idx] + graph[min_idx][j] < distance[j]){
                        distance[j] = distance[min_idx] + graph[min_idx][j];
                    }
                }
            }


        }

        for(int k=0; k<n; ++k){ if(distance[k] == Integer.MAX_VALUE)
            System.out.print("∞ ");
        else System.out.print(distance[k]+" "); }
        System.out.println("");

    }
    private static void addLine(int a,int b,int weight){

        graph[a][b] = weight;
        graph[b][a] = weight;
    }
}
