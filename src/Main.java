import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 숨바꼭질
    // bfs를 활용한 문제라고 할 수 있다.
    // 정해진 위치에서 해당 위치로 -1 +1 *2 의 위치로 움직이는 걸 선택하면서
    // 최소횟수로 이동할 수 있는 경우를 구하는 것이다.
    // 처음 위치인 N에서부터 -1 +1 *2를 bfs로 넣고 만약 그 수에 해당하는
    // boolean 배열인 visited가 false 라면 해당 수에 처음 접근하는 것이므로
    // 최소라는 소리가 되는 거니까 그 수를 만든 경우에서 +1을 해서 넣는다.
    // ex) dp[10] = dp[5] + 1( visited[10] = false 라면)

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        boolean[] visited = new boolean[100001];
        dp = new int[100001];

        dp[N] = 0;
        System.out.println(bfs(N,K,visited));


    }

    private static int bfs(int N,int K,boolean[] visited){

        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visited[N] = true;

        while(!que.isEmpty()){
            int v = que.poll();

            int nextMove = 0;
            for(int i=0;i<3;i++) {

                switch (i){
                    case 0 : nextMove = v-1; break;
                    case 1 : nextMove = v+1; break;
                    case 2 : nextMove = 2*v; break;
                }



                if (nextMove >= 0 && nextMove <= 100000) {
                    if (!visited[nextMove]) {
                        que.offer(nextMove);
                        dp[nextMove] = dp[v] + 1;
                        visited[nextMove] = true;
//                        System.out.println(nextMove + " 는 " + dp[v]+ " 에서 1번 더 이동");
                    }
                }
                if (nextMove == K) {
                    return dp[nextMove];
                }
            }

        }
        return 0;
    }


}