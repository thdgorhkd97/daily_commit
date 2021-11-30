import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 불량 사용자
    // banned_id에 있는 유저 목록 중 *로 표시된 부분은 상관없이 맞는 아이디 목록을 구하는 문제
    // *로 표시된 id 마다 가능한 경우의 수를 구해서 곱하는 로직을 생각했었다.
    // 동시에 가능한 경우의 수를 구하는 것이기 때문에 2 2 2 개면 총 8개가 되기 때문이다.
    // 하지만 이렇게 하면 banned_id에 똑같은 조건이 있을 때 문제가 생긴다.
    // 예를 들어 *rodo 가 2개이고 user 중에 crodo 와 frodo 만 있다면
    // baanned_id 에 *rodo는 2개이더라도 2 * 2 = 4 개가 아니라
    // 2개만 존재해야 하는 것이다.
    // 이런 조건을 고려해서 로직을 다시 구현해야 하는데 그걸 포함하는 조건이나
    // 예외 처리를 어떻게 해야 할 지 조금 더 생각해 봐야할 것 같다..

    public static void main(String[] args){

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        Set<String> set = new HashSet<>();


        for(String str : banned_id){
            set.add(str);
        }

        int[] many = new int[set.size()];

        int idx = 0;
        for(String str : set){
            int cnt = 0;
            for(String user : user_id){
                if(str.length() == user.length()){
                    boolean flag = true;
                    for(int i=0;i<user.length();i++){
                        if(str.charAt(i)!='*' && user.charAt(i) != str.charAt(i)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                       cnt++;
                    }
                }
            }
            many[idx++] = cnt;
        }

        for(int i=0;i<many.length;i++){
            System.out.println(many[i]);
        }



    }
}