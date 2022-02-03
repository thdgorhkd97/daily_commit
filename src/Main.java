import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 전력망을 둘로 나누기 & 큰 수 만들기
    // 예전에 했던 문제를 다시 풀어보고 설명이 가능할만큼 자세하게 뜯어보았다
    // 한번 풀어봤던 문제인데도 사용했던 자료구조나 접근방법만 기억날 뿐 사실상 처음부터
    // 풀었던 거나 다름없는 것 같다.
    // 1. 전력망을 둘로 나누기
    // -> arraylist[]로 연결된 전력망을 표현하고 bfs를 활용하기 위해서 boolean[]의
    // wires[i][0]와 wires[i][1]을 true로 바꾸고 (연결을 끊은 것과 같은의미) bfs 함수에서
    // 재귀를 활용해서 bfs로 다시 보내 연결된 전력망의 개수를 센다.

    // 2. 큰 수 만들기
    // -> number에서 k만큼 수를 빼는 것은 number.length() - k만큼 수를 고르는 것과 같기 때문에
    // i+k라는 인덱스의 범위를 정해놓고 그 중에서 가장 큰 수를 골라낸다.
    // 이중 for문중 내부 for문에서 종료 조건인 j<=i+k 이 부분을 생각해내는게 너무 어려웟ㄸ ㅏㅠ


    public static void main(String[] args) throws IOException {

        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        ArrayList[] arr = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<wires.length;i++){
            arr[wires[i][0]].add(wires[i][1]);
            arr[wires[i][1]].add(wires[i][0]);
        }

//        for(int i=1;i<=n;i++){
//            System.out.print(i+ " 번째 : ");
//            for(int j=0;j<arr[i].size();j++){
//                System.out.print(arr[i].get(j)+" ");
//            }
//            System.out.println();
//        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<wires.length;i++){
            boolean[] check = new boolean[n+1];

            check[wires[i][0]] = true;
            check[wires[i][1]] = true;
            int a = bfs(wires[i][0],check,arr);
            int b = bfs(wires[i][1],check,arr);
            answer = Math.min(answer, Math.abs(a-b));
        }

        System.out.println(answer);

    }

    public static int bfs(int idx,boolean[] check,ArrayList[] arr){
        int sum = 1;
        check[idx] = true;
        for(int i=0;i<arr[idx].size();i++){
            if(check[(int) arr[idx].get(i)]){
                continue;
            }
            sum += bfs((int)arr[idx].get(i),check,arr);
        }
        return sum;
    }
}

        /*
        String number = "1231234";
        int k = 3;

        StringBuffer sb = new StringBuffer();

        int pos = 0;
        int index = 0;

        for(int i=0; i<number.length()-k; i++) {

            int max = Integer.MIN_VALUE;

            System.out.println("i = " + i + " / "+pos+" 부터 "+(i+k)+" 까지 확인");
            for(int j=pos; j<=i+k; j++) {
                int cur_num = number.charAt(j)-'0'; //String 속 숫자를 int로
                if(max < cur_num) {
                    index = j; // 큰 숫자일때의 인덱스
                    max = cur_num; // 그때 합칠 숫자
                }
            }
            System.out.println("정답에 "+max+" 를 추가합니다");
            sb.append(max);
            pos = index + 1; // 추가한 문자의 다음 인덱스부터 다시 서치 시작
        }

        System.out.println(sb.toString());
         */

