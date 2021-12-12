import java.util.*;

public class Main {

    // programmers level 3 - 야근 지수
    // n만큼 works배열에서 뺐을 때 2의 거듭제곱의 합이 가장 최소가 되도록 해야 한다.
    // 남은 works배열의 원소값이 거듭제곱의 지수가 되기 때문에 평균적으로 가장 작게 만들어야 한다,
    // 큰 수에서 계속 빼나가면 될 것으로 보인다.

    // 거듭제곱을 위해서 가장 큰 숫자를 최대한 없애고 하향평준화해야 한다는 생각은 맞는데
    // 효율성에서 오류가 발생하였다.
    // 중간에 값을 빼 갈때 works 배열의 모든 원소의 합보다 n이 크다면 0을 리턴하는 분기를 넣었고
    // 근데, 하나를 뺄 때마다 가장 큰 값을 구하기 위해서 정렬을 하다보니 정렬을 n번 수행한다는 게
    // 효율성에서 문제가 발생한 것으로 보인다.

    public static void main(String[] args) {

        int n = 3;
        int[] works = {1,1};

        long answer = 0;

        while(n > 0){

            Arrays.sort(works);

            works[works.length-1]--;
//            if(works[works.length-1] < 0) return 0;

            n--;

        }

        int sum = 0;
        for(int i=0;i<works.length;i++){
            sum += Math.pow(works[i],2);
        }

        System.out.println(sum);





    }
}