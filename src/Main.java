package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Character.isDigit;

/*
작성자 : 송해광 ( 2022 - 06 - 29 )
문제 : java baekjoon 1620 나는야 포켓몬 마스터 이다솜
문제접근 : hashmap으로 문자열과 정수를 저장하는 건 알겠는데 반대로 하는 걸 어떻게 해야 할까 하다가
        HASHMAP에서 value로 key를 찾는 게 아니라 그냥 String[] 에서 index로 저장된 배열의
        string을 꺼내려 했다.
 */

class algorithm {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken()); // 도감에 수록된 포켓몬 개수
        int M = Integer.parseInt(stk.nextToken()); // 맞춰야 하는 문제의 개수

        HashMap<String,Integer> pocketmonMap = new HashMap<String, Integer>();
        String[] pocketmonArray = new String[N+1];

        for(int i=0;i<N;i++){
            String pocketmonName = br.readLine();
            pocketmonMap.put(pocketmonName,i+1);
            pocketmonArray[i+1] = pocketmonName;
        }

        for(int i=0;i<M;i++){
            String wantToKnow = br.readLine();
            if(isDigit(wantToKnow.charAt(0))){ // 수가 주어지면
                System.out.println(pocketmonArray[Integer.valueOf(wantToKnow)]);
            }
            else{ // 문자열이 주어지면
                if(pocketmonMap.containsKey(wantToKnow)){
                    System.out.println(pocketmonMap.get(wantToKnow));
                }
            }
        }

    }
}
