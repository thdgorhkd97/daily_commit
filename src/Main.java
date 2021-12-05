import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 단어 변환
    // begin 에서 target 으로 변환시키는 데 words에 있는 단어들을 거쳐서 얼마만에 가는가
    // 단 한번에 하나의 알파벳만을 바꾸는 게 가능하다.
    // 그래서 begin에서 words에 있는 단어들 중에 하나의 알파벳만 다르면 그 단어로 바꿔가면서
    // 최종으로 target으로 바뀌었을 때 바꾼 횟수를 구하는 식으로 구현했는데
    // 그렇게 하니까 이게 최소 횟수가 아니라 words를 다 돌아서라도 target이 되면
    // 문제가 해결되기 때문에 문제가 발생하였다.
    // 그래서 변환을 했을 때 바뀐 단어가 target 단어와 하나의 알파벳만 차이가 나면
    // 끝내는 식의 if문을 걸어야 하는지 싶다.
    // (근데 그렇게 하면 words에 있는 모든 단어를 계속 확인해야 하는 데...)

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

        change(begin,target,check,words);

        System.out.println(answer);

    }
    static void change(String begin, String target, boolean[] check, String[] words){
        if(begin.equals(target)){
            return ;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) {
                continue;
            }

            int cnt = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }

            if (cnt == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                check[i] = true;
                answer++;
                System.out.println(words[i]);
                change(words[i],target,check,words);
            }
        }
    }
}









/*char[][] keyboard = {
                {'q','w','e','r','t','y','u','i','o'},
                {'p','a','s','d','f','g','h','j','k'},
                {'l','z','x','c','v','b','n','m','.'}};

        String s = "tooth";
        int answer = 0;

        ArrayList<String> list = new ArrayList<>();

            int end = s.length()-2;
            int pos = 0;

            while(pos <= end) {
                StringBuffer sb = new StringBuffer();
                for (int j = pos; j < pos+2; j++) {
                    sb.append(s.charAt(j));
                }
                list.add(sb.toString());
                pos++;

            }



        HashMap<String,Integer> map = new HashMap<>(); // 길이가 2인 부분문자열의 복잡도를 넣는다.

        for(String str : list){
                char left = str.charAt(0);
                char right = str.charAt(1);

                int[] whereL = new int[2];
                int[] whereR = new int[2];

                for(int i=0;i< keyboard.length;i++){
                    for(int j=0;j< keyboard[0].length;j++){
                        if(keyboard[i][j] == left){
                            whereL[0] = i;
                            whereL[1] = j;
                        }
                        if(keyboard[i][j] == right){
                            whereR[0] = i;
                            whereR[1] = j;
                        }
                    }
                }

                int complex = Math.abs(whereL[0] - whereR[0]) + Math.abs(whereL[1] - whereR[1]);
                answer += complex;
            System.out.println(str + " " + complex);
                map.put(str,complex);


        }

        for(int i=3;i<=s.length();i++) {
            end = s.length() - i;
            pos = 0;

            while(pos <= end) {
                StringBuffer sb = new StringBuffer();
                for (int j = pos; j < pos+i; j++) {
                    sb.append(s.charAt(j));
                }


                int position = 0;
                int last = sb.toString().length() - 1;
                int complex = 0;

                while (position <= last - 1) {
                    String subString = sb.toString().substring(position, position + 2);
                    complex += map.get(subString);
                    position++;
                }
                System.out.println(sb.toString() + " " + complex);
                answer += complex;

                pos++;

            }

        }

        System.out.println(answer);*/