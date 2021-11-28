import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 보석 쇼핑
    // 정확성은 모두 통과하는데 효율성에서 통과하지 못하였다
    // 보석의 모든 종류를 포함하는 가장 짧은 범위를 구하는 문제
    // 전체 종류 개수를 파악한 다음 시작 포인트부터 for문을 돌며 전체 종류를 포함하게 되면
    // 해당 인덱스까지의 범위를 이전과 비교하며 더 짧으면 갱신한다.
    // gems 배열이 100000까지인데 이중배열을 돌면서 확인하다 보니까 효율성에서
    // 통과하지 못하는 것으로 보인다.
    // 전체를 도는 것이 아니라 중간에서 끊을 수 있는 조건을 찾아서
    // n^2 만큼 도는 지금 로직을 변경해야 할 것 같다.

    public static void main(String[] args){

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        HashMap<String,Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>(); // 전체 종류 개수
        for(String str : gems){
            set.add(str);
        }

        int[] answer = new int[2];
        answer[1] = 100000;
        int length = 0;

        for(int i=0;i<gems.length;i++){
            map.clear();
            int start = i;
            int end = 0;
            boolean flag = true;
            for(int j=i;j<gems.length;j++){
                map.put(gems[j], map.getOrDefault(gems[i],0)+1);
                if(map.size() == set.size()){
                    end = j;
                    flag = false;
                    break;
                }
            }

            if(!flag) {

                System.out.println(i + " 일 때 " + start + " " + end);
                length = end - start;
                if (answer[1] - answer[0] > length) {
                    answer[1] = end;
                    answer[0] = start;
                }
            }

        }

        System.out.println(answer[0] + " " + answer[1]);


    }
}