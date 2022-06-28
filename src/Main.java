package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 28 )
문제 : JAVA programmers level 2 - 다리를 지나는 트럭
문제접근 : 다리를 큐로 보는 건 생각했는데 다리가 지탱할 수 있는 무게를 초과하면 어떻게 할 지를
         전혀 몰랐는데 알아보니 0을 큐에 넣어서 원래 있던 다리를 앞으로 미뤄주면 해결되는 거였다
 */

public class Main {

    public static void main(String[] args) throws IOException {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int answer = 0;

        Queue<Integer> que = new LinkedList<>(); // 다리
        int sum = 0; // 무게

        // queue 7 0 4 5 0 6 -> 0 6
        // sum   7 0 4 9 5 0 6 -> 6
        // time  1 2 3 4 5 6 -> 6

        for(int truck : truck_weights){

            while(true){
                if(que.isEmpty()){ // 큐가 비어있다 = 다리가 비어있다
                    que.add(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                else if(que.size() == bridge_length){ // 만약 다리가 꽉 차있다면
                    sum -= que.poll();
                }
                else{
                    if(sum + truck <= weight){ // 다리에 더 올라갈 수 있으면
                        que.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                    else{ // 다리에 더 올릴 수없다-> 지금 있는 트럭만 앞으로 보내자
                        que.add(0);
                        answer++;
                    }
                }
            }

        }

        // 트럭을 올리는 게 기준이기 때문에 건너야함
//        return answer + bridge_length;

    }
}
