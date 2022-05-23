package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 소가 길을 건너는 이유 3
    // 소가 도착한 시간과 길을 건너는 시간이 주어지면 모두가 건너는 시간을 구한다.
    // 내가 주목한 부분은 소가 출발하는 시간이다.
    // 소가 도착한 시간이 이전 소가 건넌 시간보다 더 크다면 answer를 아예 다음 소의 도착시간으로
    // 바꾸고 그 소가 건너는 시간을 answer에 더한다.

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cow = new int[N+1][N+1];

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int arriveTime = Integer.parseInt(stk.nextToken());
            int checkTime = Integer.parseInt(stk.nextToken());
            cow[i][0] = arriveTime;
            cow[i][1] = checkTime;
        }

        Arrays.sort(cow, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

//        for(int i=0;i<cow.length;i++){
//            System.out.println(cow[i][0] + " " + cow[i][1]);
//        }

        timeCalculate(cow);

        System.out.println(answer);


    }
    private static void timeCalculate(int[][] cow) {

        int idx = 1;

        answer = cow[0][0] + cow[0][1];

        while(idx < cow.length){
            if(answer < cow[idx][0]){
                answer = cow[idx][0];
            }
            answer += cow[idx][1];

            idx++;
        }



    }
}