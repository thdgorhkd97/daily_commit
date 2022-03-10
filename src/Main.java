import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java
    // bfs dfs 순열 중복순열 조합
    // bfs와 dfs의 개념 및 dfs로 구현하는 순열, 중복순열, 조합에 대해서 개념이 잘 안잡힌 것 같아서
    // 다시 한 번 확실히 정리하는 시간을 가졌다.
    // dfs 자체로 구현하는 방법도 그렇지만 순열이나 조합같은 경우는 다른 문제에서
    // 많이 활용할 수 있는 개념이라고 생각하기 때문에 더 생각해야 할 것 같다.
    // 그리고 dfs를 스택을 이용해서 구현한 것이 아니라 재귀를 이용해서 구현하였는데
    // 이렇듯 여러 가지 상황을 통해서 구현 가능하다는 것도 알고 상황이나 문제 조건에 따라서
    // 선택해야 하기에 경우의 수를 모두 알고 선택해야 할 것으로 보인다.

    public static void main(String[] args) throws IOException {

        int[][] map = new int[5][5];

        addLine(0,1,map);
        addLine(0,4,map);
        addLine(1,2,map);
        addLine(0,2,map);
        addLine(3,2,map);
        addLine(4,2,map);
        addLine(3,4,map);

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        boolean[] visited = new boolean[map.length];

        System.out.println(" dfs 실행 순서 ");
        dfs(0,visited,map);

        System.out.println();
        visited = new boolean[map.length];
        System.out.println(" bfs 실행 순서");
        bfs(0,visited,map);

        System.out.println();


        int[] arr = {1,2,3,4,5};
        visited = new boolean[arr.length];
        int depth = 0;
        int[] result = new int[arr.length];
        System.out.println(" permutation ");
        permutation(result,arr,depth,3,visited);
        System.out.println();

        visited = new boolean[arr.length];
        result = new int[arr.length];
        System.out.println(" 중복 있는 permutation ");
        permutationCanRepeat(result,arr,depth,3,visited);

        System.out.println();
        visited = new boolean[arr.length];
        result = new int[arr.length];
        int startIdx = 0;
        System.out.println(" 조합 (순서 바꾼 순열이 없도록) ");
        permutationNoRepeat(result,arr,depth,3,visited,startIdx);

    }

    private static void permutationNoRepeat(int[] result, int[] arr, int depth, int r, boolean[] visited,int start) {
        if(depth == r){
            for(int i=0;i<r;i++){
                System.out.print(result[i]+ " ");
            }
            System.out.println();
            return ;
        }

        for(int i=start;i<arr.length;i++){
            result[depth] = arr[i];
            permutationNoRepeat(result,arr,depth+1,r,visited,i+1);
        }


    }

    private static void permutationCanRepeat(int[] result, int[] arr, int depth, int r, boolean[] visited) {
        if(depth == r){
            for(int i=0;i<r;i++){
                System.out.print(result[i]+ " ");
            }
            System.out.println();
            return ;
        }

        for(int i=0;i<arr.length;i++){

               result[depth] = arr[i];
            permutationCanRepeat(result,arr,depth+1,r,visited);

        }
    }

    public static void permutation(int[] result,int[] arr,int depth,int r,boolean[] visited){
        if(depth == r){
            for(int i=0;i<r;i++){
                System.out.print(result[i]+ " ");
            }
            System.out.println();
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                permutation(result,arr,depth+1,r,visited);
                visited[i] = false;
            }
        }
    }



    public static void bfs(int start, boolean[] visited, int[][] map){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int v = que.poll();
            System.out.print(v+ " ");
            for(int i=0;i<map.length;i++){
                if(map[v][i] == 1 && !visited[i]){
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int start,boolean[] visited,int[][] map){
        visited[start] = true;
        System.out.print(start + " ");

        for(int i=0;i<visited.length;i++){
            if(map[start][i] == 1 && !visited[i] ){
                dfs(i,visited,map);
            }
        }
    }

    public static void addLine(int edge1,int edge2,int[][] map){
        map[edge1][edge2] = 1;
        map[edge2][edge1] = 1;
    }
}
