import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // java programmers level 2 - k진수에서 소수 구하기

    // 0P0처럼 소수 양쪽에 0이 있는 경우
    // P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
    // 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
    // P처럼 소수 양쪽에 아무것도 없는 경우
    // 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.

    // 437674을 3진수로 바꾸면 211020101011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다.
    // (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.)
    // 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

    // 우선 n을 k진수로 변경하고 나서 0과0 사이에 있거나 0뒤, 0앞 등으로 어떻게
    // 잘라서 소수인지를 확인하려고 하는데 어떻게 3가지 기준으로 수를 잘라서 나눠야 하는지
    // 한참을 고민했는데 생각해보니까 어차피 0으로 잘라야 하는 건데 굳이 0의 위치에 따라서
    // 나누지 않아도 될 것 같아서 0을 기준으로 자르고 나오는 모든 수를 확인하면 될 것 같았다.
    // 16가지 중 2가지 경우에 런타임 에러가 뜨는데.. 길이가 특이 케이스가 있는건가. 해결해야 한다.

    public static void main(String[] args) throws IOException {

        int n = 1;
        int k = 10;

        String number = k_jinsoo(n,k);

        String[] num = number.split("0");

//        System.out.println("num");
//        for(int i=0;i<num.length;i++){
//            System.out.println(num[i]);
//        }

        int answer = 0;
        for(int i=0;i<num.length;i++){
            if(isPrime(num[i])) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isPrime(String str){
        if(str.equals("1") || str.equals("")) return false;
        else if(str.equals("2")) return true;
        int number = Integer.parseInt(str);

        for(int i=2;i<number;i++){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    public static String k_jinsoo(int n,int k){
        StringBuffer sb = new StringBuffer();

        while(n > 0){
            sb.append(n % k);
            n = n/k;
        }

        StringBuffer str = new StringBuffer();
        for(int i=sb.toString().length()-1;i>=0;i--){
            str.append(sb.toString().charAt(i));
        }


        return str.toString();
    }
}
