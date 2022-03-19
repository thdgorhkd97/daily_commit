import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 알고리즘 코딩 테스트에서 있었던 문제에 대해 복기 해보자
    // 시험중에는 문제에 대해 복사나 캡쳐가 불가능해서 기억나는 대로 문제를 옮겨보려 합니다
    // 친구관계가 주어지고 개인이 매긴 평점이 주어지는 데 만약 개인이 매긴 평점이 없다면 친구관계로 이어진
    // 사람들의 평균 평점을 그 개인의 평점으로 저장하는 문제
    // ex) 1번이 3점 2번이 5점으로 평점을 매기고 1-2-3 이렇게 3명이 친구라고 한다면 (1-2, 2-3 이런식도 가능)
    // 3번은 평점을 안 매겼어도 친구관계인 1번과 2번의 평균 평점인 4점으로 저장한다.

    // 구현한 내용인데 내가 직접 넣어본 케이스들에는 올바른 정답을 리턴하는 것으로 보인다.
    // 나는 bfs를 활용해서 만약 어떤 인원에 대해 평점을 매기지 않았다면 ( grade[i] == -1 이라면) 함수를 통해
    // 친구관계인 다른 인원들을 확인함과 동시에 친구관계라면 그 친구들의 평점을 더하고 인원을 더해서
    // 마지막에 while  문을 통과할 때 sum / cnt로 리턴한다.

    // 이렇게 하면 되는 것 같은데 시험당시에는 bfs를 통해 친구들을 직접 눈으로 보기 위해서 로그를 찍는 시간이 오히려
    // 더 걸렸던 것 같다. 그리고 문제의 추가 조건으로 친구들 중에서도 평점을 매긴 인원이 없으면 그 인물은 평점을 안 매긴것으로
    // 간주한다는 조건이 있었는데 이 조건에 대한 예외 처리를 너무 신경쓰다 보니 시간이 너무 오래 걸렸다.
    // 지금 구현하고 나서 보니까 모두 구현해놓고 sum이 음수라면 이렇게 처리하면 되는 것 같은데 처음부터 예외 처리에 너무 신경쓴 게
    // 결과론 적으로는 안 좋은 선택이었던 것 같다.


    static int[][] graph;
    static int[] grade;
    static int ave = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        int n = 5;
        graph = new int[n+1][n+1]; // 1 2 3 4 5
        friend(1,2); // 1번과 2번이 친구관계
        friend(2,3); // 2번과 3번이 친구관계 (1번과 3번역시 친구관계다)
        friend(4,5); // 4번과 5번이 친구관계

        grade = new int[n+1];
        Arrays.fill(grade,-1);
        grade[1] = 5;
        grade[2] = 5;
        grade[4] = 4;
        // 3번과 5번은 점수를 매기지 않은 상태

        int sum = 0;
        for(int i=1;i<=grade.length-1;i++){
            if(grade[i] != -1){
                sum += grade[i];
            }
            else{
                boolean[] visited = new boolean[n+1];
                grade[i] = makeGradeByFriend(i,visited);
                ave= 0;
                cnt = 0;
            }
        }

        for(int i=1;i<=graph.length-1;i++){
            System.out.println(i + " 일 때 " + grade[i]);
        }





    }

    private static int makeGradeByFriend(int idx,boolean[] visited){

        Queue<Integer> que = new LinkedList<>();

        que.add(idx);
        visited[idx] = true;

        while(!que.isEmpty()){
            int v = que.poll();

            if(grade[v] != -1 ) {
                cnt++;
                ave += grade[v];
            }
            for(int i=1;i<=graph.length-1;i++){
                if(!visited[i] && graph[v][i] == 1){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

        return ave / cnt;

    }
    private static void friend(int a,int b){
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
}
