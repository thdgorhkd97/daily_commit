package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 17 )
문제 : java baekjoon 1032 명령 프롬프트
문제접근 :  검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] fileName = new String[N]; // 입력받는 string들을 담을 배열

        for(int i=0;i<N;i++){
            fileName[i] = br.readLine(); // string 입력
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<fileName[0].length();i++){ // 첫번째 STRING을 for문으로 돌면서
            char ch = fileName[0].charAt(i); // 첫번째 string의 하나하나
            boolean flag = true;
            for(int j=0;j<fileName.length;j++){ // 다른 string 들의 i번째 문자를 모두 확인
                if(fileName[j].charAt(i) != ch){ // 그 중 다른 문자가 있다면 ?로 넣어야 한다.
                    flag = false; // 해당 위치가 모두 같지 않다
                    break;
                }
            }

            if(flag){ // 모든 string의 해당 위치 문자가 같으면
                sb.append(ch); // 해당 문자를 넣고
            } // 모든 string의 해당 위치가 모두 같지 않으면
            else sb.append("?"); // 물음표를 넣는다.

        }

        System.out.println(sb.toString());


    }
}
