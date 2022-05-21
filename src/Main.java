package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // java programmers 방문 길이
    // 좌표에서 이미 방문한 선분을 체크하는 게 쉽지 않았다
    // 나는그냥 4차원 boolean 배열로 어디서 어디로 이동 이렇게 체크했는데
    // 해당 부분을 구현하는 과정에서 중복체크가 안 되는 부분이 있는 것 같은데...
    // 오류를 찾기가 쉽지 않다ㅠㅠ

    static int answer = 0;

    static int x = 5;
    static int y = 5;

    static int nextX = 5;
    static int nextY = 5;

    static boolean[][][][] check = new boolean[11][11][11][11];

    public static void main(String[] args) throws IOException {

        String dirs = "ULURRDLLU";

        check[x][y][nextX][nextY] = true;

        for(int i=0;i<dirs.length();i++){
            char ch = dirs.charAt(i);

            switch (ch){
                case 'U' : moveUp(); break;
                case 'D' : moveDown(); break;
                case 'R' : moveRight(); break;
                case 'L' : moveLeft(); break;
            }
        }

        System.out.println(answer);
    }
    private static void moveUp(){
        if(x!=0) {

            nextX = x - 1;

            if (!check[x][y][nextX][nextY]) {
                answer++;
                check[x][y][nextX][nextY] = true;
                check[nextX][nextY][x][y] = true;
                x = nextX;

            }
        }
    }
    private static void moveDown(){
        if(x!=10) {

            nextX = x + 1;
            if (!check[x][y][nextX][nextY]) {
                answer++;
                check[x][y][nextX][nextY] = true;
                check[nextX][nextY][x][y] = true;

                x = nextX;
            }
        }
    }
    private static void moveRight(){
        if(y!=10) {

            nextY = y + 1;
            if (!check[x][y][nextX][nextY]) {
                answer++;
                check[x][y][nextX][nextY] = true;
                check[nextX][nextY][x][y] = true;

                y = nextY;
            }
        }
    }
    private static void moveLeft(){
        if(y!=0) {
            nextY = y - 1;
            if (!check[x][y][nextX][nextY]) {
                answer++;
                check[x][y][nextX][nextY] = true;
                check[nextX][nextY][x][y] = true;

                y = nextY;
            }
        }
    }
}