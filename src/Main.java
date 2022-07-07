package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 07 - 07 )
문제 : java algorithm study ( programmers level 2 - 수식 최대화 + 모음사전 )
문제접근 : 모음사전 문제는 쉽게 해결했는데 수식 최대화 문제가 40분을 넘게 했는데도 접근조차 못한것같다...
        접근 방법, 문제 구현 등 확실히 고쳐야 하는 방법이라 생각한다. 처음부터 다시 해봐야 할 것이다
 */

class algorithm {

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        String expressions = "100-200*300-500+20";


        char[][] operator = {
                {'*','+','-'},{'*','-','+'},
                {'-','+','*'},{'-','*','+'},
                {'+','*','-'},{'+','-','*'}};

        for(int i=0;i< operator.length;i++){
            String expression = expressions;
            for(int j=0;j< operator[i].length; j++){

                char ch = operator[i][j];

                for(int k=0;k<expression.length();k++){
                    if(expression.charAt(k) == ch){
                        int endPoint = 0;
                        int startPoint = 0;
                        for(int a = k+1; a<expression.length();a++){
                            if(expression.charAt(a) == '-' || expression.charAt(a) == '*' ||expression.charAt(a) == '+'){
                                endPoint = a;
                                break;
                            }
                            else if(a==expression.length()-1){
                                endPoint = a+1;
                                break;
                            }
                        }
                        for(int b = k-1; b>= 0; b--){
                            if(expression.charAt(b) == '-' || expression.charAt(b) == '*' ||expression.charAt(b) == '+'){
                                startPoint = b;
                                break;
                            }
                            else if( b == 0){
                                startPoint = -1;
                                break;
                            }
                        }

                        int num = calculate(expression.substring(startPoint+1,endPoint));

                    }
                }

            }
        }


        /*
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(i+1);
            }
        }
        list.add(expression.length()-1);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for(int i=0;i< operator.length; i++){
            for(int j=0;j< operator[i].length; j++){

                for(int k=1;k<list.size();k++){
                    if(expression.charAt(list.get(k) -1) == operator[i][j]){
                        System.out.println(operator[i][j]);
                        calculate(expression.substring(list.get(k-1),list.get(k+1)-1));
                    }
                }
                System.out.println();
            }
        }


         */
    }
    private static int calculate(String str){
        char oper = 'a';

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '+'){
                oper = str.charAt(i);
                break;
            }
        }

        String[] number = str.split("[-+*]");

        int num1 = Integer.parseInt(number[0]);
        int num2 = Integer.parseInt(number[1]);
        int result = 0;
        switch (oper){
            case '-' : result = num1 - num2; break;
            case '+' : result = num1 + num2; break;
            case '*' : result = num1 * num2; break;
        }

        return result;

    }
}

/* 모음사전문제
String word = "AAAE";

        int answer = word.length();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('E',1);
        map.put('I',2);
        map.put('O',3);
        map.put('U',4);
        int[] nextMoum = {781,156,31,6,1};

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(ch != 'A'){
                answer += nextMoum[i] * (map.get(ch));
            }
        }

        System.out.println(answer);
 */
