import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 가장 긴 팰린드롭
    // 부분 문자열 중 가장 긴 앞뒤가 똑같은 부분 문자열의 길이 찾기 문제
    // 통과했는데 효율성을 결국 검색해서 알아보고 해결했다 ㅠㅠ
    // for(int i=0;i + len <= s.length(); i++) 이 부분에 차이가 있었다.
    // 나는 s.length() - len 이렇게 했는데 이런식으로 해서 사용하는 index를 편하게 활용한 것이
    // 대부분 사람들의 풀이 방식이었다.
    // 이를 제외하고는 코드 자체가 다르지 않은 것으로 보아 내가 한 방식으로도 해결이 가능했을 터인데
    // 내가 for문을 깨끗하게 하려는 습관이 있어서 for문을 깨끗하게 하니 for 문 내에서
    // 인덱스를 순회하는 과정이 번거롭게 되어 실패했던 것이 아닐까 싶다.


    public static void main(String[] args) {

        String s = "abcdcba";

        char[] ch = s.toCharArray();

        for(int len = s.length(); len >= 1; len--){ // 7 6 5 4 3 2 1
            for(int i=0;i + len <= s.length(); i++) {

                boolean flag = true;
                int mid = len / 2;
                for(int idx=0;idx<mid;idx++){
                    if(ch[i + idx] != ch[i + len - idx - 1]){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(len);
                }

            }

        }



    }
}