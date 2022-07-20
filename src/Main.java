package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 07 - 20 )
문제 : java baekjoon 1051 숫자 정사각형
문제접근 : 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성
*/

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        char[][] rectangle = new char[N][M];
        for(int i=0;i<N;i++){
            rectangle[i] = br.readLine().toCharArray(); // 배열에 char로 넣고
        }

        int min = Math.min(N,M); // N,M 중 작은 걸로
        int maxArea = Integer.MIN_VALUE;
        int area = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<min; k++) { // 아무리 커봤자 가로,세로 중 작은 값을 넘어설 순 없다
                    if(i+k < N && j+k < M) {	// 배열 범위 이내

                        // 4개의 꼭짓점이 정사각형이 되는 조건
                        if(rectangle[i][j] == rectangle[i][j+k] && rectangle[i][j] == rectangle[i+k][j] && rectangle[i][j] == rectangle[i+k][j+k]) {
                            area = (k+1) * (k+1); // k는 인덱스이므로 + 1
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}
