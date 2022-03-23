import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 14391 종이 조각

//    영선이는 숫자가 쓰여 있는 직사각형 종이를 가지고 있다. 종이는 1×1 크기의 정사각형 칸으로 나누어져 있고, 숫자는 각 칸에 하나씩 쓰여 있다. 행은 위에서부터 아래까지 번호가 매겨져 있고, 열은 왼쪽부터 오른쪽까지 번호가 매겨져 있다.
//
//    영선이는 직사각형을 겹치지 않는 조각으로 자르려고 한다. 각 조각은 크기가 세로나 가로 크기가 1인 직사각형 모양이다. 길이가 N인 조각은 N자리 수로 나타낼 수 있다. 가로 조각은 왼쪽부터 오른쪽까지 수를 이어 붙인 것이고, 세로 조각은 위에서부터 아래까지 수를 이어붙인 것이다.
//
//    아래 그림은 4×4 크기의 종이를 자른 한 가지 방법이다.
//    종이를 적절히 잘라서 조각의 합을 최대로 하는 프로그램을 작성하시오

    // 잘랐을 때 가장 큰 값을 찾아야 하기 때문에 자릿수가 가장 큰 게 가장 크다고 생각했다.
    // 그래서 가로로 쫙 잘라서 더하것과 세로로 쫙 잘라서 더한 것 중 max 값을 리턴했는데
    // 해당 케이스를 벗어나는 케이스가 있는 것 같다.
    // 근데 예외 케이스가 뭐가 될까 싶다... 도저히 못 찾겠어서 공부해야겠다..

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        int answer = 0;
        answer = Math.max(Seroro(map,N,M),Garoro(map,N,M));
        System.out.println(answer);

    }

    private static int Seroro(int[][] map,int N,int M){
        int sum = 0;
        for(int i=0;i<M;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<N;j++){
                sb.append(map[j][i]);
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }
    private static int Garoro(int[][] map,int N,int M){
        int sum = 0;
        for(int i=0;i<N;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<M;j++){
                sb.append(map[i][j]);
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }
}
