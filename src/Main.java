import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 섬 연결하기
    // greedy 방식으로 섬을 최소 비용으로 연결하기 문제
    // 그래프에서 최소 비용으로 연결하기를 알아보니까 크루스칼 알고리즘을 사용하여
    // MST를 구해야 한다고 알아서 구현해보려고 했는데
    // 아무래도 개념만 읽고 바로 구현하기에는 부족한 듯 싶다.
    // MST 개념을 비롯한 그래프 개념에 대해서 조금 부족한 것 같은데 내일은
    // mST와 같은 그래프 관련 개념에 대해서 공부해보려한다.

    public static void main(String[] args) {

        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
//        for(int i=0;i<costs.length;i++){
//            System.out.println(costs[i][0] + " " + costs[i][1] + " " + costs[i][2]);
//        }

        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int answer = 0;

        for(int i=0;i<costs.length;i++){
            if(parent[costs[i][0]] == parent[costs[i][1]]){
                continue;
            }
            else{
                answer += costs[i][2];
                System.out.println(parent[costs[i][1]] + " 변경 " + costs[i][0] + " 로 ");

                int prev = parent[costs[i][1]];
                parent[costs[i][1]] = costs[i][0];

                if(parent[costs[i][1]] == parent[costs[i][0]]){
//                    System.out.println(answer);
                    answer -= costs[i][2];
                    parent[costs[i][1]] = prev;
                }
            }
        }

        System.out.println(answer);




    }
}