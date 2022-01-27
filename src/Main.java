import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 2108 - 통계학
    // N개의 숫자가 들어왔을 때
//    산술평균 : N개의 수들의 합을 N으로 나눈 값
//    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//    최빈값 : N개의 수들 중 가장 많이 나타나는 값
//    범위 : N개의 수들 중 최댓값과 최솟값의 차이
    // 을 구하라

    // 다른것들은 다 쉬운거였는데 생각보다 최빈값을 구하는 과정에서 시간이 걸렸다.
    // 좋은 로직으로 빠르게 해결할 수 있는 방법이 없을까 싶어서 처음에는 map을 활용해볼까 하다
    // map에 넣고나서 정렬을 한 후에 가장 큰 값이 하나인지 둘인지 확인하고
    // 그 값을 풀어야 하는 상황인건데 별로 좋지 않다고 생각했다.
    // 그게 더 빠를순 있겠지만 로직에 대한 확신이 안 들어서 조금 돌아가더라도 확실하게 처리하려 했다.
    // 우선 입력되는 정수의 절댓값이 4000을 넘지 않는다는 문제 조건은 -4000 ~ 4000이라는 소리기 때문에
    // 각 정수가 몇번 입력되는지 확인하기 위한 many[] 배열에 추가한다.
    // 단 음수를 확인할 수 없기에 4000을 더해서 넣었다. 0 -> mamy[4000]++ 이런 식으로
    // 그 후에 가장 많은 최빈값을 확인하고 최빈값과 같다면 list에 추가한다.
    // 최빈값이 하나라면 list의 사이즈가 1이기 때문에 그대로 출력하고
    // 최빈값이 여러개라서 list에 여러개가 들어간다면 list를 정렬한 후에 두번째값을 출력한다.


   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       int[] num = new int[N];

       for(int i=0;i<N;i++){
           num[i] = Integer.parseInt(br.readLine());
       }

       Arrays.sort(num);

       // 산술평균 : N개의 수들의 합을 N으로 나눈 값
       int sanSool = 0;
       int sum = 0;
       for(int i=0;i<N;i++){
           sum += num[i];
       }
       sanSool = (int)Math.round((double)sum / N);

       // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
       int joongAng = 0;
       joongAng = num[N/2];

       // 최빈값 : N개의 수들 중 가장 많이 나타나는 값(여러 개 일 경우 2번째로 작은 값)
       int most = 0;
       int[] many = new int[8001]; // -4000 ~ 4000
       ArrayList<Integer> list = new ArrayList<>();

       for(int i=0;i<num.length;i++){
           many[num[i] + 4000]++;
       }

       int max = 0;
       for(int i=0;i<many.length;i++){
           if(max < many[i]){
               max = many[i];
           }
       }

       for(int i=0;i<many.length;i++){
           if(many[i] == max){
               list.add(i - 4000);
           }
       }

       if(list.size() == 1) most = list.get(0);
       else{
           Collections.sort(list);
           most = list.get(1);
       }

       // 범위 : N개의 수들 중 최댓값과 최솟값의 차이
       int length = num[num.length-1] - num[0];


       System.out.println(sanSool);
       System.out.println(joongAng);
       System.out.println(most);
       System.out.println(length);











    }
}