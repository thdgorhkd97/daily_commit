import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // programmers 커뮤러닝 1일차
    // 그리디 알고리즘
    // 전체 구역을 true로 바뀌면 완료했다고 생각하는 로직을 구현했는데
    // 이런 식으로 하는 게 아니라 index를 이용해서 전체를 index가 넘어가면
    // 완료하는 식으로 짜야 코드가 간략해지는 것으로 보인다.

    public static void main(String[] args) {

        int n = 16;
        int[] stations = {9};
        int w = 2;

        boolean[] check = new boolean[n+1];

        int answer = 0;
        for(int i=0; i<stations.length;i++){
            for(int j=stations[i]-w; j<=stations[i]+w; j++){
                check[j] = true;
            }
        }

        while(!all_cover(check)){

            for(int i=1;i<=n;i++){
                if(!check[i]){
                    for(int j=i;j<=i+2*w;j++){
                        check[j] = true;
                    }
                    answer += 1;
                }
            }

        }

        System.out.println(answer);

    }
    public static boolean all_cover(boolean[] check){
        int flag = 0;
        for(int i=1;i< check.length;i++){
            if(!check[i]){
                flag = 1;
                break;
            }
        }

        if(flag == 0) return true;
        else return false;
    }
}