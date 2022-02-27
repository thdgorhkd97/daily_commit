import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 18870 좌표 압축
    // 문제의 예시를 통해서 이해한 바로는 중복되는 값을 제외하고 해당 인덱스의 값보다
    // 더 작은 원소의 개수를 구해서 다시 만들면 되는 것이라고 이해했다.
    // 그래서 중복되지 않게 원소들을 넣고 (set을 활용) 정렬한 후(Collections.sort)
    // 원소가 같으면 그때의 인덱스를 넣는다(정렬되어 있기 때문에 인덱스 순서는 자기 자신보다
    // 작은 원소들의 개수를 의미한다)
    // 이렇게 해서 예시에 해당하는 정답은 잘 나오는데 돌려보면 시간초과가 발생한다.
    // 아무래도 2중 for문을 돌면서 break를 쓴다해도 배열의 크기가 커지면 시간초과가 발생하는
    // 문제가 생기는 것 같다. 2중 for문이 아니라면 hash를 써야하나싶다


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] answer = new int[N];

        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(Integer num : arr){
            if(set.add(num)) list.add(num);
        }

        Collections.sort(list);

        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            for(int j=0;j<list.size();j++){
                if(list.get(j) == num){
                    answer[i] = j;
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<answer.length;i++){
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb.toString());

    }
}