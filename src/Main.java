import java.util.*;

public class Main {

    // programmers level 3 - 징검다리 건너기 ( 효율성 해결을 위한 노력 )
    // 효율성을 해결하는 방법을 도저히 모르겠어서 결국 찾아보고 말았다 ㅠㅠ
    // 이진 탐색을 활용하여 문제를 해결하고자 하였다.
    // 이진 탐색 방법을 확인해보고도 해결이 불가능해서 결국 풀이 코드를 확인하였는데
    // 내가 while문 내에서 돌리면서 확인한 for문을 함수로 따로 빼내서 해결한 부분만
    // 다르다고 판단하였다.
    // 근데 알고보니 이분탐색을 하는 max 값 설정이 잘못된 것이었다.
    // 나는 stones 배열의 전체 크기를 max로 잡았는데 stones 배열의 원소값의 최대 크기를 max로 잡았어야 했다
    // 되게 간단한 건데 이걸 어제 왜 못봤을까 ㅠㅠㅠ
    // 하여튼 함수로 따로 빼내는 거랑 비교해서 시간을 확인해 보았다.

    //        for(long i=0;i<2000000000;i++){
    //            cnt++;
    //        }
    // 이 함수를 그냥 했을 때는 1138 System.currentTimeMillis() 로 1138이 나왔고
    // 함수로 빼서 실행 했을 때는 1188이 나왔다. 함수를 호출하고 리턴받는 시간이 더해진 듯하다.
    // 당연히 함수를 호출하는 게 더 시간이 오래 걸릴거라 생각했고 나중에 알고보니 설정값 오류였다.


    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};

        int k = 3;

        int answer = 0;int min = 1;
        int max = 200000000;
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



//        long beforeTime = System.currentTimeMillis();
//        ( 시간 측정할 코드)
//        long afterTime = System.currentTimeMillis();
//        long Time = (afterTime - beforeTime);

    }
}
