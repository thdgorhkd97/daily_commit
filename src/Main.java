import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 최솟값 만들기
    // 처음에는 하나의 배열에 대해 가능한 모든 순열 조합을 만들어서 i번째 원소끼리
    // 곱해서 최솟값을 구했는데 이러면 순열을 구하는게 시간이 상당히 상당히 오래 걸려서
    // 시간 초과가 발생한다.
    // 그래서 다른 방법을 찾다가 하나의 배열에서 가장 큰 원소가 다른 배열에서 가장 작은 원소와 곱해져야
    // 가장 값이 작게 나온다는 것을 알고 하나의 배열은 오름차순으로 다른 하나는 내림차순으로 해서
    // i번째 끼리 곱해서 더해가는 것이 최솟값이 된다.

    // n=11 정렬 : 0 순열 : 1
    // n=12 정렬 : 0 순열 : 18
    // n=13 정렬 : 0 순열 : 235

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        int n = 1000;
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i=0;i<n;i++){
            A[i] = i;
            B[i] = i;
        }

        long before = System.currentTimeMillis();
        Arrays.sort(A);
        Arrays.sort(B);

        int[] reverse_B = new int[B.length];
        for(int i=0;i<B.length;i++){
            reverse_B[i] = B[B.length-i-1];
        }

        int answer = 0;
        for(int i=0;i<A.length;i++){
            answer += A[i] * reverse_B[i];
        }

        System.out.println(answer);
        long after = System.currentTimeMillis();

        System.out.println((after-before) / 1000);


        before = System.currentTimeMillis();
        int[] result = new int[B.length];
        boolean[] visited = new boolean[B.length];
        int depth = 0;
        int r = B.length;
        combination(result,A,B,visited,depth,r);
        System.out.println(min);
        after = System.currentTimeMillis();
        System.out.println((after-before) / 1000);

    }

    private static void combination(int[] result, int[] a,int[] b, boolean[] visited, int depth, int r) {
        if(depth == r){

            int sum = 0;
            for(int i=0;i<result.length;i++){
                sum += result[i] * a[i];
            }
            min = Math.min(sum,min);

            return ;
        }

        for(int i=0;i<b.length;i++){
            if(!visited[i]){
                result[depth] = b[i];
                visited[i] = true;
                combination(result,a,b,visited,depth+1,r);
                visited[i] = false;
            }
        }
    }
}

/*

        Arrays.sort(A);
        Arrays.sort(B);
        int[] reverse_B = new int[B.length];
        for(int i=0;i<B.length;i++){
            reverse_B[i] = B[B.length-i-1];
        }

        int answer = 0;
        for(int i=0;i<A.length;i++){
            answer += A[i] * reverse_B[i];
        }

        System.out.println(answer);
 */