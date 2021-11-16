import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 4 - 도둑질
    // 동적계획법에는 자신 있는 것 같다.
    // 다만 원형으로 위치한 집에서 인접한 집을 훔치지 못한다는 기준때문에
    // 원형을 어떻게 표현할까에 대해서 조금 시간이 걸렸다.
    // 원형으로 연결되었다는 것은 배열에서 처음과 마지막만 따로 신경쓰면 되기 때문에
    // 첫번째를 훔치는 경우와 첫번째를 훔치지 않는 경우로 나눠서
    // 최대값을 구하였다.
    // 돈에 대한 동적계획법은 2번 전의 집과 현재 집을 더한 값과 하나전의 집 중에서
    // 더 큰 값을 고르는 것으로 동적계획법을 실행하엿다.

    public static void main(String[] args) {

        int[] money = {1,2,3,1};
        int answer = 0;

        int[] steal1 = new int[money.length];
        int[] steal2 = new int[money.length];

        // case 1 : 첫 집 훔치고 마지막 집 안 훔치는 경우
        int case1 = 0;
        steal1[0] = money[0];
        steal1[1] = Math.max(money[0],money[1]);
        for(int i=2;i<steal1.length-1;i++){
            steal1[i] = Math.max(steal1[i-2] + money[i],steal1[i-1]);
            case1 = Math.max(steal1[i],steal1[i+1]);
        }


        // case 2 : 첫 집 안 훔치면
        int case2 = 0;
        steal2[0] = 0;
        steal2[1] = money[1];
        for(int i = 2;i<steal2.length;i++){
            steal2[i] = Math.max(steal2[i-2] + money[i], steal2[i-1]);
            case2 = Math.max(steal2[i-1],steal2[i]);
        }


        System.out.println("첫 집 털때 : ");
        for(int i=0;i<steal1.length;i++){
            System.out.print(steal1[i] + " ");
        }
        System.out.println();
        System.out.println("첫 집 안 털때");
        for(int i=0;i<steal1.length;i++){
            System.out.print(steal2[i] + " ");
        }
        System.out.println();

        System.out.println(Math.max(case1,case2));

    }
}