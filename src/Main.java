import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 2579 - 계단 오르기

//    계단 오르는 데는 다음과 같은 규칙이 있다.
//
//    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//    마지막 도착 계단은 반드시 밟아야 한다.
//    따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
//
//    각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

    // 동적 계획법에 분류된 문제이다.
    // 점수가 적힌 계단을 밟아 올라가면서 얻을 수 있는 최대 점수를 구한다.
    // 단 연속된 3개의 계단을 밟지 못하며 마지막 계단은 반드시 밟을 것이라는 조건이 붙는다
    // 어떤 N번째 계단을 밟을 때 얻을 수 있는 점수의 최대값을 구해야 하기 때문에
    // N번째 계단을 밟을 경우에 얻을 수 있는 점수를 계산해보려고 했다
    // N번째 계단을 밟는 건 2가지 경우가 있다.
    // 1. N-3번째 계단과 N-2번째 계단을 밟고서 N번째 계단을 밟는 경우
    // 2. N-2번째 계단과 N번째 계단을 밟는 경우
    // 이렇게 2가지 경우가 최대값을 얻으면서 계단을 밟는 경우다.
    // 그렇기에 이 2가지 경우를 비교해서 더 큰 값을 계속 저장해나가며 비교해나간다.
    // 단 N-3을 비교해야 하는 경우가 있기에 주어지는 N의 경우를 1,2,3 인 경우는
    // 따로 구분해 두었다.(처음에 이렇게 안 했더니 ArrayIndexOutOfBound가 발생했다)ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        if(N==1) {
            dp[1] = stair[1];
//            System.out.println(dp[1]);
        }
        else if(N==2){
            dp[2] = stair[1] + stair[2];
//            System.out.println(dp[2]);
        }
        else if(N==3){
            dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
//            System.out.println(dp[3]);
        }

        else if(N>=4) {
            for (int i = 4; i <= N; i++) {
                dp[i] = Math.max(dp[i - 3] + stair[i] + stair[i - 1], dp[i - 2] + stair[i]);
            }
        }

        System.out.println(dp[N]);



    }
}

