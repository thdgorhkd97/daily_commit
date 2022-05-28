package src; // daily 폴더를 source root로 인식시켰기 때문에


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // java baekjoon 3085 사탕 게임
    // 인접한 두칸을 바꿨을 때 행이나 열에 가장 많은 같은 색의 사탕 수를 반환
    // 구현하는 과정에서 실수를 많이 했는지 시간을 꽤 들였는데 성공하지 못했다...
    // 내가 생각한 건 가로로 먼저 바꿔가면서 바꾼 map[i][j]를 기준으로 행과 열을
    // 비교하는 식으로 생각했는데 아예 끝까지 로직을 짜고 세로를 짜려다 보니
    // i와 j를 헷갈려서 중간에 무너진 것 같다 ㅠㅠ
    // 내일은 가로로 바꾸는 것과 세로로 바꾸는 걸 먼저 확인하고 바꾼 i,j에 대해서
    // 개수를 세보는 식으로 해야겠다.
    // 그리고 코드도 생각보다 중복된 부분이 많아서 좀 더 함수화 해야 할 것 같다.

    static int answer = 0;
    static int red = 0;
    static int blue = 0;
    static int green = 0;
    static int yellow = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                if(map[i][j] != map[i][j+1]) {

                    char tmp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = tmp;

                    answer = Math.max(answer,checkGaro(map, i, j));


                    tmp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = tmp;
                }
            }
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] != map[i+1][j]) {

                    char tmp = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = tmp;

                    answer = Math.max(answer,checkSero(map, i, j));


                    tmp = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = tmp;

                }
            }
        }

        System.out.println(answer);
    }

    private static int checkSero(char[][] map, int row, int column) {
        red = 0; blue=0; green=0; yellow = 0;

        for(int j=0;j<map.length;j++){
            switch (map[row][j]){
                case 'C' : red++; break;
                case 'P' : blue++; break;
                case 'Z' : green++; break;
                case 'Y' : yellow++; break;
            }
        }

        return Math.max(Math.max(red,blue),Math.max(green,yellow));
    }

    private static int checkGaro(char[][] map, int row, int column){

        red = 0; blue=0; green=0; yellow = 0;

        for(int j=0;j<map.length;j++){
            switch (map[row][j]){
                case 'C' : red++; break;
                case 'P' : blue++; break;
                case 'Z' : green++; break;
                case 'Y' : yellow++; break;
            }
        }

        int max = Math.max(Math.max(red,blue),Math.max(green,yellow));

        red = 0; blue=0; green=0; yellow = 0;

        for(int i=0;i<map.length;i++){
            switch (map[i][column]){
                case 'C' : red++; break;
                case 'P' : blue++; break;
                case 'Z' : green++; break;
                case 'Y' : yellow++; break;
            }
        }

        max = Math.max(max,Math.max(Math.max(red,blue),Math.max(green,yellow)));
        return max;

    }
}