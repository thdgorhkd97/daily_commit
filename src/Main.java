import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // line 코팅테스트 문제
    // arr과 brr을 일치시키기 위한 과정을 거치면서 앞에서부터
    // 길이를 맞추고 그 다음 인덱스에 그만큼을 더하거나 빼면서 끝까지 맞춰간다.
    // 근데 이를 다 맞는지를 확인하는 과정에서 arr과 brr을 끝까지 확인하면서
    // 모두 맞는지를 확인하는 과정이 오래걸린 것 같다ㅠㅠ

    public static void main(String[] args) throws IOException {

        int[] arr = {3,7,2,4};
        int[] brr = {4,5,5,2};
        int answer = 0;

        int idx = 0;
        while(!arrEqaulbrr(arr,brr)){
            for(int i=0;i<arr.length;i++){
                if(arr[i] != brr[i]){
                    idx = i;
                    break;
                }
            }

            int change = Math.abs(arr[idx] - brr[idx]);
            if(arr[idx] > brr[idx]){
                arr[idx] -= change;
                arr[idx+1] += change;
            }else{
                arr[idx] += change;
                arr[idx+1] -= change;
            }

            answer++;
        }

        System.out.println(answer);

    }
    private static boolean arrEqaulbrr(int[] arr, int[] brr){
        for(int i=0;i<arr.length;i++){
            if(arr[i] != brr[i]){
                return false;
            }
        }
        return true;
    }
}
