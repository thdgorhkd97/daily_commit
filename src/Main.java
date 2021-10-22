import java.util.*;

public class Main {

    // programmers level 2 - 컬러링 북
    // 어제 했던 N사 코딩테스트 예제와 비슷해서 해결해 보았다.
    // 연결된 같은 숫자의 개수를 구하는 문제였는데 어제와 달리 로직의 실행순서를 더 확인해보았다.
    // 0 0
    // 1 0
    // 2 0
    // 3 0
    // 4 0
    // 3 1
    // 0 1
    // 0 2
    // 이런식으로 아래로 쭉 확인한 다음 위로 올라오면서 우측을 확인하여 개수를 센다.
    // bfs를 활용하여 하는 방식에 대해서 이제 확실해 진 것 같다.

    static int cnt = 1;

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {
                {1,1,1,0},
                {1,2,2,0},
                {1,0,2,1},
                {1,1,0,1},
                {1,0,0,3},
                {0,3,3,3}
        };

        int[] answer = new int[2];

        boolean[][] check = new boolean[m][n];

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j] && picture[i][j] !=0){
                    list.add(bfs(check,picture,i,j));
                    cnt=1;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        answer[0] = list.size();
        answer[1] = list.get(0);

        System.out.println(answer[0] + " " +  answer[1]);

    }
    public static int bfs(boolean[][] check, int[][] picture,int row,int column){

        check[row][column] = true;
        System.out.println(row + " " + column);

        if(row-1 >=0 && !check[row-1][column] && picture[row][column] == picture[row-1][column]){
            cnt++;
            check[row-1][column] = true;
            bfs(check,picture,row-1,column);
        }
        if(row+1 <= picture.length-1 && !check[row+1][column] && picture[row][column] == picture[row+1][column]){
            cnt++;
            check[row+1][column] = true;
            bfs(check,picture,row+1,column);
        }
        if(column-1 >=0 && !check[row][column-1] && picture[row][column] == picture[row][column-1]){
            cnt++;
            check[row][column-1] = true;
            bfs(check,picture,row,column-1);
        }
        if(column+1 <=picture[0].length-1 && !check[row][column+1] && picture[row][column] == picture[row][column+1]){
            cnt++;
            check[row][column+1] = true;
            bfs(check,picture,row,column+1);
        }

        return cnt;
    }
}