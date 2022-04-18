import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1759 암호 만들기
    // 주어지는 C 개의 알파벳을 이용해서 L개의 알파벳을 고른 후에 만들어지는 문자열 중에서
    // 모음이 1개 이상이고 자음이 2개 이상인 것을 고르고
    // 해당 문자열이 사전순으로 나열되어 있어야 하기 때문에 해당 문자열을 Chararray[]로 바꿔서
    // 문자열 각각이 사전순으로 나열되어 있는지 확인한 다음
    // 해당 조건을 만족하는 모든 문자열을 마지막으로 사전순 나열한다.
    // 이렇게 하면 정확성은 맞는게 확실한 것 같은데 메모리 초과가 발생한다.
    // 일단 모든 문자열을 확인해야 해서 순열로 문자열을 만드는 건 맞는 것 같은데
    // 각각의 문자열이 사전순으로 배열되어 있는지를 확인하는 과정에서
    // StringBuffer와 CharArray를 활용하는 게 메모리를 너무 많이 먹는 것 같다 ㅠㅠ

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int L = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        String[] str = new String[C];

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++){
            str[i] = stk.nextToken();
        }

        String[] result = new String[L];
        boolean[] visited = new boolean[C];
        int depth = 0;
        combination(result,str,L,visited,depth);

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    private static void combination(String[] result,String[] str,int L,boolean[] visited,int depth){
        if(depth == L){
            int mo = 0; // 모음 수
            int ja = 0; // 자음 수
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<result.length;i++){
                if(result[i].equals("a") ||result[i].equals("e") ||result[i].equals("i") ||result[i].equals("o") ||result[i].equals("u") ){
                    mo++;
                }
                else ja++;

                sb.append(result[i]);
            }

            char[] string = sb.toString().toCharArray();
            Arrays.sort(string);
            StringBuffer sb2 = new StringBuffer();
            for(int i=0;i<string.length;i++){
                sb2.append(string[i]);
            }

            if(mo>=1 && ja>=2 && sb.toString().equals(sb2.toString())) {
                list.add(sb.toString());
            }

            return ;
        }
        for(int i=0;i<str.length;i++){
            if(!visited[i]){
                result[depth] = str[i];
                visited[i] = true;
                combination(result,str,L,visited,depth+1);
                visited[i] = false;
            }
        }
    }
}