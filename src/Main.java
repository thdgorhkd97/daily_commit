import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // programmers kakao blind test - 신고 결과 받기
    // 2일전인가 3일전에 해봤던 문제인데 완벽히 해결하지 못해서 다시 시도해 보았다.
    // 처음에는 문제에서 구하라는 부분을 잘못 이해해서 문제를 해결하던 도중에 로직을 끝내는 실수를 했었고
    // substring을 하는 부분에서 startIdx는 바로 그 idx부터인데 신고당한 사람의 아이디를 잘못 자르는 실수를 했었다.
    // 이번엔 조금 길수도 있지만 차근차근 문제에서 구하라는 그대로 따라가면서 문제를 해결해보았다.
    // 다만 list나 set, 배열을 생각보다 많이 선언했기 때문에 메모리 측면에서는 조금 마음에 들지 않는다.
    // String[] report를 잘라서 신고한 사람과 신고당한 사람을 나누는 과정을 2번 반복했는데 이러지 말고
    // 아예 신고한 사람과 신고당한 사람에 대한 map을 다시 만드는 건 어땠을 까 싶다.


    public static void main(String[] args) throws IOException {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};

        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int k = 2;

        Map<String,Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for(String str : report){
            if(set.add(str)){ // 중복된 신고는 1회만 인정한다.
                list.add(str);
            }
        }

        for(String str : list){

            int idx = str.indexOf(" "); // 공백을 기준으로 신고한 사람과 신고당한사람의 이름이 나뉘어진다.

            String ing = str.substring(0,idx); // 신고한 사람
            String pp = str.substring(idx+1); // 신고당한 사람

            map.put(pp, map.getOrDefault(pp,0)+1); // 신고당한 사람의 횟수를 1더한다.
        }

        int[] answer = new int[id_list.length];

        ArrayList<String> stopUser = new ArrayList<>(); // 정지당한 유저의 리스트

        for(int i=0;i< id_list.length;i++){
            if(map.containsKey(id_list[i]) && map.get(id_list[i])>=k){ // 신고당한 적있고 그 횟수가 k번 이상이라면
                stopUser.add(id_list[i]); // 정지당한 유저에 추가한다
            }
        }

        Map<String, Integer> result = new HashMap<>();
        for(String str : list){
            int idx = str.indexOf(" ");

            String ing = str.substring(0,idx); // 신고한 사람
            String pp = str.substring(idx+1); // 신고당한 사람

            if(stopUser.contains(pp)){ // 신고당한 사람이 이미 정지된 유저라면
                result.put(ing,result.getOrDefault(ing,0)+1); // 정지된 유저를 신고한 사람에 대해 1을 더한다.
            }
        }

        for(int i=0;i<answer.length;i++){
            if(result.containsKey(id_list[i])){ // 정지된 유저를 신고한 적 있다면
                answer[i] = result.get(id_list[i]); // 정답 배열에서 1을 더한다.
            }
            else{
                answer[i]=0;
            }

        }



    }
}