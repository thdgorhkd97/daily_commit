import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 숫자 게임
    // A 배열의 수보다 B 배열의 수가 더 크게 만드는 최대 경우의 수
    // 처음에는 i=0 부터 A와 B의 인덱스를 동시에 비교했는데 어떻게 해도 문제가 있었다.
    // 테스트 케이스도 너무 작게 나와서 해결방법을 몰랐는데
    // 최대 점수를 얻기 위해서 A에서 큰 수가 있다면 B에서는 가장작은 걸 버릴수 있어야 한다는
    // 부분에서 힌트를 얻었다.
    // 오히려 가장 뒤에서부터 인덱스를 비교하면서 같은 인덱스만 비교하는 것이 아니라
    // B보다 A가 크면 그에 대해서는 고려를 하지 않는 식으로 A와 B의 인덱스를 따로
    // 관리했어야 했다.
    // 코드는 짧지만 반대로 만들어서 인덱스를 따로 관리하는 걸 생각하는 게 힘들었다.

    public static void main(String[] args) {

        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int b_idx = B.length-1;
        for(int i=A.length-1;i >= 0;i--){
            if(A[i] < B[b_idx]){
                answer++;
                b_idx--;
            }
        }

    }
}