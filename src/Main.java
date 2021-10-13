import java.util.*;

public class Main {

    // programmers level 2 - 교점에 별 만들기
    // 좌표를 계산하는 방식자체는 그대로 두고 정수인 교점만을 구해서
    // 이중배열에 해당하는 좌표를 *로 바꾸는 방식을 하려했는데
    // 이 방식 자체가 애초에 map의 크기를 지정하는 과정에서
    // 교점의 좌표가 해당 배열의 크기를 넘어서는 케이스가 반드시 존재해서 오류가발생하는 것 같다.
    // 해당 방식이 맞는 것 같아서 어제에 이어 오늘까지 시도했는데
    // 해당 방식 자체의 로직이 문제가 있는 것 같다.
    // 새로운 접근 방식을 고려해봐야 할 것 같다.

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

        String[] answer = new String[y_length];

        for(int i=0;i<list.size();i++){
            list.get(i)[0] += Math.abs(x_min);
            list.get(i)[1] += Math.abs(y_min);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(i + " 번째 list " + list.get(i)[0] + " " + list.get(i)[1]);
        }

        String[][] map = new String[x_length][y_length];
        for(int i=0;i<y_length;i++){
            for(int j=0;j<x_length;j++){
                map[i][j] = ".";
            }
        }

        for(int i=0;i<list.size();i++){
            map[list.get(i)[1]][list.get(i)[0]] = "*";
        }

        for(int i=0;i<y_length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<x_length;j++){
                sb.append(map[i][j]);
            }
            answer[answer.length-1-i] = sb.toString();
        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }
}