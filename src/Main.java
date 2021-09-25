import java.util.ArrayList;

public class Main {

    // programmers level 2 - 삼각 달팽이
    // 아래 -> 오른쪽 -> 왼쪽 대각선 이 방향으로 계속 하여
    // 1부터 증가하면서 수를 쓰는 건데
    // 이동하는 기준에 해당할 때를 판별하는 게 상당히 번거롭다.
    // while 문 속에서 기준을 판별해야 하기 때문에 해당 조건을 만족할 때 방향 전환
    // 이런식으로 정리해야 할 것 같다.
    // 한화시스템 코딩테스트를 봤는 데 bfs를 코딩에 적용하여 문제를 해결하는 것에 대해서 다시 해야 할 것 같다.
    // bfs를 활용하는 방법부터 확실히 잡아야겠다.


    public static void main(String[] args) {
        int n = 4;

        int[][] arr = new int[n][n];

        int max = 0;

        for(int i=1;i<=n;i++) {
            max += i;
        }

        int[] answer = new int[max];


        for (int i = 0; i < n; i++) { // 모두 -1로 세팅
            for (int j = 0; j <= i; j++) {
                arr[i][j] = -1;
            }
        }

        int i = 0, j = 0, k = 1;

        arr[i][j] = k;

        /*

        while (k < max) {
            while (i + 1 < n && k < max && arr[i + 1][j] < 0) {
                arr[++i][j] = ++k;
            }

            while (j + 1 < n && k < max && arr[i][j + 1] < 0) {
                arr[i][++j] = ++k;
            }

         */

    }




}
