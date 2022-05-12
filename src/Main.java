package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java 모음사전
    // 처음에는 순열로 r을 1씩 늘려가면서 길이가 1~5인 순열을 구해서 구하려 했는데 그런 문제가 아니었다 ㅠㅠ
    // 순열이나 조합처럼 모든 경우의 수를 구하는 건 못할 거 같아서 규칙이 있나 찾아보려 했다.
    // 직접 써보면서 4번째와 5번째 자리수의 규칙은 찾았는데 그 앞자리는 도저히 일일이 세볼 수 없어서
    // 규칙을 찾으려 했는데 처음에는 그냥 남는 자릿수에 올 수 있는 5가지를 곱했는데 숫자가 맞지 않았다.
    // 그래서 찾은 규칙을 활용해서 3번째 자리를 찾을 때는 4번째 자리가 6개씩 차이나니까 6 * 5에서 +1을 해서
    // 자릿수의 규칙을 찾아나갔다.

    public static void main(String[] args) throws IOException {

        String word = "AAAAE";

        int answer = 0;

        char[] mo = {'A','E','I','O','U'};
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);

        answer = word.length(); // 기본적으로 A만으로 이루어진 사전 순서로 세팅

        int[] diffByDigit = {781,156,31,6,1};

        for(int i=0;i<word.length();i++){
            answer += map.get(word.charAt(i)) * diffByDigit[i];
        }
        System.out.println(answer);
    }
}

/*

    static ArrayList<String> list = new ArrayList<>();

        char[] mo = {'A','E','I','O','U'};
        String word = "AAAAE";

        for(int i=1;i<=5;i++){
            int r = i;
            int depth = 0;
            boolean[] visited = new boolean[mo.length];
            char[] result = new char[r];
            combination(mo,r,depth,result,visited);
        }

        int answer= 0;
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
//            if(list.get(i).equals(word)){
//                answer = i+1;
//                break;
//            }
        }

        System.out.println(answer);

    }

    private static void combination(char[] mo, int r, int depth,char[] result,boolean[] visited) {
        if(depth == r){
            StringBuffer sb = new StringBuffer();

            for(int i=0;i<result.length;i++){
                sb.append(result[i]);
            }
            list.add(sb.toString());

            return ;
        }

        for(int i=0;i<mo.length;i++){
            if(!visited[i]){
                result[depth] = mo[i];
                visited[i] = true;
                combination(mo,r,depth+1,result,visited);
                visited[i] = false;
            }

        }

 */