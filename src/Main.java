package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 08 )
문제 : java baekjoon 9375 패션왕 신해빈
문제접근 : 입을 수 있는 옷의 종류가 주어질 때 이를 조합하여 한 가지 이상의 옷을 입을 수 있는 경우의 수
 */

class algorithm {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for(int i=0;i<T;i++){ // 테스트 케이스의 수만큼 반복
            int N = Integer.parseInt(br.readLine()); // 주어지는 옷의 수
            HashMap<String,Integer> map = new HashMap<>(); // <옷 종류,수량>을 받은 hashmap
            int clothCase = 1;

            for(int j=0;j<N;j++){ // 입력받는 옷들 
                String str = br.readLine();
                String[] cloth = str.split(" "); // 옷이름 옷종류로 주어진다
                map.put(cloth[1],map.getOrDefault(cloth[1],0)+1); // 옷 종류에 따라 수를 +1 한다
            }

            for(int value : map.values()){ // 각 종류별로 저장된 옷 개수
                clothCase *= (value + 1); // 해당 옷을 안 입을 수도 있기에 +1해서 곱한다
            }

            System.out.println(clothCase - 1); // 모든 종류를 안 입는 건 불가능하므로 -1
        }

    }
}