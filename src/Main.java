import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 9461 파도반 수열

    // 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
    // P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다
    // N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

    // 주어지는 파도반 수열의 첫 10개의 숫자를 보면 (2번째 전 + 3번째 전) 이렇게 된다.
    // N에 대해서 동적 계획법을 구현하면 될 것 같다.

    // 되게 간단한 동적 계획법 문제인데 생각보다 시간이 오래 걸렸다.
    // 이유는 pado[] 라는 수열을 int로 선언했는데 int의 범위를 넘어선다는 걸 늦게 생각했다.
    // 1 <= N <= 100 이라는 범위가 있어서 N이 100이하이기 때문에 문제 없을 것이라 생각했는데
    // 888855064897 N이 100 이면 다음과 같은 값이 나온다.
    // 이 값이 int의 허용범위를 벗어나기 때문에 long형으로 받았어야 했다.
    // 주어지는 크기값이 작다고 해서 배열의 원소값이 작은 게 아닌건데 코드를 잘못 한 것이라
    // 생각해서 다른 부분을 계속 체크하고 로그확인한게 시간을 오래 잡았다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            max = Math.max(num,max);
        }

        long[] pado = new long[max + 1];

        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 1;

        for(int i=4;i<=max;i++){
            pado[i] = pado[i-2] + pado[i-3];
        }

        for(int i=0;i<list.size();i++){
            System.out.println(pado[list.get(i)]);
        }


    }
}