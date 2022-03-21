import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 프린터

    // 큐와 arryalist를 함께 사용하면서 중요도가 가장 높다면 출력 순서인 answer를 +1하고
    // 중요도가 더 높은 문서가 있으면 큐와 arraylist에서 맨 앞 원소를 제외하고
    // 맨 뒤에 다시 넣는다
    // 이때 int[] 배열을 넣어서 순서를 알고자 하는 원소에 대해서는 int[2]에서
    // 두 번째 원소가 1이면 알고자하는 순서이고 0이면 알고자하는 순서가 아니다.

    // java 소용돌이 1
    // n = 3이면
    // 1 2 3
    // 8 9 4
    // 7 6 5 이렇게 오른쪽으로 아래로 왼쪽으로 위로 반복하며 채워나가는 소용돌이

    // java 소용돌이 2
    // n = 3이면
    // 5 4 3
    // 6 1 2
    // 7 8 9 중앙에서 시작해서 오른쪽 위쪽 왼쪽 아래쪽 반복하여 채워나가는 소용돌이
    // 시작지점이 중앙부터기 때문에 어떻게 접근해야 할지 더 고민스러웠다.
    // 처음에는 중앙에서 네모칸으로 한칸씩 늘려가면서 채워지는 규칙을 보고 네모칸으로
    // 채워나가야 하나 고민했는데 그렇게 하려면 범위를 설정해야 한다는 게 부담스럽게 느껴졌다
    // 그래서 처음부터 채워나가던 소용돌이1 처럼 오히려 map[n-1][n-1] 부터 채워나가면서
    // 역소용돌이로 1까지 빼나가면서 채워나갔다.

    public static void main(String[] args) throws IOException {

        int n = 5;
        int num = 1;
        int max = n * n;
        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 0;
            }
        }
        int x = n-1;
        int y = n-1;
        while(num <= max){
            for(int i=y;i>=0;i--){
                if(map[x][i] != 0) break;
                map[x][i] = max--;
                y = i;
            }
            x--;
            for(int i=x;i>=0;i--){
                if(map[i][y] != 0) break;
                map[i][y] = max--;
                x = i;
            }
            y++;
            for(int i=y;i<n;i++){
                if(map[x][i] != 0) break;
                map[x][i] = max--;
                y = i;
            }
            x++;
            for(int i=x;i<n;i++){
                if(map[i][y] != 0) break;
                map[i][y] = max--;
                x = i;
            }
            y--;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j] +  " ");
            }
            System.out.println();
        }
        /* 소용돌이 1
        int n = 5;

        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
            map[i][j] = 0;    }
        }

        int num = 1;
        int max = n * n;

        int x = 0;
        int y = 0;

        while(num <= max){
            for(int i=y;i<n;i++){
                if(map[x][i] != 0) break;
                map[x][i] = num++;
                y = i;
            }

            x++;

            for(int i=x;i<n;i++){
                if(map[i][y] != 0) break;
                map[i][y] = num++;
                x = i ;
            }

            y--;

            for(int i=y;i>=0;i--){
                if(map[x][i] != 0) break;
                map[x][i] = num++;
                y=i;
            }

            x--;

            for(int i=x;i>=0;i--){
                if(map[i][y] != 0) break;
                map[i][y] = num++;
                x=i;
            }
            y++;

        }



        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
         */ // 소용돌이 1

        /*
        int[] priorities = {2,1,3,2};
        int location = 2;
        int answer = 0;

        Queue<int[]> que = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0;i<priorities.length;i++){

            int[] print = new int[2];
            print[0] = priorities[i];
            if(i==location){
                print[1] = 1;
            }
            else{
                print[1] = 0;
            }

            que.add(print);
            list.add(print);
        }

        while(true) {
            int critical = list.get(0)[0];
            boolean flag = true;
            int[] print = new int[2];

            for (int i = 0; i < list.size(); i++) {
                if (critical < list.get(i)[0]) {
                    flag = false;
                    break;
                }
            }

            if (!flag) { // 중요도 더 높은게 있습니다
                print = que.poll();
                list.remove(0);

                que.add(print);
                list.add(print);
            } else {
                print = que.poll();
                list.remove(0);
                answer++;
                if (1 == print[1]) {
                    break;
                }
            }

        }

        System.out.println(answer);
         */

    }
    private static boolean Allfill(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                if(map[i][j] != 0){
                    return false;
                }
            }
        }

        return true;
    }
}
