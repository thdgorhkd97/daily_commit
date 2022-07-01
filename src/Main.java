package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 01 )
문제 : java baekjoon 1764 듣보잡
문제접근 : 듣지 못한 사람과 보지 못한 사람 중 겹치는 부분에 대해 체크한다.
 */

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        HashSet<String> notHear = new HashSet<>(); // 듣지 못한 사람을 담을 목록

        for(int i=0;i<N;i++){
            notHear.add(br.readLine()); // 듣지 못한 사람
        }

        List<String> answer = new ArrayList<>(); // 듣지도 보지도 못한 사람을 담을 리스트
        int numOfNotHearSee = 0; // 듣지도 보지도 못한 사람의 수
        for(int i=0;i<M;i++){
            String notSee = br.readLine(); // 보지 못한 사람을 입력받고
            if(!notHear.add(notSee)){ // 보지 못한 사람이 듣지 못한 사람에 있으면
                numOfNotHearSee++; // 듣보잡의 수를 추가하고
                answer.add(notSee); // 듣보잡 사람 목록으로 추가
            }
        }

        Collections.sort(answer); // 사전 순으로 출력을 위한 정렬

        System.out.println(numOfNotHearSee);
        for(int i=0;i<numOfNotHearSee;i++){
            System.out.println(answer.get(i));
        }

    }
}
