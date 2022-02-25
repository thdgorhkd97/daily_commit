import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1037 약수

//    양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
//    어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.

    // 1과 N이 아닌 N의 약수가 모두 주어지는 것이기 때문에 정렬한 후를 확인해보면
    // 총 i개의 약수가 있다면 1*i / 2*(i-1) ... 이런 식으로 합쳐서 i+1이 되는 순번을
    // 곱하면 N이 나오게 된다. (혹시 제곱수라면 같은수가 2번 곱해진다.)

    // java 1085 직사각형에서 탈출
    // 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
    // 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

    // 지나치게 복잡하게 생각해서 시간이 상당히 오래걸리는 문제가 있었다 ㅠㅠ
    // 직사각형의 경계선까지 거리를 구해야 하기 때문에 (x,y)의 위치를 Math.abs()로 절댓값으로 거리계산하고
    // (w,h)의 직선으로 위치하고 있어서 직선거리가 대각선인 경우에 (즉 꼭짓점으로 도달해야하는 경우)
    // 를 계산하기 위해서 피타고라스의 정리를 활용하고 그랬는데 문제를 보니
    // xy가 반드시 wh보다 1이상 작다는 조건이 있어서 쉽게 해결할 수 있었다.
    // 그냥 직사각형의 4가지 선분까지의 거리를 비교하면 되었다.
    // x y w-x h-y 4가지

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        int N = Integer.parseInt(br.readLine());

        int[] real = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            real[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(real);

        System.out.println(real[0] * real[real.length-1]);
         */

        StringTokenizer  stk = new StringTokenizer(br.readLine()," ");

        int[] point = new int[4];
        for(int i=0;i<4;i++){
            point[i] = Integer.parseInt(stk.nextToken());
        }

        int x = point[0];
        int y = point[1];
        int w = point[2];
        int h = point[3];

        System.out.println(Math.min(Math.min(Math.min(x,y),w-x),h-y));





    }
}