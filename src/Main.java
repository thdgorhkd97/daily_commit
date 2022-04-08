import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 파괴되지 않은 건물
    // board 배열을 갱신해 나가면서 skill의 1 ~ 4 까지의 범위를
    // 수정해가는데 skill을 for문으로 돌리고 skill의 1~4 까지를 for문으로 하는데
    // 3중 for문이 되어 효율성을 초과하게 된다...
    // for문을 돌리긴 해야 할 것 같은데 오히려 문제가 간단한 편이라 시간을 어떻게 줄여야 하는지
    // 잘 모르겠다 (효율성을 체크해야 한다..)

    public static void main(String[] args) throws IOException {

        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        int[][] sum = new int[board.length][board[0].length];
        for(int[] row : skill){
            int degree = 0;
            if(row[0] == 1){ // type == 1 공격
                degree = row[5] * (-1);
            }
            else{ // type == 2 힐
                degree = row[5];
            }
        }

        /* 정확성에 대해서는 맞지만 효율성 X
        for(int i=0;i<skill.length;i++){
            if(skill[i][0] == 1){ // type == 1 (공격)
                for(int j=skill[i][1]; j<=skill[i][3];j++){
                    for(int k=skill[i][2]; k<=skill[i][4];k++){
                        board[j][k] -= skill[i][5];
                    }
                }
            }
            else{ // type == 2 (힐)
                for(int j=skill[i][1]; j<=skill[i][3];j++){
                    for(int k=skill[i][2]; k<=skill[i][4];k++){
                        board[j][k] += skill[i][5];
                    }
                }
            }
        }

        int answer = 0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] > 0) answer++;
            }
        }

        System.out.println(answer);
         */
    }

}