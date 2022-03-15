import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 영어 끝말잇기
    // 토요일에 시험봐야 하는 sk가 c++로 시험봐서 c++의 기억을 다시 살리기 위해
    // 조금 쉬운 문제를 골라서 c++ 개념이나 문법을 다시 살펴보았다.
    // c++ 의 string에서 at, front(), back(), set에서 insert,count를 사용했다.
    // java와 세부사항이 조금 달라서 알아보는 게 있어야 했다.
    // c++로 하고 나서 java로 다시 하니까 역시 하던 게 훨씬 편하다 ㅠㅠ
    // 작성도 훨씬 빠르고 코드도 훨씬 간단하게 나온다. 언어의 차이는 아니겠지만
    // 내가 익숙하다 보니 한번에 코드를 합치거나 함축적으로 표현해도 이해하기 때문이라고
    // 생각한다. 다만 c++로 코테를 봐야 하기 때문에 c++의 문법을 공부해야 한다...

    public static void main(String[] args) throws IOException {

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        set.add(words[0]);

        int where = 0;
        for(int i=1;i<words.length;i++){
            if(!set.add(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                where = i;
                break;
            }
            set.add(words[i]);
        }

//        System.out.println(where);

        if(where != 0){
            answer[0] = where / n + 1;
            answer[1] = where % n + 1;
        }
        else{
            answer[0] = 0;
            answer[1] = 0;
        }


    }
}

/* c++ 코드
#include <string>
#include <vector>
#include <iostream>
#include <set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;

    int i,j;

    set<string> s;
    s.insert(words[0]);

    int where = 0;
    for(i=1;i<words.size();i++){
        if(s.count(words[i]) == 0){ // 원소가 없으면
            s.insert(words[i]);
        }
        else{ // 원소가 이미 존재(겹친다)
            where = i;
            break;
        }

        if(words[i].front() != words[i-1].back()){
            where = i;
            break;
        }
        else{
            continue;
        }
    }

    if(where != 0) return {(where % n) + 1, (where / n) + 1};

    return {0,0};
}
 */