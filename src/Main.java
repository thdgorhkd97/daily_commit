import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers - greedy 알고리즘
    // greedy 알고리즘을 문제 풀이를 통해서 다시 확실히 개념을 잡았다.
    // 지금 필요한 것을 당장 해결해 나가는 방식인데
    // 개념은 알고있었지만 문제를 해결함에 있어서 어떻게 적용하는지 체계적으로 학습했다.
    // 전체를 훑으면서 모든 인덱스에 대해 조건을 만족하면 끝낸다.
    // 나는 for문이나 배열같은 자료구조에서 인덱스를 돌렸는데 그냥 인덱스만 돌려서
    // 시간을 절약하거나 코드를 간결화하는 것도 가능했다.

    public static void main(String[] args) {

        int n = 11;
        int[] stations = {4,11};
        int w = 1;

        int answer = 0;
        int pos = 1;
        int si = 0;

        while(pos <= n){
            if(si < stations.length && stations[si] - w <= pos){
                pos = stations[si] + w + 1;
                si += 1;
            }
            else{
                answer += 1;
                pos += w * 2 + 1;
            }
        }


        System.out.println(answer);
    }
}