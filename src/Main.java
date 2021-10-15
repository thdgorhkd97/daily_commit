import java.util.*;

public class Main {

    // programmers level 2 - 거리두기 확인하기
    // 2칸이 차이나는 경우 , 대각선으로 만나는 경우
    // 에 대해서 나눠서 생각을 해보았는데 로직은 맞는 것 같은데
    // 어떤 경우에 틀린건지 확인해보아야 할 것 같다.
    // 26.1 / 100

    public static void main(String[] args) {

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] answer = new int[places.length];

        for(int i=0;i<answer.length;i++){
            answer[i] = GeoRiDuGi(places[i]);
            System.out.println(answer[i]);
        }


    }

    public static int GeoRiDuGi(String[] places){
        String[] str = new String[places.length];
        for(int i=0;i<str.length;i++){
            str[i] = places[i];
        }
//        for(int i=0;i<str.length;i++){
//            System.out.print(str[i] + " ");
//        }

        char[][] map = new char[str.length][5];
        for(int i=0;i<str.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j] = str[i].charAt(j);
            }
        }

        for(int i=0;i<str.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] == 'P'){
                    if(i-2 >= 0 && map[i-2][j] == 'P' && map[i-1][j] == 'O'){
                        return 0;
                    }
                    if(i+2 <= str.length-1 && map[i+2][j] == 'P' && map[i+1][j] == 'O'){
                        return 0;
                    }
                    if(j-2 >= 0 && map[i][j-2] == 'P' && map[i][j-1] == 'O'){
                        return 0;
                    }
                    if(j+2 <= str.length-1 && map[i][j+2] == 'P' && map[i][j+1] == 'O'){
                        return 0;
                    }

                    if(i-1 >=0 && j-1>=0 && map[i-1][j-1] == 'P' && (map[i][j-1]=='O' || map[i-1][j] =='O')){
                        return 0;
                    }
                    if(i+1<=str.length-1 && j-1>=0 && map[i+1][j-1] =='P' && (map[i+1][j]=='O' || map[i][j-1] =='O')){
                        return 0;
                    }
                    if(i-1>=0 && j+1<=4 && map[i-1][j+1] =='P' && (map[i-1][j]=='O' || map[i][j+1] =='O')){
                        return 0;
                    }
                    if(i+1<=str.length-1 && j+1<=4 && map[i+1][j+1] =='P' && (map[i+1][j]=='O' || map[i][j+1] =='O')){
                        return 0;
                    }

                }
            }
        }


        return 1;
    }


}