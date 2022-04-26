import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 6603 로또
    // 주어진 숫자 목록 중에서 6개를 골라서 중복없이 사전순으로 출력하는 문제다.
    // 중복이 없기 때문에 생각보다 많은 시간을 먹지는 않은 것으로 보이는데
    // 처음에 모든 조합을 출력했다가 중복을 제외해야 한다는 조건 때문에 바꿔서
    // 출력하였고 이때 출력형식 오류가 발생했는데
    // 그냥 단순히 메서드 내에서 출력하는 게 아니라 StringBuffer를 받아서
    // 한번에 출력하는 방법으로 바꿔서 실행하여 해결하였다.

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");

            int k = Integer.parseInt(stk.nextToken());

            if(k==0) break;

            int[] arr = new int[k];

            for(int i=0;i<k;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }

            int r = 6;
            int depth = 0;
            int[] result = new int[r];
            int startIdx = 0;
            permutation(arr,k,depth,r,result,startIdx);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void permutation(int[] arr, int k, int depth, int r, int[] result,int startIdx) {
        if(depth == result.length){
            for(int i=0;i<result.length;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return ;
        }

        for(int i=startIdx;i<arr.length;i++){
            result[depth] = arr[i];
            permutation(arr,k,depth+1,r,result,i+1);
        }

    }
}
