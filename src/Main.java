import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers dev matching 1번문제
    // 첫번째 행에서 #이면 아래로 > 면 오른쪽으로 < 면 왼쪽으로 이동하는데 *을 2번 만나면 그곳에서 멈춘다.
    // 첫번째 행을 모두 이동하면서 맵을 나가게 되는 케이스를 구하여라
    // 처음에는 for문 내에서 첫번째 행부터 이동하는 모든 케이스를 처리하려고 했는데
    // for문을 알아보기 힘들어서 시작위치를 인자로 받는 함수를 구현하였다.
    // 이동하게 되는 위치를 변수로 갱신해가면서 case를 활용해 위치를 이동해 나가며 맵을 나가면 answer + 1
    // *를 2번 만나게 되면 그곳에서 멈추며 다음으로 넘어가도록 하였다.
    // map을 이동하는 좌표를 구현하는 생각으로 접근한 게 주요했던 것 같다.

    public static void main(String[] args) {

        String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};

        int answer = 0;

        String[][] map = new String[drum.length][drum.length];

        for(int i=0;i<drum.length;i++){
            if(isOut(drum,0,i)) {
                answer++;
            }
        }
    }
    static boolean isOut(String[] drum,int y, int x){

        int cnt = 0;
        while(true){
            char ch = drum[y].charAt(x);
            System.out.println(ch + " " + y + " " + x);
            switch (ch){
                case '#' : y++; break;
                case '>' : x++; break;
                case '<' : x--; break;
                case '*' : if(cnt== 0) {
                    cnt++;
                    y++;
                    break;
                } else{
                    return false;
                }
            }

            if(y >= drum.length) return true;
        }

    }
}









/*char[][] keyboard = {
                {'q','w','e','r','t','y','u','i','o'},
                {'p','a','s','d','f','g','h','j','k'},
                {'l','z','x','c','v','b','n','m','.'}};

        String s = "tooth";
        int answer = 0;

        ArrayList<String> list = new ArrayList<>();

            int end = s.length()-2;
            int pos = 0;

            while(pos <= end) {
                StringBuffer sb = new StringBuffer();
                for (int j = pos; j < pos+2; j++) {
                    sb.append(s.charAt(j));
                }
                list.add(sb.toString());
                pos++;

            }



        HashMap<String,Integer> map = new HashMap<>(); // 길이가 2인 부분문자열의 복잡도를 넣는다.

        for(String str : list){
                char left = str.charAt(0);
                char right = str.charAt(1);

                int[] whereL = new int[2];
                int[] whereR = new int[2];

                for(int i=0;i< keyboard.length;i++){
                    for(int j=0;j< keyboard[0].length;j++){
                        if(keyboard[i][j] == left){
                            whereL[0] = i;
                            whereL[1] = j;
                        }
                        if(keyboard[i][j] == right){
                            whereR[0] = i;
                            whereR[1] = j;
                        }
                    }
                }

                int complex = Math.abs(whereL[0] - whereR[0]) + Math.abs(whereL[1] - whereR[1]);
                answer += complex;
            System.out.println(str + " " + complex);
                map.put(str,complex);


        }

        for(int i=3;i<=s.length();i++) {
            end = s.length() - i;
            pos = 0;

            while(pos <= end) {
                StringBuffer sb = new StringBuffer();
                for (int j = pos; j < pos+i; j++) {
                    sb.append(s.charAt(j));
                }


                int position = 0;
                int last = sb.toString().length() - 1;
                int complex = 0;

                while (position <= last - 1) {
                    String subString = sb.toString().substring(position, position + 2);
                    complex += map.get(subString);
                    position++;
                }
                System.out.println(sb.toString() + " " + complex);
                answer += complex;

                pos++;

            }

        }

        System.out.println(answer);*/