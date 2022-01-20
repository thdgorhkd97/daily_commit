import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1920 수 찾기
    // N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
    // 배열에 있는지 확인하기 위해서 for문으로 하나하나 확인하다 보면 상당히 오래 걸린다.
    // 이분탐색이 빠른 건 알고 있는데 얼마나 빠른지는 몰랐다.
    // 이분탐색 : O(logN) 인 반면 for문으로 확인할 땐 O(N)이 나온다.
    // 이분탐색은 반드시!! 정렬된 배열에서 사용 가능하다!!
    // 이분탐색에서 min은 탐색 범위의 왼쪽 끝 인덱스를 의미하고 max는 가장 끝 인덱스를 의미한다.
    // while문의 종료 조건은 min < max 이다(인덱스를 역전할 때까지)
    // while문 내에서 mid값(중간값)을 구하고 배열내의 mid 인덱스 값과 value를 비교한다.
    // 만약 arr[mid] > value 라면 arr 배열 내에서 더 앞쪽에 있다는 것이므로
    // max = mid - 1로 해서 min과 max 의 범위를 value가 있는 arr 배열의 앞 부분으로 수정한다.
    // 이런 식으로 value 값의 범위를 맞춰가면서 arr 과 비교한다.

    // *** Arrays.binarySearch 메소드와의 비교 ***
    // 위 방식과 거의 유사하지만 차이점은 음수값을 기존 리스트에서 어느 값 사이에 있는지 알 수 있도록
    // 반환 한다는 차이가 있다고 한다.
    // ex [2,4,7,8] 에서 3을 찾고자 하면 음수를 반환하는데 3은 2와 4사이에 있어야 하므로 -2를 반환
    // 자바에서는 음수 값을 -(low+1)로 반환하기 때문이다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        String str = br.readLine();
        StringTokenizer stk = new StringTokenizer(str," ");

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int M = Integer.parseInt(br.readLine());

        str = br.readLine();
        stk = new StringTokenizer(str," ");
        for(int i=0;i<M;i++){
            check(arr,Integer.parseInt(stk.nextToken()));
        }

    }

    static void check(int[] arr, int num){

        int min = 0;
        int max = arr.length-1;

        if(num < arr[0] || num > arr[max]){
            System.out.println("0");
            return ;
        }

        while(min <= max){
            int mid = (min+max) / 2;

            if(arr[mid] > num){
                max = mid - 1;
            }
            else if(arr[mid] < num){
                min = mid + 1;
            }
            else{
                System.out.println("1");
                return ;
            }
        }

        System.out.println("0");
    }

}
