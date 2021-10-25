import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // programmers level 2 - 위클리 챌린지 12주차
    // 모든 경우를 모두 다 확인해야 해서 순열을 통해서 모든 경우의 수를 구하고
    // 모든 경우의 수에 대해서 확인하였다.
    // 풀이를 다 하고 나서 프로그래머스에서 제공하는 다른 사람의 풀이를 봤는데
    // dfs를 활용해서 되게 간단하게 해결한 것을 보았다.
    // dfs를 활용하지 못하는 게 아닌데 처음에 로직을 생각하기를 너무
    // 단순하게만 생각한 것 같아 아쉽다.

    static int[][] list;
    static int idx = 0;

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        int n = dungeons.length;
        int r = n;
        int answer = -1;

        int num = 1;
        for(int i=1;i<=n;i++){
            num = num * i;
        }
        list = new int[num][n];


        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        int depth = 0;

        perm(arr,depth,n,r);


        for(int i=0;i<list.length;i++){
            int cnt = 0;
            int k_copy = k;

            System.out.println(list[i][0] +  " " + list[i][1] + " " + list[i][2]);

            for(int j=0;j<dungeons.length;j++){
                if(k_copy >= dungeons[list[i][j]][0]){
                    k_copy = k_copy - dungeons[list[i][j]][1];
                    cnt++;
                }
                else{
                    break;
                }
            }
            System.out.println(cnt);
            answer = Math.max(cnt,answer);
        }

    }

    public static void perm(int[] arr, int depth, int n, int r){
        if(depth == r){
            for(int i=0;i<arr.length;i++){
                list[idx][i] = arr[i];
            }
            idx++;
        }

        for(int i=depth;i<n;i++){
            swap(arr,depth,i);
            perm(arr,depth+1,n,r);
            swap(arr,depth,i);
        }
    }
    public static void swap(int[] arr, int depth, int i){
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }
}