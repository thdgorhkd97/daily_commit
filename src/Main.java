import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 4949 균형잡힌 세상
    // 아래 주석처리된 부분은 내가 처음에 단순히 ( [ 와 ) ] 의 개수를 세서
    // 일치하는지만 체크했던 문제 부분이다. 그 부분이 왜 문제가 되냐면 문제의 조건 중에서
    // "짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다."
    // 이 부분때문에 문제가 된다.
    // 전체적인 괄호의 개수가 균형잡혀 있더라도 일부분에서 균형이 무너지면 안 되기 때문이다.
    // 그래서 하나하나씩 꺼내보면서 확인해야 하는 스택을 활용하기로 했다
    // 열린 괄호라면 스택에 그대로 추가하고 닫힌 괄호라면 경우를 조금 나눈다.
    // 닫힌 괄호인데 만약 스택이 비어있거나(열린 괄호가 없는데 닫힌 괄호가 나온 경우)
    // stack의 pop이 짝에 맞는 괄호가 아니라면 ( ( - ) [ - ] ) no를 반환해야 한다.
    // stack이 비어있지도 않고 짝에 맞는 괄호가 stack의 맨 위에 있다면
    // 균형이 맞기 때문에 stack에서 빼내고 그 stack의 다음 문자가 맨 위에 있게 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String str = br.readLine();

            check(str);
        }

    }

    static void check(String str){

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='(' || ch=='['){
                stack.push(ch);
            }

            else if(ch == ')'){
                if(stack.empty() || stack.peek()!='('){
                    System.out.println("no");
                    return ;
                }
                else{
                    stack.pop();
                }
            }

            else if(ch == ']'){
                if(stack.empty() || stack.peek()!='['){
                    System.out.println("no");
                    return ;
                }
                else{
                    stack.pop();
                }
            }
        }

        if(stack.empty()){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }


//        int leftSmall = 0; // (
//        int rightSmall = 0; // )
//        int leftBig = 0; // [
//        int rightBig = 0; // ]
//
//        System.out.println(str);
//
//        for(int i=0;i<str.length();i++) {
//            char ch = str.charAt(i);
//
//            switch (ch){
//                case '(' : leftSmall++; break;
//                case ')' : rightSmall++; break;
//                case '[' : leftBig++; break;
//                case ']' : rightBig++; break;
//            }
//
//            if(leftSmall < rightSmall || leftBig < rightBig){
//                System.out.println("no");
//                return ;
//            }
//        }
//
//        if(leftBig == rightBig && leftSmall == rightSmall){
//            System.out.println("yes");
//        }
//        else System.out.println("no");


    }

}