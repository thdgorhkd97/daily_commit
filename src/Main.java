import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // L 사 코딩테스트 1번 문제
    // source 문자열에서 겹치지않게 하나씩 문자를 빼고 사전순으로 정렬한 다음 문자열을 이어나간다.
    // 처음에는 source 문자열에서 꺼내고 source 문자열 내에서 제외해나가면서 처리하려 했는데
    // String 형을 제외해 나가면서 하기가 쉽지 않았다( 사용했으면 아예 다른 문자로 바꾸는 식으로 치환하려 함)
    // 근데 그렇게 하면 source의 길이만큼 계속 순회를 했어야 해서 그런 방식은 포기했다.
    // 그래서 source 문자열을 arraylist로 복사해서 거기서 제외해 나가며 새로운 문자열을 만들었다.
    // 처음에 source 문자열을 처리해서 해결해야 겠다는 생각에 시간을 조금 소요했었는데
    // 진작 arraylist로 했으면 훨씬 빠르게 처리할 수 있었을 것 같다.


    public static void main(String[] args){

        String source = "execute";

        String dest = "";

        Set<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> s = new ArrayList<>();

        for(int i=0;i<source.length();i++){
            s.add(source.charAt(i));
        }

        while(true){
//if(source.equals("")) return dest;

            if(s.isEmpty()) break;

            for(int i=0;i<s.size();i++){
                if(set.add(s.get(i))){ // 겹치지 않으면
                    list.add(s.get(i));
                    s.remove(s.get(i));
                    i--;
                }
            }

            Collections.sort(list);

            StringBuffer sb = new StringBuffer();
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i));
            }
            dest += sb.toString();

            set.clear();
            list.clear();

        }

        System.out.println(dest);

    }
}