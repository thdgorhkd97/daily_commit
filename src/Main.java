import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon - 1932 정수 삼각형
    // 동적계획법의 가장 대표적인 문제라고 생각될만한 유형이고 프로그래머스에서 비슷한 문제를
    // 풀어본 경험이 있어서 문제자체는 어렵지 않았다.
    // 근데 백준이라는 사이트의 특성상 input을 직접 받아야 하기때문에 BufferedReader를 활용해야 하는데
    // stringtokenizer를 쓰는 과정이 아직 완벽하지 않아서 오히려 입력을 받는 부분을 힘들어했다;;
    // 다만 프로그래머스에서의 풀이와 달라진 부분은 프로그래머스는 위에서 아래로 내려오면서 계산했다면
    // 이번엔 아래에서 위로 올라가면서 처리했다.
    // 그러다 보니 맨 끝줄을 따로 처리해줘야하는 경우가 발생하지 않았고
    // 보다 빠르고 편하게 코드를 완료할 수 있었다.


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                arr[i][j] = Math.max(arr[i+1][j],arr[i+1][j+1])+arr[i][j];
            }
        }

        System.out.println(arr[0][0]);



    }
}