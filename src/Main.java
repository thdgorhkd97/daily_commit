package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 30 )
문제 : java programmers level 2 - 땅따먹기
문제접근 : 바로 아래줄로 내려올 수 없기때문에 한 줄씩 내려올 때마다 다른 열과의 합 중 최대값을 저장해나간다
        ex) 0열이면 한 줄 위의 1,2,3 열과의 합 중 최대를 저장한다.
 */

class algorithm {

    public static void main(String[] args) throws IOException {

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        int[][] dp = new int[land.length][4]; // 열은 반드시 4로 고정

        for(int i=0;i<4;i++){
            dp[0][i] = land[0][i]; // 0행 -> 첫 줄은 똑같이
        }

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                if(j==0){
                    dp[i][0] = Math.max(land[i][j] + dp[i-1][1],Math.max(land[i][j] + dp[i-1][2],land[i][j] + dp[i-1][3]));
                }else if(j==3){
                    dp[i][j] = Math.max(land[i][j] + dp[i-1][0],Math.max(land[i][j] + dp[i-1][1],land[i][j] + dp[i-1][2]));
                }
                else if(j==1){
                    dp[i][j] = Math.max(land[i][j] + dp[i-1][0],Math.max(land[i][j] + dp[i-1][2],land[i][j] + dp[i-1][3]));
                }
                else{
                    dp[i][j] = Math.max(land[i][j] + dp[i-1][0],Math.max(land[i][j] + dp[i-1][1],land[i][j] + dp[i-1][3]));
                }
            }
        } // dp로 해당 열을 제외한 위 열과의 합 중 최대를 구한다.

        int answer = 0;
        int num = dp[land.length-1][0];
        for(int i=0;i<4;i++){
            if(num <= dp[land.length-1][i]){
                num = dp[land.length-1][i];
            }
        } // 맨 마지막 행 중 최대값이 답이 된다.

        answer = num;
        System.out.println(answer);
    }
}
