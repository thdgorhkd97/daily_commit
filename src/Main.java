import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // B사 코딩테스트 5번 문제
    // 전체 map 배열에 0이 없다면 이 조건을 !fullCover로 해서
    // map 배열을 전체를 돌면서 0이 없는지 있는지를 확인하는 식으로 while문을 돌았는데
    // 이게 만약 rows와 columns가 커지면 시간 이슈가 생길 수도 있지 않나 싶다..
    // 해결하는 데는 조금 시간이 걸리긴 했지만 문제 없었다고 생각하는데
    // while문을 돌면서 fullCover를 도는 부분이 조금 걱정이다.git

    public static void main(String[] args) {

        int rows = 3;
        int columns = 4;

        int[][] map = new int[rows+1][columns+1];

        int r = 1;
        int c = 1;
        int num = 1;
        map[r][c] = num;
        while(!fullCover(map) ){

            System.out.println(r+"행 " + c+ "열 " + " 에 " + num);
            if(!fullCover(map) && r==1 && c== 1){
                if(num % 2 == 0){
                    if(map[r+1][c] != 0){
                        break;
                    }
                }
                else{
                    if(map[r][c+1] != 0){
                        break;
                    }
                }
            }

            map[r][c] = num;

            if(num % 2 == 0){
                if(r < rows){
                    r= r+1;
                }
                else{
                    r = 1;
                }
            }
            else{
                if(c < columns){
                    c = c+1;
                }
                else{
                    c = 1;
                }
            }

            num++;
        }

        int[][] answer = new int[rows][columns];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                answer[i-1][j-1] = map[i][j];
            }
        }


    }

    public static boolean fullCover(int[][] map){
        for(int i=1;i<map.length;i++){
            for(int j=1;j<map[0].length;j++) {
                if(map[i][j] == 0){
                    return false; // 0이 있을 때
                }
            }
        }
        return true; // 0이 없을 때
    }
}