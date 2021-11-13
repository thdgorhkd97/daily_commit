import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 2 - 타겟 넘버
    // dfs를 활용한 대표적인 문제라고 해서 해봤는데 아직 bfs 만큼 dfs를 이해하지 못한 것 같다.
    // 풀이를 확인하고서 직접 변수값을 찍어보며 값을 확인하면서 보고난 후에야 어느정도
    // 이해할 수 있었다.
    // 각각의 인덱스에 대해서 + 와 - 를 모두 구해서 연산을 해야 하는 부분을
    // dfs로 구현하여 모든 경우의 수를 구하는 것이 포인트였던 문제다.
    // dfs를 통해 그래프를 순회하는 경우에 대해서는 잘 알고 있지만 이렇게 문제에
    // 적용하는 경우에 대해서는 조금 더 공부가 필요할 것으로 보인다.

    static int answer = 0;

    public static void main(String[] args) {

        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(numbers,target,0,0);

        System.out.println(answer);
    }

    public static void dfs(int[] numbers,int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
            return ;
        }

        sum += numbers[idx];
//        for(int i=0;i<idx;i++){
//            System.out.print(numbers[i] + " ");
//        }
//        System.out.println(" sum = " + sum);
        dfs(numbers,target,idx+1,sum);
        sum -= numbers[idx];
        sum += (-1 * numbers[idx]);

//        for(int i=0;i<idx;i++){
//            System.out.print(numbers[i] + " ");
//        }System.out.println(" sum = " + sum);

        dfs(numbers,target,idx+1,sum);

    }
}