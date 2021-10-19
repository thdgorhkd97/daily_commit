import java.util.*;

public class Main {

    // programmers level 2 - 전력망을 둘로 나누기
    // 며칠동안 될 듯 안될듯 해서 결국 풀이를 보고 나서야 해결하였다.
    // 내가 못한 이유
    // 1. 각 정점에 연결된 다른 노드들을 배열로 넣을 때 해쉬와 같은 방향으로 넣어야 했다
//    1 -> 2 6
//    2 -> 1 6
//    3 -> 5 4 이런식으로 각 정점에 연결된 다른 정점을 표현하는 것이 훨씬 편하게 조절 가능하다
    // 2. bfs를 표현하는 방식이 약간 다르다.
    // check가 true 일때 안 하고 false일때 재귀로 다시 하는 식으로 해야 했다.

    // 전체적인 코드는 비슷했는데 디테일적인 부분이 약간씩 달랐다.
    // 인접배열로 표현한 방식을 해쉬와 같은 방식으로 넣는 등의 변화를 시도했으면
    // 더 좋았을 텐데 더 많은 방식으로 접근해봐야 할 것 같다.

   static ArrayList[] array;

    public static void main(String[] args) {

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{8,9}};

        int answer = 101;
        array = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            array[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < wires.length; i++) {
            array[wires[i][0]].add(wires[i][1]);
            array[wires[i][1]].add(wires[i][0]);
        }

        for(int i = 0 ; i < wires.length; i++) {
            boolean[] check = new boolean[n+1];
            check[wires[i][0]] = true;
            check[wires[i][1]] = true;
            int a = bfs(wires[i][0],check);
            int b = bfs(wires[i][1],check);
            answer = Math.min(answer, Math.abs(a-b));
        }

        System.out.println(answer);

    }
    private static int bfs(int index,boolean[] check) {
        int sum = 1;
        check[index] = true;
        for(int i = 0 ; i < array[index].size(); i++){
            if(check[(int)array[index].get(i)]) continue;
            sum += bfs((int) array[index].get(i),check);
        }

        return sum;
    }

}