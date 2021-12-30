import java.io.IOException;
import java.util.*;

public class Main {

    // programmers level 2 - 순위 검색
    // info라는 지원자 정보를 담은 배열중에서 query배열에 해당하는 정보를 만족하는
    // 지원자의 수를 골라내는 문제
    // query에 해당하는 정보를 위해서 info 배열의 지원자 점수를 제외한 나머지 정보를
    // key로 하고 점수를 value로 하여 map에 집어넣었다.
    // 그 후에 key를 보면서 query의 조건에 맞는지 확인하고 조건에 맞다면 value값과
    // 요구하는 점수 조건을 비교하는 식으로 코드를 짜보앗다.
    // 근데 query의 조건을 만족하는지 확인하는 과정에서 문제가 발생한 것으로 보인다.
    // 조건을 정리한 list와 그를 확인하기 위한 조건을 split으로 나눈 배열을 for문으로
    // 하나하나 확인하다보니 코드가 너무 번거로워졌고 split하는 과정에서
    // " and " 로 나눠서 " " 을 포함한다던지 하는 실수도 했었다.
    //

    public static void main(String[] args) throws IOException {

        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] answer = new int[query.length];

        Map<String,Integer> map = new HashMap<>();

        for(String strings : info){

            int numberIdx = 0;
            for(int i=0;i<strings.length();i++){
                if(strings.charAt(i) >= '0' && strings.charAt(i)<='9'){
                    numberIdx = i; // 처음으로 숫자가 나오는 부분
                    break;
                }
            }

            String str = strings.substring(0,numberIdx).trim(); // 숫자가 나오기 전까지
            int grade = Integer.parseInt(strings.substring(numberIdx)); // 숫자인 부분
            map.put(str,grade); // map에 숫자 전까지를 key로 숫자 부분을 value로
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        int idx = 0;
        for(String strings : query){
            String[] str = strings.split(" "); // str은 query정보

            int cnt = 0;

            for(int i=0;i<list.size();i++){
                String goal = list.get(i); // 지원자의 정보
                boolean flag = true;

                for(int j=0;j<str.length-1;j++){ // 맨 마지막은 점수이므로 앞의 조건만 확인
                    if(!str[j].equals("-") && !str[j].equals("and")){ // -과 and가 아니면 확인해야할 정보
                        if(!goal.contains(str[j])){ // 포함하고 있지않다면 더 확인할 필요 없음
                            System.out.println(goal + " 에는 " + str[j] + " 가 없습니다");
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag){ // 모든 정보를 포함하고 있다면
                    if(map.get(goal) >= Integer.parseInt(str[str.length-1])){
                        cnt++;
                    }
                }
            }

            answer[idx++] = cnt;

        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }




    }
}
