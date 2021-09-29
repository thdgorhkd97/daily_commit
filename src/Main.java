import javax.swing.text.View;
import java.util.*;

public class Main {

    // 무한히 많은 회의실에서 회의한 시간이 주어질 때, 가장 많은 회의실이 사용된 시간을 모두 구하라
    // 무한히 많은 회의실이라는 문제 조건이 있었는 데 회의실에서의 회의 시간인 info[][] 가 행이 10000이하라는
    // 문제 조건이 있어서 회의실을 10001개라고 잡고 풀었는데 이게 문제 조건을 활용한 건지, 무시한 건지 애매하다.
    // 문제 자체는 그리 어렵지 않았는데 무한한 회의실을 문제의 조건때문에 10000개로 한정했다는 점과
    // 회의시간만큼 모두 더했다는 점에서 조금 석연찮은 부분이 있다.


    public static void main(String[] args) {

        int[][] info = {{3,5},{1,8},{5,14}};

        int[] meeting = new int[10001];

        for(int i=0;i<info.length;i++){
            for(int j=info[i][0];j<=info[i][1];j++){
                meeting[j] += 1;
            }
        }

        int max = 0;
        meeting[0] = max;

        for(int i=1;i<10001;i++){
            if(max < meeting[i]){
                max = meeting[i];
            }
        }

        ArrayList<Integer> max_meeting = new ArrayList<>();
        for(int i=0;i<meeting.length;i++){
            if(meeting[i] == max){
                max_meeting.add(i);
            }
        }

        int[] answer = new int[max_meeting.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = max_meeting.get(i);
        }

    }
}