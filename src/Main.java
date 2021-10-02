import javax.swing.text.View;
import java.util.*;

public class Main {

    // programmers level 2 - 쿼드 압축 후 개수 세기
    // 분할 정복이라는 방법을 활용해야 했다.
    // 배열을 4로 나누고 각 구역을 나눠가면서 1칸만 남을때까지 계속한다.
    // 와중에 각 구역에 0이나 1로만 이뤄졌는지 확인한다.
    // 이때, 0이나 1로만 이루어진걸 어떻게 해야 하는지 몰랐는데 그냥
    // 정답배열에다가 1을 더하고 기본배열 자체에는 손을 대지 않는 방법이 있다.

    public static void main(String[] args) {

        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        int[] answer = new int[2];
        quad(arr.length, 0, 0, arr, answer);

        System.out.println(answer[0] + " " + answer[1]);
    }


        public static void quad ( int length, int y, int x, int[][] arr, int[] answer){
            if (length == 1) {
                if (arr[y][x] == 1) {
                    answer[1]++;
                } else {
                    answer[0]++;
                }

                return;
            }

            if (isZip(length, y, x, arr, answer)) return ;

            quad(length / 2, y, x, arr, answer);
            quad(length / 2, y + length / 2, x, arr, answer);
            quad(length / 2, y, x + length / 2, arr, answer);
            quad(length / 2, y + length / 2, x + length / 2, arr, answer);
        }

        public static boolean isZip ( int length, int y, int x, int[][] arr, int[] answer){
            int number = arr[y][x];

            for (int i = y; i < y+length; i++) {
                for (int j = x; j < x+length; j++) {
                    if (number != arr[i][j]) {
                        return false;
                    }
                }
            }

            if (arr[y][x] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
            return true;

        }
    }
