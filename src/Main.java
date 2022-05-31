package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers level 2 방문 길이
    // visited[][][][] 를 visited[원래 X 좌표][원래 Y 좌표][이동한 X 좌표][이동한 Y 좌표]
    // 이렇게 해서 처음 간 길인지를 확인하는 식으로 생각했다.
    // U D R L 에 따라 이동한 좌표가 맵 안에 있다면 visited가 false인지 확인하고
    // answer+1 해준다
    // cf ) 선분에 이동했는지를 확인하는 것이기 때문에 출발점과 도착점을 바꿔서
//          visited[curentX][curentY][nextX][nextY] = true;
//          visited[nextX][nextY][curentX][curentY] = true;
    //      이렇게 true로 바꿔준다

    static boolean[][][][] visited = new boolean[11][11][11][11];
    static int curentX = 0;
    static int curentY = 0;
    static int nextX = 0;
    static int nextY = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        String dirs = "LULLLLLLU";

        curentX = 5;
        curentY = 5;
        visited[5][5][5][5] = true;

        for(int i=0;i<dirs.length();i++){
            switch (dirs.charAt(i)){
                case 'U' : GoUp(); break;
                case 'D' : GoDown(); break;
                case 'L' : GoLeft(); break;
                case 'R' : GoRight(); break;
            }
        }

        System.out.println(answer);

    }

    private static void GoUp(){
        if(curentX - 1 < 0) return;
        nextX = curentX - 1;
        nextY = curentY;

        if(!visited[curentX][curentY][nextX][nextY]){
            answer++;
        }
        visited[curentX][curentY][nextX][nextY] = true;
        visited[nextX][nextY][curentX][curentY] = true;
        curentX = nextX;
        curentY = nextY;

    }
    private static void GoDown(){
        if(curentX + 1 > 10) return;
        nextX = curentX + 1;
        nextY = curentY;


        if(!visited[curentX][curentY][nextX][nextY]){
            answer++;
        }
        visited[curentX][curentY][nextX][nextY] = true;
        visited[nextX][nextY][curentX][curentY] = true;
        curentX = nextX;
        curentY = nextY;


    }
    private static void GoLeft(){
        if(curentY - 1 < 0) return;
        nextX = curentX ;
        nextY = curentY - 1;


        if(!visited[curentX][curentY][nextX][nextY]){
            answer++;
        }
        visited[curentX][curentY][nextX][nextY] = true;
        visited[nextX][nextY][curentX][curentY] = true;
        curentX = nextX;
        curentY = nextY;

    }
    private static void GoRight(){
        if(curentY + 1 > 10) return;
        nextX = curentX;
        nextY = curentY + 1;

        if(!visited[curentX][curentY][nextX][nextY]){
            answer++;
        }
        visited[curentX][curentY][nextX][nextY] = true;
        visited[nextX][nextY][curentX][curentY] = true;
        curentX = nextX;
        curentY = nextY;

    }
}