import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // 코딩테스트 중 1번 문제
    // ?로 들어오는 부분은 a,b,c 중 하나로 바뀐다고 할 때 a,b,c 모두가 연결되는 게
    // 몇 가지 경우인지 확인하는 문제이다.

    // 그래서 나는 ?의 개수를 파악하고 해당 개수만큼으로 combination을 구해서 ?를 a,b,c로 채울 수 있는
    // 모든 경우의 수를 구한 다음에 a,b,c에 대해서 bfs로 연결된 a,b,c를 체크하고 모든 부분을 방문했는지 확인하여 마무리한다

    // 위의 방식대로 했다. 문제 해결은 완료했는데 시간적으로 줄일 수 있는 부분이 있을 것 같다는 생각이 든다.
    // a,b,c에 대해서 모든 부분이 연결되어 있다면 a,b,c 에 대해 한번씩만 bfs를 돌면서 visited[][] 를 true로 바꾸면 될 것이라 생각했는데
    // 천천히 생각을 다시 해보니 가장 마지막에 false로 남아있는걸 확인하는 것이 아니라 중간중간에 이미 bfs를 돌린 문자에 대해서
    // visited[][] 가 false라면 다른 문자를 돌지 않았어도 다로 break로 빠져서 끝낼 수 있었을 것 같다.

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        String[] grid = { "cc?"};

        int letter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                if(grid[i].charAt(j) == '?'){
                    letter ++;
                }
            }
        }

        char[] ch = {'a','b','c'};

        char[] result = new char[letter];
        int depth = 0;

        combination(ch,result,depth,grid);

        System.out.println(answer);

    }

    private static void combination(char[] ch, char[] result, int depth,String[] grid){
        if(depth == result.length){

            if(allChain(result,grid)){
                answer++;
            }
            return ;
        }

        for(int i=0;i<ch.length;i++){

            result[depth] = ch[i];
            combination(ch,result,depth+1,grid);
        }
    }

    private static boolean allChain(char[] result,String[] grid){
        int idx = 0;
        char[][] copy = new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                if(grid[i].charAt(j) == '?'){
                    copy[i][j] = (result[idx++]);
                }
                else copy[i][j] = (grid[i].charAt(j));
            }
        }

        boolean[] ABC = new boolean[3]; // 0 -> A, 1->B, 2->C
        boolean[][] visited = new boolean[copy.length][copy[0].length];
        for(int i=0;i<copy.length;i++){
            for(int j=0;j<copy[0].length;j++){
                if(copy[i][j] == 'a' && !ABC[0]){
                    ABC[0] = true; // a에 대한 색칠 완료
                    bfs(copy,visited,i,j);
                }
                else if(copy[i][j] == 'b' && !ABC[1]){
                    ABC[1] = true;
                    bfs(copy,visited,i,j);
                }
                else if(copy[i][j] == 'c' && !ABC[2]){
                    ABC[2] = true;
                    bfs(copy,visited,i,j);
                }
            }
        }

// for(int i=0;i<copy.length;i++) {
// for (int j = 0; j < copy[0].length; j++) {
// System.out.print(copy[i][j] + " ");
// }
// System.out.println();
// }
//
// for(int i=0;i< visited.length;i++){
// for(int j=0;j<visited[0].length;j++){
// System.out.print(visited[i][j] + " ");
// }
// System.out.println();
// }
//
// System.out.println("--------------------------------------");

        for(int i=0;i< visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                if(!visited[i][j]) return false;
            }
        }

        return true;
    }
    private static void bfs(char[][] copy,boolean[][] visited,int a,int b){
        Queue<Character> que = new LinkedList<>();

        visited[a][b] = true;
        que.add(copy[a][b]);

        while(!que.isEmpty()){
            char ch = que.poll();

            if(a-1 >= 0 && copy[a-1][b] == ch && !visited[a-1][b]){
                bfs(copy,visited,a-1,b);
            }
            if(a+1 < copy.length && copy[a+1][b] == ch && !visited[a+1][b]){
                bfs(copy,visited,a+1,b);
            }
            if(b-1 >= 0 && copy[a][b-1] == ch && !visited[a][b-1]){
                bfs(copy,visited,a,b-1);
            }
            if(b+1 < copy[0].length && copy[a][b+1] == ch && !visited[a][b+1]){
                bfs(copy,visited,a,b+1);
            }
        }

    }

}
