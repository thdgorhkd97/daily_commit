import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers 커뮤러닝
    // 문제 : n개의 괄호쌍으로 만들어지는 순서쌍 중 올바른 괄호쌍의 개수를 구하라
    // 처음에는 순열로 구해서 전체에 대해서 검사하면서 체크했다. (정확성 X)
    // 두번째는 set를 넣어서 중복된 문자열을 제외하고 검사한다.(정확성 O, 시간초과)
    // 세번째는 중간에 ) 닫히는 괄호가 열리는 괄호보다 커지면 틀린 거니까 종료(정확성 O, 시간초과)
    // 네 번째는 처음이 열리는 괄호가 아니면 넣지 않고 set에 넣을 때 올바른지 검사(정확성 O, 시간초과)
    // 시간 보면 꾸준히 검사 시간이 감소하기는 하는데 괄호쌍이 4개를 넘어가면 경우의 수도 많고
    // 시간 초과가 난다.



    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {

        int n = 3;
        char[] ch = new char[2 * n];

        for(int i=0;i<2*n;i++){
            if(i%2 == 0){
                ch[i] = '(';
            }
            else{
                ch[i] = ')';
            }
        }

        int depth = 0;
        int m = ch.length;
        int r = m;

        permu(ch,depth,m,r);

        System.out.println(set.size());
    }

    public static void permu(char[] ch, int depth, int m, int r){
        if(depth == r){
            StringBuffer sb = new StringBuffer();
            if(ch[0] == '('){
                int cntL = 1;
                int cntR = 0;
                sb.append('(');
                for(int i=1;i<ch.length;i++){
                    if(ch[i] == '('){
                        cntL++;
                    }
                    else{
                        cntR++;
                    }
                    if(cntR > cntL) {
                        break;
                    }

                    sb.append(ch[i]);
                }
                if( sb.toString().length() == m) {
                    set.add(sb.toString());
                }
            }

        }

        for(int i=depth;i<m;i++){
            swap(ch,depth,i);
            permu(ch,depth+1,m,r);
            swap(ch,depth,i);
        }
    }

    public static void swap(char[] ch, int depth, int i){
        char tmp = ch[depth];
        ch[depth] = ch[i];
        ch[i] = tmp;
    }
}