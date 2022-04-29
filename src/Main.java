import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 1476 날짜 계산
    // E, S, M 이 정해진 범위가 있기 때문에 마치 시계처럼 가장 작은 단위가
    // 정해진 범위를 벗어나면 다음 단위가 1씩 올라가는 식으로 구현을 하는데
    // 특정한 시간이 주어지면 그에 해당하는 E S M을 구하는 게 아니라 반대로
    // E S M이 주어지고 그에 해당하는 날짜를 구하는 것이기 때문에 1 1 1 로
    // 세팅한 상태에서 주어진 시간이 될 때까지 하루하루 더해나간다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int E = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int e=1,s=1,m=1;
        int year = 1;
        while(true){
            if(e==E && s==S && m==M) {
                System.out.println(year);
                break;
            }
            e+=1;
            s+=1;
            m+=1;
            if(e==16) {
                e=1;
            }
            if(s==29) {
                s=1;
            }
            if(m==20) {
                m=1;
            }

            year ++;

        }

    }
}
