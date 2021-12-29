import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {

    // B사 코딩테스트 7번문제
    //     A
    //    MAN
    //   DRINK
    //  WATER11
    // 이렇게 있으면 clockwise에 따라 시계 혹은 반시계 방향으로 회전한다.
    // 시계방향일때와 반시계방향일때를 나눠서 확인한다.
    // 오른쪽 아래 끝 지점에서부터 인덱스와 지점을 확인하여 나눠가면서
    // 회전하는 모습에 대해 구현한다.

    public static void main(String[] args) throws IOException {

        String[] grid = {"A","MAN","DRINK","WATER11"};
        boolean clockwise = false;

        String[] answer = new String[grid.length];

        Character[][] map = new Character[grid.length][];
        for(int i=0;i<map.length;i++){
            map[i] = new Character[grid[i].length()];
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                map[i][j] = grid[i].charAt(j);
            }
        }

//        for(int i=0;i<map.length;i++){
//            for(int j=0;j<map[i].length;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if(clockwise){
            int pos = 0;
            int idx = 0;
            while(pos <= grid[grid.length-1].length()-1){
                StringBuffer sb = new StringBuffer();

                int row = grid.length-1;
                int column = pos;

                while(row>=0 && column >= 0){
                    sb.append(map[row][column]);
                    if(column-1 >=0){
                        sb.append(map[row][column-1]);
                        column -= 1;
                    }
                    else{
                        break;
                    }
                    row -= 1;
                    column -= 1;
                }

                answer[idx] = sb.toString();
                System.out.println(answer[idx]);
                idx += 1;
                pos += 2;
            }
        }

        else{
            int idx = 0;
            int len = grid.length-1;

            while(len >= 0) {
                int pos = grid[len].length() - 1;
                StringBuffer sb = new StringBuffer();

                int row = len;
                int column = pos;

                while(row <= grid.length-1){
                    sb.append(map[row][column]);

                    if(row + 1 > grid.length-1){

                        answer[idx] = sb.toString();
                        idx++;
                        break;
                    }
                    else{
                        sb.append(map[row+1][column+1]);

                    }
                    row += 1;
                }

                len--;
            }
        }

    }
}
