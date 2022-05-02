import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java
    // 코딩 테스트 문제 中 하나
    // 수직선에서 거리를 계산하여 가능한 경우의 수를 구해야 하는데
    // 0을 기준으로 설정하기로 했다. 거리가 주어지기 때문에 0을 기준으로 하면 -와 + 2가지 경우가 있는 것이기 대문에
    // 이렇게 생각했는데 끝나고 생각해보니 가장 큰 값을 기준으로 하는 게 맞는 것 같다.
    // 가장 큰 값을 기준으로 한다면 그 두 index가 최대최소 혹은 최소최대 이게 맞는 것이기 때문에
    // 훨씬 더 직관적이고 깔끔한 기준이 될 것 같다.

    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int[][] dist = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};

        char[] ch = {'+','-'};

        char[] result = new char[dist.length-1];
        int depth = 0;
        combination(ch,result,depth,dist); // 어떻게 배열하던지 0은 안 변하기 때문에 0을 기준으로 +와 -를 나누어서 수직선에 둔다는 개념

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

// for(int i=0;i<list.size();i++){
// for(int j=0;j<list.get(i).length;j++){
// System.out.print(list.get(i)[j] + " ");
// }
// System.out.println();
// }

        int[][] answer = new int[list.size()][dist.length];

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<dist.length;j++){
                answer[i][j] = list.get(i)[j];
            }
        }


    }
    private static void combination(char[] ch,char[] result,int depth,int[][] dist){
        if(depth == result.length){

            HashMap<Integer,Integer> map = new HashMap<>();

            int idx = 0;

            for(int i=1;i<dist[0].length;i++){
                if(result[idx] == '+'){
                    map.put(i,dist[0][i]);
                }
                else{
                    map.put(i,dist[0][i] * (-1));
                }
                idx++;
            }

            if(isPossible(map,dist)) {
                map.put(0,0);

                int[][] arr4sort = new int[map.size()][2];

                idx = 0;
                for(Integer key : map.keySet()){
                    arr4sort[idx][0] = key;
                    arr4sort[idx++][1] = map.get(key);
                }

                Arrays.sort(arr4sort, (o1, o2) -> o1[1] - o2[1]);

                int[] res = new int[arr4sort.length];
                for(int i=0;i<arr4sort.length;i++){
                    res[i] = arr4sort[i][0];
                }

                list.add(res);

            }

            return ;
        }

        for(int i=0;i<ch.length;i++){
            result[depth] = ch[i];
            combination(ch,result,depth+1,dist);
        }
    }

    private static boolean isPossible(HashMap<Integer,Integer> map,int[][] dist){

        for(Integer key : map.keySet()){
            for(int j=key+1;j<dist[0].length;j++){
                if(dist[key][j] != Math.abs(map.get(key) - map.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
}