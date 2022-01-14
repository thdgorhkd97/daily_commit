import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // programmers 신고 결과 받기
    // hashmap을 활용해서 특정 조건에 맞는 key값에 해당하는 경우를 다 더하고
    // int형 배열로 반환하는 문제
    // hashmap에서 조금 문제가 생겼다. 처음에는 getOrDefault를 사용하면 될 줄 알았는데
    // 자꾸 nullpointerexception이 발생해서 map.containskey()를 활용해보려 했다.
    // 근데 분명 keyset으로 확인했을 때는 해당 키가 존재하는데 String으로 비교를 하니
    // map.containskey()가 true가 반환되지 않았다...
    // 그래서 조금 돌아가는 방법이기는 하지만 keyset을 통해 확인하는 과정에서
    // if(id_list[i].equals(keyset)) 이렇게 아예 keyset과 비교하려고 했는데
    // 이 경우 역시도 똑같은 문자열인데도 true로 들어가지 않는 문제가 발생했다...
    // 문제 자체는 어렵지 않은 것 같은데 hash를 이용해서 key값이 일치하는지를 확인하고
    // 그에 따라 value값을 저장하는 데 있어서 뭔가가 잘 안되는 것 같다 ㅠㅠ


    public static void main(String[] args) throws IOException {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};

        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int k = 2;

        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[id_list.length];

        Set<String> set = new HashSet<>();

        ArrayList<String> list = new ArrayList<>();

        for(String str : report){
            if(set.add(str)){
                list.add(str);
            }
        }

        for(int i=0;i<list.size();i++){
            String str = list.get(i);

            int idx = str.indexOf(" ");

            String ing = str.substring(0,idx);
            String pp = str.substring(idx);

            map.put(pp, map.getOrDefault(pp,0)+1);
        }

        LinkedList<String> key = new LinkedList<>(map.keySet());

        for(String keyset : key){
            System.out.println(keyset + " " + map.get(keyset));

            for(int i=0;i<id_list.length;i++){
                System.out.println(id_list[i] + " 비교 " + keyset);
                if(id_list[i].equals(keyset)){
                    answer[i] = map.get(keyset);
                    break;
                }
            }

            System.out.println("-----------------------------------");
        }

        for(int i=0;i< id_list.length;i++){
            System.out.println(answer[i]);
        }








    }
}