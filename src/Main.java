import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2798 - 블랙잭
    // 3장을 골라서 가장 M에 가까운 조합을 고르는 문제
    // 3중 for문을 활용하였고 문제 조건에 의해서 M을 넘지 않는 조건과 가장 가까운 조건을 추가하여
    // 최소의 차이를 가지는 조합을 구하면 되는 문제

    // java baekjoon 7568 - 덩치
    // 각 사람의 키와 몸무게를 Body class로 저장하여 반복문을 통해 비교하였다.
    // man[i] = new Body(0,0); 생성한 클래스 객체를 new 키워드를 통해서
    // 실제 객체를 생성해주지 않아서 NullPointerException이 발생했었다.

    // 따로 어떤 자료구조나 알고리즘이 필요한 문제가 아니라 문제의 조건에 맞춰서
    // 모든 조건을 확인하는 반복문을 활용한 문제였기 때문에 2문제를 해결했다.


    public static class Body{
        int height;
        int weight;

        public Body(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Body[] man = new Body[N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();

            StringTokenizer stk = new StringTokenizer(str," ");

            man[i] = new Body(0,0);

            int kg = Integer.parseInt(stk.nextToken());
            int cm = Integer.parseInt(stk.nextToken());

            man[i].height = cm;
            man[i].weight = kg;

        }

        int[] grade = new int[N];

        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(man[i].height < man[j].height && man[i].weight < man[j].weight){
                    cnt++;
                }
            }

            grade[i] = cnt+1;
        }

        for(int i=0;i<N-1;i++){
            System.out.print(grade[i] + " ");
        }
        System.out.println(grade[N-1]);




        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N_M = br.readLine();

        StringTokenizer stk = new StringTokenizer(N_M," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        String card = br.readLine();

        stk = new StringTokenizer(card," ");

        int[] cards = new int[N];

        for(int i=0;i<N;i++){
            cards[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(cards); // card 목록을 오름차순으로 정렬

        int blackJack = Integer.MAX_VALUE;

        // 카드의 개수(N) >=3 이기 때문에 예외조건 필요 X
        for(int i=0;i<cards.length;i++){
            for(int j=i+1;j<cards.length;j++){
                for(int k=j+1;k<cards.length;k++){

                    int cardSum = cards[i] + cards[j] + cards[k];
                    if(cardSum  <= M) // M을 넘지 않는 3장의 조합
                        blackJack = Math.min(blackJack,M-cardSum); // M과 가까울수록 작으므로
                }
            }
        }

        System.out.println(M-blackJack); // blackJack이 M과의 최소 차이이므로
         */
    }

}