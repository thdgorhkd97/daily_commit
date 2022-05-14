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

    // for문으로 구현하면 시간초과가 나는 걸 보면 맞는 지 모르겠지만 투포인터로 구현해야 시간에 대한 부분이 해결될 것 같다
    // 근데 if(total >= s && min > end - start) min = end - start; 이 부분을 안 넣어서 계속 실패했다 ㅠㅠ
    // 해당부분을 보면 total이 주어진 s보다 커야할 것 && 현재 min보다 최소값으로 갱신가능할 것이라는 조건 인데
    // 이를 추가했어야 min을 계속해서 갱신가능하며 나는 그냥 투포인터로 합계만 확인하는 과정만 본것 같다..


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= n && end <= n) {
            if(total >= s && min > end - start) min = end - start;

            if(total < s) total += arr[end++];
            else total -= arr[start++];
        }

        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);

    }
}