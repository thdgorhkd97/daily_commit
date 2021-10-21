import java.util.*;

public class Main {

    // N사 코딩테스트 예시문제
    // 행렬의 영역을 구해서 오름차순으로 정렬하는 문제
    // bfs를 활용해서 문제를 해결하였다.
    // bfs 함수에서 해당 좌표의 상하좌우를 확인하는 부분을 조금 중복되게 코드를 짠 것 같은데
    // 이 부분을 함수로 빼면 조금 더 코드가 간결해질 것 같다.
    // 붙어있는 부분을 재귀를 통해 bfs를 계속 돌리면서 상하좌우로 연결된 영역을 확인하고
    // 그 연결이 끊긴다면 영역크기를 재는 변수를 1로 초기화하여
    // 다른 영역의 크기를 잰다.

    static int cnt = 1;

    public static void main(String[] args) {

        int n = 6;
        ArrayList<Integer> list = new ArrayList<>();

        int[][] matrix = {
                {0,1,1,0,0,0},
                {0,1,1,0,1,1},
                {0,0,0,0,1,1},
                {0,0,0,0,1,1},
                {1,1,0,0,1,0},
                {1,1,1,0,0,0}
        };

        boolean[][] check = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j =0; j<n;j++){
                if(!check[i][j] && matrix[i][j] == 1) {
                    bfs(matrix,i,j,check);

                    list.add(cnt);
                    cnt=1;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void bfs(int[][] matrix, int row, int column, boolean[][] check){
        check[row][column] = true;

        if(row-1 >=0 && !check[row-1][column] && matrix[row-1][column] == 1){
            cnt++;
            check[row-1][column] = true;
            bfs(matrix,row-1,column,check);
        }
        if(row+1 <= matrix.length-1 && !check[row+1][column] && matrix[row+1][column] == 1){
            cnt++;
            check[row+1][column] = true;
            bfs(matrix,row+1,column,check);
        }
        if(column-1 >= 0 && !check[row][column-1] && matrix[row][column-1]==1){
            cnt++;
            check[row][column-1] = true;
            bfs(matrix,row,column-1,check);
        }
        if(column+1 <= matrix[0].length-1 && !check[row][column+1] && matrix[row][column+1] == 1){
            cnt++;
            check[row][column+1] = true;
            bfs(matrix,row,column+1,check);
        }


    }
}