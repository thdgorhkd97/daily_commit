import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 크루스칼 알고리즘 ( MST )
    // MST 개념을 익히기 위해서 크루스칼 알고리즘을 공부하였다.
    // 최소의 가중치를 가진 간선을 더해가면서 양쪽 정점의 부모 정점을 파고 들어가면서
    // 사이클이 발생하는지를 파악하고 ( find를 통해서)
    // 사이클이 발생하면 해당 간선을 더하지 않고 사이클이 아니면 더해 나가면서
    // union을 통해서 더하는 간선의 양 정점의 부모 정점을 변경해 나간다.

    static int[] parent;

    public static void main(String[] args){

        int n = 4;

        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        parent = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
        }

        int answer = 0;

        for(int i=0;i<costs.length;i++){

            if(find(costs[i][0]) == find(costs[i][1])){ // 사이클 발생 경우
                continue;
            }

            answer += costs[i][2];

            union(costs[i][0],costs[i][1]);
        }

        for(int i=0;i<n;i++){
            System.out.print(parent[i] + " ");
        }



    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];
        if (pa == pb) {
            System.out.println(pa + " = " + pb);
            return;
        }
        System.out.println(parent[pa] + " 를 " + pb + " 로 바꿉니다.");
        parent[pa] = pb;
    }
}