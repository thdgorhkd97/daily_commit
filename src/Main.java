import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 3차 압축
    // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
    // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
    // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
    // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
    // 5. 단계 2로 돌아간다.

    // 문제를 잘못 이해하고 접근한 것이 문제가 되는 것 같다.
    // 처음에 이해한 건 첫번째 예시에 집중해서 그 다음 글자까지를 묶은 2개의 길이만을
    // 사전에 포함되었는지 확인하는 식으로 했는데 그렇게 되는 것이 아니라
    // 그 뒤쪽으로 사전에 포함된다면 가장 긴 문자열을 찾아야 하는 문제였다
    // 그리고 그 과정에서 현재 시작 지점과 그 뒤쪽으로 사전에 포함되는 문자열을 찾는
    // 인덱스를 찾는 과정에서 변수가 헷갈려서 시간이 조금 걸렸다
    // 나머지에 대해 내일 구현해 봐야 겠다.
    // 문제 이해하다가 시간이 많이 흘러서 ;;

    public static void main(String[] args) throws IOException {

        String msg = "KAKAO";

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int num = 1;
        map.put("A",num++);
        map.put("B",num++);
        map.put("C",num++);
        map.put("D",num++);
        map.put("E",num++);
        map.put("F",num++);
        map.put("G",num++);
        map.put("H",num++);
        map.put("I",num++);
        map.put("J",num++);
        map.put("K",num++);
        map.put("L",num++);
        map.put("M",num++);
        map.put("N",num++);
        map.put("O",num++);
        map.put("P",num++);
        map.put("Q",num++);
        map.put("R",num++);
        map.put("S",num++);
        map.put("T",num++);
        map.put("U",num++);
        map.put("V",num++);
        map.put("W",num++);
        map.put("X",num++);
        map.put("Y",num++);
        map.put("Z",num++);

        int idx = 0;
        for(int i=0;i<msg.length();i++){
            StringBuffer sb = new StringBuffer();

            sb.append(msg.charAt(i));


        }

        /*
        int idx = 0;
        int pos = 0;
        while(idx <= msg.length()-1){
            StringBuffer sb = new StringBuffer();

            for(int i=pos; ;){
                sb.append(msg.charAt(i));

                String str = sb.toString();
                System.out.println(str);

                if(map.containsKey(str)){
                    list.add(map.get(str));
                }
                else{
                    map.put(str,num++);
                    break;
                }

                i++;
                pos = i;

            }
            idx += pos;

        }

         */

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
