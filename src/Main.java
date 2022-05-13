package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 1806 부분합
    // 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
    // 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

    // len을 1부터 시작해서 arr.length까지 되도록 + 해가면서
    // 2중 for문을 통해 어디부터 어디까지 더하는 구역을 구해서 더했는데
    // 로직자체가 문제인지 구현과정이 문제인지 잘 해결되지는 못했다....

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        int[] arr = new int[N];

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int len = 1;

        while(len < arr.length){
            int left = 0;
            int right = left + len;

            boolean flag = true;
            for(int i=0;i<arr.length-len;i++){
                int sum = 0;
                for(int j=i;j<right;j++){
                    sum += arr[j];
                }
                if(sum >= S){
                    flag = false;
                    break;
                }
            }

            if(!flag) break;

            len++;
        }

        System.out.println(len);

    }
}