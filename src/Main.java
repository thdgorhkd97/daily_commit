package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
작성자 : 송해광 ( 2022 - 06 - 20 )
문제 : java baekjoon 2667 단지번호 붙이기
문제접근 : 뭉쳐진 단지번호별로 개수를 저장해서 오름차순으로 반환하는 문제 -> 2차원 배열에서
         1이 뭉쳐진 덩어리? 의 크기를 구해야 하기에 bfs로 접근하면서 1을 만나면 그 1과
         뭉쳐진 덩어리의 개수를 구하고 덩어리의 visited[i][j]를 true로 바꾼 후에 false를
         만난 경우에만 다시 덩어리의 크기를 구한다.
 */

class algorithm {

    static List<Integer> list = new ArrayList<>(); // 각 단지의 집 수를 저장할 리스트
    static int answer = 0; // 단지 수를 저장할 변수
    static boolean[][] visited; // 방문 여부를 저장할 2차원 배열
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1}; // 상하좌우
    static char[][] home; // 집의 유무를 알 수 있는 2차원 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        home = new char[N][N];

        for(int i=0;i<N;i++){
            home[i] = br.readLine().toCharArray(); // 각각의 배열로 받아서 [i][j]로 표현
        }

        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && home[i][j] == '1') { // 방문하지 않았고 1이면
                    bfs(i,j); // 그 1과 연결된 덩어리의 크기를 구해야 한다.
                }

            }
        }

        System.out.println(answer); // answer로 bfs를 호출한 횟수를 출력( 추후에 생각해보니 그냥 list.size()를 출력해도 괜찮을듯)
        Collections.sort(list); // list를 문제 요구대로 오름차순 정렬하고
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)); // 순서대로 출력
        }

    }
    private static void bfs(int row,int column){ // home[row][column] 과 연결된 덩어리를 찾는 bfs
        answer++; // bfs 호출 횟수 ( 덩어리의 총 갯수를 구하기 위해 )

        int cnt = 1; // 각 덩어리의 크기를 저장하는 변수
        Queue<int[]> que = new LinkedList<>();
        int[] add = new int[2];
        add[0] = row;
        add[1] = column;
        que.add(add); // (row,column)을 저장하기 위해 배열을 저장
        visited[row][column] = true; // 해당 위치를 방문 처리

        while(!que.isEmpty()){ // bfs 구현
            int[] v = que.poll();

            int nextX = 0; // 상하좌우 이동 후 행
            int nextY = 0; // 상하좌우 이동 후 열
            for(int i=0;i<dx.length;i++){
                nextX = v[0] + dx[i];
                nextY = v[1] + dy[i]; // 상하좌우로 이동 후의 위치


                if(nextX < 0 || nextY < 0 || nextX >= visited.length || nextY >= visited.length){
                    continue;
                } // 2차원 배열인 home[][]을 벗어나면
                else{ // 2차원 배열 내부면
                    if(!visited[nextX][nextY] && home[nextX][nextY] == '1'){ // 방문하지 않았고 1이라면
                        int[] addque = new int[2];
                        cnt++; // 덩어리의 크기를 1 증가시키고
                        addque[0] = nextX;
                        addque[1] = nextY;
                        que.add(addque); // que에 추가
                        visited[nextX][nextY] = true; // 해당 좌표를 방문처리
                    }
                }
            }
        }

        list.add(cnt);

    }
}
