import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 11286

//    배열에 정수 x (x ≠ 0)를 넣는다.
//    배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
//    프로그램은 처음에 비어있는 배열에서 시작하게 된다.

    // java에서 우선순위 큐를 활용하는 기본적인 문제를 접하면서 여러 기준을 잡는 문제를 해봤다
    // 그냥 선언했을 때는 오름차순, Comparator.reverseOrder()로 뒤바꾸면 내림차순
    // 근데 새로운 Comparator 기준으로 우선순위 큐의 정렬 기준을 선언해서
    // 우선순위 큐의 기준을 바꿀 수 있다는 것을 알게 되었다.
    // 우선순위 큐는 정해진 정렬 기준으로 값을 넣을 때마다 정렬을 시행하여 프로그래머가 쉽게
    // 사용할 수 있는 자료구조이기 때문에 정해진 정렬 기준이 주어져 있다면 이를 활용하여
    // 문제를 용이하게 해결할 수 있다고 생각한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<Integer> que = new PriorityQueue<>();
//        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return 1;
                }
                else if(Math.abs(o1) == Math.abs(o2)){
                    return o1-o2;
                }
                else{
                    return -1;
                }
            }
        });
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            if(num !=0){
                que.add(num);
            }
            else{
                if(que.isEmpty()){
                    list.add(0);
                }
                else{
                    list.add(que.poll());
                }
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}