import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 최고의 집합
    // 오늘도 처음에는 불량 사용자 문제를 어제에 이어서 해결하고자 하였는데
    // 문제 해결방식중에 4중 for문이 나와서 결국 해답을 확인하였다..ㅠㅠ 그래서 기억에 모드가 남아있어서
    // 나중에 다시 해결해야 할 것으로 보인다.
    // 최고의 집합이라는 문제는 n개의 자연수로 합이 s인 순서쌍 중에서 곱이 최대인 순서쌍을 구하는 문제이다.
    // 처음에는 합이 s인 n개의 자연수 모음을 모두 만들어서 하려 했는데 그렇게 하면 반드시 시간 초과가 날 게 분명하기 때문에
    // 어떻게 해야 할까 생각해보다가 산술평균에서 영감을 얻어서 같을 때 곱이 최대가 되므로 가장 차이가 나지 않는
    // 자연수 모음을 찾으려 하였다.
    // 그런데 그 경우에는 s가 n으로 나누어 떨어져서 같은 숫자로 구성되는 경우에만 해당하므로 다른 경우에는 어떻게 할까 생각하다가
    // 질문 중에 어차피 나머지가 n을 넘을 수 없기 때문에 1을 더해나가면서 s를 맞추면 된다는 걸 보고나서
    // 해결할 수 있었다.

    public static void main(String[] args) {

        int n = 2;
        int s = 9;

        int[] answer = new int[n];

        // if(n > s) return new int[] {-1};

        if(s % n == 0){ // 나누어 떨어질 때
            for(int i=0;i<n;i++){
                answer[i] = s / n;
            }
        }
        else{ // 나누어 떨어지지 않을 때
            for(int i=0;i<n;i++){
                answer[i] = s / n;
            }

            int num = s % n;

            for(int i=n-num;i<n;i++){
                answer[i] += 1;
            }
        }





    }
}