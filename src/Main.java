import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 보석 쇼핑
    // 효율성에서 문제가 생겨서 인터넷에서 검색 후 해결하였다.
    // 원래는 이중배열을 이용해서 풀어서 n^2의 시간을 소모해야 했는데 투 포인터를
    // 활용해야 하는 문제였다.
    // 모든 보석을 포함하되 큐에 가장 먼저 넣은 보석이 1개보다 많아지면 1개가 될 때까지
    // 앞의 시작 포인트를 당기는 식으로 해야 했다.
    // 정확성은 좋지만 효율성에서 문제가 생기는 경우가 꽤 많다.
    // 알고 있지만 이를 해결하기가 쉽지 않은 것 같다....
    // 이번 문제도 이중 배열이 아니라 애초에 투포인터를 이용해서 인덱스를 바꿔가며 확인하는 등
    // 시간을 좀 더 신경쓰면서 해결해보자

    public static void main(String[] args){

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();

        for (String s : gems) {
            set.add(s);
        }

        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        int start = 0;
        int idx = 0;
        int len = Integer.MAX_VALUE;

        for(int i=0;i<gems.length;i++){
            map.put(gems[i],map.getOrDefault(gems[i],0) + 1);
            q.add(gems[i]);

            while(map.get(q.peek()) > 1){
                map.put(q.peek(),map.get(q.poll())-1);
                idx++;
            }

            if(map.size() == set.size() && len > (i-idx)){
                len = i - idx;
                start = idx + 1;
            }
        }

        answer[0] = start;
        answer[1] = len+start;
        System.out.println(answer[0] + " " + answer[1]);

    }
}