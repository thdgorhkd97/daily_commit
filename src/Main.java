import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 1966 프린터 큐

    // 여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다.
    // 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다.
    // 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
    // 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
    // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
    // 예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
    // 여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

    // 처음에는 순서를 알고 싶은 문서의 위치를 어떻게 해야 할까 고민했었다. 큐를 이용해서 순서를 바꾸는 건 쉽지만 idx가 처음에 원하는 위치를 정하기 때문에
    // poll하고 add 하는 과정에서 내가 순서를 알고싶은 위치를 체크하는 게 고민이었다.
    // 그냥 que에 add할때 int[] 로 해서 내가 순서를 알고자하는 건 [1] = 1로 넣고 아닌 다른 것들은 [1] = 0으로 넣었다.
    // 문제에서 처음에 위치를 0으로 삼아서 내가 배열의 인덱스를 조절할 필요가 없다는 것과 내가 순서를 알고 싶은 문서에 [1]에 1을 넣었는 데 수가 헷갈린 거 빼고는
    // 크게 어려운 문제는 아니었다고 생각한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int many = Integer.parseInt(stk.nextToken());
            int that = Integer.parseInt(stk.nextToken());

            int[] priority = new int[many];
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<many;j++){
                priority[j] = Integer.parseInt(stk.nextToken());
            }

            System.out.println(order(priority,that));
        }

    }
    static int order(int[] priority, int that){
        if(priority.length == 1){

            return 1;
        }

        Queue<int[]> que = new LinkedList<int[]>();

        PriorityQueue<Integer> critical = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i< priority.length; i++){
            int[] add = new int[2];
            add[0] = priority[i];
            critical.add(add[0]);
            if(i == that){
                add[1] = 1;
                que.add(add);
            }
            else{
                add[1] = 0;
                que.add(add);
            }
        }

//        while(!que.isEmpty()){
//            int[] poll = new int[2];
//            poll = que.poll();
//            System.out.println(poll[0] + " " + poll[1]);
//        }

//        while(!critical.isEmpty()){
//            System.out.println(critical.poll());
//        }

        int idx = 1;

        while(true){
            int[] print = new int[2];

            if(critical.peek() == que.peek()[0]){
                if(que.peek()[1] == 1){

                    return idx;

                }
                else{
                    idx++;
                    critical.poll();
                    que.poll();
                }

            }
            else{
                print = que.poll();
                que.add(print);
            }

        }



    }
}