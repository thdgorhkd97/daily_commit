import java.util.*;

public class Main {

    // L 사 코딩테스트 2번문제
    // String[] pixels 배열이 주어지면 3열씩 잘라서 만들어지는 글자를 리턴한다.
    // 111
    // 100
    // 111
    // 001
    // 111      -> 5
    // 0 1 2 3 4 5 6 7 8 9 중에서 맨 위부터 이루어지는 1과 0중에서 하나만 특정할 수 있는 경우가 존재한다.
    // ex) 맨 위줄이 110인 건 1만 존재한다. 즉 맨 위줄이 110이라면 아래는 상관없이 1이 되는 것이다.
    // 맨 위줄이 111인 건 4만 존재한다.
    // 이런 식으로 맨 윗줄부터 숫자를 특정할 수 있는 조건을 if-else로 나누어 가며 숫자를 특정할 수 있는 순간까지
    // 문자열을 확인해보았다.
    // 정확성은 잘 맞는데 아마도 if - else를 통한 노가다 성이 있어서 조금 마이너스가 있었을 수 있는 것 같다.
    // 근데 이게 string을 잘라서 하나의 문자를 만든 것처럼 만들어서 숫자를 판별해야 하는데 if-else가 아니라면
    // 어떻게 해결해야 할지 잘 모르겠다..

    public static void main(String[] args) {

        String[] pixels = {
                "111110111101111101111101",
                "100010101101001101100101",
                "111010111111111111111111",
                "001010101001100001001001",
                "111111111001111001111001"};

        String answer = "";

        StringBuffer sb = new StringBuffer();
        for(int i=0;i< pixels[0].length();i=i+3){

            String[] str = new String[pixels.length];
            for(int j=0;j< pixels.length;j++){
                str[j] = pixels[j].substring(i,i+3);
                System.out.println(str[j]);
            }

            System.out.println(whatnumber(str));

            System.out.println("----------------------");
            sb.append(whatnumber(str));
        }

        answer = sb.toString();
        System.out.println(answer);

    }

    static String whatnumber(String[] str){
        if(str[0].equals("110")) return "1";
        else if(str[0].equals("101")) return "4";
        else{
            if(str[2].equals("101")) return "0";
            else if(str[2].equals("001")) return "7";
            else{
                if(str[3].equals("100")) return "2";
                else { // 3 5 6 8 9를 분류
                    if(str[1].equals("001")) return "3";
                    else if(str[1].equals("100")){ // 5 6
                        if(str[3].equals("001"))return "5";
                        else return "6";
                    }
                    else{ // 8 9
                        if(str[3].equals("001"))return "9";
                        else return "8";
                    }
                }
            }
        }
    }

}
