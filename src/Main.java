package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // JAVA baekjoon 2309 일곱 난쟁이
    // 작성자 : 송해광 ( 2022 - 06 - 07 )
    // 문제 설명 : 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
    //           아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
    // 문제 접근 : 처음에는 7명의 키를 더해서 100이 되는 걸 찾아야 하나 싶었는데 그렇게 하려면
    //           더 힘들 것 같아서 2명을 빼서 합이 100이 되는 걸 찾으려 했다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int yodle = 9; // 9명의 난쟁이 수
        int[] height = new int[yodle]; // 9명의 난쟁이의 키를 저장하는 배열
        int sum = 0 ; // 9명의 난쟁이의 키의 합
        for(int i=0;i<yodle;i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i]; // 키를 더해나간다.
        }

        Arrays.sort(height); // 난쟁이들의 키를 오름차순으로 정렬

        int over = sum - 100; // 7명의 난쟁이의 키의 합이 100이기 때문에 100을 초과하는 초과량을 구한다
        int idx1 = 0; // 빠져야 하는 난쟁이의 인덱스 1
        int idx2 = 0; // 빠져야 하는 난쟁이의 인덱스 2
        for(int i=0;i<yodle-1;i++){ // for 문
            for(int j=i+1;j<yodle;j++){ // for 문 ( i+1 부터 돌면서 )
                if(height[i] + height[j] == over){ // 2명의 난쟁이 키의 합이 초과량과 같으면
                    idx1 = i; // 난쟁이 한명의 인덱스 저장
                    idx2 = j; // 나머지 난쟁이의 인덱스 저장
                    break; // 찾은 순간 break로 시간 절약
                }
            }
        }

        for(int i=0;i<yodle;i++){
            if(i != idx1 && i != idx2){ // 빠져야 하는 난쟁이의 인덱스가 둘 다 아니면 출력
                System.out.println(height[i]);
            }
        }



    }
}
