package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제 : java baekjoon 3085 사탕 게임
작성자 : 송해광 ( 2022 - 06 - 16 )
문제 접근 : 위치를 확인하면서 다음 변수와 같지 않다면 2개의 위치를 바꾸고 바꾼 상태에서 최대 개수를 구한다.
         로직은 맞는 거 같은데 계속 뭔가 핀트가 어긋난 것 같다...
         결국 풀이를 확인하고 해당 코드를 이해하긴 했는데 이 역시 로직은 나와 같은 것 같은데 ㅠㅠ
         아무래도 최대 개수를 확인하고 초기화하는 과정에서 나는 한번에 한것을 조금 나눠서 해야 했을 것 같다
 */

public class Main {

    static char[][] candy; // candy를 담을 2차원 배열
    static int max; // 최대 사탕 수를 저장할 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        max = 0;
        candy = new char[n][n];
        for(int i=0;i<n;i++) {
            candy[i] = br.readLine().toCharArray();
        }
        char temp=' ';

        for(int i=0;i<n;i++) { // 가로 확인
            for(int j=0;j<n-1;j++) {
                if(candy[i][j] != candy[i][j+1]) { // 다음 변수와 다르다면
                    temp= candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = temp; // 다음 변수와 위치 교환
                    check(); // 교환한 상태로 최대 사탕 수 계산해서 저장
                    temp = candy[i][j];
                    candy[i][j] = candy[i][j+1];
                    candy[i][j+1] = temp; // 위치를 교환한 변수끼리 다시 교체
                }
            }
        }
        for(int i=0;i<n;i++) { // 세로확인
            for(int j=0;j<n-1;j++) {
                if(candy[j][i]!=candy[j+1][i]) { // 연속된 다음 변수와 다르다면
                    temp = candy[j][i];
                    candy[j][i] = candy[j+1][i];
                    candy[j+1][i] = temp; // 위치 교환
                    check();
                    temp = candy[j][i];
                    candy[j][i] = candy[j+1][i];
                    candy[j+1][i] = temp; // 다시 원래 2차원 배열로 복구
                }
            }
        }
        System.out.println(max);
    }

    static public void check(){
        int num = 1;
        for(int i=0;i<candy.length;i++) { // 가로체크
            num = 1;
            for(int j=0;j<candy[i].length-1;j++) {
                if(candy[i][j]==candy[i][j+1]) {
                    num++;
                    if(max < num) {
                        max = num;
                    }
                }
                else {
                    num = 1;
                }
            }
        }
        for(int i=0;i<candy.length;i++) { // 세로체크
            num = 1;
            for(int j=0;j<candy[i].length-1;j++) {
                if(candy[j][i]==candy[j+1][i]) {
                    num++;
                    if(max < num) {
                        max = num;
                    }
                }
                else {
                    num = 1;
                }
            }
        }
    }
}
