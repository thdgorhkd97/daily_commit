package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers level 2 - 다리를 지나는 트럭
    // 다리를 큐로 생각하는 개념도 생각했고 무게의 합으로 트럭이 앞으로 나아간다는 걸
    // 생각했는데 트럭끼리의 무게의 합이 다리의 무게보다 높으면 현재 다리위에
    // 있는 트럭만 앞으로 보낸다는 걸 생각하지 못했는데
    // 해당 부분은 큐에 0을 추가하는 식으로 처리한다는 게 진짜 인상깊었다.
    // 코드를 보고 정말 감탄을 금치 못한 것 같다

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
                else if(que.size() == bridge_length){
                    sum -= que.poll();
                }
                else{
                    if(sum + truck <= weight){
                        que.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                    else{
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
/*

        int num = 626331;
        int cnt = 0;

        for(int i=0;i<500;i++){
            if(num % 2 == 0){
                num = num/2;
            }
            else{
                num = (num * 3) + 1;
            }

            cnt ++;
            if(num == 1){
                break;
            }
        }

        System.out.println(cnt);
 */