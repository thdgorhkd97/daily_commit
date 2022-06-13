package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java baekjoon 10815 숫자 카드
작성자 : 송해광 (2022 - 06 - 13)
문제접근 : 숫자 배열이 주어지고 다음 숫자 배열은 원래 주어진 숫자배열에 포함되는지 여부를 0과 1로 구분하여 출력
         처음에는 hashmap을 활용해서 키와 밸류로 있는지 여부를 키로 비교함과 동시에 출력해야하는 0과 1을 동시에
         저장한다고 생각했는데 생각해보니 set을 활용하여 있는지 없는지만 확인하는 게 더 이득일 것이라 생각했다
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 숫자 카드의 개수

        int[] number = new int[N]; // 숫자 카드에 적혀있는 정수들

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(stk.nextToken());
            // 지금 생각해보면 굳이 배열에 넣을 필요 없이 바로 set에 int형으로 받아서 저장해도 될 것 같다
            set.add(number[i]); // set 자료구조에 저장
        }

        int M = Integer.parseInt(br.readLine()); // 포함하는지 확인할 정수의 개수

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int checkNumber = Integer.parseInt(stk.nextToken());

            if(set.add(checkNumber)){ // true를 반환하는 건 없다는 것
                System.out.print("0 ");
            }
            else{ // false를 반환하면 존재한다는 것이기 때문에
                System.out.print("1 ");
            }
        }

    }
}
