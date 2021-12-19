import java.util.*;

public class Main {

    // programmers 징검다리 건너기
    // 징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
    // 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
    // 단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로만 건너뛸 수 있습니다.
    // 이때 k 이상의 칸을 뛰어넘는 것은 불가능합니다.
    // while문에서 stones 배열에 모두 1을 빼고 만약 0일 경우에 연속된 0을 cnt로 해서 숫자를 세어
    // 연속된 0의 수가 k가 되면 건너뛸 수 없는 경우이기 때문에 break로 빠져나온다.
    // 정확성은 모두 맞지만 효율성 테스트를 통과하지 못했다.
    // 아마 stones 배열의 길이가 매우 길거나 원소가 커서 1씩 빼면서 for문을 도는 경우가 많을 때가 있는 것 같다.
    // 효율성을 생각해보면 아마도 k개의 연속된 수가 가장 작은 부분을 찾아야 할 것으로 보인다.
    // 연속된 0을 가장 빨리 만들 수 있는 범위를 찾아야 하는 것 같은데 그 부분을 생각해봐야 겠다.

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};

        int k = 3;

        int answer = 0;

        while(true){
            boolean flag = true;
            int cnt = 0;
            for(int i=0;i<stones.length;i++){
                if(stones[i] > 0) {
                    cnt=0;
                    stones[i]--;
                }
                else if(stones[i] == 0) cnt++;

                if(cnt >= k){
                    flag =false;
                    break;
                }
            }

            if(flag) answer++;
            else break;

//            for(int i=0;i<stones.length;i++){
//                System.out.print(stones[i] + " ");
//            }
//            System.out.println();
        }

        System.out.println(answer);


    }
}
