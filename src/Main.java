package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
작성자 : 송해광 ( 2022 - 07 - 18 )
문제 : java baekjoon 10953 A+B-6 && 1789 수들의 합
문제접근 :  (수들의 합)검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제
          (A+B - 6) a,b 형태로 문자열이 주어지면 합을 구해서 출력하는 문제
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 정수가 주어질 때 그 수를 더해서 만들 수 있는 최대 자연수의 개수
        long S = Long.parseLong(br.readLine());

        long answer = 0; // 더하는 자연수의 최대 개수를 구하기 위한 변수

        long number = 1; // 더하는 자연수
        while(number <= S){ // 더하는 자연수를 빼나가다가 더하는 수가 S보다 작아지면 종료
            answer++; // 더하는 자연수 개수 +1

            S -= number; // S에서 더하는 수를 뺀다
            number++; // 더하는 자연수를 1더해나간다(1,2,3... 자연수를)
        }

        System.out.println(answer);
         */

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String str = br.readLine();
            String[] number = str.split(","); // a,b형태로 수가 주어지기에
            System.out.println(Integer.parseInt(number[0]) + Integer.parseInt(number[1]));
        }
    }
}
