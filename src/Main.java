import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // 토요일 날 라인 코딩 테스트를 해야 해서 좀 알아보니 라인은 string 관련 문제가
    // 상당히 많이 나온다고 해서 string을 쫙 정리해보고자 한다.

    // 일단 string을 정리하는 과정에서 python과 비교하면서 java로 내가 구현 못하는 게
    // 뭐가 있을까 싶은 걸 찾으면서 하다보니 코드로 정리를 많이 하진 못했다.
    // 그나마 정규표현식이 가장 껄끄러울 것으로 보인다.
    // python에서는 함수 하나로 처리되는 것이 java에서는 for문을 돌리거나 특별 조건으로 처리되기때문에
    // 그래도 편하게 처리할 수 있도록 처리하는 정규표현식을 다시 보고 했다.
    // 또한, 조합 순열 중복순열 등 비슷한 개념들에 대해서 왔다갔다해서 조합만 다시 한 번 처리해봤다.

    public static void main(String[] args) throws IOException {

        // TCP school의 string method
        String str = "송해광";
        // charAt => str.charAt(i) -> i 번째 char를 반환
        System.out.println(str.charAt(0));

        // compareTo(i) -> i와 문자열을 사전 순으로 비교하여 int로 반환
        System.out.println(str.compareTo("조이현")); // -1743
        System.out.println(str.compareTo("김김김")); // 4961

        // indexOf() -> 처음 등장하는 위치의 인덱스 반환
        // lastIndexOf() -> 마지막으로 등장하는 위치의 인덱스 반환
        str = "abcdabcd";

        System.out.println(str.indexOf('c')); // 2
        System.out.println(str.lastIndexOf('c')); // 6

        // String 관련 함수는 꽤 안다고 생각하는데 가장 필요한 건 정규표현식이라 생각한다.
        // 정규표현식은 '특정한 규칙을 가진 문자열의 집합을 표현하는 데 사용하는 형식 언어'다.

        // [abc] -> a,b,c 중 하나의 문자
        // [^abc] -> a,b,c 이외의 하나의 문자
        // [0-9] -> 0~9 까지
        str = "a_b_c";
        System.out.println(str.replaceAll("[_]","A")); // aAbAc
        System.out.println(str.replaceAll("[^_]","A")); // A_A_A
        System.out.println(str.replaceAll("[a-z]","A")); // A_A_A

        str = "a_b_c932_12_1";
        System.out.println(str.replaceAll("[0-9]","N")); //숫자만 N으로

        int start = 0;
        int[] arr = {1,2,3,4,5};

        int depth = 0;

        int r = 2;
        int[] output = new int[r];
        combination(start,r,arr,depth,output);


    }
    private static void combination(int start,int r,int[] arr,int depth,int[] output){
        if(depth == r){
            for(int i=0;i< output.length;i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=start;i<arr.length;i++){
            output[depth] = arr[i];
            combination(i+1,r,arr,depth+1,output);
        }
    }
}
