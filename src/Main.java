import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1011 - fly me to the alpha centauri

    // 거리 1 -> 1
    // 거리 2 -> 1 1
    // 거리 3 -> 1 1 1
    // 거리 4 -> 1 2 1
    // 거리 5 -> 1 2 1 1
    // 거리 6 -> 1 2 2 1
    // 거리 7 -> 1 1 2 2 1
    // 거리 8 -> 1 2 2 2 1
    // 거리 9 -> 1 2 3 2 1
    // 거리 10 -> 1 1 2 3 2 1

    // 문제조건을 보고 한참 고민해보다가 뭔가 규칙은 있는 것 같은데 규칙성을 찾기 힘들어서
    // 결국 풀이를 참고하였다 ㅠㅠ
    // 위의 조건을 보면 최대 이동거리는 거리의 루트값이하이다. 그래서 거리가 4가 되어야 2만킄 이동한 게 나오고
    // 거리가 9가 되고 나서야 3만큼 이동한 것이다.
    // 그래서 4,9,16 ... 이렇게 제곱값이 나올때마다 이동의 최대거리가 변하게 된다.
    // 그리고 그 순간은 중간 이기 때문에 max * 2 - 1이 된다.

    // 이렇게 규칙성이 보이더라도 이를 코드로 바꾸기 위해서 관통하는 규칙을 찾아야 하는데
    // 이런 부분이 아직도 많이 부족하다고 느꼈다.
    // 직관적인 코드 작성 능력이 아니라 규칙성을 찾아내는 통찰력을 길러야 할 것 같다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            int distance = end - start;
            int cnt = 0;

            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)){
                cnt = max * 2 - 1;
            }
            else if(distance <= max * max + max){
                cnt = max * 2;
            }
            else cnt = max * 2 + 1;

            System.out.println(cnt);
        }




    }
}

