import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1929 소수 구하기
    // 아래의 주석친 부분은 2부터 N-1까지의 수 중에서 N을 나눠지게 하는 약수가 있다면
    // N이 소수가 아니라는 것을 활용한 정말 기본적인 소수 판별 프로그램이다.
    // 해당 방법은 시간초과가 발생하게 되고 다른 방법을 찾아야 했다
    // 에라토스테네스의 체라는 방법을 활용해보기로 했다.
    // 먼저 개념을 살펴보면 " k=2부터 루트N 이하까지 반복하여 자연수들 중 k를 제외한
    // k의 배수들을 제외시킨다 " 라는 개념을 적용시킨다.
    // 루트N 까지 확인하는 것은 소수를 판별함에 있어서 해당 수가 소수라면 반드시 둘중 하나는
    // 루트N보다 작거나 같기 때문에 소수인지 아닌지 확인할 때 루트 N까지 확인하는 것이다.
    // 따라서 확인하고자 하는 수(end)보다 하나 크게 boolean 배열을 잡고서
    // 소수인 수들의 배수를 해당 범위에서 제거해 나간다.
    // 에라토스테네스의 체를 이용해 소수를 판별하는 알고리즘이 반복문을 통해 확인하는 O(N)혹은
    // O(루트N) 의 시간이 걸리는 알고리즘보다 훨씬 빠르다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str, " ");

        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        boolean[] isPrime = new boolean[end+1];

        isPrime[0] = true;
        isPrime[1] = true;

        for(int i=2;i<=Math.sqrt(end);i++){
            if(isPrime[i]){
                continue;
            }

            for(int j=i*i; j< isPrime.length; j=j+i){
                isPrime[j] = true;
            }
        }

        for(int i=start;i<=end;i++){
            if(!isPrime[i]){
                System.out.println(i);
            }
        }


    }
}

        /*ArrayList<Integer> list = new ArrayList<>();

        for(int i=start;i<=end;i++){
            isPrimary(i,list);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    public static void isPrimary(int num,ArrayList<Integer> list){
        boolean flag = true;

        for(int i=2;i<num;i++){
            if(num % i == 0){
                flag = false;
                break;
            }
        }

        if(flag){
            list.add(num);
        }

    }
}*/

