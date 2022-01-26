import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 가장 큰 수
    // 문자열 기준 [ (기준값).compareTo(비교대상) ] -> 기준값에 비교대상이 포함되어 있으면 문자열 길이 차이 리턴
    //                                         -> 맨 앞에서 다르다면 아스키값으로 처리
    //                                         -> 비교 불가능한 지점에서 아스키값으로 비교 처리

    // java 124 나라의 숫자
    // 1,2,4 라는 숫자로만 해결이 돼야하기 때문에 3의 나머지로 해결하는 3진법과 같은
    // 방법을 떠올렷다. 근데 3으로 나누어 떨어지는 경우에 문제가 생겼다.
    // 3으로 나누어 떨어지는 경우에 124나라의 숫자에 맞춰 숫자를 넣고 로직이 마무리 되어야 하는데
    // 3으로 나누어 떨어지면 나머지가 1이 남아서 숫자를 하나 새로 넣는 문제가 있었다.
    // 해당 경우를 어떻게 처리해야 할까 고민해보면서 여러 조건을 추가했었는데 그냥
    // if문을 하나 추가해서 만약 3으로 나누어 떨어지는 경우라면 1을 빼기로 했다.
    // 그렇게 처리함으로써 3의 배수인 수가 한번 더 수가 들어가는 경우를 조심했다.


   public static void main(String[] args) throws IOException {

       int n = 10;

       int remain = 0;

       ArrayList<Integer> list = new ArrayList<>();
       while(n != 0){
           remain = n % 3;
           switch (remain){
               case 0 : list.add(4); break;
               case 1 : list.add(1); break;
               case 2 : list.add(2); break;
           }

           if(n % 3 == 0){ // 3의 배수라면
              n--;
           }
           n /= 3;
       }

       StringBuffer sb = new StringBuffer();
       for(int i=list.size()-1;i>=0;i--){
           sb.append(String.valueOf(list.get(i)));
       }

       System.out.println(sb.toString());

       /* java - 가장 큰 수 (programmers level 2)
       int[] numbers = {2,10,6};

       String[] result = new String[numbers.length];

       int idx = 0;
       for(Integer num : numbers){
           result[idx++] = String.valueOf(num);
       }

       Arrays.sort(result, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               // 문자열을 합친 것이기 때문에 그대로 합쳐진 문자열이 리턴된다.
               // ex) 6과 10을 비교한다면 610.compareTo(106)이렇게 된다.
               // 이 상황에서 610이 더 크므로 양수를 반환하기 때문에 순서를 바꾸지 않는다.
               // 반면 10,6이라서 반대로 되어 있다면 음수를 반환하기 때문에 6이 앞으로 위치를 바꾸게 된다.
               return (o2+o1).compareTo(o1+o2);
           }
       });

//       Arrays.sort(result,((o1, o2) -> (o2+o1).compareTo(o1+o2)));


       StringBuffer sb = new StringBuffer();
       for(int i=0;i<result.length;i++){
           sb.append(result[i]);
       }

       System.out.println("정답 : "+sb.toString());
        */
    }
}