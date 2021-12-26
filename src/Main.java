import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {

    // baekjoon 1939번 - 중량 제한
//    문제
//    N(2 ≤ N ≤ 10,000)개의 섬으로 이루어진 나라가 있다.
//    이들 중 몇 개의 섬 사이에는 다리가 설치되어 있어서 차들이 다닐 수 있다.
//    영식 중공업에서는 두 개의 섬에 공장을 세워 두고 물품을 생산하는 일을 하고 있다.
//    물품을 생산하다 보면 공장에서 다른 공장으로 생산 중이던 물품을 수송해야 할 일이 생기곤 한다. 그런데 각각의 다리마다 중량제한이 있기 때문에 무턱대고 물품을 옮길 순 없다.
//    만약 중량제한을 초과하는 양의 물품이 다리를 지나게 되면 다리가 무너지게 된다.
//    한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
//
//    입력
//    첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다.
//    다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다.
//    이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다.
//    서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다.
//    마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 주어진다.
//    공장이 있는 두 섬을 연결하는 경로는 항상 존재하는 데이터만 입력으로 주어진다.

    // 백준 사이트에서 문제를 해결해보려 해서 입력값을 받는 것부터 다시 확인하고 공부했다.
    // BufferedReader와 StringTokenizer를 활용했다.
    // 이분탐색을 활용한 문제라는 것을 알고 있어서 이분탐색을 활용해 보았는데 코드를 만들고 보니
    // 문제에 대해 잘못 이해한 부분이 있어서 수정해야 할 것으로 보인다.
    // 먼저 나는 공장사이를 다이렉트로 잇는 경로가 반드시 존재하는 줄 알았는데 경로가 존재하는 것이지
    // 다이렉트로 잇는 경로에 대한 언급은 없다.
    // 이 부분 때문에 공장이 있는 섬 사이의 경로에 대한 값을 확인하는 코드가 추가되어야 한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer stk = new StringTokenizer(s);

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[][] island = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            island[left][right] = Math.max(island[left][right],weight);
            island[right][left] = Math.max(island[right][left],weight);

        }
        s = br.readLine();

        stk = new StringTokenizer(s);

        int factory1 = Integer.parseInt(stk.nextToken());
        int factory2 = Integer.parseInt(stk.nextToken());

//        for(int i=1;i<=3;i++){
//            for(int j=1;j<=3;j++){
//                System.out.print(island[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(" 공장 위치 : " + factory1 + " " + factory2);

        int min = 1;
        int max = 1000000000;

        while(min <= max){
            int mid = (min + max) / 2;

            if(canMove(mid,island,factory1,factory2)){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }

        System.out.println(min);

    }

    public static boolean canMove(int mid,int[][] island,int factory1,int factory2){
        if(island[factory1][factory2] <= mid){
            return true;
        }
        else return false;
    }
}
