import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 가장 긴 팰린드롭
    // 부분 문자열 중 가장 긴 앞뒤가 똑같은 부분 문자열의 길이 찾기 문제
    // 중첩 반복문을 활용하여 길이를 조절해서 부분 문자열을 구해가며 구하는 데는 성공했는데
    // 정확성에서 통과를 하지 못하였다..
    // 그래서 arraylist를 char[] 배열에 복사하는 걸 크기 조정을 통해 순회를 한 번 없애고
    // 반복문으로 부분 문자열을 복사하는 걸 substring(start, start + len + 1)을 통해
    // 없앴는 데도 한 가지 효율성 테스트 케이스를 통과하지 못한다 ㅠㅠㅠ
    // 시간을 줄이기 위해서 코드를 리팩토링 해보았는데 계속 안되는 거면
    // 아마 내 로직 자체가 시간이 오래 걸리는 것으로 보인다.
    // 자료구조는 char[] 만 사용했기에 자료구조 자체에 시간이 오래 걸리는 것은 아닐 것으로


    public static void main(String[] args) {

        String s = "abcdcba";

        for(int len = s.length(); len >= 1; len--){ // 7 6 5 4 3 2 1
            int pos = s.length() - len;
            for(int i=0;i<pos;i++) {
                int start = i;
                int cnt = 0;

                char[] ch = s.substring(start,start + len + 1).toCharArray();

                    int mid = ch.length / 2;
                    boolean flag = true;
                    for(int idx=0;idx<mid;idx++){
                        if(ch[idx] != ch[ch.length - idx - 1]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        System.out.println(ch.length);
                        return ;
                    }

            }
        }


    }
}