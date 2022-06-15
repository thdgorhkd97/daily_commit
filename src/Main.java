package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : java 3085 사탕 게임
작성자 : 송해광 ( 2022 - 06 - 15 )
문제접근 : 연속된 문자가 다르면 이 문자의 위치를 바꿔서 연속된 문자가 몇 개인지 체크
 */

public class Main {

    static int maxCandy = 0; // 가장 많은 캔디의 수를 저장하는 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] candy = new char[N][N];

        for(int i=0;i<N;i++){
            candy[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                char target1 = candy[i][j]; // 비교할 2가지 변수 중 하나
                char target2 = candy[i][j+1]; // 비교할 2가지 변수 중 하나

                if(target1 != target2){ // 연속된 2 문자가 다르다면
                    change(i,j,i,j+1,candy); // 바꿔서 체크하는 메소드로
                }
            }
        }
        System.out.println(maxCandy);


    }

    private static void change(int posX1, int posY1, int posX2, int posY2, char[][] candy) {
        char tmp = candy[posX1][posY1];
        candy[posX1][posY1] = candy[posX2][posY2];
        candy[posX2][posY2] = tmp; // 연속된 두 문자가 다르기 때문에 위치를 바꾼다.

        int cntC = 0;
        int cntP = 0;
        int cntZ = 0;
        int cntY = 0;
        int len = candy.length;

        for(int i=0;i<len;i++){
            cntC = 0;
            cntP = 0;
            cntZ = 0;
            cntY = 0; // 각각의 사탕 색에 대한 변수들 초기화
            for(int j=0;j<len;j++){
                switch (candy[i][j]){
                    case 'C' : cntC++; break;
                    case 'P' : cntP++; break;
                    case 'Z' : cntZ++; break;
                    case 'Y' : cntY++; break;
                }
            }

            maxCandy = Math.max(maxCandy,Math.max(Math.max(cntC,cntP),Math.max(cntZ,cntY)));
        }

        tmp = candy[posX1][posY1];
        candy[posX1][posY1] = candy[posX2][posY2];
        candy[posX2][posY2] = tmp; // 위치를 바꾼걸 다시 원위치 해야한다.
    }
}
