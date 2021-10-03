import javax.swing.text.View;
import java.util.*;

public class Main {

    // S사 코딩테스트 - 개미수열
    // 1 11 12 1121 122111 ...
    // 개미수열은 1 -> 11 에서의 과정은 "1이 하나" 이기 때문에 11이된다.
    // 11 -> 12 는 11은 "1이 둘" 이기 때문에 12가 된다.
    // 12 -> 1121 은 12는 "1이 하나 2가 하나" 이기 때문에 1121이 된다.
    // ant_arr 에서 문자가 다를 때마다 체크를 했는데 그렇게 하다보니 다르다는 else문에 들어가지 않는
    // 마지막까지 비교하던 문자에 대해서 추가되지 않는 문제가 있었다.
    // 그래서 for문에서만 하는 것이 아니라 마지막으로 비교하던 문자에 대해서 추가하기 위해서
    // for문 밖에서 마지막으로 append 해주어야 한다.


    private static String[] ant = new String[40]; // 문제조건이 40까지 구한다

    public static void main(String[] args) {

        String answer = "";

        ant[0] = "1";

        for(int i=1;i<40;i++){
            ant[i] = ant_arr(ant[i-1]);
        }

        for(int i=0;i<40;i++){
            System.out.println(ant[i]);
            System.out.println();
        }

    }

    public static String ant_arr(String str){

        StringBuffer sb = new StringBuffer();

        char ch = str.charAt(0);
        int cnt = 1;

        for(int i=1;i<str.length();i++){
            if(ch == str.charAt(i)){
                cnt++;
            }
            else{
                sb.append(ch);
                sb.append(String.valueOf(cnt));
                ch = str.charAt(i);
                cnt=1;
            }
        }

        sb.append(ch);
        sb.append(String.valueOf(cnt));

        return sb.toString();

    }
}