import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers 커뮤러닝 3일차
    // 이분탐색 -> 항상 서치하는 경우에 시간이 문제가 되었는데
    // 이럴 경우에 사용할 수 있는 이분탐색에 대해서 확실히 인지할 수 있는 시간이었다.
    // 정렬되있는 경우에 대해서 전체를 확인하는 것이 아니라
    // 최소 최대의 사이값으로 변환해 가면서 값을 확인하는 개념이다.

    public static void main(String[] args) {

        int[] budgets = {120,110,140,150};

        int M = 485;
        int answer = 0;

        int max = 0;
        for(int i=0;i<budgets.length;i++){
            max = Math.max(max,budgets[i]);
        }

        int top = max;
        int floor = 1;

        while(true){
            int mid = (top + floor) / 2;
            int bud = 0;
            for(int i=0;i<budgets.length;i++){
                if(budgets[i] > mid){
                    bud += mid;
                }
                else{
                    bud += budgets[i];
                }
            }


            if(bud <= M){
                floor = mid;
            }
            else{
                top = mid;
            }

            if(Math.abs(top-floor) == 1){
                int bud_top = 0;
                for(int i=0;i<budgets.length;i++){
                    if(budgets[i] > top){
                        bud_top += top;
                    }
                    else{
                        bud_top += budgets[i];
                    }
                }

                if(bud_top > M){
                    answer = floor;
                }
                else{
                    answer = top;
                }
                break;
            }
        }

        System.out.println(answer);
    }
}