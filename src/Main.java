import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 단속카메라
    // 최대한 적은수의 카메라로 모든 차량을 한번이상 커버해야 하기 때문에
    // 맨 앞의 가장 마지막 범위에 첫 카메라를 설치하고 그 이후로 그 카메라를 범어나는 범위가 있다면
    // 그 차량의 가장 마지막에 추가적인 카메라를 설치한다.
    // 처음에는 가장 겹치는 부분을 설치하려고 했는데 그렇게 하면 모든 부분을 체크해야 하기 때문에
    // 시간적으로 문제가 생겼다
    // 그래서 정렬을 한 후에 이런 방식으로 해야 했다.
    // (처음에 -30000 ~ 30000 까지의 int[] 배열을 더해서 모든 차량이 지나는 구간을 구했는데 처음에는 시간 상으로
    // 너무 큰 손해가 나온다.)

    public static void main(String[] args) {

        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        Arrays.sort(routes,(a,b)->Integer.compare(a[1],b[1]));

//        for(int i=0;i<routes.length;i++){
//            System.out.println(routes[i][0] + " " + routes[i][1]);
//        }

        int answer = 1;
        int max = routes[0][1];
        for(int i=1;i< routes.length;i++){
            if(max < routes[i][0]) {
                answer++;
                max = routes[i][1];
            }
        }

        System.out.println(answer);



   }
}