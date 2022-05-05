import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // ?로 표시된 부분에 a,b,c가 순서대로 들어가면서 연결된 a,b,c를 확인
    // ?에 중복을 허용하면서 a,b,c가 들어가야 하기 때문에 abc에 대한 조합을 구하고
    // 이를 순서대로 넣으면서 bfs로 개수를 파악한다.

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        String[] grid = {"cc?"};

        int letter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '?') {
                    letter++;
                }
            }
        }

        char[] ch = {'a', 'b', 'c'};

        char[] result = new char[letter];
        int depth = 0;

        combination(ch, result, depth, grid);

        System.out.println(answer);

    }

    private static void combination(char[] ch, char[] result, int depth, String[] grid) {
        if (depth == result.length) {

            if (allChain(result, grid)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < ch.length; i++) {

            result[depth] = ch[i];
            combination(ch, result, depth + 1, grid);
        }
    }

    private static boolean allChain(char[] result, String[] grid) {
        int idx = 0;
        char[][] copy = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '?') {
                    copy[i][j] = (result[idx++]);
                } else copy[i][j] = (grid[i].charAt(j));
            }
        }

        return true;
    }

}