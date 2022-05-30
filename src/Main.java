package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers level 2 메뉴 리뉴얼
    // 한참 고생한 문제다 ㅠㅠ 근래 들어 가장 고생한 것 같다 ㅠㅠ
    // 오기가 생겨서 끝까지 혼자 해결해보려다가 시간이 더 걸린 것 같다.
    // orders[] 배열에서 나오는 course[] 에 해당하는 길이의 모든 문자열 조합을 구해서
    // 모든 문자열 조합을 HashMap에 넣어가며 몇 번 나오는지를 체크한다.
    // 그 후를 어떻게 처리해야 할 지 가장 고생한 것 같다.
    // 각 문자열에 대해 나온 횟수까지는 구했는데 이걸 가지고 course[] 배열에 해당하는
    // 길이를 가진 문자열 중 가장 많이 나온 걸 어떻게 구해야 할 지를 고민했다.
    // 결국 course의 원소는 10이하라길래 check[] 배열을 하나 생성해서
    // 가장 먼저 등장하는 course배열의 원소와 같은 문자열의 길이를 가진 문자열이 나오면
    // check[keyset.getKey().length()] 를 해당 횟수로 바꾸고 이 횟수와 같다면
    // 같은 문자열의 길이를 가진 다른 문자열이 동일하게 가장 많이 나온다는 것이므로
    // list에 추가하는 식으로 처리했다.

    static HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] orders = {"XYZ", "XWY", "WXA"};

        int[] course = {2, 3, 4};

        Arrays.sort(orders,((o1, o2) -> o2.length() - o1.length()));

        for(int i=0;i<course.length;i++){
            int r = course[i];
            int depth = 0;
            int start = 0;
            for(int j=0;j<orders.length;j++){
                char[] ch = orders[j].toCharArray();
                Arrays.sort(ch);

                if( course[i] > orders[j].length()) break;

                boolean[] visited = new boolean[ch.length];

                combination(ch,visited,start,ch.length,r);
            }
        }

        List<Map.Entry<String,Integer>> key = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(key, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int[] check = new int[11];
        Arrays.fill(check,-1);

        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> keyset : key){
//            System.out.println(keyset.getKey() + " " + keyset.getValue());
            if( ( check[keyset.getKey().length()] == -1 || check[keyset.getKey().length()] == keyset.getValue() ) && keyset.getValue() >= 2){
                list.add(keyset.getKey());
                check[keyset.getKey().length()] = keyset.getValue();
            }
        }

//        System.out.println("-----------------------------------------");
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);



    }
    private static void combination(char[] ch, boolean[] visited,int start, int n ,int r){
        if(r == 0){

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(ch[i]);
                }
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+ 1);
                return ;
        }

        for(int i=start;i<ch.length;i++){
            visited[i] = true;
            combination(ch,visited,i+1,n,r-1);
            visited[i] = false;

        }
    }
}