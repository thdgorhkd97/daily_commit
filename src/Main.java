import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 10973 이전 순열
    // combination method에서 result를 출력했을 때는 사전순으로 잘 정렬되서 나오는데
    // 왜 list.add(result)를 해서 list를 확인하면 제대로 나오지 않는지 모르겠다...
    // list의 선언도 했고 static이고 int[]을 받는 데 왜...

    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int[] target = new int[N];
        for(int i=0;i<N;i++){
            target[i] = Integer.parseInt(stk.nextToken());
        }

        int[] arr = new int[N];
        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }

        boolean flag = true;
        for(int i=0;i< target.length;i++){
            if(target[i] != i+1){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("-1");
            return ;
        }


        boolean[] visited = new boolean[N];
        int depth = 0;
        int[] result = new int[N];
        combination(visited,arr,depth,result);

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).length;j++){
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println();
        }

        for(int i=1;i<list.size();i++){
            flag = true;

            for(int j=0;j<list.get(i).length;j++){
                if(list.get(i)[j] != target[j]){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                for (int j = 0; j < list.get(i-1).length; j++) {
                    System.out.print(list.get(i - 1)[j] + " ");
                }
                return ;
            }

        }



    }
    private static void combination(boolean[] visited,int[] arr,int depth,int[] result){
        if(depth == result.length){

//            for(int i=0;i< result.length;i++){
//                System.out.print(result[i] + " ");
//            }
//            System.out.println();
            list.add(result);
            return ;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                result[depth] = arr[i];
                visited[i] = true;
                combination(visited,arr,depth+1,result);
                visited[i] = false;
            }
        }
    }
}
