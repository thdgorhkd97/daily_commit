import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 2일차 - 가장 큰수
    // {6,10,2} -> 6210 이 가장 큰 수가 된다.
    // 순열을 이용해서 해결하고자 했는 데 해당 방식이 정확성을 맞는데 시간을 초과한다.
    // 온라인 강의를 통해서 해결방법에 대해서 알아보고 공부했는데
    // stream을 이용해서 코드를 간략하게 바꿔서 해결하는 것을 보았다.
    // stream을 코드에 직접 활용해 본적은 없는데 해당 스킬이 코드를 상당히 간략히
    // 만드는 것을 보고 stream을 활용하는 방식을 공부해야 할 것 같다.

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        int[] numbers = {6,10,2};

        String[] str = new String[numbers.length];

        for(int i=0;i<str.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }

        int depth = 0;
        int n = str.length;
        int r = n;

        permu(str, depth, n, r);

        int max = 0;
        for(int i=0;i<list.size();i++){
            max = Math.max(max,Integer.parseInt(list.get(i)));
        }

        String answer = String.valueOf(max);
        System.out.println(answer);


//        String answer = IntStream.of(numbers)
//                .mapToObj(String::valueOf)
//                .sorted((s1,s2)->(s2+s1).compareTo(s1+s2))
//                .collect(Collectors.joining());


    }

    public static void permu(String[] str, int depth, int n, int r){
        if(depth == r){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<str.length;i++){
                sb.append(str[i]);
            }
            System.out.println(sb.toString());
            list.add(sb.toString());
        }

        for(int i=depth;i<n;i++){
            swap(str,depth,i);
            permu(str,depth+1,n,r);
            swap(str,depth,i);
        }
    }

    private static void swap(String[] str, int depth, int i) {
        String st = str[depth];
        str[depth] = str[i];
        str[i] = st;
    }
}