import java.util.*;

public class Main {

    // programmers level 3 - 야근 지수
    // n만큼 works배열에서 뺐을 때 2의 거듭제곱의 합이 가장 최소가 되도록 해야 한다.
    // 남은 works배열의 원소값이 거듭제곱의 지수가 되기 때문에 평균적으로 가장 작게 만들어야 한다,
    // 큰 수에서 계속 빼나가면 될 것으로 보인다.

    // 효율성에서 문제가 생겨서 loop를 수정하고 정렬을 줄이고 해도 해결이 안 되서 결국
    // 해결법을 알아보았더니 우선순위 큐를 이용하여 for문 내에서 정렬을 안 하도록 하는 것이었다.
    // 우선순위 큐 -> 일반적인 큐의 FIFO 구조가 아니라 우선순위를 결정하고 그 우선순위에 따라
    // 나가는 원소가 결정되는 구조를 가진다.(힙을 이용하여 구현함)
    // 내부 요소는 이진 트리로 구성, 높은 우선순위의 요소를 먼저 꺼내서 처리
    // 우선순위 큐는 값이 추가되면 즉시 정렬 되는 것이 가장 큰 특징이다!!
    // 즉 먼저 정한 우선순위에 따라 값을 넣을 때마다 즉시 정렬
    // 우선순위 큐를 적극적으로 활용하는 방법이 괜찮을 것 같다.
    // 값을 넣을 때마다 정렬이 필요한 경우에


    public static void main(String[] args) {

        int n = 4;
        int[] works = {3,4,3};

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

//        Arrays.sort(works);

        for(int number : works){
            que.offer(number);
        }

        for(int i=0; i<n;i++){

            int max = (int)que.poll();
//            if(max <= 0) return 0;
            que.offer(max-1);

        }

        long sum = 0;
        while(!que.isEmpty()){
            sum += Math.pow(que.poll(),2);
        }

        System.out.println(sum);





    }
}