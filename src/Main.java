import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // JAVA - BOJ 거리
    // B O J가 반복되기 때문에 B -> O, O->J, J->B 해당 구문을 반복하면서
    // 이전 인덱스의 위치 차이를 제곱해서 더해나가면 될 줄 알았는데..
    // 풀리지 않았다..

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] ch = new char[N+1];

        String str = br.readLine();
        for(int i=0;i<=N-1;i++){
            ch[i+1] = str.charAt(i);
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        int pos = 0;
        int idx = 0;
        String[] next = {"B","O","J"};
        int min = 0;
        int lastB = 0;
        int lastO = 0;
        int lastJ = 0;

        while(pos < N){

            switch (next[idx]){
                case "B" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'O'){
                            lastO = i;
                            pos = i;
                            min += (i-lastB) * (i-lastB);
                            dp[i] = min;
                        }
                        else if(str.charAt(i) == 'J') break;
                    }
                    break;
                case "O" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'J'){
                            lastJ = i;
                            pos = i;

                            min += (i-lastO) * (i-lastO);
                            dp[i] = min;
                        }
                        else if(str.charAt(i) == 'B') break;
                    }
                    break;
                case "J" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'B'){
                            lastB = i;
                            pos = i;

                            min += (i-lastJ) * (i-lastJ);
                            dp[i] = min;
                        }
                        else if(str.charAt(i) == 'O') break;
                    }
                    break;
            }
            idx++;
            idx = idx % 3;

            System.out.println(pos);
        }

        System.out.println(dp[N]);
        /*
        int lastB = 0;
        int lastO = 0;
        int lastJ = 0;
        String[] next = {"B","O","J"};
        int idx = 0;
        int min = 0;
        int pos = 0;

        int a = 0;
        while(pos != N-1){

            boolean flag = true;
            switch (next[idx]){
                case "B" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'O'){
                            lastO = i;
                            pos = i;
                            flag = false;
                        }
                        if(str.charAt(i) =='J') break;
                    }
                    min += Math.pow(lastO-lastB,2);
                    break;

                case "O" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'J'){
                            lastJ = i;
                            pos = i;
                            flag = false;
                        }
                        if(str.charAt(i) =='B') break;
                    }

                    min += Math.pow(lastJ-lastO,2);
                    break;
                case "J" :
                    for(int i=pos;i<str.length();i++){
                        if(str.charAt(i) == 'B'){
                            lastB = i;
                            pos = i;
                            flag = false;
                        }
                        if(str.charAt(i) =='O') break;
                    }
                    min += Math.pow(lastB-lastJ,2);
                    break;
            }
            idx++;
            idx = idx % 3;

            System.out.println(pos);

        }

        System.out.println(min);*/







    }
}
