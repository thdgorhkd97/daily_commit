import javax.swing.text.View;
import java.math.BigInteger;
import java.util.*;

public class Main {

    // programmers 월간 코드 챌린지 2
    // long 의 범위를 int 형 배열에 넣으려다 메모리 초과가 나는데
    // int 형 배열이 고정이다 보니 이를 어떻게 해결해야 할 지 모르겠다
    // long - long 의 크기 만큼 int 형 배열에 집어 넣어야 하는데
    // 그래서 BigInteger를 고려했지만 이 역시 int형으로 고정된 answer 배열에
    // 들어가지 않는다..


    public static void main(String[] args) {

        int n = 3;
        long left = 2;
        long right = 5;

        int[][] map = new int[n][n];

        map[0][0] = 1;

        int idx=2;
        while(idx != n+1){
            for(int i=0;i<idx;i++){
                for(int j=0;j<idx;j++){
                    if(map[i][j] == 0){
                        map[i][j] = idx;
                    }
                }
            }

            idx++;
        }

        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Long> arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr.add((long)map[i][j]);
            }
        }
        BigInteger[] answer = new BigInteger[(int) (right - left + 1)];

        idx = 0;
        for(long i=left;i<=right;i++){
            arr2.add(arr.get((int) i));
        }

        for(int i=0;i<arr2.size();i++){
            answer[idx++] = BigInteger.valueOf((arr2.get(i)));
        }

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] + " ");
        }


    }
}