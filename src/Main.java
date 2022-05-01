import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 2529 부등호
    // 순열로 하면 해결은 되는데 시간이 초과된다 ㅠㅠ
    // 순열로 해서 모든 경우의 수를 확인하는 백트래킹은 잘 하는것 같은데
    // 시간을 고려하면 dfs로 재귀를 활용해야 하는데 dfs로 재귀를 하는게 아직 잘
    // 못하는 것 같다 ㅠㅠㅠ 해당 개념이 잘 이해가 되질 않는데
    // 해당 파트를 뛰어넘는 이해가 있어야 할 것 같다 ㅠㅠ

    // dfs로 재귀하는 건 꼭 봐야하는 것 같다 ...

    private static int k; // 부등호 문자의 개수(2 ≤ k ≤ 9)
    private static boolean[] isVisited = new boolean[10]; // 0~9 숫자방문여부 (중복숫자불가하므로)
    private static char[] signs;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        dfs("", 0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1)); //최댓값
        System.out.println(result.get(0)); //최솟값


    }
    private static void dfs(String num, int depth) { //처음 nums를 int[]로 접근했는데 String으로 하는게 간단해진다.
        if (depth == k + 1) {
            result.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !isVisited[i] && compare(num.charAt(num.length() - 1) - '0', i, signs[depth - 1])) { //처음건 비교할게없으므로 통과 || 방문안한숫자 && 비교
                isVisited[i] = true;
                dfs(num + i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean compare(int a, int b, char c) {
        if (c == '<') return a < b;
        else return a > b;
    }

}
