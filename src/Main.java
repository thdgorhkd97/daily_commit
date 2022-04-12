import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 징검다리

    // 출발지점에서 distance의 도착지점 사이에 rocks[] 에 해당하는 바위가 있을 때
    // n개의 돌을 제거했을 때 각 바위 사이 거리의 최소값들 중 가장 큰 값을 구하는 문제다

    // 우선 나는 n개의 돌을 제거한다는 것은 rocks.length-n 개의 돌을 남긴다는 것이므로
    // 조합을 이용해 돌을 남기고 0이라는 출발점과 distance에 해당하는 도착점을 넣고
    // 그 돌 사이의 거리를 구해 그 중 최소값을 우선순위 큐에 집어넣었다.
    // 테스트 케이스도 통과하고 답도 정확히 나오는데 문제에서 해결을 원하는 방법은
    // 따로 있는 것으로 보인다.(메모리 초과와 시간 초과가 발생한다.)
    // 조합을 사용하는 방식 자체가 맞지 않는 방법으로 보인다.
    // 다른 방법을 찾아봐야 할 것으로 보임...

    static int answer = Integer.MAX_VALUE;
    static int dist = 0;
    static PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {

        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        dist = distance;

        Arrays.sort(rocks);

        int start = 0;
        int[] result = new int[rocks.length-n];
        int depth = 0;
        combination(depth,start,rocks,result);

        answer = list.poll();
        System.out.println(answer);

    }
    private static void combination(int depth,int start,int[] rocks,int[] result){
        if(depth == result.length){

            int[] arr = new int[result.length + 2];
            arr[0] = 0;
            for(int i=1;i<result.length+1;i++){
                arr[i] = result[i-1];
            }
            arr[result.length + 1] = dist;

            int min = Integer.MAX_VALUE;
            for(int i=1;i<arr.length;i++){
                min = Math.min(arr[i] - arr[i-1],min);
            }
            list.add(min);

            return;
        }
        for(int i=start;i<rocks.length;i++){
            result[depth] = rocks[i];
            combination(depth+1,i+1,rocks,result);
        }
    }

}