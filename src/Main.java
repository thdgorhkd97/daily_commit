import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 베스트 앨범
    // 각 장르에 맞는 전체 횟수를 정렬하고 for문을 돌면서 각 장르에 맞는 횟수를 더해서
    // 정렬한 후 상위 2개를 자르는 식으로 했는데
    // 정렬단계가 상당히 오래 걸리고 정확성은 맞다고 생각했는데
    // 정확성에서 생각보다 낮은 결과를 보였다...
    // hashmap을 정렬하는 데 있어서 keyset이나 keyvalues를 활용해서 키나 밸류를 보는 건
    // 알았는데 소트를 하면서 키나 밸류를 한번에 확인하는 방식에 대해서 새로 알았다.
//    List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(many.entrySet());
//            Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
//        @Override
//        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//            return o2.getValue().compareTo(o1.getValue());
//        }
//    });

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};

        int[] plays = {500,600,150,800,2500};

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i< genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }

        List<String> key = new LinkedList<>(map.keySet());

        key.sort((s1,s2)->s2.compareTo(s1));

        ArrayList<String> grade = new ArrayList<>();
        int idx = 0;
        for(String keyset : key){
            grade.add(keyset);
            idx++;
            if(keyset.isEmpty()||idx == 2) break;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<grade.size();i++){
            String str = grade.get(i);

            HashMap<Integer,Integer> many = new HashMap<>();
            for(int j=0;j<plays.length;j++){
                if(genres[j].equals(str)){
                    many.put(j,plays[j]);
                }
            }


            List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(many.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            int index = 0;
            for(Map.Entry<Integer,Integer> entry : entryList){
                result.add(entry.getKey());
                index++;
                if(index == 2) break;
            }

        }

        int[] answer = new int[result.size()];

        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
//            System.out.println(answer[i]);
        }



    }
}