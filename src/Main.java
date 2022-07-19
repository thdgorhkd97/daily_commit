package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 07 - 20 )
문제 : java baekjoon 1049 기타줄
문제접근 : 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격,
낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] pack = new int[M];
        int[] one = new int[M];

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int price_package = Integer.parseInt(stk.nextToken());
            int price_one = Integer.parseInt(stk.nextToken());

            pack[i] = price_package;
            one[i] = price_one;
        }

        int answer = 0;

        Arrays.sort(pack);
        Arrays.sort(one);
        if (N < 6) {
            answer += Math.min(pack[0], one[0] * N);
        } else {
            int calcHelp = Math.min(pack[0], one[0] * 6);
            answer += calcHelp * (N / 6);
            answer += Math.min(calcHelp, one[0] * (N % 6));
        }
    }
}
