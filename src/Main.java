import javax.swing.text.View;
import java.util.*;

public class Main {

    // programmers level 2 - 삼각 달팽이
    // 아래 오른쪽 왼쪽위 이 규칙에 따라서 방향이 전환되고 그에 따라 n에서부터 숫자가 달라지는 걸 알고 나서 풀렸다
    // n = 4이면 아래 오른쪽 왼쪽위 아래 이렇게 4번 방향이 전환되고
    // 아래일 때 4 오른쪽일때 3 왼쪽위일때 2 아래 1 이렇게
    // n에서부터 1씩 감소하며 숫자를 쓰기 때문이다.
    // n X n 행렬에 규칙에 따라 채우고 채워진 걸 answer행렬로 옮긴다.

    public static void main(String[] args) {

        int n = 5;

        int max = 0;
        for(int i=n;i>0;i--){
            max += i;
        }

        int[] answer = new int[max];

        int[][] map = new int[n][n];

        int x = 0, y = -1;
        int num = 1;

        for(int i=0;i<n;i++){ // 방향전환이 n번 이루어짐
            for(int j=i;j<n;j++){ // 방향으로 n개의 숫자만큼 있다.
                // n = 4면 방향 전환 4번, 방향 전환때마다 4 3 2 1
                if(i % 3 == 0){ // 아래로 이동
                    y++;
                }
                else if(i % 3 == 1){ // 오른쪽 이동
                    x++;
                }
                else{ // 왼쪽 대각선
                    y--;
                    x--;
                }
                map[y][x] = num++;
            }
        }

        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] != 0){
                    answer[idx++] = map[i][j];
                }
            }
        }

        for(int i=0;i<max;i++){
            System.out.print(answer[i] + " ");
        }



    }

}