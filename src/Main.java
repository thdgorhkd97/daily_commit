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

    // 친구와 함께 고민해보면서 2군데를 수정하였다.
    // 먼저 처음에 설정하는 min과 max를 그냥 범위의 최소와 최대로 넣는 것이 아니라
    // 입력되는 코스트와 비교하면서 min과 max로 넣어 입력 되는 코스트의 최소와 최대로 맞춰
    // 조금이나마 코드의 속도를 빠르게 하였다. 근데 이 부분은 약간의 코드 성능 문제인것같고
    // 내가 애초에 했던 방식(최소 최대로 설정)도 문제가 있을 것 같지는 않다.
    // 코드가 옳게 바뀐 건 boolean[] visited = new boolean[N + 1]; 이 코드를
    // while문 내부로 옮긴 게 주요한 것 같다.
    // 내가 잘못 생각했던 게 visited를 한 번만 선언해서 사이클을 돌면 되는 것이 아니라
    // mid 값이 설정된 상태에서 visited를 돌면서 mid값이 바뀔 때마다 visited의 값을 변경하면서
    // 진행해야 하는 건데 외부에서 선언하니 visited를 계속 활용하지 못해서 mid값이 변하는 상황을
    // 제대로 반영하지 못한 것으로 보인다.


    public static class Node{
        int n;
        int cost;
        public Node(int n,int cost){
            this.n = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer stk = new StringTokenizer(s);

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        ArrayList<Node> island[] = new ArrayList[N + 1];
        for(int i=0;i<N+1;i++){
            island[i] = new ArrayList<>();
        }


        int max = 1;
        int min = 1000000000;

        for(int i=0;i<M;i++){
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            min = Math.min(weight,min);
            max = Math.max(weight,max);

            island[left].add(new Node(right,weight));
            island[right].add(new Node(left,weight));

        }
        s = br.readLine();

        stk = new StringTokenizer(s);

        int factory1 = Integer.parseInt(stk.nextToken());
        int factory2 = Integer.parseInt(stk.nextToken());

        int answer = 0;

        while(min <= max){
            int mid = (min + max) / 2;
            boolean[] visited = new boolean[N + 1];

            if(canMove(mid,island,factory1,factory2,visited)){

                min = mid + 1;
                answer = mid;
            }
            else{
                max = mid - 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean canMove(int mid,ArrayList<Node>[] island,int factory1,int factory2,boolean[] visited){

        Queue<Integer> que = new LinkedList<>();
        que.offer(factory1);
        visited[factory1] = true;

        while(!que.isEmpty()){
            int tmp = que.poll();
            if(tmp == factory2) return true;

            for(int i=0;i<island[tmp].size();i++){
                if(island[tmp].get(i).cost >= mid && !visited[island[tmp].get(i).n]){
                    visited[island[tmp].get(i).n] = true;
                    que.offer(island[tmp].get(i).n);
                }
            }
        }

        return false;
    }
}
