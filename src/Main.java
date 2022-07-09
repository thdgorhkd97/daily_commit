package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 09 )
문제 : java baekjoon 1834 나머지와 몫이 같은 수
문제접근 : 처음에는 그저 for문을 돌리면 될 줄알았는데 그럼 무한히 반복되서 규칙을 찾기로 했다
*/

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        // N answer
        // 1 : X
        // 2 : 3
        // 3 : 4,8
        // 4 : 5, 10, 15

        for(long i=1;i<N;i++){
            answer += (N+1) * i;
        }
        System.out.println(answer);
    }
}
        /* 원래 시도했던 방식 -> i의 범위가 정해진 거고 확인하는 거는 모든 자연수를 다 해야한다.
        for(int i=1;i<=2000000;i++){
            if(checkTrue(i,N)){
                answer += i;
            }
        }

        System.out.println(answer);
    }
    private static boolean checkTrue(int number,int N){
        if(number / N == number % N){
            return true;
        }
        else return false;
    }
}*/