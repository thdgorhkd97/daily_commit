import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 11054 가장 긴 바이토닉 부분수열

    // 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면,
    // 그 수열을 바이토닉 수열이라고 한다.

    // LIS를 양쪽으로 계산해야 한다고 생각했다.(산 모양으로 증가하는 수열을 구해야 하기 때문에)
    // 그래서 LIS를 왼쪽에서 증가하는 수열 & 오른쪽에서 부터 증가하는 수열을 구해서
    // 2개의 LIS를 더한다.
    // 다만 오른쪽에서부터 증가하는 수열을 구하는 과정에서 인덱스가 헷갈려서 몇 번 수정을 거쳤고
    // 왼쪽에서의 증가수열과 오른쪽에서의 증가수열이 하나가 겹치는 부분이 있기 때문에
    // 최종적으로 더해진 수열에서 가장 큰 값 - 1을 해서 답을 도출한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] bitonic = new int[N+1];
        int[] bitonic_left = new int[N+1];
        int[] bitonic_right = new int[N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i=1;i<=N;i++){
            bitonic_left[i] = 1;
            for(int j=1;j<i;j++){
                if(arr[i] > arr[j] && bitonic_left[i] <= bitonic_left[j]){
                    bitonic_left[i] = bitonic_left[j] + 1;
                }
            }
        }

        for(int i=N;i>=1;i--){
            bitonic_right[i] = 1;
            for(int j=N;j>i;j--){
                if(arr[i] > arr[j] && bitonic_right[i] <= bitonic_right[j]){
                    bitonic_right[i] = bitonic_right[j] + 1;
                }
            }
        }

        for(int i=1;i<=N;i++){
            bitonic[i] = bitonic_left[i] + bitonic_right[i];
        }

//        System.out.println("왼쪽에서부터");
//        for(int i=1;i<=N;i++){
//            System.out.print(bitonic_left[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println("오른쪽에서부터");
//        for(int i=1;i<=N;i++){
//            System.out.print(bitonic_right[i] + " ");
//        }
        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(bitonic[i],max);
        }

        System.out.println(max-1);





    }
}