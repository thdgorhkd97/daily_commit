import java.util.*;

public class Main {

    // programmers level 3 - 네트워크
    // 문제 : 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return
    // computer[i][i]는 무조건 1이고 i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computer[i][j]가 1 이다.
    // for문을 돌면서 연결여부를 파악하는 check 배열을 보며 check가 false이고 computers 배열이 1이면 연결되었다는 걸 표현하기 위해
    // check를 true로 바꾸고 answer에 1을 더한다.
    // 즉, for문을 돌면서 check가 false면 연결된 네트워크를 아직 보지 않았다는 것이므로 연결된 네트워크를 확인하면서 해당 네트워크의
    // 인덱스를 가지는 check를 true로 바꾼다.
    // 연결된 네트워크의 check는 true로 만들고 연결된 네트워크를 모두 돌면 answer+1

    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        boolean[] check = new boolean[n];
        int answer = 0;

        for(int i=0;i<n;i++){
            if(!check[i]){
                dfs(computers,i,check);
                answer++;
            }
        }

        System.out.println(answer);

    }

    static void dfs(int[][] computers, int start,boolean[] check){
        check[start] = true;

        for(int i=0;i< computers.length;i++){
            if(start != i && !check[i] && computers[start][i] == 1){
                dfs(computers,i,check);
            }
        }
    }
}
