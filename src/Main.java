package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 27 )
문제 : java baekjoon 2559
문제접근 : 총 N개의 수가 주어지면 K의 연속된 숫자의 합 중 최대를 구하라
 */

class algorithm {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken()); // 온도를 측정한 전체 날짜의 수
        int K = Integer.parseInt(stk.nextToken()); // 합을 구하기 위한 연속적 날짜의 수

        stk = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0;i<=N-K;i++){
            int sum = 0;
            for(int j=i;j<i+K;j++){
                sum += arr[j];
            }
            answer = Math.max(sum,answer);
        }

        System.out.println(answer);

    }
}

