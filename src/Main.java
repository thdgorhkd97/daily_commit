import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 2164 - 카드 2

//    N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
//
//    이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
//
//    예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
//
//    N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

    // 처음에는 맨 앞의 원소를 제거하고 list.get(0)로 맨 앞원소를 저장한 다음
    // 맨 앞 원소를 제거하고 저장해둔 원소를 큐에 offer했다.
    // 하나 남을 때까지 반복해야 하므로 큐의 사이즈가 1이 되면 break 하였다.
    // 근데 이렇게 하면 시간초과가 발생했다.
    // 생각해보니 get으로 맨앞 원소를 찾아서 따로 저장한 다음 다시 저장하는 것이 아니라
    // 맨 앞 원소를 제거하면서 offer 하는 것이 가능하다고 생각해서 코드를 수정했다.
    // 틀렸습니다가 나왔다.
    // 그 후 while(true) 후에 if로 큐의 사이즈를 확인하는 과정을
    // while문의 조건문에 집어넣었더니 성공적으로 처리되었다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        LinkedList<Integer> list = new LinkedList<>();
//
//        for(int i=1;i<=N;i++){
//            list.add(i);
//        }
//
//        while(true){
//            list.remove(0);
//
//            int move = list.get(0);
//            list.remove(0);
//            list.add(move);
//
//            if(list.size() == 1) {
//                System.out.println(list.get(0));
//                return ;
//            }
//        }     -> 시간초과 발생 코드

        Queue<Integer> que = new LinkedList<>();

        for(int i=1;i<=N;i++){
            que.offer(i);
        }

        while(que.size() > 1){

            que.poll();

            que.offer(que.poll());

        }

        // 틀렸습니다 가 발생한 코드다.
//        while(true){
//
//            que.poll();
//
//            que.offer(que.poll());
//
//            if(que.size() == 1){
//                break;
//            }
//        }

        System.out.println(que.poll());



    }
}