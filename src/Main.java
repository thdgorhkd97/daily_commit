import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // java 9095 1,2,3 더하기

    // 1 = 1
    // 2 = 1,1 / 2 = 2
    // 3 = 1,1,1 / 1, 2 / 2,1 / 3 = 4
    // 4 = 1,1,1,1 / 1,1,2 / 1,2,1 / 2,1,1 / 2,2 / 1,3 / 3,1 = 7

    // 5 = 1+1+1+1+1 / 1+1+1+2 / 1+1+2+1 / 1+2+1+1 / 2+1+1+1 / 1+1+3 / 1+3+1 / 3+1+1
    //     1+2+2 / 2+1+2 / 2+2+1 / 2+3 / 3+2 = 13

    // 6 = 1+1+1+1+1+1 / 2+1+1+1+1 (2가 한 개일때 5) / 2+2+1+1 / 2+1+2+1 /
    //     2+1+1+2 / 1+1+2+2 / 1+2+2+1 / 1+2+1+2 / 1+1+1+3 (3 한개면 4)
    //     1+2+3 / 1+3+2 / 2+3+1 / 2+1+3 / 3+2+1 / 3+1+2 / 3+3 / 2+2+2
    //     -> 24

    // 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    // 1 ~ 6까지의 수에 대해 경우의 수를 모두 구했더니 규칙을 찾을 수 있었다.
    // 7까지 구하려 했는데 7의 경우 너무 복잡해서 구하기 어려웠다.
    // 다행히 규칙이 바로 보여서 dp를 활용해 해결할 수 있었지만 브루트 포스(완전탐색)으로
    // 분류된 문제이니 만큼 완전탐색을 통해서 해결하는 연습도 필요할 것 같다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] number = new int[11];
        number[1] = 1;
        number[2] = 2;
        number[3] = 4;

        for(int i=4;i<11;i++){
            number[i] = number[i-1] + number[i-2] + number[i-3];
        }

        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());

            System.out.println(number[num]);
        }





    }
}