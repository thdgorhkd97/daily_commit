import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // Line 코딩테스트 대비 실전 문제 풀이
    // 주어지는 문자열을 원형으로 연결하여 생각해서 연속된 같은 문자의 개수를 문자열 배열로 반환
    // 원래 오늘 그래프 이론 중 MST를 공부하려 했는 데 토요일날 라인 코딩테스트를 봐도 된다는 메일이 와서
    // 실전 코딩테스트 문제를 하나 추가로 풀어보기로 하였다.
    // 원형으로 연결되었다는 걸 표현하기 위해서 0번 인덱스와 맨 끝 인덱스를 연결하여 같은 문자가 어디까지 연결되는지
    // 확인하고서 그 사이에 있는 문자의 개수를 파악한다.
    // 로직자체는 그리 어렵진 않았지만 0번 인덱스에서 시작해서 끝 인덱스로 이어지는 부분을 표현하는게 어려웠다.
    // 처음에 0번부터 while로 체크하고 s.length-1에서 -- 해가며 while 로 체크 하는 데 자꾸 인덱스 오류가 났었다.

    public static void main(String[] args) {

        String s = "wowwow";

        char ch = s.charAt(0);
        int idx = 0;

        ArrayList<Integer> list = new ArrayList<>();

        int first = 0;
        int last = 0;
        int cnt = 0;
        while(ch == s.charAt(idx)){
            cnt++;
            idx++;
        }
        first = idx;
        idx = s.length()-1;
        while(ch == s.charAt(idx)){
            cnt++;
            idx--;
        }
        last = idx;
        list.add(cnt);

        int pos = first;
        for(int i=pos;i<=last;i++){
            ch = s.charAt(i);
            cnt = 0;
            while(ch == s.charAt(pos)){
                cnt++;
                pos++;
            }
            list.add(cnt);
            i = pos-1;
        }

        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }



    }
}