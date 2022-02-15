import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers level 2 - 스킬트리
    // 토요일에 programmers에서 코딩테스트를 볼 게 있어서 다시 programmers 문제를 해결한다
    // java가 아닌 c++로 해결한 문제가 있어서 java로 다시 풀어보려고 했다

    // skill_trees에 있는 원소들을 skill에 있는 문자들만 꺼내서 string으로 만든다
    // 그러면 skill_trees[i]에서 skill에 포함된 문자로만 만들어진 string을 만들었을 때
    // 순서가 일치하면 answer+1을 해준다
    // 순서가 일치하는지를 보는 과정에서 조금 시간이 걸렸다.
    // 나는 그 과정을 contains로 포함되는지 확인한 다음에 첫 문자의 시작 인덱스가 0인지를 확인했는데
    // 그 과정에서 런타임 에러가 발생했다.
    // 그래서 indexOf를 검색해봤는데 단순히 문자의 위치만을 확인하는 것이 아니라 indexOf는
    // string이 인자로 주어지면 첫 문자가 일치하는 지점을 리턴하기 때문에
    // indexOf(str) == 0으로 하면 첫번째 문자와 같은지를 비교할 수 있었다.

    public static void main(String[] args) throws IOException {

        String skill = "CBD";

        String[] skill_trees = {"BACDE","CBADF","AECB","BDA"};

        int answer =  0;

        for(int i=0;i< skill_trees.length;i++){

            StringBuffer sb = new StringBuffer();
            for(int j=0;j<skill_trees[i].length();j++){
                if(skill.contains(String.valueOf(skill_trees[i].charAt(j)))){
                    sb.append(skill_trees[i].charAt(j));
                }
            }

            System.out.println(sb.toString());

            if(skill.indexOf(sb.toString()) == 0){ // string 끼리 비교하면 처음만나는 지점을 의미
                answer++;
            }


        }

        System.out.println(answer);


    }
}