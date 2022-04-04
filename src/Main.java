import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // 내일 면접을 앞두고 있어서 플로이드 와샬 알고리즘을 정리해보려 한다.
    // 플로이드 와샬도 그래프에서 정점에서 정점까지의 최단 경로를 구하는 알고리즘인데
    // 최단 경로를 구하는 다익스트라와의 차이점은 "모든" 정점에서의 최단경로를 구한다는 것
    // 플로이드 와샬의 핵심은 '거쳐가는 정점'을 기준으로 최단 거리를 구한다는 것이다.
    // 그리고 다익스트라는 음의 가중치가 있을 때 불가능하지만
    // 플로이드 와샬은 사이클이 없다면 음수 가중치에 대한 처리가 가능하다.

    // kruskal -> 최소 신장 트리(MST)를 찾는 알고리즘이다.
    // 가중치를 낮은 순에서 높은 순으로 오름차순 정렬한다.
    // 가중치가 가장 낮은 간선부터 선택하면서 양쪽 정점을 union한다.(이때 두 정점이 같은 집합이면
    // 사이클이 있는 것이므로 포함시키지 않는다)


    // (java 불량 사용자) 해결 필요

    static int[][] graph;
    static int[][] dist;

    public static void main(String[] args) throws IOException {

        graph = new int[5][5];
        int N = 5;
        dist = new int[N][N];


        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(i==j){
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 100000;
            }
        }

        addLine(0,1,5);
        addLine(0,2,7);
        addLine(0,4,1);
        addLine(1,2,3);
        addLine(1,3,6);
        addLine(0,3,2);
        addLine(2,3,10);
        addLine(3,4,4);

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }


    }
    private static void addLine(int a,int b, int weight){
        dist[a][b] = Math.min(dist[a][b],weight);
        dist[b][a] = Math.min(dist[b][a],weight);
    }



}
