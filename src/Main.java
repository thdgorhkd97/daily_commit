import java.util.*;

public class Main {

    // programmers level 3 - 이중 우선순위 큐
    // 어제 사용했던 우선순위 큐를 다시 사용하는 문제를 골라서 해결해보았다.
    // 최소 힙과 최대 힙을 구현한 우선순위 큐를 따로 구현함으로써 최대값과 최소값에 대한
    // 함수를 빠르게 구현할 수 있었다.
    // 다만 처음에는 하나의 우선순위 큐를 사용했기 때문에 최소로 하면 최대값을 제외할 때
    // 최대로 하면 최소값을 제외할 때 큐의 마지막 원소를 어떻게 찾아야 하지 라는 고민을 했는데
    // 이걸 최소와 최대로 나눠서 보면 어떻게 해야 할 까 싶었다.
    // 우선순위 큐에서 원소를 remove로 제외하면 자동적으로 정렬이 되기 때문에
    // 최대값을 제외할 때는 최대힙을 구현한 우선순위 큐에서 poll로 꺼내서 remove를 사용해
    // 빠르게 정렬과 remove를 동시에 작업하는 게 가능했다.

    public static void main(String[] args) {

        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        int[] answer = new int[2];

        PriorityQueue<Integer> queMin = new PriorityQueue<>();
        PriorityQueue<Integer> queMax = new PriorityQueue<>(Comparator.reverseOrder());

        for(String str : operations){
            if(str.contains("I")){ // 뒤에 오는 숫자 삽입
                String sub = str.substring(2);
                queMin.offer(Integer.parseInt(sub));
                queMax.offer(Integer.parseInt(sub));
            }
            else if(str.contains("D") && str.contains("-")){ // 큐에서 최솟값 삭제
                if(!queMin.isEmpty()){
                    int min = queMin.poll();
                    queMin.remove(min);
                    queMax.remove(min);
                }
            }
            else{ // 큐에서 최대값 삭제
                if(!queMax.isEmpty()){
                    int max = queMax.poll();
                    queMin.remove(max);
                    queMax.remove(max);
                }
            }

        }



        if(!queMin.isEmpty() && !queMax.isEmpty()) {
            answer[0] = queMax.poll();
            answer[1] = queMin.poll();

        }

        System.out.println(answer[0] + " " + answer[1]);



    }
}