import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // L사 코딩테스트 2번 문제
    // ( 문제 ) x와 y 배열에 좌표로 주어지는 점들을 최소 길이로 연결하였을 때 그 중 가장 긴 선분의 길이 구하기
    // 좌표 배열을 정렬해서 다음 인덱스가 오른쪽이나 오른쪽 위에 위치하도록 만든 다음
    // 다음 인덱스와의 거리를 계산해서 그 중 최대값의 ceil 값을 구한다.
    // 이게 각 좌표값을 우상향으로 정렬한 다음에 다음 인덱스와의 거리를 구하는 게 각 지점을 연결하는 방법이라고 판단해서
    // 이렇게 한 건데 문제의 조건 중에서 각 지점을 연결하는 거리를 최소로 한다는 조건을 만족시키는 지에 대해서
    // 미지수인 것이 걸리는 부분이다.
    // 처음에 int[] x와 int[] y의 i번째 좌표가 지점을 만든다는 걸 이해하는데 조금 걸렸고
    // 유클리드 거리를 구하는 식에서 조금 애먹은 것 같다.
    //              for(int j=0;j<2;j++){
    //                sum += Math.pow(matrix[i][j]-matrix[i+1][j], 2); // 각 좌표의 차의 제곱값
    //            }
    //            max = Math.max(max,(int)Math.ceil(Math.sqrt(sum)));

    public static void main(String[] args) {

        int[] x = {1,2,4,2};
        int[] y = {1,1,4,2};

        int[][] matrix = new int[x.length][2];

        for(int i=0;i<x.length;i++){
            matrix[i][0] = x[i];
            matrix[i][1] = y[i];

        }

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0]-o2[0];
            }
        });

        int max = 0;
        for(int i=0;i<matrix.length-1;i++){ // 유클리드 거리 구하기
            double sum = 0;
            for(int j=0;j<2;j++){
                sum += Math.pow(matrix[i][j]-matrix[i+1][j], 2);
            }
            max = Math.max(max,(int)Math.ceil(Math.sqrt(sum)));

        }

        System.out.println(max);

    }
}