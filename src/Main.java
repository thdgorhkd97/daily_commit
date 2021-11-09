import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 정수 삼각형
    // 한번 해봤던 문제인데 가장 앞의 인덱스와 가장 뒤의 인덱스를
    // 따로 함수로 빼는 것이 아니라 if else를 통해서 하나의 분기문으로 처리함
    // if else 분기문도 없이 하나의 조건으로 처리하고 싶었는데
    // for문의 범위에서 벗어나는 경우가 있기 때문에 예외 처리 조건이 없어서는
    // 불가능할 것으로 보입니다.


    public static void main(String[] args) {

        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        for(int i=1;i<triangle.length;i++){
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


        int answer = 0;
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        System.out.println(answer);

    }
}