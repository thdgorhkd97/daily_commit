import javax.swing.text.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // N사 코딩테스트 3번 문제
    // 선두에 선 트럭은 a만큼 뒤따르는 트럭은 b만큼 연료를 소비할 때 가장 오래 달릴 수 있는 시간 구하기
    // while문에서 for문을 4번이나 돌린 게 맘에 들지 않는다
    // 1. 최대값 구하기 -> 선두에서 가장 많은 연료를 소모할 트럭
    // 2. 전체 트럭중에서 선두 트럭은 a만큼 나머지는 b만큼 연료를 뺀다
    // 3. (종료 조건) 뒤따르는 트럭 중 b만큼의 연료가 없는지 확인
    // 4. (종료 조건) 선두에서 a만큼 연료를 소모할 수 있는 트럭이 없는지 확인
    // 이렇게 while문에서 for문으로 확인하였는데 테스트 케이스에는 짧은 것 밖에 없어서 잘 나왔지만
    // 문제의 조건에서 최대길이가 짧은 편이 아니었던 걸로 기억하는 데 효율성이 괜찮을지 걱정이다.
    // 특히 3,4번은 종료조건을 보는데다가 for문의 범위도 일치했는데 이를 잘 묶어서 코드를 간결하게 만들 수 있지 않았을까하는 아쉬움도 있다.

    public static void main(String[] args) {

        int[] v = {4,5,5};
        int a = 2;
        int b = 1;

        int answer = 0;
        boolean flag = true;

        while( flag ){

            int max = 0;
            int max_idx = 0;
            for(int i=0;i<v.length;i++){
                if(max < v[i]){
                    max_idx = i;
                    max = v[i];
                }
            }

            for(int i=0;i<v.length;i++){
                if(max_idx == i){
                    v[i] = v[i] - a;
                }
                else{
                    v[i] = v[i] - b;
                }
            }


            answer++;

            for(int i=0;i<v.length;i++){
                if(v[i] < b){
                    flag = false;
                    break;
                }
            }

            boolean first = false;
            for(int i=0;i<v.length;i++){
                if(v[i] >= a){
                    first = true;
                    break;
                }
            }

            if( !flag || !first){
                break;
            }
        }
        System.out.println(answer);

    }
}