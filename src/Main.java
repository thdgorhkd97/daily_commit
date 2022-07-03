package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 03 )
문제 : java baekjoon 1699 제곱수의 합
문제접근 : 몇 개의 제곱수로 주어진 수를 표현할 수 있는가?
 */

class Main {

    static int answer = 0; // 더해지는 제곱수의 개수 ( 정답 )
    static int N = 0; // 주어진 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N < 100,000

        int[] square = new int[317]; // 316의 제곱 < 100000 < 317의 제곱

        square[0] = 1;
        square[1] = 1;
        for(int i=1;i<square.length-1;i++){
            square[i+1] = (int) Math.pow(i+1,2); // square 배열은 제곱수를 저장한 배열
        }

        while(N != 0) { // N이 0이 될때까지 진행
            BinarySearch(N, square); // 시간 효율성을 위해 이분탐색으로 가장 가깝게 작은 제곱수를 구한다
            answer++; // 횟수 + 1
        }

        System.out.println(answer);

    }

    private static void BinarySearch(int n, int[] square) {
        int left = 1;
        int right = square.length-1;
        while(Math.abs(left - right) != 1){ // 이분탐색

            int mid = (left + right) / 2;
            if(square[mid] < n){
                left = mid+1;
            }
            else if(square[mid] > n){
                right = mid -1;
            }
            else{ // square[mid] == n
                N -= square[mid];
                return ;
            }

        }

        N -= square[Math.min(left,right)];
    }
}
