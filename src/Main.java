import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 가장 먼 노드
    // bfs를 통해 그래프를 훑어가면서 1로부터 최대 거리인 점의 수를 찾는 문제
    // bfs를 구현하여 거리는 모두 구했지만 메모리 초과가 났다.
    // 처음에 graph[][] 2중 배열을 사용했을 때가 메모리 초과가 생겻는데
    // ArrayList<ArrayList<Integer>> 이렇게 2중 리스트를 구현하니 메모리 이슈가 해결되었다.
    // 아무래도 bfs를 위해서 이중 배열의 모든 원소를 확인하여 1인지 확인하다 보니
    // 이중 배열로 구현하니까 큰 그래프에서 순회가 많아져 메모리 초과가 발생한 것으로 보인다.
    // 단순히 배열과 list가 순회와 삽입 삭제 에서만 속도 차이가 있다고 알고 있는데
    // 순회적인 측면을 강조해야 하는 bfs이다 보니 처음부터 이중 배열을 선택했는데
    // 절대적인 게 아니라는 걸 또 깨닫게 되었다.

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edge.length;i++){
            list.add(new ArrayList<Integer>());
        }
        //노드 연결
        int a, b;
        for(int[] node:edge){
            a=node[0];
            b=node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

//        for(int i=1;i<graph.length;i++){
//            for(int j=1;j<graph.length;j++){
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        int[] distance = new int[n+1];

        distance[1] = 1;
        que.offer(1);
        check[1] = true;

        while(!que.isEmpty()){
            int idx = que.poll();
            System.out.println(idx + " 에 대해서 확인해보자 ");

            for(int v : list.get(idx)){
                if(!check[v]){
                    que.offer(v);
                    check[v] = true;
                    distance[v] = distance[idx] + 1;
                }
            }

        }

        int answer = 0;
        int max = 0;
        for(int num : distance){
            if(num > max){
                max = num;
                answer = 1;
            }
            else if(num == max){
                answer ++;
            }
        }

        System.out.println(answer);




   }
}