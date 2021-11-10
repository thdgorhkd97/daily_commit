import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 특별 모의고사 1번
    // 순열 조합으로 풀었는데 시간 초과...
    // dfs로 하는 게 순서쌍에 대한 개수를 알 수는 있는데 맞는 경우에 대한
    // 문자열을 알 수가 없어서 조합을 구하였는데 시간이 초과한다..
    // dfs에서 '(' 과 ')' 의 조합을 활용하여 모든 조합을 구하면 어떨까 했는데
    // 해당 방법에 대해서는 조금 더 공부가 필요할 것 같다.


    static ArrayList<String> list = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {

        int N = 2;

        char[] ch = new char[N * 2];

        for(int i=0;i<ch.length;i++){
            if(i % 2 ==0) ch[i] = '(';
            else ch[i] = ')';
        }

        int depth = 0 ;
        int n = ch.length;
        int r = n;

        permu(ch,depth,n,r);

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
            System.out.println(list.get(i));
        }

    }
    public static void permu(char[] ch, int depth, int n, int r){
        if(depth == r){

            if(ch[0]=='('){
                StringBuffer sb = new StringBuffer();
                int L = 0;
                boolean flag = false;
                int R = 0;
                for(int i=0;i<r;i++){
                    if(ch[i] == '('){
                        L++;
                    }
                    else{
                        R++;
                    }
                    if(R > L) {
                        flag = true;
                        break;
                    }

                    sb.append(ch[i]);
                }
                if(!flag){
                    if(set.add(sb.toString())){
                        list.add(sb.toString());
                    }
                }
            }
        }
        for(int i=depth;i<n;i++){
            swap(ch,depth,i);
            permu(ch,depth+1,n,r);
            swap(ch,depth,i);
        }
    }
    public static void swap(char[] ch, int depth, int i){
        char tmp = ch[depth];
        ch[depth] = ch[i];
        ch[i] = tmp;

    }
}