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

    // 결국 풀이하는 데 다른 분의 생각을 참조하고 말았다
    // 현재 문자열의 인덱스를 기준으로 인덱스를 하나씩 늘려가며 string을 만들고
    // 해당하는 string이 사전에 있는지 확인한다.
    // 그리고 해당 string이 없으면 그때 idx와 i를 초기화하는 식으로 하면서
    // 진행하는데 내가 애먹었던 부분인 idx와 i의 관계나 증감을 이런 식으로 표현하는 구나
    // 하면서 반복문과 초기화를 활용한 부분에서 왜 놓쳤는지를 위주로 많이 보았다.

    public static void main(String[] args) throws IOException {
        String msg = "KAKAO";

        HashMap<String,Integer> map = new HashMap<>();

        int num = 1;
        char ch = 'A';

        while(ch != 'Z'){
            map.put(ch + "",num++);
            ch += 1;
        }
        map.put(ch + "",num++); // A ~ Z 까지 map에 저장(map은 사전과 같이 사용)
        // 아스키 코드를 이용해서 반복문으로 저장

        ArrayList<Integer> list = new ArrayList<>();

        int idx = 0;
        for(int i=0;i<msg.length();i++){
            String key = msg.charAt(i) + "";
            idx = i + 1;

            while( idx <= msg.length()){ //단어의 마지막까지 확인
                if(idx == msg.length()){ //단어의 마지막까지온 경우
                    list.add(map.get(msg.substring(i))); //i부터 마지막 단어까지 글자에 대응되는 색인 번호를 출력
                    i = idx; //i값을 index값으로 설정
                    break;
                }

                String nextKey = msg.substring(i,idx+1);

                if(map.containsKey(nextKey)){
                    idx++;
                }else{ //다음 글자가 사전에 없음
                    key = msg.substring(i, idx);
                    list.add(map.get(key)); //그 때의 key값에 대응되는 색인번호 출력
                    map.put(nextKey, num++); //w+c 사전에 추가
                    i = idx-1; //다음 글자의 index부터 다시 LZW
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
// System.out.println(answer[i]);
        }
    }
}
