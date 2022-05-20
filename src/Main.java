package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 16968 차량 번호판 1
    // 처음에는 길이가 4라는 부분을 보고 2^4 = 16 가지 경우라서 브루트 포스를 생각했다가
    // 길이가 4 "이하"라는 걸 체크하고서는 완전탐색은 아니라고 생각했다.
    // 같은 문자나 숫자가 연속으로 오면 안 되는 거니까 문자-문자면 26이 아닌 25를 곱하고
    // 숫자-숫자면 10이 아닌 9를 곱하면서 string을 끝까지 간다.
    // 이때 i번째가 숫자인지 문자인지는 flag를 true나 false로 바꿔가면서 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // cccc dddd
        // cccd dddc
        // ccdc ddcd
        // ccdd ddcc
        // cdcc dcdd
        // cdcd dcdc
        // cddc dccd
        // cddd dccc

        int answer = 1;
        boolean flag = true;
        if(str.charAt(0)=='c'){
            flag = true;
            answer = 26;
        }
        else{ // 처음이 d
            flag = false;
            answer = 10;
        }

        for(int i=1;i<str.length();i++){
            if(flag && str.charAt(i) == 'c'){ // c뒤에 c가 또 오는 경우
                answer *= 25;
                flag = true;
            }
            else if(flag && str.charAt(i) == 'd'){ // c뒤에 d가 오는 경우
                answer *= 10;
                flag = false;
            }
            else if(!flag && str.charAt(i) == 'c'){ // d뒤에 c가 오는 겨웅
                answer *= 26;
                flag = true;
            }
            else {
                flag = false;
                answer *= 9;
            }
        }

        System.out.println(answer);
    }
}