import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 1655 가운데를 말해요
    // 문제에서 요구하는 건 쉽다. 정렬된 값들 중 중간값을 찾아서 리턴하면 된다.
    // 근데 N의 범위가 100,000이기 때문에 반드시 시간초과가 발생할 것이므로
    // 우선순위 큐를 활용하기로 했다 (우선순위 큐에 분류된 문제지만 왜 우선순위 큐를 활용해야 할까 생각했다)
    // 최대 힙과 최소 힙의 크기가 같은 경우에는 반드시 최대 힙으로 푸시한다
    // 최대 힙과 최소 힙의 크기가 같다면 중간 값중 작은 수를 말해야 하기 때문이다.
    // 그럼 그냥 푸시된 최대 힙의 peek()를 리턴하면 된다.
    // 근데 크기가 다를 때 최대 힙에 수를 푸시했을 때 만약 최대 힙의 peek가 최소힙의 peek와
    // 크기 비교했을 때 최대 힙의 peek가 더 크면 최소 힙과 위치를 바꿔줘야 한다.
    // 그래야지 홀수개 일때 최대 힙의 peek값이 중간값이 되기 때문이다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            if(maxQue.size() == minQue.size()){ // 크기가 같으면 최대힙에 넣는다
                maxQue.add(num);

                if(!minQue.isEmpty() && maxQue.peek() > minQue.peek()){
                    minQue.add(maxQue.poll());
                    maxQue.add(minQue.poll());
                }
            }
            else{
                minQue.add(num);

                if(maxQue.peek() > minQue.peek()){
                    minQue.add(maxQue.poll());
                    maxQue.add(minQue.poll());
                }
            }

            System.out.println(maxQue.peek());
        }



    }
}