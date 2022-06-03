package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers level 2 - 교점에 별 만들기
    // 주어지는 직선끼리의 모든 교점 중 정수인 교점만 취해서 최소범위에 대한
    // string 배열을 반환한다
    // 주어지는 직선끼리의 교점을 구하는 공식을 직접 구해서 그랬는데 문제에 주어져 있었다 ㅠㅠ(잘 읽어야지)
    // 그리고 교점을 Math.round(x * 100) / 100.0; 로 해서 소수 2째 자리까지 반올림해서 구했고
    // 그 수가 정수인지 아닌지를 확인하는 방법으로는 그 수를 Math.floor()한 것과 (int)로 형변환한게
    // 일치하면 정수라고 판단하였다.
    // 그렇게 정수인 교점을 다 찾았는데 거기서 어떻게 좌표표현을 해야 할지 모르겠다 ㅠㅠ

    static List<int[]> list = new ArrayList<>();
    static Set<int[]> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        int[][] line = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
//        int[][] line = {{0,1,-1},{1,0,-1},{1,0,1}};
//          int[][] line = {{1,-1,0},{2,-1,0}};
//          int[][] line = {{1,-1,0},{2,-1,0},{4,-1,0}};

        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                whereMeet(line[i],line[j]);
            }
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            minX = Math.min(minX,list.get(i)[0]);
            minY = Math.min(minY,list.get(i)[0]);
            maxX = Math.max(maxX,list.get(i)[1]);
            maxY = Math.max(maxY,list.get(i)[1]);
        }

        System.out.println();
        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        System.out.println();

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }

        String[] answer = new String[maxY - minY + 1];

        int idx = 0;
        for(int i=0;i<answer.length;i++){

        }


    }

    private static void whereMeet(int[] line1, int[] line2) {

        if(line1[0] * line2[1] - line1[1] * line2[0] == 0){
            return ;
        }

        double x = ((line1[1] * line2[2]) - (line1[2] * line2[1])) / (double)((line1[0] * line2[1]) - (line1[1]*line2[0]));
        double y = ((line1[2] * line2[0]) - (line1[0] * line2[2])) / (double)((line1[0] * line2[1]) - (line1[1]*line2[0]));

        x = Math.round(x * 100) / 100.0;
        y = Math.round(y * 100) / 100.0;

        if(Math.round(x) == x && Math.round(y) == y){            // 정수인지 확인
            int[] add = new int[2];
            add[0] = (int)x;
            add[1] = (int)y;
            if(set.add(add)){
                list.add(add);
            }
        }

    }
}