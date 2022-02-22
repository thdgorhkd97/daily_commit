import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 13305 주유소

    // 5(도시의 주유값) 2(거리) 2(도시의 주유값) 3(거리) 4(도시의 주유값) 1(거리) 1(도시의 주유값)
//    제일 왼쪽 도시에서 6리터의 기름을 넣고, 더 이상의 주유 없이 제일 오른쪽 도시까지 이동하면 총 비용은 30원이다.
//    만약 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 3리터의 기름을 넣고(3×2 = 6원)
//    다음 도시에서 1리터의 기름을 넣어(1×4 = 4원) 제일 오른쪽 도시로 이동하면, 총 비용은 20원이다.
//    또 다른 방법으로 제일 왼쪽 도시에서 2리터의 기름을 넣고(2×5 = 10원) 다음 번 도시까지 이동한 후 4리터의 기름을 넣고(4×2 = 8원) 제일 오른쪽 도시까지 이동하면, 총 비용은 18원이다.
//
//    각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.

    // 처음의 생각은 어떤 도시에서의 기름값보다 다음 도시의 기름값이 비싸면 그 도시에서 기름을 다다음 도시까지 갈 분량을 집어넣는 게 이득이다.
    // 그래서 도시를 idx로 보면서 도시와 그 다음 도시의 기름값을 비교해서 더 값싼 도시의 기름을 최대한 많이 넣는 식으로 하려는 데
    // 기름값과 거리가 index가 다르니까 이게 되게 구현하는 게 쉽지 않았다 ㅠㅠㅠ
    // 그런데 알맞은 로직은 직접 index를 바꿔가면서 비교하는 게 아니라 기름값 자체를 내림차순이 되도록 ( 다음 도시의 기름값이 더 크면 이전 기름값과 같게 바꿔서)
    // 바꾼 다음에 도시의 기름값을 곱해서 더하면 가능하다고 한다.
    // 그렇게 구현해본 것 같은데... 정답은 아니었다... 내일 더 공부해봐야겠다...


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] road = new int[N-1];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N-1;i++){
            road[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine()," ");
        int[] money = new int[N];
        for(int i=0;i<N;i++){
            money[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0;
        int idx = 0;

        /*
        while(idx != N-1){

            int distance = 0;
            for(int i=idx; idx < N-1 ;i++){
                if(money[i] < money[i+1]){
                    distance += road[i];
                }
                else {
                    idx = i;
                    distance = road[i];
                    break;
                }
            }

            answer += distance * money[idx];

        }
         */

        for(int i=0;i< money.length-1;i++){
            if(money[i] < money[i+1]){
                money[i+1] = money[i];
            }
        }

        for(int i=0;i<money.length-1; i++){
            answer += money[i] * road[i];
        }

        System.out.println(answer);

















    }
}