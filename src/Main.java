import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 11866 요세푸스 순열
//    요세푸스 문제는 다음과 같다.
//
//    1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//    이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
//    예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

    // 처음에는 K번째 수가 될 때까지 idx를 더하다가 K가 되면 그때 answer에 넣는 식으로 한다는 걸 생각했는데
    // idx를 초기화해주지 않는 실수를 해서 한 번 실패했었다.

    // K-1까지 for문으로 반복문을 돌리는 방식이나 idx++의 방식이나 똑같다고 생각했는데 결과는 그렇지 않다.
    // for문을 활용하는 2번 방식은 문제를 해결할 수 있는데 내가 처음에 생각한 idx++해서 K랑 같은지 확인하는
    // 1번 방식은 채점 도중 61%에서 시간초과가 발생한다ㅠㅠㅠㅠ
    // 근데 이 이유를 도저히 모르겠어서 오래 고민했다 ㅠㅠ
    // 시간초과가 발생한다는 건 while문을 빠져나오지 못한다는 것이고 그렇다면 que가 isEmpty()가 되지 않는다는 거니까
    // 혹시 N이 1일때 케이스에 대해서 이미 1인 N에 ++을 계속해서 못 나오지 않나 싶어서
    // if문으로 N==1에 대해서 따로 분기를 두었는데도 시간 초과가 똑같이 발생했다....
    // 테스트 케이스도 없고 어떤 경우인지 알 수가 없어서 정말 오래 고민했는데 끝까지 알 수가 없다ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str);

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        Queue<Integer> que = new LinkedList<>();

        for(int i=1;i<=N;i++){
            que.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 1번 방식
//        int idx = 1;
//        while(!que.isEmpty()){
//            que.offer(que.poll());
//            idx += 1;
//            if(idx == K){
//                answer.add(que.poll());
//                idx=1;
//            }
//        }

        // 2번 방식
        while(!que.isEmpty()){
            for(int i=0;i<K-1;i++){
                que.offer(que.poll());
            }
            answer.add(que.poll());
        }

        System.out.print("<");
        for(int i=0;i<answer.size()-1;i++){
            System.out.print(answer.get(i)+", ");
        }
        System.out.print(answer.get(answer.size()-1));
        System.out.print(">");





    }
}