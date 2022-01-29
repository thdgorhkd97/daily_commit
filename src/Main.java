import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2839 설탕 배달
//    봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
//    상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다
//    상근이가 배달하는 봉지의 최소 개수를 출력한다.
//    만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

    // 처음에는 가장 적은 봉지를 활용해야 하기 때문에 5킬로그램 봉지를 기준으로 생각했다.
    // 5킬로그램을 N에서 빼가면서 최대한 N을 빠르게 줄이는 데 신경썼는데 그렇게 하다 보니
    // 3의 배수이거나 3으로 해결되는 경우에 대해서 부정확한 케이스가 있었다.
    // 그래서 이걸 어떻게 한번에 해결할까 하다가 반대로 생각해서 3을 빼가다가
    // 5의 배수가 나오면 이걸 처리하는 방식으로 하면 처음에 5의 배수인 것도 해결되고
    // 3을 빼다가 5의 배수가 나오는 경우도 해결되지 않을까 생각했다.

    // java 1011 - fly me to the alpha centauri
    // 문제를 해결하던 중이다.

   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       int[] answer = new int[N];

       for(int i=0;i<N;i++){
           String str = br.readLine();

           StringTokenizer stk = new StringTokenizer(str," ");

           int start = Integer.parseInt(stk.nextToken());
           int end = Integer.parseInt(stk.nextToken());

           System.out.println(minMove(start,end));
       }

       /*
       int answer = 0;

       while(true){
           if( N % 5 == 0){
               answer += N / 5;
               break;
           }
           else{
               N -= 3;
               answer++;
               if(N < 0){
                   answer = -1;
                   break;
               }
           }
       }

       System.out.println(answer);
        */


    }

    static int minMove(int start, int end){
       int move = 1;

       int maxMove = 1;

       end--;

       while(true){
           if(start + maxMove < end){
               start += maxMove;
               maxMove++;
               move++;
           }

           else if(start + maxMove > end){
               maxMove--;
           }

           if(start + maxMove == end){
               break;
           }
       }






       return move;
    }
}