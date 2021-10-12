import java.util.*;

public class Main {

    // programmers level 2 - 교점에 별 만들기
    // 좌표를 -만큼 +해서 모두 양수로 해서 계산하려고 했는데
    // 이런식으로 하다보니 직선형으로 나오는 모습에서 에러가 발생한다.
    // 일반적으로 가능한 방식을 다시 고려해봐야 할 것 같다.
    // - ~ + 를 모두 포용하는 좌표에서의 계산을 일반적으로 표현할 수 있는 방식을 생각해보자
    // 직선형으로 "*.*" 인 이중 배열에서 y쪽의 길이가 1인 경우에 에러가 발생한다,

    public static void main(String[] args) {

        int[][] line = {{0,1,-1},{1,0,-1},{1,0,1}};

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=-500;i<=500;i++){
            for(int j=-500;j<=500;j++){
                int cnt= 0;
                int[] result = new int[2];
                for(int k=0;k< line.length;k++){
                    if(line[k][0] * i + line[k][1] * j + line[k][2] == 0){
                        cnt++;
                        if(cnt >= 2){

                            result[0] = i;
                            result[1] = j;
                            list.add(result);
                            break;
                        }
                    }
                }
            }
        }

        int x_min = list.get(0)[0];
        int x_max = list.get(list.size()-1)[0];

        int y_min = 500;
        for(int i=0;i<list.size();i++){
            if(y_min > list.get(i)[1]){
                y_min = list.get(i)[1];
            }
        }

        int y_max = -500;
        for(int i=0;i<list.size();i++){
            if(y_max < list.get(i)[1]){
                y_max = list.get(i)[1];
            }
        }

        int x_length = x_max-x_min+1;
        int y_length = y_max-y_min+1;

        String[] answer = new String[x_length];

        if(x_min < 0){
            for(int i=0;i<list.size();i++){
                list.get(i)[0] -= x_min;
            }
        }
        else{
            for(int i=0;i<list.size();i++){
                list.get(i)[0] += x_min;
            }
        }

        if(y_min < 0){
            for(int i=0;i<list.size();i++){
                list.get(i)[1] -= y_min;
            }
        }
        else{
            for(int i=0;i<list.size();i++){
                list.get(i)[1] += y_min;
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }

        String[][] map = new String[x_length][y_length];
        System.out.println("map의 크기 : " + x_length + " " + y_length);

        if(y_length != 1) {
            for (int i = 0; i < x_length; i++) {
                for (int j = 0; j < y_length; j++) {
                    map[i][j] = ".";
                }
            }
        }
        else{
            for(int i=0;i<x_length;i++){
                map[i][1] = ".";
            }
        }

        int idx=0;
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<list.size();j++){
                if(list.get(j)[1] == i){
                    map[i][list.get(j)[0]] = "*";
                }
            }
        }


//        for(int i=0;i<x_length;i++){
//            for(int j=0;j<y_length;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        idx = 0;
        for(int i=map.length-1;i>=0;i--){

            StringBuffer sb = new StringBuffer();
            for(int j=0;j<map[i].length;j++){
                sb.append(map[i][j]);
            }
            answer[idx++] = sb.toString();
        }



    }
}