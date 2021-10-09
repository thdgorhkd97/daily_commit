import javax.swing.text.View;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {

    // N사 코딩테스트 문제
    // 코딩테스트 도중에 해결하지 못한 문제가 있어서 해결해보려 한다.
    // 2차 배열의 (a,b)에서부터 (c,d)까지 대각선으로 원소를 바꿔간다.
    // programmers 사이트에서 바로 코딩하다 보니 에러가 생긴 부분을 고치지 못했다.
    // 로직은 똑같은데 워낙 사용하는 인덱스도 여러가지고 하다 보니까 index 아웃오브바운드를 중간에 어디서
    // 틀린지 몰라서 고치는 데 시간이 부족하고 그랬는데
    // IDE로 확인하고 고치니까 해결할 수 있었다.

    public static void main(String[] args) {

        int[][] map = new int[5][6];
        int num=0;

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j] = num++;
            }
        }

        int[] querie = {3,2,5,6,-1};

        if(querie[4] == 1)type1(map,querie[0]-1,querie[1]-1,querie[2]-1,querie[3]-1);
        // 0 1 2 3 4 5
        // 6 7 8 9 10 11
        // 12 13 19 25 26 27
        // 18 14 20 21 22 28
        // 24 15 16 17 23 29

        else if(querie[4] == -1) type2(map,querie[0]-1,querie[1]-1,querie[2]-1,querie[3]-1);
        // 0 1 2 3 4 5
        // 6 7 8 9 10 11
        // 12 27 28 29 23 17
        // 18 26 20 21 22 16
        // 24 25 19 13 14 15

        for(int i=0;i<map.length;i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void type1(int[][] map, int sx, int sy, int ex,int ey){ // 오른쪽위 대각선으로 변환
        // 맨 왼쪽 위 좌표부터 시작해서 아래쪽으로 간 다음 오른쪽으로 가며 변환한다.
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=sx+1;i<=ex;i++){ // 대각 변환을 아래쪽으로 이동하며 진행
            list.clear();
            int idx_x = i; // 아래쪽으로
            int idx_y = sy; // 맨 앞줄
            int cnt = 0;
            list.add(map[idx_x][idx_y]);
            while(idx_x-1 >= sx && idx_y+1 <= ey){ // 변환하는 구역 내라면
                idx_x--;
                idx_y++;
                cnt++;
                list.add(map[idx_x][idx_y]); // list에 저장해나간다음에
            }

            int idx = 0;
            for(int j=0;j<=cnt;j++){
                map[idx_x][idx_y] = list.get(idx++); // 반대로 내려오면서 map[idx_x][idx_y]를 채워나간다.
                idx_x++;
                idx_y--;
            }
        }

        int i = ex; // 오른쪽으로만 가니 row는 ex로 고정
        for(int j=sy+1;j<=ey;j++){ // 아래쪽으로 쭉 했으니 이제오른쪽으로 쭉 진행해 나간다.
            list.clear();
            int idx_x = i;
            int idx_y = j;
            list.add(map[idx_x][idx_y]);
            int cnt=0;
            while(idx_x-1 >= sx && idx_y+1 <= ey){ // 변환 구역 내부라면
                idx_x--;
                idx_y++;
                cnt++;
                list.add(map[idx_x][idx_y]);
            }

            int idx = 0;
            for(int k=0;k<=cnt;k++){
                map[idx_x][idx_y] = list.get(idx++);
                idx_x++;
                idx_y--;
            }
        }

    }

    // 0 1 2 3 4 5
    // 6 7 8 9 10 11
    // 12 27 28 29 23 17
    // 18 26 20 21 22 16
    // 24 25 19 13 14 15

    public static void type2(int[][] map, int sx, int sy, int ex,int ey){ // 왼쪽 대각선 위로 변환해 나간다.
        // 맨아래 좌표부터 시작해서 오른쪽으로 쭉 이동하며 변환한다음 위로 변환한다.

        ArrayList<Integer> list = new ArrayList<>();

        int row = ex; // 오른쪽으로만 이동하면 row는 고정

        for(int j=sy+1;j<=ey;j++){ // 오른쪽으로 이동
            list.clear();
            int idx_x = row;
            int idx_y = j;
            int cnt = 0;
            list.add(map[idx_x][idx_y]);

            while(idx_x-1 >= sx && idx_y-1 >= sy){ // 변환 구역 내부라면
                idx_x--;
                idx_y--;
                cnt++;
                list.add(map[idx_x][idx_y]);
            }
            int idx = 0;

            for(int k=0;k<=cnt;k++){ // 거꾸로 list에서 빼면서 삽입
                map[idx_x][idx_y] = list.get(idx++);
                idx_x++;
                idx_y++;
            }
        }

        for(int i=ex-1;i>sx;i--){ //위쪽으로 이동
            list.clear();
            int idx_x = i;
            int idx_y = ey;
            int cnt = 0;
            list.add(map[idx_x][idx_y]);

            while(idx_x-1 >= sx && idx_y-1 >= sy){ // 변환구역 내부라면
                idx_x--;
                idx_y--;
                cnt++;
                list.add(map[idx_x][idx_y]);
            }
            int idx = 0;

            for(int k=0;k<=cnt;k++){
                map[idx_x][idx_y] = list.get(idx++);
                idx_x++;
                idx_y++;
            }
        }






    }
}