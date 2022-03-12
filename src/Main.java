import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // sk 계열사 코딩 테스트 1번 문제
    // 오늘 코딩 테스트를 봤는데 조금 아쉬워서 내가 마무리한 코드를 다시 정리해본다
    // money를 만들기 위해 정해진 금액의 동전을 얼만큼 사용했을 때 가장 작은 금액으로 만들 수 있는지 만드는 문제였다.
    // 각 동전마다 사용하는 데 드는 돈이 다르다.
    // 그래서 문제에 접근할 때 같은 금액이라 가정했을때 드는 비용이 작은 걸 찾으려고 했다.(비용이 작을수록 해당 동전을 많이 사용해야 한다는 뜻)
    // 예를 들어 100원을 만들때 9원이 들고 500원을 만들때 50원이 들면 100원 * 5 => 45원 이므로 500원 하나보다 100원짜리 5개를 쓰는 게 최소다.
    // 그렇게 동전의 우선순위를 정해서 목표 금액에서 우선순위에 따른 동전의 금액만큼 빼가면서 정답에 값을 더해나간다.


    public static void main(String[] args) throws IOException {

        int money = 1999;
        int[] costs = {2, 11, 20, 100, 200, 600};

        int[] coin = {1,5,10,50,100,500};

        int[][] value = new int[6][2];

        for(int i=0;i<value.length;i++){
            value[i][0] = i;
            value[i][1] = costs[i] * (500/coin[i]);

        }

        Arrays.sort(value, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int idx = 0;
        while(money > 0){

            for(int i=idx;i<6;i++) {
                while (money >= coin[value[i][0]]) {
                    answer += costs[value[i][0]];
                    money -= coin[value[i][0]];
                }
                if(money < 0 ) break;
            }
        }

        System.out.println(answer);

    }
}