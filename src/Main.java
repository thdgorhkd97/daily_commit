import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers 최소직사각형 & 전력망을 둘로 나누기
    // 최소 직사각형 : 배열의 최대값과 배열의 i번째 원소의 작은 값중 최대값을 곱해서 리턴
    // 전력망을 둘로 나누기 : 각각의 연결선을 하나씩 지워나가면서 양쪽 정점을 기준으로
    // bfs 를 통해 연결된 정점의 개수를 구해서 min 값을 구한다.

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int answer = -1;

        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};

        /*
        int max = 0;
        int maxAmongMin = 0;
        for(int i=0;i<sizes.length;i++){
            max = Math.max(max,Math.max(sizes[i][0],sizes[i][1]));
            maxAmongMin = Math.max(maxAmongMin
                    ,Math.min(sizes[i][0],sizes[i][1]));
        }
        System.out.println(max + " " + maxAmongMin);
         */





        int[][] tree = new int[n+1][n+1];

        for(int i=0;i<wires.length;i++){
            addLine(tree,wires[i][0],wires[i][1]);
        }

        int[][] clone = tree;
        for(int i=0;i<wires.length;i++){

            clone[wires[i][0]][wires[i][1]] = 0;
            clone[wires[i][1]][wires[i][0]] = 0;

            withoutOneLine(clone,wires[i][0],wires[i][1]);

            clone[wires[i][0]][wires[i][1]] = 1;
            clone[wires[i][1]][wires[i][0]] = 1;

        }

        answer = min;
        System.out.println(answer);
    }

    private static void withoutOneLine(int[][] clone, int left, int right) {
        min = Math.min(min,Math.abs(bfs(left,clone) - bfs(right,clone)));
    }

    private static int bfs(int n,int[][] clone) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[clone.length];

        que.add(n);

        int cnt = 1;

        while(!que.isEmpty()){
            int v = que.poll();
            visited[v] = true;

            for(int i=1;i<=clone.length-1;i++){
                if(clone[v][i] == 1 && !visited[i]){
                    que.add(i);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void addLine(int[][] tree, int a,int b) {
        tree[a][b] = 1;
        tree[b][a] = 1;
    }

}