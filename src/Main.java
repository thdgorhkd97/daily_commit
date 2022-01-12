import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 18258 - 큐 2
//    push X: 정수 X를 큐에 넣는 연산이다.
//    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    size: 큐에 들어있는 정수의 개수를 출력한다.
//    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    // 큐를 구현하는 알고리즘인데 대부분 큐에 구현된 함수를 이용하면 문제가 해결되지만
    // 큐의 가장 마지막 원소를 구현하는 건 따로 구현을 해야 했다.
    // 나는 따로 static 변수를 선언하여 offer 함수를 수행할 때 마지막 수를 따로 변수에 적고
    // 가장 뒤에 있는 정수는 가장 마지막에 들어간 정수이기 때문에 back을 수행할 때는
    // static 변수를 출력하도록 구현햇다.
    // 구현은 했지만 좀 더 찾아보니 큐를 LinkedList로 구현해서
    // q.peekLast()로 마지막 원소를 출력하는 것도 가능하다고 한다.

    // java에서 큐에 대한 추가 정보!!
    // 큐의 앞 부분인 front는 삭제 연산만 수행
    // 큐의 뒷 부분 rear는 삽입 연산만 수행
    // 주로 컴퓨터 버퍼에서 사용하며 대기열을 만들어 순차적으로 처리할 때 사용
    // 데이터 삽입 : add, offer 중간이 아닌 맨 뒤로만 삽입 가능
    // 데이터 삭제 : poll 맨 앞의 값 삭제, remove(Object) Object에 해당하는 값 삭제
    //             poll -> 대기열이 비어있으면 null 반환
    //             remove -> 대기열이 비어있으면 NoSuchElement 에러 반환
    // 데이터 초기화 : clear
    // 데이터 출력 : peek 맨 처름 넣은 값 확인 (모두 확인하려면 Iterator 사용)


    static int late = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();

            check(str,que);
        }

    }

    public static void check(String str, Queue<Integer> q){
        switch(str){
            case "pop" :
                if(q.isEmpty()) System.out.println("-1");
                else System.out.println(q.poll());
                return ;
            case "size" :
                System.out.println(q.size());
                return ;
            case "empty" :
                if(q.isEmpty()) System.out.println("1");
                else System.out.println("0");
                return ;
            case "front" :
                if(q.isEmpty()) System.out.println("-1");
                else System.out.println(q.peek());
                return ;
            case "back" :
                if(q.isEmpty()) System.out.println("-1");
                else System.out.println(late);
                return ;
        }

        if(str.contains("push")){
            int X = Integer.parseInt(str.substring(5));
            late = X;
            q.offer(X);
            return ;
        }

    }
}