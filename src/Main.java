import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // java 누적합의 개념

//    1. S(n) = 배열 a의 1번째 요소 부터 n번째 요소까지의 누적합
//    2. S(1) = a(1)
//    3. S(i) = S(i-1) + a(i)
//    4. a(i) + a(i+1) + ... + a(j-1) + a(j) = S(j) - S(i-1) // 누적합을 활용한 빠른 구간합 계산

    // 누적합의 성질에 대해서 알아보았고 카카오 코테에 나왔던 2중 for문을 활용한 방법보다 누적합이 빠른
    // 방법을 생각해서 for문과 누적합의 시간을 알아보고자 함수를 만들어보았다.
    // 구현과정에서 누적합의 index를 헷갈리면서 시간이 조금 오래 걸리긴 했다.
    // 누적합이란 배열에 대해서 배열의 각 인덱스까지의 모든 합을 구해서 정해진 구간의 합을 구할때
    // 누적합으로 만들어진 배열에서 조회를 통해서 합을 구하는 방식이고 나는 누적합으로 구하는 시간이
    // 훨씬 짧을 것이라 예상했는데 꼭 그렇지만은 않았다.

    // 1. n=100000 일때 For : 3 VS Prefix : 1 누적합이 더 빨랐다.
    // 2. n=1000000 일때 For : 12 VS Prefix : 5 누적합이 빠르다
    // 3. n=100000000 이면 For:129 VS Prefix:154로 그냥 반복문이 더 빠르다.
    // 아마도 구간에 따라서 장단점과 시간의 차이가 있는 듯 하다.

    public static void main(String[] args) throws IOException {

        int[] num = new int[100000000];

        for(int i=0;i<num.length;i++){
            num[i] = i;
            // 0 1 2 3 4 5 6 7 8 9
        }

        long a = System.currentTimeMillis();
        System.out.println(sumByFor(num,num.length/2, num.length));
        System.out.println(sumByFor(num,num.length/3, num.length));
        System.out.println(sumByFor(num,num.length/4, num.length));
        long b = System.currentTimeMillis();
        System.out.println("sumByFor : " + (b-a));

        int[] prefixArr = new int[num.length];
        long c = System.currentTimeMillis();
        prefixArr[0] = num[0];
        makePrefixArr(num,prefixArr);
        System.out.println(sumByPrefix(prefixArr,num.length/2,num.length));
        System.out.println(sumByPrefix(prefixArr,num.length/3,num.length));
        System.out.println(sumByPrefix(prefixArr,num.length/4,num.length));
        long d =System.currentTimeMillis();

        System.out.println("sumByPrefix : " + (d-c));

    }
    private static int sumByFor(int[] num,int start,int end){
        int sum = 0;
        for(int i=start;i<end;i++){
            sum += num[i];
        }
        return sum;
    }

    private static void makePrefixArr(int[] num, int[] prefixArr){
        for(int i=1;i<num.length;i++){
            prefixArr[i] = prefixArr[i-1] + num[i];
        }
//        for(int i=0;i<num.length;i++){
//            System.out.print(prefixArr[i] + " ");
//        }
//        System.out.println();
    }
    private static int sumByPrefix(int[] prefixArr,int start,int end){

        return prefixArr[end-1] - prefixArr[start-1];
    }

}