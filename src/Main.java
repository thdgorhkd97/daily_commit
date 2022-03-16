import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 14889 스타트와 링크
    // 순열을 이용해서 팀을 구하고 그에 따라 점수를 구한다...

    static int min = Integer.MAX_VALUE;

    static int[][] power;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        power = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                power[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

//        for(int i=1;i<=N;i++){
//            for(int j=1;j<=N;j++){
//                System.out.print(power[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        int[] output = new int[N];

        int depth = 0;
        boolean[] visited = new boolean[N];
        combination(arr,output,depth,visited);

        System.out.println(min);
    }

    private static void combination(int[] arr, int[] output, int depth,boolean[] visited){
        if(depth == arr.length){

            int[] team1 = new int[arr.length/2];
            int[] team2 = new int[arr.length/2];

            int StartTeam = 0;
            int RinkTeam = 0;
            for(int i=0;i<output.length/2;i++){
                team1[i] = output[i];
            }

            int idx = arr.length/2;
            for(int i=0;i<output.length/2;i++){
                team2[i] = output[idx];
                idx++;
            }


            for(int i=0;i<team1.length;i++){
                if(i != team1.length-1)
                    StartTeam += power[team1[i]][team1[i+1]];
                else
                    StartTeam += power[team1[team1.length-1]][team1[0]];
            }

            for(int i=0;i<team2.length;i++){
                if(i != team2.length-1)
                    RinkTeam += power[team2[i]][team2[i+1]];
                else
                    RinkTeam += power[team2[team2.length-1]][team2[0]];
            }

            min = Math.min(min,Math.abs(StartTeam-RinkTeam));

        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combination(arr, output, depth + 1, visited);
                visited[i] = false;
            }
        }
    }
}
