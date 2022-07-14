package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 14 )
문제 : java programmers level 2 - 수식 최대화
문제접근 :
 */

class Main {

    public static long answer = Long.MIN_VALUE;

    public static ArrayList<Long> numList = new ArrayList<>(); // 숫자 담을 리스트
    public static ArrayList<String> operList = new ArrayList<>(); // 연산자 담을 리스트

    public static String[] oper = {"+", "-", "*"};
    public static String[] output = new String[3]; // 순열 결과 담을 배열
    public static boolean[] visited = new boolean[3];

    public static void main(String[] args) throws IOException {

        String expression = "100-200*300-500+20";

        String n = "";
        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp == '+' || exp == '-' || exp == '*') {
                operList.add(exp + ""); // char -> string으로 변환해서 저장
                numList.add(Long.parseLong(n)); // String -> long으로 변환해서 저장
                n = ""; // n 문자열 초기화
            } else { // 숫자면
                n += exp; // n에 추가하면서 계속 진행
            }
        }
        // 마지막 숫자 삽입
        numList.add(Long.parseLong(n));

        //순열 만들기
        per(0, oper.length);

        System.out.println(answer);
    }

    //순열 찾기
    static void per ( int depth, int r){
        if (depth == r) { // 연산자에 대해 순열이 완성되면
            solve(); // 연산

            return;
        }

        for (int i = 0; i < oper.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = oper[i];
                per(depth + 1, r);
                visited[i] = false;
            }
        }
    }

    // 연산
    static void solve () {
        // 연산자 우선 순위에 따른 값을 얻기 위해 List 복사 (그냥 쓰면 하나의 수열 경우에 대해서만 계산 가능하니까 복사해서 사용)
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(operList);

        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(numList);

        for (int i = 0; i < output.length; i++) {
            String curOper = output[i]; // 현재 우선순위 연산자

            for (int j = 0; j < oper.size(); j++) {

                if (oper.get(j).equals(curOper)) { // 현재 우선순위에 맞는 연산자일 경우
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long res = cal(n1, n2, curOper);
                    // 숫자1 연산자1 숫자2 연산자2 숫자3 -> 100 + 23 * 12 ( 이런 식으로 주어지니까 )
                    // 연산자1을 가지고 계산하려면 숫자1과 숫자2에 연산자1을 해야한다. (예시의 경우 +에 대한 계산은 첫번째 연산자이므로 첫번째 숫자100과 두번째 숫자 23을 더한다)


                    num.remove(j + 1); // 숫자 삭제
                    num.remove(j); // 2개의 숫자가 연산되어 하나의 숫자가 되므로 원래 2개의 숫자는 제거
                    oper.remove(j); // 연산자 삭제

                    num.add(j, res); // 연산 결과 넣기 (j번째에 res 넣기)

                    j--; // 삭제했으니 인덱스 하나 줄여주기
                }
            }
        }

        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    // 수식 계산
    static long cal ( long n1, long n2, String o){
        long res = 0;
        switch (o) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
        }

        return res;
    }

}
