import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 단어 변환
    // 한글자만 다른 단어를 words에서 찾아서 dfs로 재귀 호출하며
    // 모든 경우의 수를 찾아가다가 begin과 target이 같아지면 종료한다.
    // 다만, 내가 놓쳤던 부분은 다시 false로 재설정해야 하는 부분이다.
    // 이게 어제 내가 놓쳤던 부분처럼 하나만 다른게 여러개인 경우가 있기 때문에
    // 모든 경우의 수를 구해야 해서 다시 false로 재설정하고 begin과 target이 같게 되는 경우를
    // 기다려야 하는 거였다.
    // 나는 하나가 다른 경우의 수 중에서 변환하는 케이스가 많을 때를 어떻게 해야 할지 고민했는데
    // check를 false로 재설정하여 다시 찾아가도록 해야 한다는 게 정답이었던 듯 싶다.

    static int answer = 0;

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";

        String[] words = {"hot","dot","dog","lot","log","cog"};

        boolean make = false;
        for(String str : words){
            if(str.equals(target)){
                make = true;
            }
        }

//        if(!make) return 0;

        boolean[] check = new boolean[words.length];

        change(begin,target,check,words,0);

        System.out.println(answer);

    }
    static void change(String begin, String target, boolean[] check, String[] words,int cnt){

        if(begin.equals(target)){
            answer = cnt;
            return ;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) {
                continue;
            }

            int count = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    count++;
                }
            }

            if (count == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                check[i] = true;
//                System.out.println(words[i] + " " + cnt);
                change(words[i],target,check,words,cnt+1);
                check[i] = false; // 모든 경우의 수를 보기 위해 false로 변환
            }
        }
    }
}