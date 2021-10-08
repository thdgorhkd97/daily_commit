import javax.swing.text.View;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {

    // programmers - 복서 정렬하기
    // 승률이나 무거운 상대와 이긴 횟수 등 정렬에 필요한 기준을 구하는 건 했는데
    // 처음에는 이를 비교하기 위해 if-else문을 사용하려다가
    // 너무 코드가 복잡해져서 comparator 문을 공부해서 정렬하였다.
    // o2 - o1 은 내림차순 o1 - o2 는 올림차순

    public static void main(String[] args) {

        int[] weights = {50,82,75,120};

        int[][] boxer = new int[weights.length][4];

        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        int[] VS_heavy = new int[head2head.length];

        for(int i=0;i< weights.length;i++){
            int cnt_win = 0;
            int cnt_winVS_heavy = 0;
            for(int j=0;j< head2head[i].length();j++){
                if(head2head[i].charAt(j) == 'W'){
                    cnt_win++;
                    if(weights[i] < weights[j]){
                        cnt_winVS_heavy++;
                    }
                }
            }
            VS_heavy[i] = cnt_winVS_heavy;

            boxer[i][0] = i+1;
            boxer[i][1] = weights[i];
            boxer[i][2] = (int) ((1.0 * cnt_win/head2head[i].length()) * 100);
            boxer[i][3] = VS_heavy[i];


        }

        int[] answer = new int[weights.length];

        Arrays.sort(boxer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2]) return o2[2] - o1[2];
                if(o1[3] != o2[3]) return o2[3] - o1[3];
                if(o1[1] != o2[1]) return o2[1] - o1[1];


                return o1[0] - o2[0];

            }
        });


        for(int i=0;i< answer.length;i++){
            //System.out.println(boxer[i][0] + " " + boxer[i][1] + " " + boxer[i][2] + " " + boxer[i][3]);
            answer[i] = boxer[i][0];
            System.out.println(answer[i]);
        }






    }
}