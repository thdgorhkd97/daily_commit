package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 14467 소가 길을 건너간 이유 1
    // 소의 위치 변화가 발생한 횟수를 구하는 문제.
    // 2가지 실수를 했다
    // 1. 소의 위치가 주어지는 경우가 소의 위치가 변할 때 일 줄 알아서 set 자료구조에
    //    있는지 여부만 확인해서 있을 때마다 answer+1 했는데 소의 위치가 그대로인 경우도 있기에
    //    해당 방법은 옳은 방법이 아니었다.
    // 2. 주어지는 N의 크기로 int형 배열을 선언했는데 N의 크기는 위치변화의 개수이고 소는 10마리라고
    //    나와있기 때문에 11로 선언하여 문제를 해결했다
    // 추가로 cow배열을 cow[몇번째 소인지][소의 위치] 이렇게 해서 2차원 배열로 선언하려고 했는데
    // 생각해보니 2차원배열을 1차원배열로 하는방법을 통해서 cow[소의위치] 이렇게만 선언해서
    // cow의 i번째를 몇번째 소인지 판단하는 식으로 2차원배열이 아닌 1차원배열로 메모리를 고려했다

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cow = new int[11];
        Arrays.fill(cow,-1);

        int answer = 0;

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int cowNumber = Integer.parseInt(stk.nextToken());
            int cowLocation = Integer.parseInt(stk.nextToken());

            /* 소에 대한 위치의 변화가 있을때만 주어지는 줄 알았는데 위치의 변화가 없는
               경우도 주어진다는 걸 알고 이 방법은 취소
            if(set.add(cow)){
                answer++;
            }
             */

            if(cow[cowNumber] != -1 && cow[cowNumber] != cowLocation){
                answer++;
            }

            cow[cowNumber] = cowLocation;

        }

        System.out.println(answer);



    }
}