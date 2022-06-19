package src;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
작성자 : 송해광 ( 2022 - 06 - 19 )
문제 : java programmers 카펫
문제 접근 :
        가로 x 세로 y -> 2 * x + 2 * y - 4 = brown
        x * y - (2 * x + 2 * y - 4) = yellow

        2x + 2y -4 = brown
        xy - (2x + 2y -4) = yellow;
        xy = brown + yellow
        x + y = (brown + 4)/2;
        무조건 바깥쪽 1줄만 brown이므로 가로와 세로에 의해 brown과 yellow로 이차방정식을 만들 수 있다.
 */

public class Main {

    public static void main(String[] args) throws IOException {


        int[] answer = new int[2];

        int brown = 24;
        int yellow = 24;

        int xy = brown + yellow; // x * y
        int sum = (brown + 4)/2; // x+y

        int width = 0;
        int height = 0;
        for(int i=1;i<=sum-1;i++){
            height = i;
            width = sum - i;

            if(width * height == xy){
                break;
            }
        }

        answer[0] = width;
        answer[1] = height;

    }
}
