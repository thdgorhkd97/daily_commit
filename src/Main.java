import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 파괴되지 않은 건물

    // 누적합을 활용해야 활용성을 통과할 수 있는 문제다
    // 누적합으로 문제를 해결하는 방법에 대해서 잘 알고 있지 않아서 시간이 상당히 걸렸다
    // 풀이 방법에 대해서는 이해가 가는 것 같은데 막상 array의 범위를 벗어나게 되는데 이게
    // 정확한 풀이 방법을 아직 이해하지 못한 것 같다.
    // 해당 문제를 마무리하고 누적합의 개념에 대해 제대로 파악해야 할 필요가 있을 것 같다..


    public static void main(String[] args) throws IOException {

        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        int[][] prefix = new int[board.length][board[0].length];

        for(int[] row : skill){
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = 0;
            if(row[0] == 1){
                degree = -row[5];
            }
            else{
                degree = row[5];
            }

            for(int i=r1;i<r2;++i){
                prefix[i][c1] += degree;
                prefix[i][c2] += degree;
            }
        }

        int answer = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(j!=0) prefix[i][j] += prefix[i][j-1];
                board[i][j] += prefix[i][j];
                if(board[i][j] > 0) answer++;
            }
        }

        System.out.println(answer);
    }

}