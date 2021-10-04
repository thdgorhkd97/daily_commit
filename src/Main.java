import javax.swing.text.View;
import java.util.*;

public class Main {

    // 알고리즘 - bfs 실습
    // bfs 실습문제가 보여서 bfs를 구현하였다.
    // 단, 미리 행렬을 만들어놓은게 아니라 입력을 받아서 실행한다.
    // 한 번에 구현할 수 있을 줄 알았는데 bfs 함수내에서
    // for문의 범위를 graph의 길이만큼으로 했어야 하는데 num으로 했었다.
    // 이 부분이 아쉬웠다.


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        int[][] graph = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            int edge1 = sc.nextInt();
            int edge2 = sc.nextInt();

            graph[edge1][edge2] = 1;
            graph[edge2][edge1] = 1;
        }

        boolean[] visited = new boolean[n+1];

        bfs(s,visited,graph);

    }

    public static void bfs(int start,boolean[] visited,int[][] graph){

        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.println(num);

            for(int i=1;i< graph.length; i++){ // <- i의 범위를 <= num 으로 했었다
                if(!visited[i] && graph[num][i] == 1){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}