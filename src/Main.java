import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java programmers 순위 검색
    // 효율성에서 문제가 생기는데 해당 방법에 대해 고민을 많이 해도 당장은 잘 모르겠다..
    // query에 있는 string을 split하고 이를 info 배열과 비교하다 보니
    // 3중 for문으로 구현하게 되었고 이 과정에서 마지막 점수를 쉽게 뽑기 위해
    // split을 한 번더 활용한 것이 시간초과를 발생시킨 것 같다.
    // 근데 이 과정도 index랑 다중 for문 사이에서 string 을 다루는 게 많이
    // 복잡해서 정확성을 맞추는 것도 어려웠는데 효율성을 다시 따져 봐야 할 것 같다.

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

        for(int i=0;i< query.length;i++){
            String str = query[i].replace("and","");
            String[] condition = str.split(" ");
            int cnt = 0;

            for(int j=0;j<info.length;j++){
                boolean flag = true;
                for(int k=0;k<condition.length-1;k++){
                    if(!condition[k].equals("-") && !info[j].contains(condition[k])){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    String[] sub_info = info[j].split(" ");
                    if((Integer.parseInt(sub_info[4]) >= Integer.parseInt(condition[condition.length-1]))){
                        cnt++;
                    }
                }

            }
            answer[i] = cnt;

        }

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] + " ");
        }


    }

}

