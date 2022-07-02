package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 02 )
문제 : java baekjoon 11478 서로 다른 부분 문자열의 개수
문제접근 : 입력된 string의 부분 문자열 중에서 서로 다른 문자열의 개수를 구하는 문제
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Set<String> subString = new HashSet<>();

        for(int i=0;i<str.length();i++){
            String sub = "";

            for(int j=i;j< str.length();j++){
                sub += str.substring(j,j+1);
                subString.add(sub);
            }
        }

        /*
        int length = 1;
        while(length <= str.length()-1){
            for(int i=0;i<=str.length()-length;i++){
                StringBuffer sb = new StringBuffer();

                for(int j=i;j<i+length;j++){
                    sb.append(str.charAt(j));
                }

                subString.add(sb.toString());
            }
            length++;
        }
        subString.add(str);
         */

        System.out.println(subString.size());

    }
}
