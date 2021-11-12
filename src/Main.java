import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers 등굣길
    // 동적계획법으로 위와 왼쪽을 더해가면서 채워나가는 식으로 풀이하였는데
    // 자꾸 조금씩 어긋났다.
    // 아마 어떤 특수한 경우가 있는 것 같은데 그걸 모두 다 커버하는
    // 전체식을 구하기 힘들었다ㅠㅠ (내가 넣어본 테케는 모두 맞는데)
    // 결국 해답을 찾아서 해결했다.. if 문으로 위와 왼쪽 값을 파악해 가면서 더해 나가는데
    // 나는 1열과 1행 모두를 1로 세팅해놓고 해서 문제가 발생한 듯 싶기도 하다.

    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        int[][] map = new int[n+1][m+1];

        for(int i=0;i< puddles.length;i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        map[1][1] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(map[i][j] == -1) continue;
                if(map[i - 1][j] > 0) map[i][j] += map[i - 1][j] % 1000000007;
                if(map[i][j - 1] > 0) map[i][j] += map[i][j - 1] % 1000000007;
            }
        }

        for(int i=1;i<map.length;i++){
            for(int j=1;j<map[0].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(map[n][m]);



    }
}