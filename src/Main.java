import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 빙고문제인데
    // 세로와 대각을 구현하지못했다.
    // 잘못한것같다..

    public static void main(String[] args) {

        //int[][] board = [[11,13,15,16],[12,1,4,3],[10,2,7,8],[5,14,6,9]]
        // int[] nums = [14,3,2,4,13,1,16,11,5,15]
        // answer = 3;
        int answer = 0;
        final int n = board.length;
        for(int number:nums){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j] == number){
                        board[i][j] = 0;
                        break;
                    }
                }
            }
        }



        answer = garo(board) + sero(board) + daegak(board);
        return answer;
    }
    public static int garo(int[][] board){
        boolean flag = false;
        int answer=0;
        for(int i=0;i<board.length;i++){
            flag = false;
            for(int j=0;j<board.length;j++){
                if(board[i][j] != 0){
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        System.out.println(" garo : " + answer);
        return answer;
    }
    public static int sero(int[][] board){
        boolean flag = false;
        int answer=0;
        int column = 0;
        for(int i=0;i<board[0].length;i++){
            column = 0;
            while(column < board.length){
                if(board[column][i] != 0){
                    flag = true;
                    break;
                }
                column++;
            }
            if(!flag) answer++;
        }

        System.out.println(" sero : " + answer);
        return answer;
    }

    public static int daegak(int[][] board){
        boolean flag = false;
        int answer=0;
        int i=0;
        int j=0;

        while(i < board.length && j < board[0].length){
            if(board[i][j] != 0){
                flag = true;
                break;
            }
            i++;
            j++;
        }
        if(!flag) answer++;

        i=board.length-1;
        j=0;
        while(i >=0 && j < board[0].length){
            if(board[i][j] != 0){
                flag = true;
                break;
            }
            i--;
            j++;
        }
        if(!flag) answer++;



        System.out.println(" daegak : " + answer);
        return answer;
    }
}