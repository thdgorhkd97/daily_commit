package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java 요세푸스 순열
작성자 : 송해광 (2022-06-12)
문제접근 : 배열에서 N번째를 계속 제거해나가는 것이므로 큐를 활용하기로 했다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken()); // 전체 사람 수
        int K = Integer.parseInt(stk.nextToken()); // 몇 번째 사람을 제거하는지

        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<N;i++){
            que.add(i+1); // N명의 사람을 큐에 넣는다
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        while(!que.isEmpty()){
            for(int i=0;i<K-1;i++){ // N-1번째까지는 빼는게 아니니까 큐에서 제거해 다시 뒤에 넣는다
                que.offer(que.poll());
            }

            if(que.size()!=1) sb.append(que.poll() + ", "); // 맨 마지막이 아니면 ,를 포함해 넣는다
            else sb.append(que.poll());
        }
        sb.append(">");
        System.out.println(sb.toString());





    }
}
