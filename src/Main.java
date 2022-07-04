package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 04 )
문제 : java baekjoon 1269 대칭차집합
문제접근 : A와 B 배열 원소 중 서로에게 없는 원소 ( A-B, B-A ) 의 개수 합을 구한다.
 */

class algorithm {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int Alength = Integer.parseInt(stk.nextToken());
        int Blength = Integer.parseInt(stk.nextToken());

        int[] A = new int[Alength]; // A 배열의 원소를 담을 배열
        int[] B = new int[Blength]; // B 배열의 원소를 담을 배열

        HashMap<Integer,Integer> Amap = new HashMap<>();
        HashMap<Integer,Integer> Bmap = new HashMap<>();

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<Alength;i++){
            int aIndex = Integer.parseInt(stk.nextToken());
            A[i] = aIndex;
            Amap.put(aIndex,1); // A에 해당하는 원소
        }

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<Blength;i++){
            int bIndex = Integer.parseInt(stk.nextToken());
            B[i] = bIndex;
            Bmap.put(bIndex,1); // B에 해당하는 원소
        }


        int BminusA = 0;

        for(Integer aIndex : A){ // A 배열의 원소 각각을 확인
            if(Bmap.containsKey(aIndex)){ // A 배열의 원소가 B에 포함되는가
                BminusA++;
            }
            else{
                continue;
            }
        }

        int AminusB = 0;

        for(Integer bIndex : B) {

            if (Amap.containsKey(bIndex)) {
                AminusB++;
            } else {
                continue;
            }
        }

        System.out.println(B.length - BminusA + A.length - AminusB);

    }
}
