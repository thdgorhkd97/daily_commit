import javax.swing.text.View;
import java.util.*;

public class Main {

    // programmers level 2 - N진수 게임
    // while문에서 String에 문자를 붙일 때 + 쓰기 싫었는데 (시간이 오래 걸리므로)
    // 그때그때 하나씩 붙이는 걸 StringBuffer로 하기 어려워서
    // 구현에 초점을 두고 +로 구현하였다.
    // t * m + p (미리 구할 숫자 개수 * 참여 인원) + 튜브의 순서
    // 까지만 문자열을 구하면 되기 때문에 제한 조건을 두고 구한다.


    public static void main(String[] args) {
        int n = 2; // 진법
        int t = 4; // 미리 구할 숫자 개수
        int m = 2; // 참여 인원
        int p = 1; // 튜브의 순서

        String str = "0";
        int count = 0;

        while (str.length() < (t * m + p)) {
            String byNum = "";
            int num = count++;

            while (num != 0) {
                if (num % n >= 10)
                    byNum += String.valueOf((char) (num % n + 55));
                else
                    byNum += String.valueOf(num % n);

                num /= n;
            }

            str += new StringBuffer(byNum).reverse().toString();
        }

        String answer = "";

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++)
            sb.append(String.valueOf(str.charAt(m * i + p - 1)));

        answer = sb.toString();

        System.out.println(answer);
        //return answer

    }
}