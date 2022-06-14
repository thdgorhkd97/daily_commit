package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java 14425 문자열 집합
작성자 : 송해광 ( 2022 - 06 - 14 )
문제접근 : 처음엔 set으로 있냐없냐만 판단했는데 그렇게 하면 나중에 있는지를 확인만해야 하는 문자열이
        set에 들어가면서 있는지를 확인해야 하는 문자열이 달라지는 문제가 있었다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        /* 처음에 생각한 방식
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        int answer = 0;
        for(int i=0;i<M;i++){
            if(!set.add(br.readLine())){
                answer++;
            }
        }

        System.out.println(answer);
        */ // set에 들어가는 거에 true/false로 확인했는데 이렇게 하면 문제가 발생한다.

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0); // map에 저장해둔다
        }
        int answer = 0; // 정답을 리턴할 변수
        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) answer++; // map에 미리 저장된 키와 같으면
        }
        System.out.print(answer);
    }
}
