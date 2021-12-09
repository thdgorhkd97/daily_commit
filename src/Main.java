import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 줄 서는 방법
    // 순열을 통해서 조합을 구하는 데 순서를 유지하기 위한 방법을 공부했다.
    // 사전순을 유지하면서 조합을 구하는 방법을 사용했는데 그렇게 만들어진 배열을
    // ArrayList<long[]> 에 넣었는데 이걸 출력하는 방식에서 막힌다..
    // list.get(i)를 해서 for문으로 j를 list.get(i)[j]로 표현하는데
    // 이렇게 표현하면 항상 마지막으로 list에 넣은 값에 대해서만 출력이 되기 때문에
    // 어떻게 해결해야 할 지 막히고 말았다..
    // arraylist를 다시 구현해야 하는지 혹은 arraylist에서 꺼내서 출력하는 방식을
    // 다시 고민해야 하는지 모르겠다.

    static ArrayList<long[]> list =  new ArrayList<>();
    static long[] answer;

    public static void main(String[] args) {

        int n = 3;
        long k = 5;

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

        long[] output = new long[n];
        boolean[] visited = new boolean[n];


        long[] answer = new long[n];

        perm(arr,output,visited,0,n,n,k);


        for(int i=0;i<list.size();i++){
            long[] array = Arrays.stream(list.get(i)).toArray();
            for(int j=0;j<n;j++){
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }


    }

    static void perm(long[] arr, long[] output, boolean[] visited, int depth, int n, int r,long k) {
        if (depth == r) {

            list.add(output);
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r,k);
                visited[i] = false;
            }
        }

    }
}