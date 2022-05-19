package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 16917 양념 반 후라이드 반
    // 반반치킨을 2배 한 가격과 양념 + 후라이드 가격만을 비교한 게 패착이었다
    // 양념이나 후라이드를 사더라도 반반이 싸다면 최소비용이 더 적어진다는 것을 고려해야 했다 ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(stk.nextToken()); // 양념치킨 가격
        int B = Integer.parseInt(stk.nextToken()); // 후라이드치킨 가격
        int C = Integer.parseInt(stk.nextToken()); // 반반 가격
        int X = Integer.parseInt(stk.nextToken()); // 양념 치킨 마리수
        int Y = Integer.parseInt(stk.nextToken()); // 후라이드 치킨 마리수

        /*
        int min = Integer.MAX_VALUE;

        int halfChicken = Math.min(X,Y) * 2;

        for(int i = 2; i<=halfChicken; i+=2){

            int chicken = i/2;
            min = Math.min(min, i*C + A *(X-chicken) + B*(Y-chicken));

            System.out.println(i*C + A *(X-chicken) + B*(Y-chicken));
        }

        min = Math.min(min, X*A + B*Y);
        System.out.println(X*A + B*Y);

        System.out.println(min);
         */

        long sum = 0;
        if(A + B > 2 * C){ // 양념 + 후라이드 > 반반 2마리 (반반을 사는 게 이득)
            int halfChicken = Math.min(X,Y);
            if(halfChicken < X){ // 반반에다가 양념치킨을 더해야
                sum += Y * C*2;
                sum += Math.min((X-Y) * A, (X-Y) * 2 * C);
            }
            else{
                sum += X * C * 2;
                sum += Math.min( (Y-X) * B, (Y-X) * 2 * C);
            }

        }
        else{
            sum = X*A + B*Y;
        }

        System.out.println(sum);



    }
}