import java.io.IOException;
import java.util.*;

public class Main {

    // programmers level 3 - 디스크 컨트롤러
    // 우선순위 큐를 활용하는 과정에서 int[] 배열이 들어오는 데 이 중 [1] 원소에 대해서 지속적으로
    // 정렬하는 기준에 대해서 알지 못했는데 우선순위 큐를 선언하는 과정에서
    // 우선순위 큐에서 확인할 정렬 기준에 대해 집어넣어 주면 된다는 걸 알았다.(람다식으로 표현하였다)
    // 그 이후의 로직은 생각보다 단순하다고 생각된다. 큐에 들어간 작업이 끝나는 시점에서 요청이 들어왔는가에 따라
    // 큐에 집어넣을지 넣지 않을지 판단하고 실행하는 작업에 대해서 작업 종료시간을 수정해나간다.
    // 느낀 점 : 우선순위 큐를 활용하지 못했던 것은 아니라고 생각한다. 이전에도 우선순위 큐를 활용한 적이 있었고 개념도 알고 있다.
    //          다만 우선순위 큐에 int[]가 들어갈 때 int[] 배열 중 특정 순서의 원소의 내림차순 혹은 오름차순 기준으로 정렬하도록
    //          기준 자체를 설정할 수 있다는 부분은 어떻게 표현하는지 잘 몰랐는데 이번 기회에 확실히 할 수 있었다.

    public static void main(String[] args) throws IOException {

        int[][] jobs = {{0,3},{1,9},{2,6}};

        Arrays.sort(jobs,(o1, o2) -> o1[0]-o2[0]);

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        while(count < jobs.length){ // 모든 요청을 모두 수행할 때까지

            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                // 작업이 완료되는 시간이 end 니까 그 시점까지 들어온 모든 요청을 큐에 삽입
                que.add(jobs[jobsIdx]);
                jobsIdx += 1;
            }

            if(que.isEmpty()){ // 큐가 비어있다면
                // 작업이 완료되는 end 이후로 작업 요청이 들어오는 것이므로 end를 다음 요청의 작업 시간으로 초기화
                end = jobs[jobsIdx][0];
            }
            else{ // 큐가 비어있지 않다면(작업이 진행 중일 때 요청이 들어오면)
                int[] tmp = que.poll(); // 현재 큐에 있는 것 중 수행시간이 가장 짧은 것
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;
            }
        }


//        return (int) Math.floor(answer / jobs.length);
    }
}
