import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // B사 코딩테스트 마지막 문제
    // 삼각형 모양으로 구성되는 길이가 차이나는 문자열의 탑을
    // 시계방향이나 반시계방향으로 돌렸을 때 나오는 문자열의 조합을 보낸다.
    // 처음에는 어떻게 접근할 지 몰랐는데 여러가지 케이스를 두고 돌렸을 경우와
    // 비교를 해보니 규칙을 찾을 수 있었다.
    // 시계방향의 경우 오른쪽 아래에서부터 ㄴ자를 좌우반전시킨 모습의 모양을 가지는
    // 인덱스의 조합을 돌리는 형태로 구현하면 가능하다.
    // 규칙을 찾은 뒤부터는 index와 for문을 활용하는 문제였다.
    // 다만 규칙을 찾는 과정이 쉽지 않았는데 단순히 하나만 보는 것이 아니라
    // 줄을 추가하거나 길이를 줄이는 등 모든 경우에 적용 가능한 케이스를 찾기 위해
    // 여러 케이스를 확인한 게 주요했다.

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

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

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