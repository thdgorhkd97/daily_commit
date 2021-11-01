import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 11월 1일
    // hashmap을 활용할 때 아무 값이 없어서 null이 반환되는 것을
    // if-else문으로 구현하였는데
    // map의 map.getOrDefault()를 통해 더 간략하게 구현이 가능하다.
    // 문제풀이를 하는 과정에서 계속 value를 1 더해서 갱신해야 하는데
    // key값을 다루는 과정에서 에러가 계속 났다.
    // 추가로 stream을 활용하여 하는 방법을 계속 공부해야 겠다.

    public static void main(String[] args) {
        int answer = 1;

        String[][] clothes = {{"yellowhat","headgear"},{"bluesunglasses","eyewear"},
                {"green_turban","headgear"}};


        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0;i<clothes.length;i++){
            if(map.get(clothes[i][1])!=null){
            map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
            else{
                map.put(clothes[i][1],1);
            }
        }

        LinkedList<String> keyset = new LinkedList<>(map.keySet());

        for(String key : keyset){
            System.out.println(map.get(key));

            answer = answer * (map.get(key)+1);
        }



        System.out.println(--answer);

   }
}