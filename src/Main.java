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

    // 내림차순으로 거리를 조정해서 그 거리에 해당하는 기름값을 곱하는 로직을 구한다고 생각했는데
    // 도저히 거기서 진전이 없어서 결국 코드를 알아보고 말았다ㅠㅠㅠ
    // 근데 코드를 보고서도 '아 내꺼랑 로직이 같은데' 싶어서 한참 더 고민하다가 알아냈다
    // 원래 내 코드의 문제점은 거리만 내림차순으로 정렬함으로써 주유값을 곱하는데
    // 최소의 주유값을 초기화하지 않아서 문제였다
    // 예를 들어 어떤 지역에서 그 다음지역으로 갈때 기름값이 더 비싸면 지금 지역에서
    // 다다음 지역까지의 거리값을 한번에 곱해야 하는데 해당 거리값이 계산이 안 되는 문제가 있었다.


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

        long answer = 0;

//        int cost = money[0];
//        for(int i=0;i< money.length-1;i++){
//            if(money[i] < money[i+1]){
//                money[i+1] = money[i];
//            }
//        }
//
//        for(int i=0;i< money.length-1;i++){
//            if(money[i] < cost){
//                cost = money[i];
//            }
//
//            answer += cost * road[i];
//        }

        long cost = money[0];

        for(int i=0;i< money.length-1;i++){
            if(money[i] < cost){
                cost = money[i];
            }

            answer += cost * road[i];
        }

        System.out.println(answer);






    }
}