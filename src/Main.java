import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // java programmers level 2 - N개의 최소공배수

    // arr의 모든 원소의 공통된 최소공배수를 구하는 문제
    // 처음에 생각했던 방식은 lcd_long 방식이었다.
    // 가장 큰 숫자를 기준으로 그 숫자에 +1씩 해가면서 다른 모든 수가 그 수의 약수인지 확인하는
    // 식으로 진행하였다. 공통된 배수는 반드시 가장 큰 숫자보다도 커야 하기 때문에 for문의
    // 첫 시작점의 수를 설정하는 것으로 시간을 줄이려고 했다

    // 근데 시간초과가 우려되어 다른 생각을 해봤다.
    // 공통 공배수라는 건 단순히 가장 큰 숫자보다 더 크다는 것 뿐 아니라 가장 큰 숫자보다
    // n배씩 해가는 배수이기 때문에 1,2,3,4... 가장 큰 숫자의 배수를 다른 원소들로 나누면서
    // 공배수인지 확인하면 되는 것이다.

    // 실제로 시간상 이득이 있는건지 확인하기 위해서 시간을 재보았는데
    // 내가 임의로 정한 이름(lcd_short vs lcd_long) 의 시간 비교는 arr의 크기를 2000으로
    // 설정했을 때 lcd_short 는 2 lcd_long은 17이라는 숫자가 나왔다.
    // 물론 원소가 임의로 마구 들어가 있어서 정확한 비교는 안 될 수있지만 같은 상황에서 시간이
    // 줄어드는 것은 확실한 것 가탇.

    public static void main(String[] args) throws IOException {

        int[] arr = new int[2000];

        for(int i=0;i<arr.length;i++){
            arr[i] = 2*i + 2;
        }
        Arrays.sort(arr);

        long beforeTime = System.currentTimeMillis();
        int answer = lcd_short(arr,arr[arr.length-1]);

        long afterTime = System.currentTimeMillis();
        System.out.println(" 시간 : " + (afterTime- beforeTime)/1000);

        System.out.println(answer);
    }

    public static int lcd_short(int[] arr,int max){


        for(int i=1; ;i++){
            int num = max * i;
            boolean flag = true;
            for(int j=0;j<arr.length;j++){
                if(num % arr[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) return num;
        }
    }


    public static int lcd_long(int[] arr,int max){

        for(int i=max; ;i++){
            boolean flag = true;
            for(int j=0;j<arr.length;j++){
                if( i % arr[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
    }

}
