import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2309 일곱 난쟁이

//    왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다.
//    일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
//    아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
//    뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
//    아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

    // 조합으로 9명 중에서 7명을 골라서 그 7명의 키 합이 100이면 출력한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hobit = new int[9];

        for(int i=0;i<9;i++){
            hobit[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hobit);
        int[] result = new int[7];
        int depth = 0;
        int startIdx = 0;
        combination(depth,startIdx,result,hobit);

    }
    private static void combination(int depth,int startIdx,int[] result,int[] hobit){
        if(depth == result.length){
            int sum = 0;
            for(int i=0;i<result.length;i++){
                sum += result[i];
            }
            if(sum == 100){

                for(int i=0;i<result.length;i++){
                    System.out.println(result[i]);
                }
            }

            return ;
        }
        for(int i=startIdx;i<hobit.length;i++){
            result[depth] = hobit[i];
            combination(depth+1,i+1,result,hobit);
        }
    }


}