package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers 메뉴 리뉴얼
    // 애초에 문제에 대한 이해가 상당히 오래걸렸다...
    // course[]의 길이에 대해서 조합 메뉴중 가장 많은 것만 넣어야 했다
    // 근데 hashmap을 활용해서 어떤 조합 메뉴가 몇 번 반복되었는지 까지는 확인이 가능한데
    // 이를 기준으로 특정 길이에 대한 메뉴를 고르는 걸 어떻게 해야 할 지 잘 모르겠다...

    static HashMap<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};

        int[] course = {2,3,4};

        Arrays.sort(orders, (o1, o2) -> o2.length()-o1.length());

        for(int i=0;i< course.length;i++){
            for(int j=0;j<orders.length;j++){
                if(course[i] > orders[j].length()){
                    break;
                }
                else{
                    int depth = 0;
                    boolean[] visited = new boolean[orders[j].length()];
                    combination(orders[j].toCharArray(),visited,depth,orders[j].length(),course[i]);
//                    System.out.println(orders[j] + " 에서 " + course[i] + " 만큼 ");
                }
            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2)
            {
                // 내림 차순으로 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        int max = 0;
        for(Map.Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            max = Math.max(max,entry.getValue());
        }
        ArrayList<String> list = new ArrayList<>();







    }

    private static void combination(char[] toCharArray, boolean[] visited, int start, int length, int r) {
        if(r == 0){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    sb.append(toCharArray[i]);
                }
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return ;
        }

        for (int i = start; i < length; i++) {
            visited[i] = true;
            combination(toCharArray, visited, i + 1, length, r - 1);
            visited[i] = false;
        }
    }

}

        /*
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        Arrays.sort(strings);
        String[] answer = new String[strings.length];

        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            list.add(strings[i].charAt(n));
        }

        Collections.sort(list);

        int idx = 0;

        boolean[] visited = new boolean[strings.length];
        for(int i=0;i<list.size();i++){
            for(int j=0;j< strings.length; j++){
                if(strings[j].charAt(n) == list.get(i) && !visited[j]){
                    answer[idx++] = strings[j];
                    visited[j] = true;
                    break;
                }
            }
        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
         */
