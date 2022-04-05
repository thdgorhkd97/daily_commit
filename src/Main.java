import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 불량 사용자

    // 풀이를 찾아보고 로직을 이해하면서 직접 주석을 달아보았다.
    // 풀이 과정은 나랑 비슷한 것 같은데 matches라는 메소드를 활용해서 백트래킹으로 조합을 구했는데
    // matches라는 메소드에 대해서 좀 더 알아보자.

    // str.matches("(.*)code(.*)"); -> code 앞뒤로 다른 문자가 와도 code가 있으면
    //                                 true를 리턴( .contains와 같은 기능)
    // str.matches("code"); -> code를 제외한 문자가 포함되면 false를 리턴

    // contains와 matches의 차이점
    // contains()는 인자로 전달된 문자열이 존재하는지 확인
    // matches()는 정규표현식을 인자로 받고 동일한 패턴이면 true 리턴

    // str.matches("java") -> 정확히 일치해야 한다.(정규표현식이 아니면)
    // 대소문자도 구별한다. 정확히 일치해야만 true를 리턴하기 때문에
    // 특정 문자열을 검색할 때 보다는 정규식 표현에 주로 활용한다.

    static HashSet<String> set;
    static String[] regex;
    static String[] user;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        set = new HashSet<>();
        user = user_id;

        regex = new String[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
            // *을 .으로 변경한다.( mathches()를 활용하기위함 ?)
        }

        visited = new boolean[user.length];
        backtracking(0, ""); // 내가 했던 것처럼 전체적인 조합에 대해서 구하는 메서드

        System.out.println(set.size());


    }

    private static void backtracking(int idx,String result){
        if(idx == regex.length) { // banned_id와 길이가 같다면
//            System.out.println(result);
            String[] str = result.split(" ");
            Arrays.sort(str); // 정렬

            String newstr = "";
            for(int i = 0; i < str.length; i++) {
                newstr += str[i]; // 배열에 있는 걸 하나의 string으로
            }
            set.add(newstr); // string이 set에 들어가는지(중복이 아닌지)
            return;
        }

        for(int i = 0; i < user.length; i++) {
            if(!visited[i] && user[i].matches(regex[idx])) {
                visited[i] = true;
                backtracking(idx + 1, result + " " + user[i]);
                visited[i] = false;
            }
        }
    }
}
