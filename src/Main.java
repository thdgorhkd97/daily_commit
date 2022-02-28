import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 18870 좌표 압축
    // 문제를 잘못 이해한 부분이 있어서 해결하는 시간이 오래 걸렸다.
    // 나는 처음에 해당 인덱스보다 작은 원소의 개수를 더해서 새로운 인덱스값을 만드는 줄 이해했는데
    // 알고보니 개수가 아니라 등수를 구해서 넣는 것이었다.(예시로 나와있던 값이 우연히 개수와 등수가
    // 일치하는 경우라서 헷갈렸다.)
    // 개수를 구하는 경우는 아래쪽에 주석처리 된 부분이다.
    // 해당 원소와 개수를 넣어서 키 값을 비교해가며 더 작은 값이라면 더한다.
    // 등수를 구하는 건 오히려 쉬웠는데 map에 해당 원소와 개수를 넣는 게 아니라 원소와 rank를 넣는다.
    // rank는 0으로 초기화하고 키값이 달라지면 등수가 증가해야 하기 때문에 rank++로 등수를 바꾼다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        int[] clone = arr.clone();
        Arrays.sort(clone);

        int ranking = 0;
        for(int num : clone){
//            System.out.print(num + " ");
            if(!map.containsKey(num)){
                map.put(num,ranking++);
            }
        }

        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            answer[i] = map.get(arr[i]);
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<N;i++){
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb.toString());

//        for(int i=0;i<N;i++){
//
//            int cnt = 0;
//            for(Integer keyset : key){
//                if(keyset < arr[i]){
//                    cnt += map.get(keyset);
//                }
//            }
//
//            answer[i] = cnt;
//        }



    }
}