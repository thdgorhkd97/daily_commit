import java.util.*;

public class Main {

    // programmers level 3 - 징검다리 건너기 ( 효율성 해결을 위한 노력 )
    // 효율성을 해결하는 방법을 도저히 모르겠어서 결국 찾아보고 말았다 ㅠㅠ
    // 이진 탐색을 활용하여 문제를 해결하고자 하였다.
    // 최소와 최대값의 중간값부터 확인해가면서 그 값이 stones 배열에서 뺐을 때
    // k값을 넘는지 확인한다. ( 중간값이 지나간 인원이라고 한다면 이때 그 인원들이 징검다리를
    // 건널 수 없다면 더 적은 인원이 지나가야만 하는 것이기 때문에 max를 mid-1로 바꾼다.
    // 이진 탐색법을 활용해야 한다는 것을 알고서 구현하는 데 성공했는데
    // 어제는 효율성 테스트에서 시간초과가 발생했는데 이번에는 실패라고 뜨면서
    // 시간이 표시되기는 했다.
    // 뭔가 어제보다는 시간적인 측면에서 발전한 것 같긴 한데 이 방법으로도 해결하는 데는
    // 실패했다는 것이다...

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};

        int k = 3;

        int answer = 0;

        // 이진 탐색을 활용해보자

        int min = 1;
        int max = 200000;
        int mid = 0;

        while(min <= max){
            mid = (min + max) / 2;

            int cnt = 0;
            boolean flag = true;

            for(int i=0;i< stones.length; i++){
                if(stones[i] < mid){
                    cnt++;
                }
                else cnt = 0;

                if(cnt == k){
                    flag = false;
                    break;
                }
            }

            if(!flag){
                max = mid - 1;
            }
            else{
                min = mid + 1;
                answer =  Math.max(answer,mid);
            }

        }

        System.out.println(answer);





    }
}
