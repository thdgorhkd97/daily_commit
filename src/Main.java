import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 불량 사용자

    // 주어진 불량 사용자 목록에 일치하는 아이디 목록의 수를 구하는 문제이다.

    // user_id에서 구해지는 banned_id의 수와 일치하는 아이디 목록만큼을 조합으로 구한 다음에
    // 해당 목록이 banned_id에 일치하는 지를 확인해보려 했다.
    // 근데 banned_id를 보면서 거기에 해당하는 문자까지 확인하려다 보니까 또 다시
    // 다중 for문에 대한 인덱스 개념이 많이 어렵게 느껴졌다 ㅠㅠ
    // 이중 for문을 돌면서 string을 비교하는데 거기서 또 이중 for문을 돌면서 문자 하나하나
    // 비교해야 하는 부분이 많이 힘들었다.

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};

        String[] banned_id = {"fr*d*", "abc1**"};

        int depth = 0;
        String[] result = new String[banned_id.length];
        int startIdx = 0;

        combination(depth,startIdx,result,user_id,banned_id);

        System.out.println(answer);
    }

    private static void combination(int depth,int start,String[] result,String[] user_id,String[] banned_id){
        if(depth == result.length){

            if(isPossible(result,user_id,banned_id)){
                answer++;
            }

            return ;
        }
        for(int i=start;i< user_id.length;i++){
            result[depth] = user_id[i];
            combination(depth+1,i+1,result,user_id,banned_id);
        }
    }

    private static boolean isPossible(String[] result,String[] userId,String[] ban){
        boolean[] check = new boolean[result.length];

        for(int i=0;i< ban.length;i++){
            for(int j=0;j< result.length;j++){

                String str1 = ban[i];
                String str2 = result[j];
                boolean flag = true;
                for(int m=0;m<str1.length();m++){
                    if(ban[i].charAt(m) != '*' && ban[i].charAt(m) != str2.charAt(m)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    check[i] = true;
                }
            }
        }

        for(int i=0;i< check.length;i++){
            if(!check[i]) return false;
        }
        return true;
    }

}
