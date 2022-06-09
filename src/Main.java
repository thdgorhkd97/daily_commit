package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java baekjoon ROT13 (ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.)
작성자 : 송해광 ( 2022 - 06 - 09 )
문제해결 애로사항 : 알파벳 대문자와 소문자에만 적용해야 하기 때문에 숫자나 공백에 대해서는 그냥 넘어가야 해서 else continue로 넘어가도록 했는데
else continue 아래에 sb.append(letter)를 넣어서 continue로 넘어가기 때문에 공백이나 숫자를 정답 문자열에 넣지 않는 문제가 있었다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ROT13(str); // 입력받은 문자열을 ROT13 암호화

    }
    private static void ROT13(String str){
        StringBuilder sb = new StringBuilder(); // 정답 문자열을 저장한 StringBuilder

        for(int i=0;i<str.length();i++){ // 입력받은 문자열을 돌면서 글자 하나하나를 확인한다.
            char letter = str.charAt(i);
            if('a'<= letter && letter <= 'z'){ // 영어 소문자에 해당한다면
                letter += 13; // 13글자를 밀어준다 ( ROT 13 암호화 방식 )
                if(letter > 'z') { // 13글자를 밀었을 때 z를 넘어가면
                    letter -= 'z'; // 아스키코드에서 z를 빼서 a에서 얼마나 더 가야하는 지
                    letter += 'a' - 1; // a를 더해주고 -1 을 해줘야한다.
                }
            }
            else if ('A' <= letter && letter <= 'Z') { // 영어 대문자에 해당한다면
                letter += 13; // 13글자를 밀어준다 ( ROT 13 암호화 방식 )
                if(letter > 'Z') { // 13글자를 밀었을 때 Z를 넘어가면
                    letter -= 'Z'; // 아스키코드에서 Z를 빼서 A에서 얼마나 더 가야하는 지
                    letter += 'A' - 1; // A를 더해주고 -1을 해줘야 한다.
                }
            }

            sb.append(letter); // ROT 13 암호화를 한 문자를 문자열로 저장

        }

        System.out.println(sb.toString());
    }
}

