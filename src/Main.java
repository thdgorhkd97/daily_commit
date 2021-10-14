import java.util.*;

public class Main {

    // programmers level 2 - n^2 배열 자르기
    // int 배열이 고정인데 long의 범위만큼 인덱스를 잘라서 해야한다...
    // 그래서 Long.valueOf(i).intValue();를 활용했는데
    // 메모리 초과를 피할 수 없다..


    public static void main(String[] args) {

        int n = 3;
        long left = 2;
        long right = 5;

        long[][] map = new long[n][n];
        int num=1;
        map[0][0] = num;

        while(num <= n){
            for(int i=0;i<num;i++){
                for(int j=0;j<num;j++){
                    if(map[i][j] == 0)map[i][j] = num;
                }
            }
            num++;
        }

        long[] arr = new long[n*n];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[idx++] = map[i][j];
            }
        }

        int[] answer = new int[Long.valueOf(right-left+1).intValue()];

        idx = 0;
        for(long i=left;i<=right;i++){
            int i1 = Long.valueOf(i).intValue();
            answer[idx++] = (int) arr[i1];
        }


    }
}