package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 07 - 21 )
문제 : java programmers 타겟 넘버
문제접근 : int형 배열이 주어지고 타겟넘버가 주어질 때 + - 를 조합해서 타겟넘버가 되는 경우의 수
*/

class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(numbers,target,0,0);
        System.out.println(answer);
    }

    static void dfs(int[] numbers, int target,int sum,int index){
        if(numbers.length == index){ // index가 같다는 건 모든 수에 대해 부호를 정했다는 뜻
            if(sum == target){ // 부호를 정한 모든 수의 계산이 target과 같으면
                answer++;
            }
            return ;
        }

        dfs(numbers,target,sum + numbers[index],index+1); // 해당 인덱스의 수를 + 로
        dfs(numbers,target,sum - numbers[index],index+1); // 해당 인덱스의 수를 - 로
    }
}