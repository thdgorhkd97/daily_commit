import java.io.IOException;
import java.util.*;

public class Main {

    // programmers level 2 - 괄호 변환
    // 따로 어떤 자료구조나 알고리즘 개념이 쓰인 문제는 아니지만 문제에서 주어지는
    // 조건을 그대로 구현해야 하는 문제였다.
    // 처음에는 그저 main 함수에 코드를 구현하다 문제 조건에서 처음부터 구현해야 하는 경우가 있기에
    // 따로 함수로 구현하여 표현하였다.
    // replaceAll에서 '(' 라는 문자와 ')' 라는 문자 자체를 표현하는 방법에 대해 고민했는데
    // \\를 앞에 붙혀서 괄호의 문자 자체를 표현하는 방법에 대해 숙지 하였다.
    // 단순히 문제를 따라가면서 조건에 맞춰 코드를 구현하는 것 뿐 아니라
    // 조건을 일치하는 환경 내에서 일정 부분 코드를 리팩토링하여 사용하는 게 더 효율적이라는 걸
    // 다시 한 번 느꼈다. 조건을 파괴하지 않는 선에서 내가 조건을 수정할 수 있어야 한다.


    public static void main(String[] args) throws IOException {

        String p = "(()())()";

        String answer = "";

        answer = change(p); // 문제에서 다시 변환해야 하는 조건이 있기에 함수로 따로 표현

//        return answer;
    }

    static String change(String p){
        if(p.equals("")) return ""; // 입력이 빈 문자열이면 빈 문자열을 반환 (조건 1)

        int open = 0; // ( 의 개수
        int close = 0; // ) 의 개수

        int idx = 0; // '(' 의 개수와 ')' 의 개수가 같은 곳의 idx를 저장
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }
            if(open == close) {
                idx = i;
                break;
            }
        }

        String u = p.substring(0,idx+1); // 균형잡힌 문자열로 더 이상 분리 불가능하게
        String v = p.substring(idx+1); // 빈 문자열이 가능

        if(isCorrect(u)){ // u가 올바른 괄호 문자열이면
            u += change(v); // v에 대해 처음부터 다시 수행 후 u에 이어 붙여 반환
        }
        else{
            String emp = "(" + change(v) + ")"; // '(' 에 v를 처음부터 수행한 결과에 ')' 더하기
            u = u.substring(1, u.length()-1);// u의 첫번째와 마지막 문자 제거하기
            u = u.replaceAll("\\(","\\/").replaceAll("\\)","\\(").replaceAll("\\/","\\)");
            // 나머지 문자열의 괄호 방향을 뒤집기
            emp += u; // 뒤에 이어 붙히기
            return emp;
        }
        return u;
    }

    static boolean isCorrect(String u){ // 올바른 괄호 문자열인지 확인
        while(!u.equals("")){ // 비어있지 않다면
            if(u.charAt(0)==')'){
                return false;
            }
            u = u.replaceAll("\\(\\)",""); //( 과 ) 를 빈칸으로 변환
        }
        return true;
    }
}
