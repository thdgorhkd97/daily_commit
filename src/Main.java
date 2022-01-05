import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 17298 오큰수
    // stack에 분류되어 있는 문제이다. 문제 자체는 그리 어렵지 않아서
    // for문을 통해서 구현했더니 테스트 케이스의 크기가 커서 2중 for문을 구현하니
    // 바로 시간초과가 발생했다.
    // stack을 활용하기 위해서 방법을 생각해 봤는데 아마 index를 활용하는 방법이지 않을까
    // 라는 생각까지는 닿았는데 명확한 스택을 활용한 해답이 안 떠올라서 결국
    // stack을 활용한 풀이 방법에 대해서는 조금 참고를 했다.
    // 근데! 솔직히 아직 정확히 이해를 하지 못했다.
    // index를 활용해서 배열의 원소의 크기를 비교해서 index를 stack에 집어넣는 과정은 같은데
    // 이 과정을 완벽히 구현하고 이해하지 못했다 ㅠㅠ
    // 좀 더 오래 고민해봐야 겠다. 이해하지 못하고 그냥 따라하는 건 의미가 없지 않을까..

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