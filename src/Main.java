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

        long answer = 0;
        for(int i=0;i<tester.length;i++){

            if(tester[i] <= B){ // 정감독이 커버가능한 인원만 있다면
                answer++; // 감독관수 + 1
                continue; // for 문 반복
            }
            else{
                answer++; // 감독관수 +1
                tester[i] -= B; // 남아있는 인원에서 정감독이 커버가능한 인원을 제외

                // 부감독관 감시 가능 인원으로 배열값을 나눠 나머지가 0이면 그 값을 넣고
                if(tester[i] % C == 0) answer += tester[i]/C;
                // 안떨어지면 나눈 몫에 +1
                else answer += tester[i]/C + 1;
            }

        }

        System.out.println(answer);

    }
}