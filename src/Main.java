package src; // daily 폴더를 source root로 인식시켰기 때문에


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // java baekjoon 15904 UCPC는 무엇의 약자일까?
    // 주어진 문자열에 대해서 UCPC로 축약이 가능하냐를 묻는 문제다
    // UCPC라는 대문자가 포함되있는지를 확인하기 위해서 처음에는 contains로 'U','C','P'를
    // 확인하려 했는데 C가 2번 포함되기 때문에 단순 포함여부가 아니라 순서를 알아야 했다
    // 그래서 char[] ucpc = {'U','C','P','C'}; 에서 index를 통해 UCPC를 순서대로
    // 충족하는 지 확인하기로 했다.

    // java baekjoon 1026 보물
    // A배열과 B배열이 주어질 때 S = A[0] × B[0] + ... + A[N-1] × B[N-1]가
    // 최소가 되기 위해서는 A배열의 최대값과 B배열의 최소값이 곱해져야 한다.
    // 그렇기 때문에 배열을 정렬한 후에 A[i]와 B[N-1-i]가 곱해져야 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* java baekjoon 15904 UCPC는 무엇의 약자일까?
        String str = br.readLine();

        char[] ch = str.trim().toCharArray();

        int idx = 0;
        boolean flag = true;
        char[] ucpc = {'U','C','P','C'};
        for(int i=0;i<str.length();i++){
            if(ch[i] == ucpc[idx]){
                idx++;
                if(idx == 4){
                    flag = false;
                    break;
                }
            }
        }

        if(!flag) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
         */

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int[] A = new int[N];
        int[] B = new int[N];

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            B[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i=0;i<N;i++){
            answer += A[i] * B[N-i-1];
        }
        System.out.println(answer);



    }
}