import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 17298 오큰수
    // stack을 활용하여 시간초과에 걸리지 않는 풀이법에 대해서 이해하느라 시간이 오래 걸림 ㅠㅠ
    // 일단 원리자체는 수열의 인덱스를 특정 기준(현재 원소가 이전의 원소보다 작을 때까지)
    // 을 만족하면 index를 stack에 추가하는 것이다.
    // 그러다가 현재 원소가 top 원소를 인덱스로 하는 수열의 원소보다 크게 되면
    // stack의 원소를 pop하면서 해당 인덱스에 해당하는 원소를 현재 원소로 바꾼다.
    // https://st-lab.tistory.com/196 이 사이트에서 설명 가져왔습니다(설명 어렵네요..)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] N = new int[T];

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str," ");

        int idx = 0;
        while(stk.hasMoreTokens()){
            N[idx++] = Integer.parseInt(stk.nextToken());
        }

        int[] NGE = new int[T];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<T;i++){
            /*
             * 스택이 비어있지 않으면서
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */
            while(!stack.isEmpty() && N[stack.peek()] < N[i]){
                N[stack.pop()] = N[i];
            }

            stack.push(i);
        }


        /*
         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
         * -1로 초기화한다.
         */
        while(!stack.isEmpty()){
            N[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            sb.append(N[i]).append(' ');
        }

        System.out.println(sb);



        /* stack에 분류된 문제인데 그냥 for문으로 확인했을 때 시간초과가 발생한다.
        stack을 사용하지 않아서 발생한 문제인가...

        for(int i=0;i<T-1;i++){
            boolean isBig = false;
            for(int j=i+1;j<T;j++){
                if(N[i] < N[j]){
                    isBig = true;
                    NGE[i] = N[j];
                    break;
                }
            }

            if(!isBig){
                NGE[i] = -1;
            }
        }

        NGE[T-1] = -1;

        for(int i=0;i<T;i++){
            System.out.print(NGE[i] + " ");
        }*/

    }

}