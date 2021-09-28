import javax.swing.text.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // programmers 위클리 코드 8주차
    // 직사각형의 사이즈의 배열을 가지고 모든 사이즈를 커버할 수 있는 사이즈를 구한다.
    // 명함을 돌리는 게 가능하기 때문에 긴 쪽을 sizes[i][0]으로 놔두고
    // sizes[i][0] 중의 최대값과 sizes[i][1]의 최대값을 구한다.

    public static void main(String[] args) {

        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};

        int answer = 0;

        int max = 0;
        for(int i=0;i< sizes.length;i++){
            int tmp = 0;
            if(sizes[i][0] <= sizes[i][1]){ // 긴쪽을 sizes[i][0]으로 놔둔다
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            if(max < sizes[i][0]){
                max = sizes[i][0];
            }

        } // 최대값을 구한다 반드시 한쪽길이는 최대길이가 되야 하니까

        int max2 = 0;
        for(int i=0;i<sizes.length;i++){ // 명함의 짧은 쪽인 sizes[i][1] 중에서 최대값을 구한다.
            if(max2 < sizes[i][1]){
                max2 = sizes[i][1];
            }
        }

        answer = max * max2; // answer = 모든 명함을 커버할 수 있는 지갑
    }
}