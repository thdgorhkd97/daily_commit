import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 알고리즘 스터디
    // java programmers 가장 큰 정사각형 찾기

    // 1로 이루어진 가장 큰 정사각형의 넓이를 찾는 문제다
    // 처음에는 1인 board[i][j]에서 그 점을 시작으로 오른쪽으로 쭉 1인 부분과
    // 아래로 쭉 1인 부분을 찾아서 그중 작은 값이 정사각형의 길이가 되니까
    // 그렇게 구해지는 정사각형의 최대값을 구하려고 했는데
    // 1인 지점을 찾을 때마다 오른쪽으로 아래로 길이를 구해서 다중 for문을 돌리고 하면
    // 지나치게 오래 걸린다.

    // 그래서 알아본 방법으로는 정사각형의 오른쪽 아래점을 기준으로 길이가 2인 정사각형을
    // 계속해서 알아간다고 생각하면서
    // 그런 정사각형이 어디까지 이어지는지 알아보는식으로 진행하면 된다고 한다.


    public static void main(String[] args) throws IOException {

        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};

        int answer = 1234;
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[i].length;j++){
                if(board[i][j] == 1&&board[i-1][j-1] > 0 && board[i-1][j] > 0 && board[i][j-1] > 0){
                    board[i][j] = Math.min(Math.min(board[i-1][j-1],board[i-1][j]),board[i][j-1]);
                    board[i][j] += 1;
                }
            }
        }

        int max = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++) {
                if (max < board[i][j]) {
                    max = board[i][j];
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        answer = max * max;







    }
}
