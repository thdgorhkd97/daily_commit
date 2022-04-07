import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 줄 서는 방법
    // 사전 순으로 순열을 표현하는 방법으로 해서 쭉 모든 케이스를 표현한 후에
    // k번째를 구하려고 했는데 그렇게 하니 몇몇 케이스에서 시간과 메모리 초과가 발생한다
    // 그래서 다른 방법을 찾아야만했다.

    // n = 4, k = 7인 경우를 생각해보면
//            1, 2, 3, 4
//            1, 2, 4, 3
//            1, 3, 2, 4
//            1, 3, 4, 2
//            1, 4, 2, 3
//            1, 4, 3, 2
//            2, 1, 3, 4
//            2, 1, 4, 3
//            2, 3, 1, 4
//            2, 3, 4, 1
//            2, 4, 1, 3
//            2, 4, 3, 1
//            3, 1, 2, 4
//            …
    // 이렇게 되는 건데 즉 맨 앞자리는 (n-1)! 만큼 반복되므로 맨 앞자리를 유추할 수 있다.
    // 그 후에는 2를 제외한 [1,3,4] 중에 k = (k-1) % (n-1)!을 통해 구할 수 있다고 한다

    public static void main(String[] args) throws IOException {

        int n = 3;
        long k = 5;

        ArrayList<Integer> list = new ArrayList<>();

        long factorial = 1;
        for(int i=1;i<=n;i++){
            list.add(i);
            factorial *= i;
        }

        long remain = k-1;
        int[] answer = new int[n];

        int i = 0;
        while(i < n){
            factorial = factorial / (n-i); // n-i = 3 2 1 factorial = 2 1 1
            long value = remain / factorial; // value = 2 4 4
            answer[i++] = list.get((int) value);
            list.remove((int)value);
            remain = remain % factorial;

            System.out.println("factorial = " + factorial + " value = " + value + " remain = " + remain);
        }






    }
}