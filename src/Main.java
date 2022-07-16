package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 16 )
문제 : java baekjoon 9655 돌 게임
문제접근 : 탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.

 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] rock = new boolean[1001];
        for(int i=1;i<=1000;i++){
            rock[i] = false;
            if((i-1 >= 0 && !rock[i-1]) ||  (i-3 >= 0 && !rock[i-3])){
                rock[i] = true;
            }

        }

        System.out.println(rock[N] ? "SK" : "CY");

    }

}
