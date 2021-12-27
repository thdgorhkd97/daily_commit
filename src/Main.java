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

    // 백준에서 메모리 초과가 나서 인접행렬로 구현한 부분을 cost와 연결된 다음 섬을 인자로 가지는
    // 인접리스트로 바꿔서 다시 구현했다. 항상 인접행렬로 구현하던 습관이 있어서 이번 기회에 찾아보고
    // 하느라 시간은 좀 걸렸지만 인접리스트로 구현해서 메모리 초과는 해결할 수 있었다.
    // 다만 ArrayList로 선언하고서 각 배열의 인자에 대해 새롭게 선언하는 부분을 놓쳐서
    // 처음에는 널포인트에 수를 넣으려는 오류가 발생하였다.
    // 그 후에는 bfs를 활용하여 factory1에서 factory2까지 이동하는 경로를 구현하기 위해
    // 코드를 짜서 방문여부와 가중치를 표현하여 이동하였을 때 무게를 이분탐색하는 코드를 구현했느데
    // 문제를 해결하지는 못했다 ㅎㅎ;;
    // 백준 사이트가 테스트 케이스도 적고 얼마나 틀렸는지 나오지 않아서 정확히는 모르겠지만
    // 수정이 필요하다는 것은 확실하다ㅠㅠ

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
        boolean[] visited = new boolean[N + 1];

        for(int i=0;i<M;i++){
            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            island[left].add(new Node(right,weight));
            island[right].add(new Node(left,weight));

        }
        s = br.readLine();

        stk = new StringTokenizer(s);

        int factory1 = Integer.parseInt(stk.nextToken());
        int factory2 = Integer.parseInt(stk.nextToken());

        int min = 1;
        int max = 1000000000;

        int answer = 0;

        while(min <= max){
            int mid = (min + max) / 2;

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
