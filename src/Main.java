package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 2644 촌수계산
    // 처음에는 tree를 구현해서 depth 차이를 계산해야 하나 싶었는데 생각해보니
    // 부모 자식 관계만 파악하면 되기 때문에 tree를 구현할 필요까진 없을 것으로 보였다.
    // 그래서 부모 자식 관계만 넣은 일차원 배열(d)을 만든 다음에
    // bfs를 통해 첫 지점에서부터 출발해서 2차원 배열 map[][] 의 map[v][i]가 1이면
    // 연결된 것이기 때문에 거리를 입력한다는 의미에서 d[i] = d[v] + 1을 해준다.
    // 그러다가 원하는 도착지점에 도달하면 로직을 끝내고 만약 bfs로 타고타고 가더라도
    // 해당 정점을 거치지 않았다면 연결되어 있지 않다는 것이므로 -1을 리턴한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int one = Integer.parseInt(stk.nextToken());
        int two = Integer.parseInt(stk.nextToken());

        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            map[y][x] = 1;
            map[x][y] = 1;
        }

        int[] d = new int[n+1];


        bfs(one, two,d,map);

        if(d[two] == 0){
            System.out.println("-1");
        }
        else System.out.println(d[two]);
    }

    private static void bfs(int one, int two,int[] d,int[][] map) {

        Queue<Integer> que = new LinkedList<>();
        que.add(one);

        while(!que.isEmpty()){
            int v = que.poll();

            if(v == two) break;

            for(int i=1;i<=map.length-1;i++){
                if(map[v][i] == 1 && d[i] == 0){
                    d[i] = d[v] + 1;
                    que.add(i);
                }
            }
        }

    }
}