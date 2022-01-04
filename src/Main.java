import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon stack 단계 2문제
    // 스택을 구현하는 문제 2개를 해결했는데 문제가 어렵지않아서 스택의 개념에 대해서
    // 확실하게 정리한다.
    // stack 은 LIFO(Last In First Out) 후입선출 구조를 가진다.
    // 깊이 우선 탐색(DFS) & 재귀 함수 호출에 사용
    // stack의 여러가지 활용법
    // stack.push(원소) -> stack에 값 추가
    // stack.pop() -> stack의 값 제거(가장 최근에 들어간 값 제거)
    // stack.clear() -> stack 초기화(전체 값 제거)
    // stack.peek() -> stack의 가장 상단의 값 출력
    // stack.peek() 와 stack.pop()의 차이는 peek()는 stack에서 값 제거 X
    // stack.empty() -> stack이 비어있는지 check (비어있으면 true 반환)
    // stack.contains(원소) -> 원소를 포함하는지 확인(잇으면 true 반환)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String str = br.readLine();
            System.out.println(isVPS(str));
        }

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<K;i++){
            int number = Integer.parseInt(br.readLine());
            if(number != 0){
                stack.add(number);
            }
            else{
                stack.pop();
            }
        }


        int sum = 0;
        for(int i=0;i<stack.size();i++){
            int num = stack.peek();
            sum += num;
            stack.pop();
            i--;
        }

        System.out.println(sum);
        */



    }

    private static String isVPS(String str) {
        int open = 0;
        int close = 0;

        boolean flag = true;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }

            if(close > open){
                flag = false;
                break;
            }
        }

        if(!flag || open != close){
            return "NO";
        }

        return "YES";
    }
}