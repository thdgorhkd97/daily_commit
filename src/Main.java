import java.util.*;

public class Main {

    // programmers level 3 - 여행 경로
    // 정확성은 맞는데 또 효율성에서 문제가 생긴다 ㅠㅠㅠ
    // 출발지를 두고 for문을 돌리면서 가능한 도착 루트를 정렬하여 다음 도착지를 정했는데
    // 이런 방식이 너무 시간이 오래 걸린다.
    // 효율성을 맞추기 위해서 서치해본 결과 dfs 방식을 활용해야 했다.
    // 도착하지 않았고 출발지가 일치한다면 그 다음 도착지를 넣고
    // 다시 visited[i]를 false로 바꿔서 모든 경로를 다시 볼 수 있도록 한다.
    // programmers를 돌려보면서 공부 한 뒤라서 이제 남은 문제들이 거의 다 내가 어디가 막혔느지
    // 알거나 해결하기 어려운 문제들만 남아있다.
    // 계속 찾아보면서 이해하고 공부하는 게 과연 공부가 되는 건지 싶지만 이해하고 습득하면서
    // 비슷한 문제가 나온다면 해결할 수 있도록 하는 게 좋지 않을까 싶다.

    static boolean[] visited;
    static ArrayList<String> answers;

    public static void main(String[] args) {

        String[][] tickets = {
                {"ICN","SFO"},
                {"ICN","ATL"},
                {"SFO","ATL"},
                {"ATL","ICN"},
                {"ATL","SFO"}};

        visited = new boolean[tickets.length];
        answers = new ArrayList<>();

        int cnt = 0;
        dfs(cnt,"ICN","ICN",tickets);

        Collections.sort(answers);

        String[] answer = answers.get(0).split(" ");
//        return answer;
    }

    public static void dfs(int cnt, String present, String answer, String[][] tickets){
        if(cnt == tickets.length){
            answers.add(answer);
            return ;
        }

        for(int i=0;i< tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(present)){
                visited[i] = true;

                dfs(cnt + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }

        return;
    }
}
