package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 11 )
문제 : java baekjoon 13458 시험 감독
문제접근 : 각 시험장의 정감독1명을 포함해 부감독까지 총 몇명이 있어야 커버가능한가
*/

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tester = new int[N]; // N 개의 시험장에서 시험보는 인원

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            tester[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine()," ");

        int B = Integer.parseInt(stk.nextToken()); // 정감독이 커버가능한 시험생
        int C = Integer.parseInt(stk.nextToken()); // 부감독이 커버가능한 시험생

        int answer = N; // 필요한 감독관의 수를 찾을 변수
        for(int i=0;i<tester.length;i++){

            int boo = tester[i] - B; // 부감독이 감당해야 할 인원

            while(boo > 0){
                boo -= C;
                answer++;
            }
        }


        System.out.println(answer);

    }
}