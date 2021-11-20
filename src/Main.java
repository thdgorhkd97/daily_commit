import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 여행 경로
    // 50 / 100 절반 성공 절반 시간 초과
    // 2개 이상이 가능할 경우 알파벳 순으로 가장 빠른 도시를 방문해야 하는 조건에서
    // 시간이 조금 오래 걸렸다.
    // 그래서 전체를 순회하여 도착 가능한 모든 도시를 구하고 도시를 정렬한 후에
    // 위치하고 그 도시를 다시 큐에 넣는 bfs를 활용한 방식을 구현하였는데
    // 모두 순회하고 도시가 새로 들어올 때마다 모두 순회하다 보니
    // 경우의 수가 많아져서 시간 초과가 발생한 것으로 보인다.
    // 근데 도착 가능한 모든 경우의 수를 구해야 하기 때문에 모두 순회하는 것으로 구현한 것인데
    // 시간을 줄이기 위한 방법을 더 고민해 봐야 할 것으로 보인다.

    public static void main(String[] args) {

        String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},
                {"ATL","SFO"}};
//        String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};

        Queue<String> que = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        String[] answer;
        boolean[] check = new boolean[tickets.length];

        que.offer("ICN");
        result.add("ICN");

        while(!cover(check)){
            String str = que.poll();
            ArrayList<String> list = new ArrayList<>();
            int idx = 0;

            for(int i=0;i< tickets.length; i++){
                if(tickets[i][0].equals(str) && !check[i]){
                    list.add(tickets[i][1]);
                    idx = i;
                }
            }

            if(list.size() == 1){
                que.offer(list.get(0));
                result.add(list.get(0));
                check[idx] = true;
            }
            else{ // 가능한 경로가 2개 이상일 때
                Collections.sort(list);

                for(int i=0;i<tickets.length;i++){
                    if(tickets[i][0].equals(str) &&tickets[i][1].equals(list.get(0)) && !check[i]){
                        que.offer(list.get(0));
                        result.add(list.get(0));
                        check[i] = true;
                        break;
                    }
                }
            }

        }

        answer = new String[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);

        }

    }

    public static boolean cover(boolean[] check){
        for(int i=0;i<check.length;i++){
            if(!check[i]) return false;
        }
        return true;
    }
}