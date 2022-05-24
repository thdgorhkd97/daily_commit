package src; // daily 폴더를 source root로 인식시켰기 때문에

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java baekjoon 14468 소가 길을 건너간 이유 2
    // 처음에는 연속된 2개의 같은 문자를 계속 지워나가면서 엇갈린 문자만 놔두고 string을
    // 바꿔나가면서 최종적으로 엇갈린 문자들만 남아있는 문자열이 남아있다면 해당 문자열의 길이를 4로 나눠서
    // 쌍을 리턴하려고 생각했다.
    // 근데 해당 로직이 틀린 걸 보니 삭제해나가다 보면 홀수로 남아있는 경우가 있는 게 아닐까 싶다..
    // 그래서 로직을 바꿔서 해당하는 문자의 첫 등장과 두번째 등장을 first[]와 second[]에 넣어서
    // if(first[i] < first[j] && second[i] > first[j] && second[i] < second[j])
    // 이 조건을 만족하면 엇갈린 것이기 때문에 answer+1 을 해간다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ

        /*
        boolean flag = true;

        while(flag){
            boolean[] check = new boolean[str.length()];
            flag = false;
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i) == str.charAt(i+1)){
                    check[i] = true;
                    check[i+1] = true;
                    flag = true;
                }
            }

            StringBuffer sb = new StringBuffer();
            for(int i=0;i<str.length();i++){
                if(!check[i]) sb.append(str.charAt(i));
            }

            str = sb.toString();
            System.out.println(str);
        }

        System.out.println(str.length()/4);
         */


        int[] first = new int[26];
        int[] second = new int[26];

        int idx = 0;

        Character[] alphabet = {'A','B','C','D','E','F','G','H','I','J',
        'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<alphabet.length;i++){
            char ch = alphabet[i];

            boolean flag = true;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == ch && flag){
                    first[idx] = j;
                    flag = false;
                }
                else if(str.charAt(j) == ch && !flag){
                    second[idx] = j;
                    idx += 1;
                    break;
                }

            }

        }

        int answer = 0;

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(first[i] < first[j] && second[i] > first[j] && second[i] < second[j]) {
//                    System.out.println(alphabet[i] + " " + alphabet[j] + " 가 만나네");
                    answer++;
                }
            }
        }
        System.out.println(answer);


    }

}