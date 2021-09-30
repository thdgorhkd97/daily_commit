import javax.swing.text.View;
import java.util.*;

public class Main {

    // programmers level 2 - 점프와 순간 이동
    // 효율성 테스트를 위해서는 jump 함수를 안 하고 그냥 main에 넣으면 된다.(호출 시간때문)
    // 가독성을 위해서 함수로 빼두려 한다.
    // 올라가는 경우를 생각한다면 n을 넘어가는 경우, 뛰거나 점프하는 경우 등등
    // 수많은 경우가 존재하기 때문에 내려오는 경우를 생각하는 게 좋다.
    // 0의 위치에서 순간이동이 안되고 반드시 1로는 이동해야 했기때문에 answer = 1로 초기화하고
    // 1의 위치에서 생각하는 게 좋았다.
    // 배터리 사용량을 최소로 하기 위해서는 순간 이동을 많이 해야 했으므로 짝수일 때는 나누기 2를 해서 배터리를 사용하지 않고
    // 홀수일 때만 1을 빼서 다시 순간이동을 할 수 있게 한다.

    public static void main(String[] args) {

        int N = 5;
        int answer = 1; // 1만큼 이동하고 1의 위치에서 시작한다고 가정

        // N에서 0으로 반대로 내려온다고 생각해보면
        // N이 짝수면 N/2 위치까지 가면 순간 이동가능

        answer = jump(N);
        System.out.println(answer);
    }

    public static int jump(int n){
        int result = 1;
        int cnt = 0;
        while(n != 1){
            if(n % 2 == 0){
                n = n/2;
            }
            else{
                n=n-1;
                cnt++;
            }
        }

        result += cnt;

        return result;
    }


}