import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 트리구조에서 각 정점사이의 최단거리를 구하는 것 내일 그 부분에 대해서만 고민해보자.
    // 트리구조에서 각 정점사이의 거리를 구하는 공부를 인터넷을 찾아가며 공부했다.
    // 역시 처음부터 이해되지는 않았고 그림을 그리고 다른 예시를 들어가보며 직접 로그를 찍어본 뒤에
    // 이해할 수 있었고 백지에서부터 코딩할 수 있도록까지 공부했다.
    // 물론 지금 당장은 기억력으로 코딩한 부분이 있을 수 있기 때문에 지속적으로 복습해야 한다.

    // 일단 이론은 두 노드 사이의 거리를 구하는 것이기 때문에 한쪽의 노드에서부터 트리의 꼭대기까지
    // 가는 경로를 저장하고 그 경로까지의 거리를 구한다.
    // 예를 들어 2 1 -1 0 -1이렇게 visitedX가 저장이 된다면 3번 노드에서 출발해서 2번, 4번 노드는 거치지 않고
    // 3번 -> 1번 -> 0번 이렇게 거친다는 의미다.
    // 그리고 다른 한 점도 똑같이 처리하지만 visitedX의 -1이 아닌 부분이 되면(즉, X노드에서 꼭대기까지 가는 경로를 Y좌표에서
    // 꼭대기까지 가는 경로가 겹치는 공통 조상이 맞닿으면) 거기서 visitedX[y] + sum을 리턴한다.
    // 이때 visitedX[y]는 X 노드에서 공통 조상까지의 거리
    // sum은 Y 노드에서 공통 조상까지의 거리를 의미한다.


    private static int[] parent;
    private static int[] visitedX;
    private static int[] visitedY;


    public static void main(String[] args) throws IOException {

        int n = 5;

        int[][] graph = new int[n][n];

        parent = new int[n];
        visitedX = new int[n];
        visitedY = new int[n];

        Arrays.fill(visitedX,-1);
        Arrays.fill(visitedY,-1);

//        for(int i=0;i<visitedY.length;i++){
//            System.out.print(visitedX[i] + " ");
//        }

        addLine(0,1,graph);
        parent[1] = 0;
        addLine(0,2,graph);
        parent[2] = 0;
        addLine(1,3,graph);
        parent[3] = 1;
        addLine(1,4,graph);
        parent[4] = 1;

        int cnt = 0;

        int x = 0;
        int y = 4; // 3과 4 노드 사이의 거리를 구하는 문제라는 가정

//        for(int i=0;i< parent.length;i++){
//            System.out.print(parent[i] + " ");
//        }
//        System.out.println();

        while(true){
            visitedX[x] = cnt++;
            if(x == 0) break;
            x = parent[x];
        }


//        for(int i=0;i< visitedX.length;i++){
//            System.out.print(visitedX[i] + " ");
//        }
//        System.out.println();


        // 여기서 visitedX[i]는 2 1 -1 0 -1 이렇게 나오는데 이 의미는 우선 -1로 그대로인 노드는
        // 3번 노드에서부터 끝까지 갔을 때 2번과 4번 노드는 거치지 않고 0 1 2 순인
        // 3 -> 1 -> 0 번 노드의 경로를 통해 이동한다는 뜻이다.

        cnt = 0;
        int sum = 0;
        while(true){
            if(visitedX[y] != -1){
                // 공통조상이 된다는 뜻(x노드에서 올라가는 과정의 노드중에서
                // y의 조상이 있다는 뜻이므로
                sum = visitedX[y] + cnt; // x 노드에서 공통조상까지의 거리 = visitedX[y]
                // y노드에서 공통조상까지의 거리 = cnt
                break;
            }
            else{ // 위와 똑같이 y 노드에서부터 공통조상을 찾는 과정(위로 올라가는 과정)
                visitedY[y] = cnt++;
                if(y == 0) break;
                y = parent[y];
            }
        }


        System.out.println(sum);
    }

    private static void addLine(int a,int b,int[][] graph){
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
}