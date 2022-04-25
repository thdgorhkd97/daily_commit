import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 10973 이전 순열
    // combination으로 순열을 받아서 해결하는 과정에 대한 문제는 해결했다.
    // result를 list에 넣으니까 마지막으로 갱신한 result값만 들어갔는데
    // 새로운 배열로 받아서 그 갱신되는 배열을 넣으니까 해결 가능했다.
    // 근데 그렇게 순열을 모두 구해서 일치하는 바로 앞을 구하는 방식은
    // 순열을 구하는 방식이 오래 걸리기 때문에 시간초과가 발생한다.

    // 그래서 해결방법을 보니

//    1. A[i-1] > A[i]를 만족하는 카장 큰 i를 찾는다.
//    2. j >= i 이면서 A[j] < A[i-1]을 만족하는 가장 큰 j를 찾는다.
//    3. A[i-1]과 A[j]를 swap한다.
//    4. A[i]부터 순열을 뒤집는다.
//  사전순이기 때문에 해결할 수 있는 로직이 있었고 이를 알아보고 해결하는 데 도움을 받았다

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int[] target = new int[N];
        for(int i=0;i<N;i++){
            target[i] = Integer.parseInt(stk.nextToken());
        }

        if (Previous(target)) {
            for (int i=0; i<target.length; i++) {
                System.out.print(target[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }

    }

    private static boolean Previous(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] <= a[i]) {
            i -= 1;
        }

        // 첫 번째 순열인 경우
        if (i <= 0) {
            return false;
        }
        //2. a[i-1] > a[j]를 만족하는 첫 번째 수 찾기
        int j = a.length-1;
        while (a[j] >= a[i-1]) {
            j -= 1;
        }

        //3. a[i-1]과 a[j] swap
        swap(a, i-1, j);

        //4 i부터 a.length-1까지 순열 뒤집기
        j = a.length-1;
        while (i < j) {
            swap(a, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
