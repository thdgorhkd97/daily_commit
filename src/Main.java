import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 프린터 & 괄호
    // string으로 주어진 문자열에서 알맞는 괄호를 체크하는 건 많이 해본 유형이라서
    // 빠르게 해결할 수 있었는데
    // 큐로 해결하는 '프린터'라는 문제를 해결하는 과정에서 생각보다 시간이 많이 소모되었다.
    // 문제 해결보다는 큐나 스택을 어떤 상황에서 사용해야 하고 장단점이 뭘까 생각하고
    // 고민하는 시간이 많아서 오래걸렸다
    // 문제를 못 푼다는 느낌은 아닌데 12시가 되버려서 일단 기록을 남기고 내일 다시
    // 해결해보고자 한다.

    public static void main(String[] args) throws IOException {

        int[] priorities = {2,1,3,2};
        int location = 2;
        int answer = 0;

        Queue<int[]> que = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        int[] print = new int[2];
        for(int i=0;i<priorities.length;i++){
            print[0] = priorities[i];
            if(i==location){
                print[1] = 1;
            }
            else{
                print[1] = 0;
            }

            que.add(print);
            list.add(print);
        }

        while(true){
            int critical = list.get(0)[0];
            boolean flag = true;
            for(int i=0;i<que.size();i++){
                if(critical < list.get(i)[0]){
                    flag = false;
                    break;
                }
            }

            if(!flag){ // 중요도 더 높은게 있습니다
                que.poll();

            }
        }





        System.out.println(answer);



        /*
        String s = ")()(";

        boolean answer = true;

        int open = 0;
        int close = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }

            if(close > open){
                answer = false;
                break;
            }
        }

        if(close != open) answer= false;
        */

    }
}
