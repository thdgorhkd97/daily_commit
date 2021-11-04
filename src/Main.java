import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers - 정수 삼각형
    // 위에서부터 맨 아래로 내려오면서 거치는 숫자의 최대 합을 구하는 문제다
    // 딱 보는순간 동적 계획법이라는 게 바로 보일만한 전통적인 유형의 문제인 것 같다.
    // 다만 각 행의 맨 앞과 맨 뒤를 if 로 빼서 조건문을 걸었는데
    // 윗 줄의 합을 더 하는 걸 묶어서 한 번에 코드로 정리하면 더 좋을 것 같다.

    public static void main(String[] args) {

        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5

        triangle[1][0] += triangle[0][0];
        triangle[1][1] += triangle[0][0];

        for(int i=2;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }
                else if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
        }

        int max = 0;
        for(int i=0;i< triangle[triangle.length-1].length;i++){
            max = Math.max(max,triangle[triangle.length-1][i]);
        }

        System.out.println(max);





    }
}