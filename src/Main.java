import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 징검다리

    // 이분탐색으로 분류된 문제이기에 이분탐색으로 해결해 보려고 했는데
    // 정렬된 rocks[] 배열을 만들어서 이를 기준으로 이분탐색을 해야 할 것 같긴 했는데
    // 이분탐색의 기준을 어떻게 처리해야 할 지 몰라서 알아보았다.
    // 역시 이분탐색의 기준이 되는 건 가능한 최소값이었는데 이 최소값을 갱신하는 기준은
    // 해당 거리를 가질 수 있는 바위간의 거리였다.
    // 즉 어떤 거리를 기준으로 바위간의 거리가 이보다 작으면 해당 바위를 제거하는 식으로
    // 진행하면서 어떤 거리가 n개의 바위를 제거해서 만들어 질 수 있는 거리인지를 보는 것이다.
    // 코드 자체는 이분탐색 그 자체이기에 간단했는데
    // 이 로직을 이해하는 게 상당히 힘들었다.
    // 시간이 굉장히 오래걸렸고 level 4에 해당하는 문제답게...

    public static void main(String[] args) throws IOException {

        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        int mid = 0;

        int answer = 0;

        while(left <= right){
            mid = (left + right) / 2;
            int prev = 0;
            int removeCnt = 0;

            for(int i=0;i<rocks.length;i++){
                if(rocks[i] - prev < mid){ // 바위간의 거리가 mid보다 작으면 바위 제거
                    removeCnt++; // 제거한 바위 수
                    if(removeCnt > n) break; // n개까지 제거 가능
                }
                else{
                    prev = rocks[i];
                }
            }

            if(removeCnt > n){ // 만약 제거한 바위가 n개 이상이면 바위간의 거리가 너무 길다는 것이므로 수정
                right = mid - 1;
            }
            else {
                answer = Math.max(answer,mid);// mid이하의 거리를 가진 바위간의 거리가 적절하니까 answer 초기화
                left = mid + 1;
            }
        }



    }

}