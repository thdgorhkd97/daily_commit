package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 15 )
문제 : java baekjoon 11931
문제접근 : 배열을 받아서 내림차순으로 정렬
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(br.readLine());
        }

        /* Integer 형 배열로 Arrays.sort 처리
        Integer[] clone = new Integer[N];
        for(int i=0;i<clone.length;i++){
            clone[i] = number[i];
        }

        Arrays.sort(clone,Comparator.reverseOrder());

        for(int i=0;i<clone.length;i++){
            System.out.println(clone[i]);
        }
         */


        /* 2중 for문으로 비교해가면서 더 큰수를 앞으로
        for(int i=0;i< number.length-1;i++){
            for(int j=i+1;j< number.length;j++){
                if(number[i] < number[j]){
                    int tmp = number[i];
                    number[i] = number[j];
                    number[j] = tmp;
                }
            }
        }

        for(int i=0;i<number.length;i++){
            System.out.println(number[i]);
        }
         */

        Arrays.sort(number);
        for(int i=number.length-1;i>=0;i--){
            System.out.println(number[i]);
        }





    }

}
