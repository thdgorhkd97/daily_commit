import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // 알고리즘 스터디 공부 내용 bfs & 그래프

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int[][] friends = {{1, 2}, {2, 3}, {4, 5}};
        int[] grade = {3, 0, 5, 4, 0};

        int n = 5;
        int[][] map = new int[n+1][n+1];

        for(int i=0;i<friends.length;i++){
            map[friends[i][0]][friends[i][1]] = 1;
            map[friends[i][1]][friends[i][0]] = 1;
        }

//        for(int i=1;i<=map.length-1;i++){
//            for(int j=1;j<=map.length-1;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i=1;i<=n;i++) {
            boolean[] visited = new boolean[n + 1];
            whoFriend(i,map,visited);

            if(grade[i-1] == 0){
                int sum = 0;
                for(int j=0;j<list.size();j++){
                    sum += grade[list.get(j)-1];
                }
                grade[i-1] = sum / (list.size()-1);
            }

            list.clear();

        }

        for(int i=0;i<grade.length;i++){
            System.out.println((i+1) + " 번의 평점 : " + grade[i]);
        }
    }

    private static void whoFriend(int start,int[][] map,boolean[] visited){
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);
        while(!que.isEmpty()){
            int v = que.poll();
            list.add(v);

            for(int i=1;i<=map.length-1;i++){
                if(map[v][i] == 1 && !visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}

        /*
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        Queue<int[]> que = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<priorities.length;i++){
            int[] add = new int[2];
            list.add(priorities[i]);
            add[0] = priorities[i];
            if(i== location){
                add[1] = 1;
            }
            else{
                add[1] = 0;
            }
            que.add(add);
        }

        int answer = 0;

        while(true){

            int[] arr = new int[2];
            arr = que.poll();

            boolean isMax = true;
            for(int i=0;i<list.size();i++){
                if(arr[0] < list.get(i)){
                    isMax = false;
                    break;
                }
            }

            if(!isMax){
                que.add(arr);
            }
            else{
                answer++;
                list.remove(new Integer(arr[0]));
                if(arr[1] == 1){
                    break;
                }
            }
        }

        System.out.println(answer);

         */

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        int old = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            String[] operator = str.split(" ");
            if(!operator[0].equals("push")){
                switch (operator[0]){
                    case "pop" :
                        if(que.isEmpty()) list.add(-1);
                        else list.add(que.poll());

                        if(que.isEmpty()) old = 0;
                        break;
                    case "size" :
                        list.add(que.size());
                        break;
                    case "empty" :
                        if(que.isEmpty()) list.add(1);
                        else list.add(0);
                        break;
                    case "front" :
                        if(que.isEmpty()) list.add(-1);
                        else list.add(que.peek());
                        break;
                    case "back" :
                        if(que.isEmpty()) {
                            list.add(-1);
                        }
                        else list.add(old);
                        break;
                }
            }
            else{
                if(old == 0) old = Integer.parseInt(operator[1]);
                que.offer(Integer.parseInt(operator[1]));

            }
        }
         */

