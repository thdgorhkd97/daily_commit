package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 11659 구간 합 구하기 4
    /*
    작성자 : 송해광
    2022-06-06 소요 시간 : 40분
    문제 설명 : 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
    문제 접근 방법 : 그때그때 인덱스에 해당하는 for문을 돌리면 시간초과가 발생하기 때문에
                   다른 방법을 활용해야 했고 누적합을 활용하기로 하였다.
                   배열의 합을 바로바로 구할 수 있는 방법이기 때문이다.
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken()); // 수의 개수 ( arr 의 크기 )
        int M = Integer.parseInt(stk.nextToken()); // 합을 구해야 하는 횟수

        int[] arr = new int[N]; // 주어지는 수를 담을 배열
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        accumlateSum(arr); // arr배열의 누적합 계산

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(stk.nextToken()); // 합을 구해야하는 구간 시작
            int end = Integer.parseInt(stk.nextToken()); // 합을 구해야하는 구간 끝
            checkSum(arr,start,end); // arr배열의 start에서 end 까지의 합을 계산하는 메서드
        }

    }

    private static void checkSum(int[] arr, int start, int end) {
        if(start == 1){ // start가 1이라는 건 end번 까지의 누적합을 구하라는 것
            System.out.println(arr[end-1]); // 배열의 인덱스는 0부터 시작하기 때문에 end-1 번째를 구한다
        }
        else if( start == arr.length){ // start 가 arr의 크기와 같이 주어지면 end는 반드시 start와 같은 맨 끝이기 때문에
                                       // 맨 마지막 원소를 가져오면된다.
            System.out.println(arr[arr.length-1] - arr[arr.length-2]);
            // arr은 누적합을 저장한 배열로 바뀌었기 때문에 가장 마지막 원소에서 바로 앞 원소를 뺀다
        }
        else{
            System.out.println(arr[end-1] - arr[start-2]); // 배열의 중간에서 중간까지를 구하는 것
        }
    }

    private static void accumlateSum(int[] arr) {
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
    } // 누적합 계산 함수


}
