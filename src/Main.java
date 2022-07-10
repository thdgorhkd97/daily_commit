package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 10 )
문제 : java baekjoon 3273 두 수의 합
문제접근 : 배열에서 2개 수의 합이 특정 수(x)가 되는 경우의 수를 구하라.
*/

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int answer = 0;

        /* 가장 일반적으로 생각할 수 있는 2중 for문을 활용한 해결법
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] + arr[j] == x){
                    answer++;
                }
            }
        }
         */

        Arrays.sort(arr); // 투포인터로 접근하기 위해 정렬

        for(int left = 0; left < n-1; left++){ // 배열의 끝 -1 까지만
            for(int right = left+1; right<n; right++){ // 중복이 아니게 하나 다음부터
                if(arr[left] + arr[right] == x){ // 해당 수와 같으면
                    answer++;
                }
                else if(arr[left] + arr[right] > x) break;
                // 정렬되어 있기때문에 arr[i] + arr[j]가 x를 넘으면 arr[k](k>j)와 더하는 건 무조건 x가 아니다
                // 따라서 x를 넘는 순간 그 다음부터는 보지 않아도 괜찮다.
            }
        }

        System.out.println(answer);


    }
}