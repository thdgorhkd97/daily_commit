package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java programmers level 2 기능개발
작성자 : 송해광 ( 2022 - 06 - 11 )
문제 접근 : 각 기능별로 언제 완성되는지를 구하는 방식에서 나는 현재 진척도에서 하루하루의 진행률을 더해나가면서
100을 넘는 순간이 언젠지를 알아냈는데 나눈 몫을 올림하는 것으로 처리하는 게 훨씬 빠르게 처리 가능하다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};

        int[] finishDay = new int[progresses.length]; // 각 기능별로 완료되는 일자를 저장하는 배열

        for(int i=0;i< progresses.length;i++){
            int day = 0; // 완료되는 일자
            while(progresses[i] < 100){ // 100% 완료가 아닐때까지는
                progresses[i] += speeds[i]; // 계속 작업을 진행해나간다
                day ++; // 작업 일자를 더해나간다.
            }
            finishDay[i] = day; // 100% 완료될때까지 진행한 작업 일자
        }

        List<Integer> result = new ArrayList<>(); // 정답을 넣을 리스트

        int distributeWith = 1; // 함께 배포하는 기능의 수에 대한 변수
        int standardDistributeDay = finishDay[0]; // 비교하는 기준 배포 날짜
        for(int i=0;i< finishDay.length - 1; i++){
            if(standardDistributeDay >= finishDay[i+1]){ // 기준 배포 날짜보다 먼저 만들어졌으면
                distributeWith++; // 기준 배포날짜가 배포될 때 한번에 배포되기 때문에 함께 배포하는 기능의 수를 더한다.
            }
            else { // 기준 배포날짜보다 나중에 완성된다면
                result.add(distributeWith); // 기준 배포날짜에 배포되는 기능의 수를 result에 넣어두고
                distributeWith = 1; // 배포하는 기능의 수를 초기화 하고
                standardDistributeDay = finishDay[i+1]; // 나중에 완성되는 기능이 완성되는 날짜로 기준 날짜를 바꾼다
            }
        }

        result.add(distributeWith); // 마지막으로 저장되지 않은 배포 기능들을 넣는다.(for문의 마지막에 add를 안 할수도 있으니까)

        int[] answer = new int[result.size()]; // result의 값을 answer로 옮긴다. 정답을 int[] 형태로 리턴해야 한다.
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }

    }
}
