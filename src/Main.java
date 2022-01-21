import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 10816 - 숫자 카드 2
    // 이분탐색으로 분류된 문제라서 이분탐색으로 풀어봤는데 결국 처음 생각한대로
    // hashmap을 활용해서 마무리 하였다
    // 우선 arr배열중에서 특정수가 얼마나 있는지 체크하는 문제였기 때문에 arr배열에 있는 수를
    // hashmap에 집어넣고 몇개 있는지 찾고자 하는 수가 key로 존재한다면 그 value값을
    // 존재하지 않는다면 0을 출력하도록 하여 해결하는 데는 전혀 문제가 없었다.
    // 근데 이 문제는 이분탐색 문제로 분류되어 있었기 때문에 이분탐색으로 해결해보려고 노력했다.
    // 먼저 이분탐색을 통해서 특정 수가 arr배열에 있는지 없는지를 확인하는 것은 그리 어렵지 않다.
    // 근데 있다 없다가 아니라 몇 개 있는지를 알아내야 했기 때문에 내가 선택한 방식은
    // mid인덱스를 기준으로 앞쪽과 뒤쪽으로 같은 원소가 있는지를 체크해서 idx의 범위를 구하는 방식이었다
    // 만약 arr[mid]가 num과 같다면 num은 arr에 존재하는 것이기 때문에 arr[mid-1], arr[mid-2]...이런 식으로
    // arr[mid]를 기준으로 앞과 뒤를 보면서 arr배열에서 num과 같은 원소를 가지는 인덱스의 범위를 구하는 것이다.
    // 이렇게 나는 그 원소가 arr에 있는지 확인하고 있다면 인덱스의 범위를 찾는 방식으로 했는데
    // 조금 찾아보니 처음부터 원소의 upper bound와 lower bound를 찾는 방식이 있었다.
    // 찾고자 하는 수의 이상과 초과를 가지는 원소의 인덱스를 찾는 방식이다.
    // 만약 arr 배열에 원소가 있다면 나와 같은 방식으로 arr배열의 인덱스 범위가 나오고
    // arr 배열에 없다면 이상과 초과를 뜻하는 인덱스가 같은 인덱스를 가르키게 되기 때문에
    // 존재하지 않는다는 것을 쉽게 알 수 있는 방법이 있다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str, " ");

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        str = br.readLine();
        stk = new StringTokenizer(str, " ");

        int[] answer = new int[M];

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(stk.nextToken());

            sb.append(map.getOrDefault(num,0)).append(' ');

        }

        System.out.println(sb.toString());



//        int[] answer = new int[M];
//
//        for(int i=0;i<M;i++){
//            int num = Integer.parseInt(stk.nextToken());
//            answer[i] = check(arr,num);
//        }
//
//
//        for(int i=0;i<M;i++){
//            System.out.print(answer[i] + " ");
//        }
//
//
//    }
//
//    static int check(int[] arr, int num){
//
//        int min = 0;
//        int max = arr.length-1;
//        int cnt = 0;
//        while(min < max){
//            int mid = (min+max) / 2;
//
//            if(arr[mid] > num){
//                max = mid - 1;
//            }
//            else if(arr[mid] < num){
//                min = mid + 1;
//            }
//            else{ // arr에 num이 존재합니다
//                int left = 0;
//                int right = arr.length-1;
//
//                for(int i=mid;i>=0 ;i--){
//                    if(arr[i] != num){
//                        left = i+1;
//                        break;
//                    }
//                }
//                for(int i=mid+1;i<arr.length;i++){
//                    if(arr[i] != num){
//                        right = i-1;
//                        break;
//                    }
//                }
//                cnt = right - left + 1;
//                break;
//            }
//        }
//
//        return cnt;
//
//    }
//}
    }
}