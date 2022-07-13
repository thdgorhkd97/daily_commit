package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 13 )
문제 : java baekjoon 2822 점수 계산
문제접근 : 높은 점수 중 5개를 처음 주어진 배열에서 몇 번째 인덱스에 있는가
*/

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[8];

        for(int i=0;i<score.length;i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] clone = score;

        Arrays.sort(clone); // score 배열을 정렬(오름차순)

//        for(int i=0;i<clone.length;i++){
//            System.out.print(clone[i] + " ");
//        }
//        System.out.println();

        int sum = 0;
        int[] highScore5 = new int[5]; // 높은 점수 5개를 저장할 배열
        int idx = 0;
        for(int i=clone.length-5;i< clone.length; i++){
            System.out.println("clone[i] " + clone[i] );
            sum += clone[i];
            for(int j=0;j<score.length;j++){
                if(score[j] == clone[i]){
                    highScore5[idx++] = j;
                    break;
                }
            }
        }

        System.out.println(sum);
        for(int i=0;i< highScore5.length;i++){
            System.out.print(highScore5[i] +" ");
        }


    }
}