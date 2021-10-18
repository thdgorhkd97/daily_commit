import java.util.*;

public class Main {

    // programmers 복서 정렬하기
    // 정렬하는 것에서 좀 시간이 걸린 문제다.

//        Arrays.sort(rank, (a, b) -> {
//        if(a[1] != b[1]) return b[1] - a[1];
//        if(a[2] != b[2]) return b[2] - a[2];
//        if(a[3] != b[3]) return b[3] - a[3];
//        return a[0] - b[0];
//    });

    // 해당 방식으로 rank의 인덱스를 활용하여 정렬을 깔끔하게 할 수 있다.
    // 그리고 rank[i][1] = (int)((double)win / cnt * 10000000);
    // 하나만 double 형이라서 어떻게 해야하는지도 좀 고생했는데
    // 이런 식으로 처리하여 int형으로 자료값을 넣는 것도 가능하다(double 변수를 int로 넣을 때)
    // double 형으로 저장하면 비교할 때 또 처리해야 하니까 이런 식으로 하면 한번에 정렬이 가능

    public static void main(String[] args) {

        int[] weights = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        int[][] rank = new int[weights.length][4];

        for(int i = 0; i < weights.length; i++) {
            int w = weights[i];
            int cnt = 0;
            int win = 0;
            int over = 0;

            for(int j = 0; j < weights.length; j++) {
                char c = head2head[i].charAt(j);

                if(c != 'N') {
                    cnt++;
                }
                if(c == 'W'){
                    win++;
                    if(weights[i] < weights[j]){
                        over++;
                    }
                }
            }

            rank[i][0] = i + 1;
            rank[i][1] = (int)((double)win / cnt * 10000000);
            rank[i][2] = over;
            rank[i][3] = weights[i];

        }
        Arrays.sort(rank, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            if(a[2] != b[2]) return b[2] - a[2];
            if(a[3] != b[3]) return b[3] - a[3];
            return a[0] - b[0];
        });

        int[] answer = new int[weights.length];

        for(int i = 0; i < weights.length; i++) {
            answer[i] = (int)rank[i][0];
        }



    }
}