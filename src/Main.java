import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers 피로도
    // https://programmers.co.kr/learn/courses/30/lessons/87946
    // 처음에는 필요피로도나 소모피로도를 기준을 정렬해서 for문을 돌며 몇 개의 던전을
    // 돌 수 있는지를 체크하려고 했으나 한번의 정렬을 기준으로 문제를 해결할 수 있는
    // 기준을 모르겠다 ㅠㅠㅠ
    // 그래서 던전의 길이가 8밖에 되지않기 때문에 조합을 통해서 아예 가능한 던전 방문의
    // 모든 경우의 수를 구하고 해당 던전 방문 순서를 지키면서 몇 개의 던전을 갈 수 있는지
    // 체크하는 식으로 문제를 해결해보았다.
    // 근데 문제가 던전의 길이가 짧기 때문에 가능했던 것이지 다른 방법을 찾아야 할 것으로 보인다...
    static int[][] list;
    static int idx = 0;

    public static void main(String[] args) throws IOException {

        int k = 80;

        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        int answer = 0;

        int n = dungeons.length;

        int[] arr = new int[n];

        int factorial = 1;
        for(int i=1;i<=n;i++){
            factorial *= i;
        }
        list = new int[factorial][n];

        for(int i=0;i<n;i++) arr[i] = i;

        int depth = 0;

        permu(arr,depth,n,n);

        for(int i=0;i<factorial;i++){
            int result = 0;
            int pirodo = k;
            for(int j=0;j<n;j++){
                if(pirodo >= dungeons[list[i][j]][0]){
                    pirodo -= dungeons[list[i][j]][1];
                    result++;
                }

                else break;
            }

            answer = Math.max(answer, result);
        }
    }

    public static void permu(int[] arr,int depth,int n, int r){
        if(depth == r){
            for(int i=0;i<arr.length;i++){
                list[idx][i] = arr[i];
            }
            idx++;
        }

        for(int i=depth;i<n;i++){
            swap(arr,depth,i);
            permu(arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }

    public static void swap(int[] arr, int depth,int i){
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }

}

        /*
        Arrays.sort(dungeons,((o1, o2) -> o2[0] - o1[0]));

        int idx = 0;
        while(idx < dungeons.length && k >= dungeons[idx][0] ){
            k -= dungeons[idx][1];
            idx++;

            for(int i=idx;i< dungeons.length-1;i++){
                if(dungeons[i][1] > dungeons[i+1][1]){
                    int[] arr = new int[2];
                    arr[0] = dungeons[i][0];
                    dungeons[i][0] = dungeons[i+1][0];
                    dungeons[i+1][0] = arr[0];

                    arr[1] = dungeons[i][1];
                    dungeons[i][1] = dungeons[i+1][1];
                    dungeons[i+1][1] = arr[1];
                }
            }

            answer++;
        }
         */

        /*
        Arrays.sort(dungeons, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });


        int idx = 0;
        while(k >= 0 && idx < dungeons.length){
            System.out.println("k = " + k + " " + dungeons[idx][0]);
            if(k >= dungeons[idx][0]){
                k -= dungeons[idx][1];
                answer++;
            }
            idx++;

        }*/

