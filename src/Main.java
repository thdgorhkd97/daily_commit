import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 배열 돌리기 3
    // 배열에 대한 여러 작업을 진행한다.
    // 1번 연산 -> 상하반전 -> 절반까지만 for문을 돌면서 직접 바꾸는 연산을 진행한다.
    // 2번 연산 -> 좌우반전 -> 좌우에 대해서 상하와 똑같은 작업을 한다
    // 3번 연산 -> 오른쪽으로 90도 회전
    // 4번 연산 -> 왼쪽으로 90도 회전
    // 회전 연산 -> 각 열이나 행에 대해서 저장해가면서 바꾸는 연산을 취하려 했는데
    // 그렇게 하면 상당히 복잡하고 내부에 대해서도 for문을 돌려야 하기 때문에
    // 다중 for문에다가 index에 대한 작업도 상당히 불편하게 진행해야 한다.
    // 그래서 알아보니 회전이라는 것은 일단 원래의 배열과 행렬이 바뀌어야 하고
    // i와 j에 대한 2중 for문에서 ( 원래배열크기 - 1 - i )를 적절히 활용하여
    // 연산식을 활용해 구현 가능하다.

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int operator = Integer.parseInt(br.readLine());

        for(int i=0;i<R;i++){
            switch (operator){
                case 1 : rotate_ReverseUpDown(arr);break;
                case 2 : rotate_ReverseLeftRight(arr); break;
                case 3 : rotate_90Right(arr); break;
                case 4 : rotate_90Left(arr); break;
            }
        }


    }

    private static void rotate_90Left(int[][] arr) {
        int[][] rotate = new int[arr[0].length][arr.length];

        for(int i=0;i<arr[0].length;++i){
            for(int j=0;j<arr.length;++j){
                rotate[i][j] = arr[j][rotate.length -1 -i];
            }
        }

        for(int i=0;i<rotate.length;i++){
            for(int j=0;j<rotate[0].length;j++){
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate_90Right(int[][] arr) {
        int[][] rotate = new int[arr[0].length][arr.length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                rotate[j][arr.length-1-i] = arr[i][j];
            }
        }

        for(int i=0;i<rotate.length;i++){
            for(int j=0;j<rotate[0].length;j++){
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate_ReverseLeftRight(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length/2;j++){
                int tmp = arr[i][j];
                arr[i][j] = arr[i][arr[0].length-1-j];
                arr[i][arr[0].length-1-j] = tmp;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate_ReverseUpDown(int[][] arr) {
        for(int i=0; i<arr.length/2;i++){
            for(int j=0;j<arr[0].length;j++){
                int tmp = arr[i][j];
                arr[i][j] = arr[arr.length-i-1][j];
                arr[arr.length-i-1][j] = tmp;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}